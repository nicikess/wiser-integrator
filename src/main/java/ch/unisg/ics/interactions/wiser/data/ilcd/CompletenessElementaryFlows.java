package ch.unisg.ics.interactions.wiser.data.ilcd;

import javax.xml.bind.annotation.*;


@XmlRootElement
// order of the fields in XML

@XmlAccessorType(XmlAccessType.FIELD)
public class CompletenessElementaryFlows {

    @XmlAttribute
    String type;

    @XmlAttribute
    String value;

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}