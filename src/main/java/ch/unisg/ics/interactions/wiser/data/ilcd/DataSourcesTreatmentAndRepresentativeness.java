package ch.unisg.ics.interactions.wiser.data.ilcd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
// order of the fields in XML

@XmlAccessorType(XmlAccessType.FIELD)
public class DataSourcesTreatmentAndRepresentativeness {

    @XmlElement
    String dataCutOffAndCompletenessPrinciples;

    String deviationsFromCutOffAndCompletenessPrinciples;

    String dataSelectionAndCombinationPrinciples;

    String deviationsFromSelectionAndCombinationPrinciples;

    List<ReferenceToDataHandlingPrinciples> referenceToDataHandlingPrinciples = new ArrayList<ReferenceToDataHandlingPrinciples>();

    String annualSupplyOrProductionVolume;

    String dataCollectionPeriod;

    String useAdviceForDataSet;


    public String getDataCutOffAndCompletenessPrinciples() {
        return dataCutOffAndCompletenessPrinciples;
    }

    public String getDeviationsFromCutOffAndCompletenessPrinciples() {
        return deviationsFromCutOffAndCompletenessPrinciples;
    }

    public String getDataSelectionAndCombinationPrinciples() {
        return dataSelectionAndCombinationPrinciples;
    }

    public String getDeviationsFromSelectionAndCombinationPrinciples() {
        return deviationsFromSelectionAndCombinationPrinciples;
    }

    public List<ReferenceToDataHandlingPrinciples> getReferenceToDataHandlingPrinciples() {
        return referenceToDataHandlingPrinciples;
    }

    public String getAnnualSupplyOrProductionVolume() {
        return annualSupplyOrProductionVolume;
    }

    public String getDataCollectionPeriod() {
        return dataCollectionPeriod;
    }

    public String getUseAdviceForDataSet() {
        return useAdviceForDataSet;
    }
}
