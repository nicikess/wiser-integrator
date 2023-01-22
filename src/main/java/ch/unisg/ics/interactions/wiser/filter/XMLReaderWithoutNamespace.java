package ch.unisg.ics.interactions.wiser.filter;

import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;

public class XMLReaderWithoutNamespace extends StreamReaderDelegate {

    public XMLReaderWithoutNamespace(XMLStreamReader reader) {
        super(reader);
    }

    /**
     * Ignores namespaces to prevent unmarshalling errors
     */

    @Override
    public String getAttributeNamespace(int arg0) {
        return "";
    }
    @Override
    public String getNamespaceURI() {
        return "";
    }
}