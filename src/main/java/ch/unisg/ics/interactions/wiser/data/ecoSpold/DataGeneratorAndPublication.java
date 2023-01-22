package ch.unisg.ics.interactions.wiser.data.ecoSpold;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)

public class DataGeneratorAndPublication {

    @XmlAttribute
    String personId;

    @XmlAttribute
    String personName;

    @XmlAttribute
    String personEmail;

    @XmlAttribute
    String dataPublishedIn;

    @XmlAttribute
    String publishedSourceId;

    @XmlAttribute
    String publishedSourceYear;

    @XmlAttribute
    String publishedSourceFirstAuthor;

    @XmlAttribute
    String isCopyrightProtected;

    @XmlAttribute
    String accessRestrictedTo;

    @XmlAttribute
    String companyIdOverwrittenByChild;


    public String getPersonId() {
        return personId;
    }

    public String getPersonName() {
        return personName;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public String getDataPublishedIn() {
        return dataPublishedIn;
    }

    public String getPublishedSourceId() {
        return publishedSourceId;
    }

    public String getPublishedSourceYear() {
        return publishedSourceYear;
    }

    public String getPublishedSourceFirstAuthor() {
        return publishedSourceFirstAuthor;
    }

    public String getIsCopyrightProtected() {
        return isCopyrightProtected;
    }

    public String getAccessRestrictedTo() {
        return accessRestrictedTo;
    }

    public String getCompanyIdOverwrittenByChild() {
        return companyIdOverwrittenByChild;
    }
}
