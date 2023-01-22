package ch.unisg.ics.interactions.wiser.data.ecoSpold;

import javax.xml.bind.annotation.*;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)

public class FileAttributes {

    @XmlAttribute
    String majorRelease;

    @XmlAttribute
    String minorRelease;

    @XmlAttribute
    String majorRevision;

    @XmlAttribute
    String minorRevision;

    @XmlAttribute
    String internalSchemaVersion;

    @XmlAttribute
    String defaultLanguage;

    @XmlAttribute
    String creationTimestamp;

    @XmlAttribute
    String lastEditTimestamp;

    @XmlAttribute
    String fileGenerator;

    @XmlAttribute
    String fileTimestamp;

    @XmlAttribute
    String contextId;

    @XmlElement
    String contextName;

    public String getMajorRelease() {
        return majorRelease;
    }

    public String getMinorRelease() {
        return minorRelease;
    }

    public String getMajorRevision() {
        return majorRevision;
    }

    public String getMinorRevision() {
        return minorRevision;
    }

    public String getInternalSchemaVersion() {
        return internalSchemaVersion;
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public String getCreationTimestamp() {
        return creationTimestamp;
    }

    public String getLastEditTimestamp() {
        return lastEditTimestamp;
    }

    public String getFileGenerator() {
        return fileGenerator;
    }

    public String getFileTimestamp() {
        return fileTimestamp;
    }

    public String getContextId() {
        return contextId;
    }
}
