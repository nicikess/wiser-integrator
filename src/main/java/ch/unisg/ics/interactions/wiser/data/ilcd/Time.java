package ch.unisg.ics.interactions.wiser.data.ilcd;

import javax.xml.bind.annotation.*;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
public class Time {

    @XmlElement
    String referenceYear;

    String dataSetValidUntil;

    String timeRepresentativenessDescription;

    public String getReferenceYear() {
        return referenceYear;
    }

    public String getDataSetValidUntil() {
        return dataSetValidUntil;
    }

    public String getTimeRepresentativenessDescription() {
        return timeRepresentativenessDescription;
    }
}
