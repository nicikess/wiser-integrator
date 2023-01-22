package ch.unisg.ics.interactions.wiser.data.ilcd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
public class ProcessInformation {

    @XmlElement
    DataSetInformation dataSetInformation;

    QuantitativeReference quantitativeReference;

    Time time;

    Geography geography;

    Technology technology;

    public DataSetInformation getDataSetInformation() {
        return dataSetInformation;
    }

    public QuantitativeReference getQuantitativeReference() {
        return quantitativeReference;
    }

    public Time getTime() {
        return time;
    }

    public Geography getGeography() {
        return geography;
    }

    public Technology getTechnology() {
        return technology;
    }
}