package ch.unisg.ics.interactions.wiser.data.ecoSpold;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)

public class IntermediateExchange {

    @XmlAttribute
    String id;

    @XmlAttribute
    String classificationId;

    @XmlAttribute
    String unitId;

    @XmlAttribute
    String variableName;

    @XmlAttribute
    String casNumber;

    @XmlAttribute
    String amount;

    @XmlAttribute
    String intermediateExchangeId;

    @XmlAttribute
    String productionVolumeAmount;

    @XmlAttribute
    String productionVolumeVariableName;

    @XmlAttribute
    String productionVolumeMathematicalRelation;

    @XmlElement
    String name;

    String unitName;

    List<Property> property = new ArrayList<Property>();

    String productionVolumeComment;

    ProductionVolumeUncertainty productionVolumeUncertainty;

    List<Classification> classification = new ArrayList<Classification>();

    String outputGroup;

    public String getId() {
        return id;
    }

    public String getClassificationId() {
        return classificationId;
    }

    public String getUnitId() {
        return unitId;
    }

    public String getVariableName() {
        return variableName;
    }

    public String getCasNumber() {
        return casNumber;
    }

    public String getAmount() {
        return amount;
    }

    public String getIntermediateExchangeId() {
        return intermediateExchangeId;
    }

    public String getProductionVolumeAmount() {
        return productionVolumeAmount;
    }

    public String getProductionVolumeVariableName() {
        return productionVolumeVariableName;
    }

    public String getProductionVolumeMathematicalRelation() {
        return productionVolumeMathematicalRelation;
    }

    public String getName() {
        return name;
    }

    public String getUnitName() {
        return unitName;
    }

    public List<Property> getProperty() {
        return property;
    }

    public String getProductionVolumeComment() {
        return productionVolumeComment;
    }

    public ProductionVolumeUncertainty getProductionVolumeUncertainty() {
        return productionVolumeUncertainty;
    }

    public List<Classification> getClassification() {
        return classification;
    }

    public String getOutputGroup() {
        return outputGroup;
    }
}

