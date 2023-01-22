package ch.unisg.ics.interactions.wiser.data.ilcd;


import javax.xml.bind.annotation.*;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
public class ProcessDataSet {

    @XmlElement
    ProcessInformation processInformation;

    AdministrativeInformation administrativeInformation;

    ModellingAndValidation modellingAndValidation;

    Exchanges exchanges;


    public ProcessInformation getProcessInformation() {
        return processInformation;
    }

    public AdministrativeInformation getAdministrativeInformation() {
        return administrativeInformation;
    }

    public ModellingAndValidation getModellingAndValidation() {
        return modellingAndValidation;
    }

    public Exchanges getExchanges() {
        return exchanges;
    }
}
