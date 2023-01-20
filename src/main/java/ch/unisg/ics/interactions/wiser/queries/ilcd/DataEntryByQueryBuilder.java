package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.DataEntryBy;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class DataEntryByQueryBuilder {

    private DataEntryBy dataEntryBy;
    private String activityIdILCD;

    public DataEntryByQueryBuilder(DataEntryBy dataEntryBy, String activityIdILCD) {
        this.dataEntryBy = dataEntryBy;
        this.activityIdILCD = activityIdILCD;
    }

    public String createDataEntryByInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdProcessPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdDatatypesPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?dataEntryBy a " + VocabularyILCD.dataEntryByType + ";\n" +
                        VocabularyILCD.dataEntryByTimeStamp + " \"" + dataEntryBy.getTimeStamp() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI(" + VocabularyILCD.dataEntryByIRI + activityIdILCD + "') AS ?dataEntryBy)" + "\n" +
                        "}";

        return query;

    }


}