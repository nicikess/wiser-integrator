package ch.unisg.ics.interactions.wiser.data.ecoSpold;

import javax.xml.bind.annotation.*;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)

public class LogNormal {

    @XmlAttribute
    String classificationId;

    @XmlAttribute
    String meanValue;

    @XmlAttribute
    String mu;

    @XmlAttribute
    String variance;

    @XmlAttribute
    String varianceWithPedigreeUncertainty;

    public String getClassificationId() {
        return classificationId;
    }

    public String getMeanValue() {
        return meanValue;
    }

    public String getMu() {
        return mu;
    }

    public String getVariance() {
        return variance;
    }

    public String getVarianceWithPedigreeUncertainty() {
        return varianceWithPedigreeUncertainty;
    }
}
