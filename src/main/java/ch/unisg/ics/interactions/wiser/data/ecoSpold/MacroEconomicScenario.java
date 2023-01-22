package ch.unisg.ics.interactions.wiser.data.ecoSpold;


import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)

public class MacroEconomicScenario {

    @XmlAttribute
    String macroEconomicScenarioId;

    @XmlElement
    String name;

    public String getMacroEconomicScenarioId() {
        return macroEconomicScenarioId;
    }

    public String getName() {
        return name;
    }
}
