package ch.unisg.ics.interactions.wiser.data.ilcd;

import javax.xml.bind.annotation.*;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
public class Name {

    @XmlElement
    String baseName;

    String treatmentStandardsRoutes;

    String mixAndLocationTypes;

    public String getBaseName() {
        return baseName;
    }

    public String getTreatmentStandardsRoutes() {
        return treatmentStandardsRoutes;
    }

    public String getMixAndLocationTypes() {
        return mixAndLocationTypes;
    }
}
