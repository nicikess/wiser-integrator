package ch.unisg.ics.interactions.wiser.data.ecoSpold;


import javax.xml.bind.annotation.*;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)

public class Property {

    @XmlAttribute
    String propertyId;

    @XmlAttribute
    String amount;

    @XmlAttribute
    String isDefiningValue;

    @XmlAttribute
    String unitId;

    @XmlElement
    String name;

    String unitName;

    String comment;

    public String getPropertyId() {
        return propertyId;
    }

    public String getAmount() {
        return amount;
    }

    public String getIsDefiningValue() {
        return isDefiningValue;
    }

    public String getUnitId() {
        return unitId;
    }

    public String getName() {
        return name;
    }

    public String getUnitName() {
        return unitName;
    }

    public String getComment() {
        return comment;
    }
}
