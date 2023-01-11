package ch.unisg.ics.interactions.wiser.queries;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.Technology;
import ch.unisg.ics.interactions.wiser.tools.VocabularyEcoSpold;

public class TechnologyQueryBuilder {

    private Technology technology;
    private String activityIdEcoSpold;

    public TechnologyQueryBuilder(Technology technology, String activityIdEcoSpold) {
        this.technology = technology;
        this.activityIdEcoSpold = activityIdEcoSpold;
    }

    public String createTechnologyInsertionQuery() {

        String query =
                "PREFIX " + VocabularyEcoSpold.ecoSpoldDataActivityPrefix + "\n" +
                "PREFIX " + VocabularyEcoSpold.ecoSpoldDataBasePrefix + "\n" +
                "PREFIX " + VocabularyEcoSpold.ecoSpoldDataMetaInformationPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?technology a " + VocabularyEcoSpold.technology + ";\n" +
                        VocabularyEcoSpold.technologyLevel + " " + technology.getTechnologyLevel() + ";\n" +
                        VocabularyEcoSpold.technologyComment + " \"" + technology.getComment().get(0).getText().get(0) + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI(" + VocabularyEcoSpold.technologyIRI + activityIdEcoSpold + "') AS ?technology)" + "\n" +
                        "}";

        return query;

    }


}