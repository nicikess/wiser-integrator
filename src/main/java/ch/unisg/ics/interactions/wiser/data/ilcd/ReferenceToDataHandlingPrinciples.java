package ch.unisg.ics.interactions.wiser.data.ilcd;

import javax.xml.bind.annotation.*;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
public class ReferenceToDataHandlingPrinciples {

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
