package ch.unisg.ics.interactions.wiser.data.ilcd;

import javax.xml.bind.annotation.*;

@XmlRootElement
// order of the fields in XML

@XmlAccessorType(XmlAccessType.FIELD)
public class Geography {

    @XmlElement
    LocationOfOperationSupplyOrProduction locationOfOperationSupplyOrProduction;

    public LocationOfOperationSupplyOrProduction getLocationOfOperationSupplyOrProduction() {
        return locationOfOperationSupplyOrProduction;
    }
}

