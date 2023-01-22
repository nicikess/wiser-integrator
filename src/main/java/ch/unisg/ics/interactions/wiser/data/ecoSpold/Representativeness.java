package ch.unisg.ics.interactions.wiser.data.ecoSpold;

import javax.xml.bind.annotation.*;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)

public class Representativeness {

    @XmlAttribute
    String systemModelId;

    @XmlElement
    String systemModelName;

    String samplingProcedure;

    String extrapolations;

    public String getSystemModelId() {
        return systemModelId;
    }

    public String getSystemModelName() {
        return systemModelName;
    }

    public String getSamplingProcedure() {
        return samplingProcedure;
    }

    public String getExtrapolations() {
        return extrapolations;
    }
}
