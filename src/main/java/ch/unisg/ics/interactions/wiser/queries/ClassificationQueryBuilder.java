package ch.unisg.ics.interactions.wiser.queries;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.Classification;
import ch.unisg.ics.interactions.wiser.tools.VocabularyEcoSpold;

public class ClassificationQueryBuilder {

    private Classification classification;
    private String activityIdEcoSpold;

    public ClassificationQueryBuilder(Classification classification, String activityIdEcoSpold) {
        this.classification = classification;
        this.activityIdEcoSpold = activityIdEcoSpold;
    }

    public String createClassificationInsertionQuery() {

        String query =
                "PREFIX " + VocabularyEcoSpold.ecoSpoldDataTypesPrefix + "\n" +
                "PREFIX " + VocabularyEcoSpold.bridgingOntologyPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?classification a " + VocabularyEcoSpold.classification + ";\n" +
                        VocabularyEcoSpold.classificationId + " " + classification.getId() + ";\n" +
                        VocabularyEcoSpold.classificationSystem + " \"" + classification.getclassificationSystem() + "\";\n" +
                        VocabularyEcoSpold.classificationValue + " \"" + classification.getclassificationValue() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI(" + VocabularyEcoSpold.classificationIRI + activityIdEcoSpold + "') AS ?classification)" + "\n" +
                        "}";

        return query;

    }


}