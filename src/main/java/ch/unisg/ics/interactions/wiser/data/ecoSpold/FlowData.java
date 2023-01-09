package ch.unisg.ics.interactions.wiser.data.ecoSpold;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
// order of the fields in XML

@XmlAccessorType(XmlAccessType.FIELD)
public class FlowData {

    @XmlElement
    List<IntermediateExchange> intermediateExchange = new ArrayList<IntermediateExchange>();

    public List<IntermediateExchange> getIntermediateExchange() {
        return intermediateExchange;
    }
}
