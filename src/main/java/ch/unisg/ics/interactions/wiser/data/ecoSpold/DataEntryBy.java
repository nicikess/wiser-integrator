package ch.unisg.ics.interactions.wiser.data.ecoSpold;

import javax.xml.bind.annotation.*;

@XmlRootElement
// order of the fields in XML
// @XmlType(propOrder = {"price", "name"})
@XmlAccessorType(XmlAccessType.FIELD)
public class DataEntryBy {

    @XmlAttribute
    String personId;

    @XmlAttribute
    String isActiveAuthor;

    @XmlAttribute
    String personName;

    @XmlAttribute
    String personEmail;

    public String getPersonId() {
        return personId;
    }

    public String getIsActiveAuthor() {
        return isActiveAuthor;
    }

    public String getPersonName() {
        return personName;
    }

    public String getPersonEmail() {
        return personEmail;
    }
}
