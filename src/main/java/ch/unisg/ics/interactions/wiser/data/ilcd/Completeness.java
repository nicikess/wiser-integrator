package ch.unisg.ics.interactions.wiser.data.ilcd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
public class Completeness {

    @XmlElement
    String completenessProductModel;

    List<CompletenessElementaryFlows> completenessElementaryFlow = new ArrayList<CompletenessElementaryFlows>();

    String completenessOtherProblemField;

    public String getCompletenessProductModel() {
        return completenessProductModel;
    }

    public List<CompletenessElementaryFlows> getCompletenessElementaryFlow() {
        return completenessElementaryFlow;
    }

    public String getCompletenessOtherProblemField() {
        return completenessOtherProblemField;
    }
}
