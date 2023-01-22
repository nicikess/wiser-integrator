package ch.unisg.ics.interactions.wiser.queries.ecoSpold;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.Classification;
import ch.unisg.ics.interactions.wiser.tools.VocabularyEcoSpold;

public class ClassificationQueryBuilder {

    private Classification classification;
    private String identifier;

    public ClassificationQueryBuilder(Classification classification, String activityIdEcoSpold) {
        this.classification = classification;
        this.identifier = VocabularyEcoSpold.classificationIRI + activityIdEcoSpold + "/"+ classification.getId();
    }

    public String createClassificationInsertionQuery() {

        String query =
                "PREFIX " + VocabularyEcoSpold.ecoSpoldTypesPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?classification a " + VocabularyEcoSpold.classification + ";\n" +
                        VocabularyEcoSpold.classificationId + " \"" + classification.getId() + "\";\n" +
                        VocabularyEcoSpold.classificationSystem + " \"" + classification.getclassificationSystem() + "\";\n" +
                        VocabularyEcoSpold.classificationValue + " \"" + classification.getclassificationValue() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI('" + identifier + "') AS ?classification)" + "\n" +
                        "}";

        return query;

    }

    public String getIdentifier() {
        return identifier;
    }


}