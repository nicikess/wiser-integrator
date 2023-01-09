package ch.unisg.ics.interactions.wiser.data.ecoSpold;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
// order of the fields in XML
// @XmlType(propOrder = {"price", "name"})
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

}

