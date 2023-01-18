package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.Geography;
import ch.unisg.ics.interactions.wiser.data.ilcd.QuantitativeReference;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class QuantitativeReferenceQueryBuilder {

    private QuantitativeReference quantitativeReference;
    private String activityIdIlcd;

    public QuantitativeReferenceQueryBuilder(QuantitativeReference quantitativeReference, String activityIdIlcd) {
        this.quantitativeReference = quantitativeReference;
        this.activityIdIlcd = activityIdIlcd;
    }

    public String createQuantitativeReferenceInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdProcessPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdCommonEnumeration + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?quantitativeReference a " + VocabularyILCD.quantitativeReference + ";\n" +
                        VocabularyILCD.quantitativeReferenceType + " \"" + quantitativeReference.getType() + "\";\n" +
                        VocabularyILCD.referenceToReferenceFlow + " " + quantitativeReference.getReferenceToReferenceFlow() + ";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI(" + VocabularyILCD.quantitativeReferenceIRI + activityIdIlcd + "') AS ?quantitativeReference)" + "\n" +
                        "}";

        return query;

    }

}