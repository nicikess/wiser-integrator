package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.Technology;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class TechnologyQueryBuilder {

    private Technology technology;
     private String identifier;

    public TechnologyQueryBuilder(Technology technology, String activityIdIlcd) {
        this.technology = technology;
        this.identifier = VocabularyILCD.technologyIRI + activityIdIlcd;
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
                        "BIND(IRI('" + identifier + "') AS ?technology)" + "\n" +
                        "}";

        return query;

    }

    public String getIdentifier() {
        return identifier;
    }


}