package ch.unisg.ics.interactions.wiser.data.ilcd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
public class CommissionerAndGoal {

    @XmlElement
    List<ReferenceToCommissioner> referenceToCommissioner = new ArrayList<ReferenceToCommissioner>();

    String project;

    String intendedApplications;

    public List<ReferenceToCommissioner> getReferenceToCommissioner() {
        return referenceToCommissioner;
    }

    public String getProject() {
        return project;
    }

    public String getIntendedApplications() {
        return intendedApplications;
    }
}