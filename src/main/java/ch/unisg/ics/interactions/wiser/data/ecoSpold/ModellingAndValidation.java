package ch.unisg.ics.interactions.wiser.data.ecoSpold;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)

public class ModellingAndValidation {

    @XmlElement
    Representativeness representativeness;

    List<Review> review = new ArrayList<Review>();

    public Representativeness getRepresentativeness() {
        return representativeness;
    }

    public List<Review> getReviews() {
        return review;
    }
}
