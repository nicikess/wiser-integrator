package ch.unisg.ics.interactions.wiser.data.ilcd;

import javax.xml.bind.annotation.*;

@XmlRootElement
// order of the fields in XML

@XmlAccessorType(XmlAccessType.FIELD)
public class ReferenceToFlowDataSet {

    @XmlAttribute
    String type;

    @XmlAttribute
    String refObjectId;

    @XmlAttribute
    String version;

    @XmlAttribute
    String uri;

    @XmlElement
    String shortDescription;

    public String getType() {
        return type;
    }

    public String getRefObjectId() {
        return refObjectId;
    }

    public String getVersion() {
        return version;
    }

    public String getUri() {
        return uri;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}