package ch.unisg.ics.interactions.wiser.data.ecoSpold;


import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)

public class TimePeriod {

    @XmlAttribute
    String startDate;

    @XmlAttribute
    String endDate;

    @XmlAttribute
    Boolean isDataValidForEntirePeriod;

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public Boolean getDataValidForEntirePeriod() {
        return isDataValidForEntirePeriod;
    }
}
