package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.DataEntryBy;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class DataEntryByQueryBuilder {

    private DataEntryBy dataEntryBy;
    private String identifier;

    public DataEntryByQueryBuilder(DataEntryBy dataEntryBy, String activityIdILCD) {
        this.dataEntryBy = dataEntryBy;
        this.identifier = VocabularyILCD.dataEntryByIRI + activityIdILCD;
    }

    public String createDataEntryByInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdProcessPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?dataEntryBy a " + VocabularyILCD.dataEntryByType + ";\n" +
                        VocabularyILCD.dataEntryByTimeStamp + " \"" + dataEntryBy.getTimeStamp() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI('" + identifier + "') AS ?dataEntryBy)" + "\n" +
                        "}";

        return query;

    }

    public String getIdentifier() {
        return identifier;
    }

}