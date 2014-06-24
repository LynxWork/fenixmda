package mx.com.damsolutions.xml.dom;


import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

/**
 * Simple Sample that:
 * - Generates a DOM from scratch.
 * - Writes the DOM to a String using an LSSerializer
 * @author Juan Arturo Vargas Torrres
 * @version $Id: DOMGenerate.java 546623 2007-06-12 20:25:08Z jvargas $
 */
public class DOMGenerator {

	 public static void main( String[] argv ) {
	        try {
	            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	            dbf.setNamespaceAware(true);
	            DocumentBuilder db = dbf.newDocumentBuilder();
	            Document doc = db.newDocument();
	            
	            Element root = doc.createElementNS("http://java.sun.com/jsf/facelets", "composition"); // Create Root Element
	            root.setPrefix("ui");
	            
	            Element item = doc.createElementNS("http://java.sun.com/jsf/html", "form");   // Create element
	            item.setPrefix("h");
	            item.appendChild( doc.createTextNode("Jeff") );
	            root.appendChild( item );                           // Attach element to Root element
	            
	            Element input = doc.createElement("inputText");            // Create another Element
	            input.appendChild( doc.createTextNode("28" ) );       
	            item.appendChild( input );                           // Attach Element to previous element down tree
	            
	            item = doc.createElementNS(null, "height");            
	            item.appendChild( doc.createTextNode("1.80" ) );
	            root.appendChild( item );                           // Attach another Element - grandaugther
	            doc.appendChild( root );                            // Add Root to Document

	            DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
	            DOMImplementationLS domImplLS = (DOMImplementationLS)registry.getDOMImplementation("LS");
	            
	            LSSerializer ser = domImplLS.createLSSerializer();  // Create a serializer for the DOM
	            LSOutput out = domImplLS.createLSOutput();
	            StringWriter stringOut = new StringWriter();        // Writer will be a String
	            out.setCharacterStream(stringOut);
	            ser.write(doc, out);                                // Serialize the DOM

	            System.out.println( "STRXML = " 
	                    + stringOut.toString() );                   // Spit out the DOM as a String
	        } catch ( Exception ex ) {
	            ex.printStackTrace();
	        }
	    }

}
