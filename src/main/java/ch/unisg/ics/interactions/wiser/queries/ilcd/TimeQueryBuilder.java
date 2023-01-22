package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.Time;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class TimeQueryBuilder {

    private Time time;
    private String identifier;

    public TimeQueryBuilder(Time time, String activityIdIlcd) {
        this.time = time;
        this.identifier = VocabularyILCD.timeIRI + activityIdIlcd;
    }

    public String createTimeInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdProcessPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?time a " + VocabularyILCD.time + ";\n" +
                        VocabularyILCD.timeReferenceYear + " " + time.getReferenceYear() + ";\n" +
                        VocabularyILCD.timeDataSetValidUntil + " " + time.getDataSetValidUntil() + ";\n" +
                        VocabularyILCD.timeRepresentativenessDescription + " \"" + time.getTimeRepresentativenessDescription() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI('" + identifier + "') AS ?time)" + "\n" +
                        "}";

        return query;

    }

    public String getIdentifier() {
        return identifier;
    }


}