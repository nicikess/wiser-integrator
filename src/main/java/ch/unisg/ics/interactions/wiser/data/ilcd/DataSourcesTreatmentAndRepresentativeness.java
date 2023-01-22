package ch.unisg.ics.interactions.wiser.data.ilcd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
public class DataSourcesTreatmentAndRepresentativeness {

    @XmlElement
    String dataCutOffAndCompletenessPrinciples;

    String deviationsFromCutOffAndCompletenessPrinciples;

    String dataSelectionAndCombinationPrinciples;

    String deviationsFromSelectionAndCombinationPrinciples;

    List<ReferenceToDataSource> referenceToDataSource = new ArrayList<ReferenceToDataSource>();

    String annualSupplyOrProductionVolume;

    String dataCollectionPeriod;

    String useAdviceForDataSet;

    String dataTreatmentAndExtrapolationsPrinciples;

    public String getDataCutOffAndCompletenessPrinciples() {
        return dataCutOffAndCompletenessPrinciples.replaceAll("\n", " ");
    }

    public String getDeviationsFromCutOffAndCompletenessPrinciples() {
        return deviationsFromCutOffAndCompletenessPrinciples;
    }

    public String getDataSelectionAndCombinationPrinciples() {
        return dataSelectionAndCombinationPrinciples.replaceAll("\n", " ");
    }

    public String getDeviationsFromSelectionAndCombinationPrinciples() {
        return deviationsFromSelectionAndCombinationPrinciples;
    }

    public List<ReferenceToDataSource> getReferenceToDataSources() {
        return referenceToDataSource;
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

    public String getDataTreatmentAndExtrapolationsPrinciples() {
        return dataTreatmentAndExtrapolationsPrinciples.replaceAll("\n", " ");
    }

}
