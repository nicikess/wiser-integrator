package ch.unisg.ics.interactions.wiser.data.ilcd;


import javax.xml.bind.annotation.*;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
public class QuantitativeReference {

    @XmlAttribute
    String type;

    @XmlElement
    String referenceToReferenceFlow;

    String functionalUnitOrOther;

    public String getType() {
        return type;
    }

    public String getReferenceToReferenceFlow() {
        return referenceToReferenceFlow;
    }

    public String getFunctionalUnitOrOther() {
        return functionalUnitOrOther;
    }
}
