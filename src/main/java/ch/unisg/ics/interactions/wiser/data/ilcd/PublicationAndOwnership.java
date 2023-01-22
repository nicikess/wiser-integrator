package ch.unisg.ics.interactions.wiser.data.ilcd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
public class PublicationAndOwnership {

    @XmlElement

    String dateOfLastRevision;

    String dataSetVersion;

    String workflowAndPublicationStatus;

    ReferenceToRegistrationAuthority referenceToRegistrationAuthority;

    String registrationNumber;

    ReferenceToOwnershipOfDataSet referenceToOwnershipOfDataSet;

    ReferenceToUnchangedRepublication referenceToUnchangedRepublication;

    String copyright;

    String licenseType;

    String accessRestrictions;

    public String getDateOfLastRevision() {
        return dateOfLastRevision;
    }

    public String getDataSetVersion() {
        return dataSetVersion;
    }

    public String getWorkflowAndPublicationStatus() {
        return workflowAndPublicationStatus;
    }

    public ReferenceToRegistrationAuthority getReferenceToRegistrationAuthority() {
        return referenceToRegistrationAuthority;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public ReferenceToOwnershipOfDataSet getReferenceToOwnershipOfDataSet() {
        return referenceToOwnershipOfDataSet;
    }

    public ReferenceToUnchangedRepublication getReferenceToUnchangedRepublication() {
        return referenceToUnchangedRepublication;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public String getAccessRestrictions() {
        return accessRestrictions.replaceAll("\n", " ");
    }
}