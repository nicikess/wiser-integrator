package ch.unisg.ics.interactions.wiser.data;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class SkillSet {

    private List<String> skills = new ArrayList<String>();

    @XmlElement(name="Skill")
    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

}
