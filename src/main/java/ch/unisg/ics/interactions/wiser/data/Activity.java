package ch.unisg.ics.interactions.wiser.data;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
// order of the fields in XML
// @XmlType(propOrder = {"price", "name"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Activity {

    @XmlAttribute
    int specialActivityType;
    String id;
    String activityNameId;
    int inheritanceDepth;
    int type;
    int energyValues;

    @XmlElement(name = "n")
    String activityName;
    List<Synonym> synonyms = null;
    String includedActivitiesStart;
    String includedActivitiesEnd;

}

