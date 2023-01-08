package ch.unisg.ics.interactions.wiser.data;


import javax.xml.bind.annotation.*;

@XmlRootElement
// order of the fields in XML
// @XmlType(propOrder = {"price", "name"})
@XmlAccessorType(XmlAccessType.FIELD)
public class EcoSpold {

    @XmlAttribute(name = "xmlns")
    int id;

    public int getId(){
        return id;
    }

}
