package ch.unisg.ics.interactions.wiser.data.ecoSpold;


import javax.xml.bind.annotation.*;

@XmlRootElement
// order of the fields in XML
// @XmlType(propOrder = {"price", "name"})
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductionVolumeUncertainty {

    @XmlElement
    LogNormal lognormal;

    @XmlElement
    PedigreeMatrix pedigreeMatrix;

    @XmlElement
    String comment;

    public LogNormal getLognormal() {
        return lognormal;
    }

    public PedigreeMatrix getPedigreeMatrix() {
        return pedigreeMatrix;
    }

    public String getComment() {
        return comment;
    }
}
