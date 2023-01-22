package ch.unisg.ics.interactions.wiser.data.ecoSpold;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
public class Activity {

    @XmlAttribute
    int specialActivityType;

    @XmlAttribute
    String id;

    @XmlAttribute
    String activityNameId;

    @XmlAttribute
    int inheritanceDepth;

    @XmlAttribute
    int type;

    @XmlAttribute
    int energyValues;

    @XmlElement()
    String activityName;

    private List<String> synonym = new ArrayList<String>();

    String includedActivitiesStart;

    String includedActivitiesEnd;

    private List<GeneralComment> generalComment = new ArrayList<GeneralComment>();

    public List<String> getSynonyms() {
        return synonym;
    }

    public List<GeneralComment> getComment() {
        return generalComment;
    }

    public int getSpecialActivityType() {
        return specialActivityType;
    }

    public String getId() {
        return id;
    }

    public String getActivityNameId() {
        return activityNameId;
    }

    public int getInheritanceDepth() {
        return inheritanceDepth;
    }

    public int getType() {
        return type;
    }

    public int getEnergyValues() {
        return energyValues;
    }

    public String getActivityName() {
        return activityName;
    }

    public String getIncludedActivitiesStart() {
        return includedActivitiesStart;
    }

    public String getIncludedActivitiesEnd() {
        return includedActivitiesEnd;
    }

    public List<GeneralComment> getGeneralComment() {
        return generalComment;
    }


}

