package ch.unisg.ics.interactions.wiser.data.ecoSpold;

import javax.xml.bind.annotation.*;

@XmlRootElement
// order of the fields in XML

@XmlAccessorType(XmlAccessType.FIELD)
public class EcoSpold {

    @XmlElement
    ActivityDataset activityDataset;

    public ActivityDataset getActivityDataset() {
        return activityDataset;
    }
}
