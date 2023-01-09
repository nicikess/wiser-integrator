package ch.unisg.ics.interactions.wiser.data.ilcd;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.IntermediateExchange;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
// order of the fields in XML

@XmlAccessorType(XmlAccessType.FIELD)
public class LCIMethodAndAllocation {

    @XmlElement
    String typeOfDataSet;

    String LCIMethodPrinciple;

    String deviationsFromLCIMethodPrinciple;

    List<String> LCIMethodApproaches = new ArrayList<String>();

    String deviationsFromLCIMethodApproaches;

    ReferenceToLCAMethodDetails referenceToLCAMethodDetails;


    public String getTypeOfDataSet() {
        return typeOfDataSet;
    }

    public String getLCIMethodPrinciple() {
        return LCIMethodPrinciple;
    }

    public String getDeviationsFromLCIMethodPrinciple() {
        return deviationsFromLCIMethodPrinciple;
    }

    public List<String> getLCIMethodApproaches() {
        return LCIMethodApproaches;
    }

    public String getDeviationsFromLCIMethodApproaches() {
        return deviationsFromLCIMethodApproaches;
    }

    public ReferenceToLCAMethodDetails getReferenceToLCAMethodDetails() {
        return referenceToLCAMethodDetails;
    }
}