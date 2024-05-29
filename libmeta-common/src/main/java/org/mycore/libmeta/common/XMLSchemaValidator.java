/* 
 * This file is part of *** MyCoRe LibMeta ***
 * See https://github.com/MyCoRe-Org/libmeta/ for details.
 * 
 * MyCoRe LibMeta is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published 
 * by the Free Software Foundation, either version 3 of the License, 
 * or (at your option) any later version.
 *
 * MyCoRe LibMeta is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with MyCoRe LibMeta.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.mycore.libmeta.common;

import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.xml.catalog.CatalogFeatures;
import javax.xml.catalog.CatalogFeatures.Feature;
import javax.xml.catalog.CatalogManager;
import javax.xml.catalog.CatalogResolver;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * This class validates XML files against their corresponding XML Schemas.
 * 
 * The implementation looks for XML catalog files on classpath.
 * The predefined locations are /libmeta/catalog.xml and /libmeta/catalog.additional.xml
 * The 2nd path may be used, if you have the need to add more entries (for example in tests).
 * 
 * You can 1) provide your own schemaLocation Mapping which will override the xsi:schemaLocation attribute
 *            for the validation phase
 *         2) configure if the resolver should work in strict mode
 *            (see https://docs.oracle.com/javase%2F9%2Fdocs%2Fapi%2F%2F/javax/xml/catalog/CatalogFeatures.html)
 *            if true - all schema files must be provided locally in classpath
 *            otherwise the resolvers tries to look up unmatched schema locations on the internet 
 * 
 * The results are stored as properties valid, errorMsg) in the validator object.
 * You should NOT reuse the object for another validation. Create a new instance for each usage!
 * 
 */
public class XMLSchemaValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(XMLSchemaValidator.class);
    static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    static final String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";

    static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";

    static final String DEFAULT_METS_SCHEMA_LOCATIONS
        = "http://www.loc.gov/METS/ http://www.loc.gov/standards/mets/mets.xsd"
            + " http://www.w3.org/1999/xlink http://www.loc.gov/standards/xlink/xlink.xsd"
            + " http://www.loc.gov/mods/v3 http://www.loc.gov/standards/mods/v3/mods.xsd"
            + " http://www.loc.gov/mix/v20 http://www.loc.gov/standards/mix/mix20/mix20.xsd"
            + " http://purl.uni-rostock.de/ub/standards/mets-extended-v1.0 http://purl.uni-rostock.de/ub/standards/mets-extended-v1.0.xsd"
            + " http://purl.uni-rostock.de/ub/standards/mets-extended-v1.1 http://purl.uni-rostock.de/ub/standards/mets-extended-v1.1.xsd"
            + " http://dfg-viewer.de/ http://purl.uni-rostock.de/ub/standards/dfg-viewer.xsd"
            + " info:srw/schema/5/picaXML-v1.0 http://www.loc.gov/standards/sru/recordSchemas/pica-xml-v1-0.xsd";

    static final String SCHEMA_LOCATIONS_METS_MODS_MIX
        = "http://www.loc.gov/METS/ http://www.loc.gov/standards/mets/mets.xsd"
            + " http://www.w3.org/1999/xlink http://www.loc.gov/standards/xlink/xlink.xsd"
            + " http://www.loc.gov/mods/v3 http://www.loc.gov/standards/mods/v3/mods.xsd"
            + " http://www.loc.gov/mix/v20 http://www.loc.gov/standards/mix/mix20/mix20.xsd";

    private DocumentBuilderFactory DOC_BUILDER_FACTORY = DocumentBuilderFactory.newInstance();

    private CatalogResolver xmlSchemaCatalogResolver;

    private boolean valid = false;

    private String errorMsg = "";

    /**
     * create an new XML schema validator instance
     * in strictMode with no external schema locations
     */
    public XMLSchemaValidator() {
        init(true, null);
    }

    /**
     * create a new XML schema validator instance
     * @param strictMode 
     *   - if false, the validator will try to resolve unknown schema location urls on the internet.
     *   - if true, the validation fails if a schema location is not found in one of the catalog.xml files
     */
    public XMLSchemaValidator(boolean strictMode) {
        init(strictMode, null);
    }

    /**
     * create a new XML schema validator instance
     * @param strictMode 
     *   - if false, the validator will try to resolve unknown schema location urls on the internet.
     *   - if true, the validation fails if a schema location is not found in one of the catalog.xml files
     *   
     *   @param schemaLocations
     *     It contains a mappings of XML namespace and XML schema location
     *     The syntax matches the requirements of the xsi:schemaLocation attribute
     *     You may set it null, if you do want to set any schema location.
     */
    public XMLSchemaValidator(boolean strictMode, String schemaLocations) {
        init(strictMode, schemaLocations);
    }

    private void init(boolean strictMode, String schemaLocations) {

        URI[] catalogURLs = Stream.of(
            XMLSchemaValidator.class.getResource("/libmeta/catalog.xml"),
            XMLSchemaValidator.class.getResource("/libmeta/catalog.additional.xml"))
            .filter(x -> x != null)
            .map(x -> {
                try {
                    return x.toURI();
                } catch (URISyntaxException e) {
                    LOGGER.error("Wrong URI: " + x, e);
                    return null;
                }

            })
            .filter(x -> x != null)
            .toArray(URI[]::new);

        CatalogFeatures f = strictMode
            ? CatalogFeatures.defaults()
            : CatalogFeatures.builder().with(Feature.RESOLVE, "continue").build();

        xmlSchemaCatalogResolver = CatalogManager.catalogResolver(f, catalogURLs);

        List<String> schemas = new ArrayList<>();
        if (schemaLocations != null) {
            for (String s : schemaLocations.split("\\s")) {
                s = s.trim();
                if (s.toLowerCase().endsWith(".xsd")) {
                    schemas.add(s);
                }
            }
        }

        DOC_BUILDER_FACTORY.setNamespaceAware(true);
        DOC_BUILDER_FACTORY.setValidating(true);

        try {
            DOC_BUILDER_FACTORY.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
            if (schemas.size() > 0) {
                DOC_BUILDER_FACTORY.setAttribute(JAXP_SCHEMA_SOURCE, schemas.toArray(new String[] {}));
            }

        } catch (IllegalArgumentException x) {
            LOGGER.error("Error in constructor", x);
        }
    }

    /**
     * This starts the validation process.
     * It should only be called ON TIME !!!!
     * 
     * @param path - a file to test
     * @return true, if the file is valid for the defined XML schema
     */
    public boolean validate(Path path) {
        final Path p = path;
        try (Reader reader = Files.newBufferedReader(p)) {
            validate(reader, p.getFileName().toString());
        } catch (IOException e) {
            LOGGER.debug("Validation error", e);
            errorMsg += "\n" + e.getMessage();
            valid = false;
        }
        return valid;
    }

    /**
     * This starts the validation process.
     * It should only be called ONCE !!!!
     * 
     * @param reader - a reader object, that access the XML (from String, stream, file, ...)
     * @param resourceName - a human readable name of the resource (e.g. file name) for messages and debugging
     * 
     * @return true, if the file is valid for the defined XML schema
     */
    public boolean validate(Reader reader, String resourceName) {
        valid = true;
        try {
            DocumentBuilder docBuilder = DOC_BUILDER_FACTORY.newDocumentBuilder();
            docBuilder.setErrorHandler(new ErrorHandler() {

                @Override
                public void warning(SAXParseException exception) throws SAXException {
                    outputError(exception);
                }

                @Override
                public void fatalError(SAXParseException exception) throws SAXException {
                    outputError(exception);
                }

                @Override
                public void error(SAXParseException exception) throws SAXException {
                    outputError(exception);
                }

                private void outputError(SAXParseException exception) throws SAXException {
                    String msg = resourceName + ": Line: " + exception.getLineNumber() + ", Column: "
                        + exception.getColumnNumber() + " - " + exception.getMessage();
                    LOGGER.error(msg);
                    errorMsg += "\n" + msg;
                    valid = false;
                }
            });

            docBuilder.setEntityResolver(xmlSchemaCatalogResolver);

            docBuilder.parse(new InputSource(reader));
        } catch (Exception e) {
            LOGGER.error("Validation error", e);
            errorMsg += "\n" + e.getMessage();
            valid = false;
        }
        return valid;
    }

    /**
     * @return the error message (...or empty string if valid)
     * after validation
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * @return true, if the validation was successful
     */
    public boolean isValid() {
        return valid;
    }

}
