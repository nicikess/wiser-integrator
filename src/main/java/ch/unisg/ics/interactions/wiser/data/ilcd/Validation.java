package ch.unisg.ics.interactions.wiser.data.ilcd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
public class Validation {

    @XmlElement
    Review review;

    public Review getReview() {
        return review;
    }
}