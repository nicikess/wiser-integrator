package ch.unisg.ics.interactions.wiser.data.ilcd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
public class Technology {

    @XmlElement
    String technologyDescriptionAndIncludedProcesses;

    String technologicalApplicability;

    String timeRepresentativenessDescription;

    ReferenceToTechnologyFlowDiagrammOrPicture referenceToTechnologyFlowDiagrammOrPicture;

    public String getTechnologyDescriptionAndIncludedProcesses() {
        return technologyDescriptionAndIncludedProcesses.replaceAll("\n", " ").replaceAll("\""," ");
    }

    public String getTechnologicalApplicability() {
        return technologicalApplicability;
    }

    public String getTimeRepresentativenessDescription() {
        return timeRepresentativenessDescription;
    }

    public ReferenceToTechnologyFlowDiagrammOrPicture getReferenceToTechnologyFlowDiagrammOrPicture() {
        return referenceToTechnologyFlowDiagrammOrPicture;
    }
}
