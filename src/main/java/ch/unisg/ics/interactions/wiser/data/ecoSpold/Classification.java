package ch.unisg.ics.interactions.wiser.data.ecoSpold;


import javax.xml.bind.annotation.*;

@XmlRootElement
// order of the fields in XML

@XmlAccessorType(XmlAccessType.FIELD)
public class Classification {

    @XmlAttribute
    String classificationId;

    @XmlElement
    String classificationSystem;

    String classificationValue;

    public String getId() {
        return classificationId;
    }

    public String getclassificationSystem() {
        return classificationSystem;
    }

    public String getclassificationValue() {
        return classificationValue;
    }

}
