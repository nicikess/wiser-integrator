package ch.unisg.ics.interactions.wiser.data.ecoSpold;

import javax.xml.bind.annotation.*;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)

public class PedigreeMatrix {

    @XmlAttribute
    String reliability;

    @XmlAttribute
    String completeness;

    @XmlAttribute
    String temporalCorrelation;

    @XmlAttribute
    String geographicalCorrelation;

    @XmlAttribute
    String furtherTechnologyCorrelation;

    public String getReliability() {
        return reliability;
    }

    public String getCompleteness() {
        return completeness;
    }

    public String getTemporalCorrelation() {
        return temporalCorrelation;
    }

    public String getGeographicalCorrelation() {
        return geographicalCorrelation;
    }

    public String getFurtherTechnologyCorrelation() {
        return furtherTechnologyCorrelation;
    }
}
