package ch.unisg.ics.interactions.wiser.data.ecoSpold;

import javax.xml.bind.annotation.*;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)

public class AdministrativeInformation {

    @XmlElement
    DataEntryBy dataEntryBy;

    DataGeneratorAndPublication dataGeneratorAndPublication;

    FileAttributes fileAttributes;

    public DataEntryBy getDataEntryBy() {
        return dataEntryBy;
    }

    public DataGeneratorAndPublication getDataGeneratorAndPublication() {
        return dataGeneratorAndPublication;
    }

    public FileAttributes getFileAttributes() {
        return fileAttributes;
    }
}
