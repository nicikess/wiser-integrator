package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.Technology;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class TechnologyQueryBuilder {

    private Technology technology;
    private String activityIdIlcd;

    public TechnologyQueryBuilder(Technology technology, String activityIdIlcd) {
        this.technology = technology;
        this.activityIdIlcd = activityIdIlcd;
    }

    public String createTechnologyInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdProcessPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?technology a " + VocabularyILCD.technology + ";\n" +
                        VocabularyILCD.technologyDescriptionAndIncludedProcesses + " \"" + technology.getTechnologyDescriptionAndIncludedProcesses() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI(" + VocabularyILCD.technologyIRI + activityIdIlcd + "') AS ?technology)" + "\n" +
                        "}";

        return query;

    }


}