package ch.unisg.ics.interactions.wiser.queries.ecoSpold;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.TimePeriod;
import ch.unisg.ics.interactions.wiser.tools.VocabularyEcoSpold;

public class TimePeriodQueryBuilder {

    private TimePeriod timePeriod;
    private String identifier;

    public TimePeriodQueryBuilder(TimePeriod timePeriod, String activityIdEcoSpold) {
        this.timePeriod = timePeriod;
        this.identifier = VocabularyEcoSpold.timePeriodIRI + activityIdEcoSpold;
    }

    public String createTimePeriodInsertionQuery() {

        String query =
                "PREFIX " + VocabularyEcoSpold.ecoSpoldBasePrefix + "\n" +
                "PREFIX " + VocabularyEcoSpold.ecoSpoldMetaInformationPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?timePeriod a " + VocabularyEcoSpold.timePeriod + ";\n" +
                        VocabularyEcoSpold.startDate + " \"" + timePeriod.getStartDate() + "\";\n" +
                        VocabularyEcoSpold.endDate + " \"" + timePeriod.getEndDate() + "\";\n" +
                        VocabularyEcoSpold.isDataValidForEntirePeriod + " " + timePeriod.getDataValidForEntirePeriod() + ";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI('" + identifier + "') AS ?timePeriod)" + "\n" +
                        "}";

        return query;

    }

    public String getIdentifier() {
        return identifier;
    }

}