package ch.unisg.ics.interactions.wiser.data.ilcd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
public class ModellingAndValidation {

    @XmlElement
    LCIMethodAndAllocation LCIMethodAndAllocation;

    DataSourcesTreatmentAndRepresentativeness dataSourcesTreatmentAndRepresentativeness;

    Completeness completeness;

    Validation validation;

    ComplianceDeclarations complianceDeclarations;


    public ch.unisg.ics.interactions.wiser.data.ilcd.LCIMethodAndAllocation getLCIMethodAndAllocation() {
        return LCIMethodAndAllocation;
    }

    public DataSourcesTreatmentAndRepresentativeness getDataSourcesTreatmentAndRepresentativeness() {
        return dataSourcesTreatmentAndRepresentativeness;
    }

    public Completeness getCompleteness() {
        return completeness;
    }

    public Validation getValidation() {
        return validation;
    }

    public ComplianceDeclarations getComplianceDeclarations() {
        return complianceDeclarations;
    }
}