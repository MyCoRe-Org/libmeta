//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v3.0.0 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2023.06.23 um 12:38:43 PM CEST 
//

package org.mycore.libmeta.dfgviewer.model;

import jakarta.xml.bind.annotation.XmlRegistry;

/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.mycore.libmeta.dfgviewer.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.mycore.libmeta.dfgviewer.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Links }
     * 
     */
    public Links createLinks() {
        return new Links();
    }

    /**
     * Create an instance of {@link Rights }
     * 
     */
    public Rights createRights() {
        return new Rights();
    }

    /**
     * Create an instance of {@link Links.Reference }
     * 
     */
    public Links.Reference createLinksReference() {
        return new Links.Reference();
    }

}
