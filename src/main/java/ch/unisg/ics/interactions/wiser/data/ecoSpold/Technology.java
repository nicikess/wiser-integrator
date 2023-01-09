package ch.unisg.ics.interactions.wiser.data.ecoSpold;


import ch.unisg.ics.interactions.wiser.data.ecoSpold.GeneralComment;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
// order of the fields in XML
// @XmlType(propOrder = {"price", "name"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Technology {

    @XmlAttribute
    String technologyLevel;

    @XmlElement
    private List<GeneralComment> comment = new ArrayList<GeneralComment>();

    public String getTechnologyLevel() {
        return technologyLevel;
    }

    public List<GeneralComment> getComment() {
        return comment;
    }

}