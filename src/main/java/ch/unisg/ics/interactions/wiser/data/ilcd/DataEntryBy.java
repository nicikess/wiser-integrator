package ch.unisg.ics.interactions.wiser.data.ilcd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
public class DataEntryBy {

    @XmlElement

    String timeStamp;

    ReferenceToDataSetFormat referenceToDataSetFormat;

    ReferenceToConvertedOriginalDataSetFrom referenceToConvertedOriginalDataSetFrom;

    ReferenceToPersonOrEntityEnteringTheData referenceToPersonOrEntityEnteringTheData;

    public String getTimeStamp() {
        return timeStamp;
    }

    public ReferenceToDataSetFormat getReferenceToDataSetFormat() {
        return referenceToDataSetFormat;
    }

    public ReferenceToConvertedOriginalDataSetFrom getReferenceToConvertedOriginalDataSetFrom() {
        return referenceToConvertedOriginalDataSetFrom;
    }

    public ReferenceToPersonOrEntityEnteringTheData getReferenceToPersonOrEntityEnteringTheData() {
        return referenceToPersonOrEntityEnteringTheData;
    }
}