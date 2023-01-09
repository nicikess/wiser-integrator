package ch.unisg.ics.interactions.wiser.data.ilcd;

import javax.xml.bind.annotation.*;

@XmlRootElement
// order of the fields in XML

@XmlAccessorType(XmlAccessType.FIELD)
public class ClassificationInformation {

    @XmlAttribute
    String name;

    @XmlAttribute
    String classes;

    @XmlElement
    Classification classification;

    public String getName() {
        return name;
    }

    public String getClasses() {
        return classes;
    }

    public Classification getClassification() {
        return classification;
    }
}
