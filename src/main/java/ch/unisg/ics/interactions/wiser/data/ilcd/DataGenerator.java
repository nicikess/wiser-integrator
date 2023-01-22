package ch.unisg.ics.interactions.wiser.data.ilcd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
public class DataGenerator {

    @XmlElement
    List<ReferenceToPersonOrEntityGeneratingTheDataSet> referenceToPersonOrEntityGeneratingTheDataSet = new ArrayList<ReferenceToPersonOrEntityGeneratingTheDataSet>();

    public List<ReferenceToPersonOrEntityGeneratingTheDataSet> getReferenceToPersonOrEntityGeneratingTheDataSet() {
        return referenceToPersonOrEntityGeneratingTheDataSet;
    }
}