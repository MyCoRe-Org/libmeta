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

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;



public class XMLSchemaValidator {
	static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	static final String JAXP_SCHEMA_SOURCE ="http://java.sun.com/xml/jaxp/properties/schemaSource";

    static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
    
    static final String DEFAULT_METS_SCHEMA_LOCATIONS = "http://www.loc.gov/METS/ http://www.loc.gov/standards/mets/mets.xsd"
            + " http://www.w3.org/1999/xlink http://www.loc.gov/standards/xlink/xlink.xsd"
            + " http://www.loc.gov/mods/v3 http://www.loc.gov/standards/mods/v3/mods.xsd"
            + " http://www.loc.gov/mix/v20 http://www.loc.gov/standards/mix/mix20/mix20.xsd"
            + " http://purl.uni-rostock.de/ub/standards/mets-extended-v1.0 http://purl.uni-rostock.de/ub/standards/mets-extended-v1.0.xsd"
            + " http://purl.uni-rostock.de/ub/standards/mets-extended-v1.1 http://purl.uni-rostock.de/ub/standards/mets-extended-v1.1.xsd"
            + " http://dfg-viewer.de/ http://purl.uni-rostock.de/ub/standards/dfg-viewer.xsd"
            + " info:srw/schema/5/picaXML-v1.0 http://www.loc.gov/standards/sru/recordSchemas/pica-xml-v1-0.xsd";
    
    static final String SCHEMA_LOCATIONS_METS_MODS_MIX = "http://www.loc.gov/METS/ http://www.loc.gov/standards/mets/mets.xsd"
            + " http://www.w3.org/1999/xlink http://www.loc.gov/standards/xlink/xlink.xsd"
            + " http://www.loc.gov/mods/v3 http://www.loc.gov/standards/mods/v3/mods.xsd"
            + " http://www.loc.gov/mix/v20 http://www.loc.gov/standards/mix/mix20/mix20.xsd";
            
    
    private DocumentBuilderFactory DOC_BUILDER_FACTORY = DocumentBuilderFactory.newInstance();

    private boolean isValid = true;

    private String errorMsg = "";

    

    public XMLSchemaValidator(String SchemaLocations) {
    	List<String> schemas = new ArrayList<>();
    	for(String s: SchemaLocations.split("\\s")){
    		s = s.trim();
    		if(s.toLowerCase().endsWith(".xsd")){
    			schemas.add(s);
    		}
    	}
    	
        DOC_BUILDER_FACTORY.setNamespaceAware(true);
        DOC_BUILDER_FACTORY.setValidating(true);

        try {
            DOC_BUILDER_FACTORY.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
           // DOC_BUILDER_FACTORY.setAttribute(JAXP_SCHEMA_SOURCE, schemas.toArray(new String[]{}));
            
        } catch (IllegalArgumentException x) {
            // Happens if the parser does not support JAXP 1.2
        }
        
    }

    public boolean validate(Path path) {
    	final Path p = path;
        try {
           
            InputStream is = Files.newInputStream(p);
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
                    String msg = "File: " + p.getFileName().toString() + " Line: " + exception.getLineNumber() + ", Column: "
                        + exception.getColumnNumber() + " - " + exception.getMessage();
                    errorMsg += "\n" + msg;
                    System.err.println(msg);
                    isValid = false;
                }
            });
            
            docBuilder.setEntityResolver(new EntityResolver() {
				
				@Override
				public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
					try {
						InputStream is = getClass().getResourceAsStream("/xml_schemas/"+ systemId.substring(systemId.lastIndexOf("/")+1));
						if(is!=null) {
						return new InputSource(is);
						}
					}
					catch(Exception e) {
						System.err.println("Error resolving entity: " + e.getMessage());
						e.printStackTrace();
					}
					return null;
				}
			});

            docBuilder.parse(is);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isValid) {
            System.out.println("METS file " + p.getFileName().toString() + " is valid.");
        }

        return isValid;

    }

    public String getErrorMsg() {
        return errorMsg;
    }
    
    public static void main(String[] args){
    	System.out.println("START");
    	Path pTest = Paths.get("E:\\temp\\s3test\\rosdok_ppn862159598.lza.mets.xml");
    	XMLSchemaValidator xsv = new XMLSchemaValidator(DEFAULT_METS_SCHEMA_LOCATIONS);
    	System.out.println("Ergebnis: "+ xsv.validate(pTest));
    	
    	
    	
    	try(FileOutputStream fos = new FileOutputStream("E:\\temp\\s3test\\mets.xsd")){
    		URL website = new URL("http://www.loc.gov/standards/mets/mets.xsd");
    		URLConnection con = website.openConnection();
    		// con.setRequestProperty("User-Agent",  "Hello LOC");
    		
    		ReadableByteChannel rbc = Channels.newChannel(con.getInputStream());
    	
    		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    		    	}
    	catch(IOException e){
    		e.printStackTrace();
    	}
    	
    	try(FileOutputStream fos = new FileOutputStream("E:\\temp\\s3test\\mets_rosdok.xsd")){
    		URL website = new URL("https://rosdok.uni-rostock.de/data/standards/mets.xsd");
    		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
    	
    		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    	}
    	catch(IOException e){
    		e.printStackTrace();
    	}
    	
    }
}
