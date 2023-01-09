package ch.unisg.ics.interactions.wiser.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="SkillSets")

public class SkillSets<SkillSet> {

    private List<SkillSet> skills = new ArrayList<SkillSet>();

    @XmlElement(name="SkillSet")
    public List<SkillSet> getSkills() {
        return skills;
    }
    public void setSkills(List<SkillSet> skills) {
        this.skills = skills;
    }
}
