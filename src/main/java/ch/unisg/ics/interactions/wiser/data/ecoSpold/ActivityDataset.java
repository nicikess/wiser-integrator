package ch.unisg.ics.interactions.wiser.data.ecoSpold;

import javax.xml.bind.annotation.*;

@XmlRootElement
// order of the fields in XML
// @XmlType(propOrder = {"price", "name"})
@XmlAccessorType(XmlAccessType.FIELD)
public class ActivityDataset {

    @XmlElement
    ActivityDescription activityDescription;

    FlowData flowData;

    ModellingAndValidation modellingAndValidation;

    AdministrativeInformation administrativeInformation;

    public ActivityDescription getActivityDescription() {
        return activityDescription;
    }

    public FlowData getFlowData() {
        return flowData;
    }

    public ModellingAndValidation getModellingAndValidation() {
        return modellingAndValidation;
    }

    public AdministrativeInformation getAdministrativeInformation() {
        return administrativeInformation;
    }
}