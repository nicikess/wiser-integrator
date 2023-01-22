package ch.unisg.ics.interactions.wiser.data.ilcd;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.Classification;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
public class DataSetInformation {

    @XmlElement
    String UUID;

    Name name;

    String synonyms;

    ClassificationInformation classificationInformation;

    String generalComment;

    List<ReferenceToExternalDocumentation> referenceToExternalDocumentation = new ArrayList<ReferenceToExternalDocumentation>();

    public String getUUID() {
        return UUID;
    }

    public Name getName() {
        return name;
    }

    public String getSynonyms() {
        return synonyms;
    }

    public ClassificationInformation getClassificationInformation() {
        return classificationInformation;
    }

    public String getGeneralComment() {
        return generalComment.replaceAll("\n", " ");
    }

    public List<ReferenceToExternalDocumentation> getReferenceToExternalDocumentation() {
        return referenceToExternalDocumentation;
    }
}
