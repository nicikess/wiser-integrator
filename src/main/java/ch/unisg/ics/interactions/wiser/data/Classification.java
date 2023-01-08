package ch.unisg.ics.interactions.wiser.data;


import javax.xml.bind.annotation.*;

@XmlRootElement
// order of the fields in XML
// @XmlType(propOrder = {"price", "name"})
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
