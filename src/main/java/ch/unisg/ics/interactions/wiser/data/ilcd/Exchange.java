package ch.unisg.ics.interactions.wiser.data.ilcd;

import javax.xml.bind.annotation.*;


@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
public class Exchange {

    @XmlAttribute
    String dataSetInternalID;

    @XmlElement
    ReferenceToFlowDataSet referenceToFlowDataSet;

    String location;

    String exchangeDirection;

    String meanAmount;

    String resultingAmount;

    public String getDataSetInternalID() {
        return dataSetInternalID;
    }

    public ReferenceToFlowDataSet getReferenceToFlowDataSet() {
        return referenceToFlowDataSet;
    }

    public String getLocation() {
        return location;
    }

    public String getExchangeDirection() {
        return exchangeDirection;
    }

    public String getMeanAmount() {
        return meanAmount;
    }

    public String getResultingAmount() {
        return resultingAmount;
    }
}