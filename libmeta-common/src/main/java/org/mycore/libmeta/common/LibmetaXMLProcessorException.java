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

/**
 * This class wraps JAXBExceptions, TransformerExceptions and other
 * exceptions that occur during processing or creating of the XML documents.
 * 
 * @author Robert Stephan
 *
 */
public class LibmetaXMLProcessorException extends Exception {
    private static final long serialVersionUID = 1L;

    public LibmetaXMLProcessorException() {
        super();
    }

    public LibmetaXMLProcessorException(String message, Throwable cause, boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public LibmetaXMLProcessorException(String message, Throwable cause) {
        super(message, cause);
    }

    public LibmetaXMLProcessorException(String message) {
        super(message);
    }

    public LibmetaXMLProcessorException(Throwable cause) {
        super(cause);
    }

}
