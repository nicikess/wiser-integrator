package ch.unisg.ics.interactions.wiser.data.ilcd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
public class Comliance {

    @XmlElement
    ReferenceToComplianceSystem referenceToComplianceSystem;

    String approvalOfOverallCompliance;

    String nomenclatureCompliance;

    String methodologicalCompliance;

    String reviewCompliance;

    String documentationCompliance;

    String qualityCompliance;

    public ReferenceToComplianceSystem getReferenceToComplianceSystem() {
        return referenceToComplianceSystem;
    }

    public String getApprovalOfOverallCompliance() {
        return approvalOfOverallCompliance;
    }

    public String getNomenclatureCompliance() {
        return nomenclatureCompliance;
    }

    public String getMethodologicalCompliance() {
        return methodologicalCompliance;
    }

    public String getReviewCompliance() {
        return reviewCompliance;
    }

    public String getDocumentationCompliance() {
        return documentationCompliance;
    }

    public String getQualityCompliance() {
        return qualityCompliance;
    }
}