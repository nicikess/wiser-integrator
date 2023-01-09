package ch.unisg.ics.interactions.wiser.data.ilcd;

import javax.xml.bind.annotation.*;


@XmlRootElement
// order of the fields in XML

@XmlAccessorType(XmlAccessType.FIELD)
public class LocationOfOperationSupplyOrProduction {

    @XmlAttribute
    String location;

    @XmlElement
    String descriptionOfRestrictions;

    public String getLocation() {
        return location;
    }

    public String getDescriptionOfRestrictions() {
        return descriptionOfRestrictions;
    }
}