package ch.unisg.ics.interactions.wiser.data.ilcd;

import javax.xml.bind.annotation.*;


@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
public class LocationOfOperationSupplyOrProduction {

    @XmlAttribute
    String location;

    @XmlAttribute
    String latitudeAndLongitude;

    @XmlElement
    String descriptionOfRestrictions;

    public String getLocation() {
        return location;
    }

    public String getLatitudeAndLongitude() {
        return latitudeAndLongitude;
    }

    public String getDescriptionOfRestrictions() {
        return descriptionOfRestrictions.replaceAll("\n", " ");
    }
}