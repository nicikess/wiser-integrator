package ch.unisg.ics.interactions.wiser.data.ecoSpold;


import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)

public class Geography {

    @XmlAttribute
    String geographyId;

    @XmlElement
    String shortname;

    private List<GeneralComment> comment = new ArrayList<GeneralComment>();

    public String getGeographyId() {
        return geographyId;
    }

    public String getShortname() {
        return shortname;
    }

    public List<GeneralComment> getComment() {
        return comment;
    }

}
