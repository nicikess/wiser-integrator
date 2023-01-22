package ch.unisg.ics.interactions.wiser.data.ecoSpold;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)

public class GeneralComment {

    @XmlElement(name="text")
    private List<String> text = new ArrayList<String>();

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }

}