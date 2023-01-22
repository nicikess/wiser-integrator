package ch.unisg.ics.interactions.wiser.data.ecoSpold;

import javax.xml.bind.annotation.*;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)

public class Review {

    @XmlAttribute
    String reviewedMajorRelease;

    @XmlAttribute
    String reviewedMinorRelease;

    @XmlAttribute
    String reviewedMajorRevision;

    @XmlAttribute
    String reviewedMinorRevision;

    @XmlAttribute
    String reviewerId;

    @XmlAttribute
    String reviewerName;

    @XmlAttribute
    String reviewerEmail;

    @XmlAttribute
    String reviewDate;

    @XmlElement
    String otherDetails;

    public String getReviewedMajorRelease() {
        return reviewedMajorRelease;
    }

    public String getReviewedMinorRelease() {
        return reviewedMinorRelease;
    }

    public String getReviewedMajorRevision() {
        return reviewedMajorRevision;
    }

    public String getReviewedMinorRevision() {
        return reviewedMinorRevision;
    }

    public String getReviewerId() {
        return reviewerId;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public String getReviewerEmail() {
        return reviewerEmail;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public String getOtherDetails() {
        return otherDetails;
    }
}
