package ch.unisg.ics.interactions.wiser.data.ilcd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)

public class AdministrativeInformation {

    @XmlElement
    CommissionerAndGoal commissionerAndGoal;

    DataGenerator dataGenerator;

    DataEntryBy dataEntryBy;

    PublicationAndOwnership publicationAndOwnership;

    public CommissionerAndGoal getCommissionerAndGoal() {
        return commissionerAndGoal;
    }

    public DataGenerator getDataGenerator() {
        return dataGenerator;
    }

    public DataEntryBy getDataEntryBy() {
        return dataEntryBy;
    }

    public PublicationAndOwnership getPublicationAndOwnership() {
        return publicationAndOwnership;
    }
}