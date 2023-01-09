package ch.unisg.ics.interactions.wiser.data.ilcd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement
// order of the fields in XML

@XmlAccessorType(XmlAccessType.FIELD)
public class Exchanges {

    @XmlElement
    List<Exchange> exchange = new ArrayList<Exchange>();


    public List<Exchange> getExchange() {
        return exchange;
    }
}