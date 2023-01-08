package ch.unisg.ics.interactions.wiser.data;


import javax.xml.bind.annotation.*;

@XmlRootElement
// order of the fields in XML
// @XmlType(propOrder = {"price", "name"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Fruit {

    @XmlAttribute
    int id;

    @XmlElement(name = "n")
    String name;

    String price;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

}
