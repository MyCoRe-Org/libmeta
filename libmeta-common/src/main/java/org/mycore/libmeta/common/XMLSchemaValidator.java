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
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

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

    private boolean isValid = true;

    private String errorMsg = "";

    public XMLSchemaValidator() {
        init(null);
    }

    public XMLSchemaValidator(String schemaLocations) {
        init(schemaLocations);
    }

    private void init(String schemaLocations) {
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
            // Happens if the parser does not support JAXP 1.2
        }

    }

    public boolean validate(Path path) {
        final Path p = path;
        try (Reader reader = Files.newBufferedReader(p)) {
            return validate(reader, p.getFileName().toString());
        } catch (IOException e) {
            LOGGER.debug("Validation error", e);
        }
        return false;
    }

    public boolean validate(Reader reader, String resourceName) {
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
                    errorMsg += "\n" + msg;
                    LOGGER.error(msg);
                    isValid = false;
                }
            });

            docBuilder.setEntityResolver(new EntityResolver() {

                @Override
                public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
                    try {
                        InputStream is = getClass()
                            .getResourceAsStream(
                                "/libmeta/xml_schemas/" + systemId.substring(systemId.lastIndexOf("/") + 1));
                        if (is != null) {
                            return new InputSource(is);
                        }
                    } catch (Exception e) {
                        LOGGER.error("Error resolving entity", e);
                    }
                    return null;
                }
            });

            docBuilder.parse(new InputSource(reader));
        } catch (Exception e) {
            LOGGER.error("Validation error", e);
        }

        return isValid;

    }

    public String getErrorMsg() {
        return errorMsg;
    }

}
