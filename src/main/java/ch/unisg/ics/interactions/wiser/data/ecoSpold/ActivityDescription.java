package ch.unisg.ics.interactions.wiser.data.ecoSpold;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)

public class ActivityDescription {

    @XmlElement
    Activity activity;

    List<Classification> classification = new ArrayList<Classification>();

    Geography geography;

    Technology technology;

    TimePeriod timePeriod;

    MacroEconomicScenario macroEconomicScenario;

    public Activity getActivity() {
        return activity;
    }

    public List<Classification> getClassification() {
        return classification;
    }

    public Geography getGeography() {
        return geography;
    }

    public Technology getTechnology() {
        return technology;
    }

    public TimePeriod getTimePeriod() {
        return timePeriod;
    }

    public MacroEconomicScenario getMacroEconomicScenario() {
        return macroEconomicScenario;
    }
}
