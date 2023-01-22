package ch.unisg.ics.interactions.wiser.data.ilcd;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
public class Review {

    @XmlAttribute
    String type;

    @XmlElement
    List<Scope> scope = new ArrayList<Scope>();

    DataQualityIndicators dataQualityIndicators;

    String reviewDetails;

    List<ReferenceToNameOfReviewerAndInstitution> referenceToNameOfReviewerAndInstitution = new ArrayList<ReferenceToNameOfReviewerAndInstitution>();

    ReferenceToCompleteReviewReport referenceToCompleteReviewReport;


    public String getType() {
        return type;
    }

    public List<Scope> getScope() {
        return scope;
    }

    public DataQualityIndicators getDataQualityIndicators() {
        return dataQualityIndicators;
    }

    public String getReviewDetails() {
        return reviewDetails.replaceAll("\n", " ");
    }

    public List<ReferenceToNameOfReviewerAndInstitution> getReferenceToNameOfReviewerAndInstitution() {
        return referenceToNameOfReviewerAndInstitution;
    }

    public ReferenceToCompleteReviewReport getReferenceToCompleteReviewReport() {
        return referenceToCompleteReviewReport;
    }
}