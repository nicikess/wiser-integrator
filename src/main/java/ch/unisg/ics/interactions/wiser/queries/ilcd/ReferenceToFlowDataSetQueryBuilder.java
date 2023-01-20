package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.ReferenceToFlowDataSet;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class ReferenceToFlowDataSetQueryBuilder {

    private ReferenceToFlowDataSet referenceToFlowDataSet;
    private String activityIdILCD;

    public ReferenceToFlowDataSetQueryBuilder(ReferenceToFlowDataSet referenceToFlowDataSet, String activityIdILCD) {
        this.referenceToFlowDataSet = referenceToFlowDataSet;
        this.activityIdILCD = activityIdILCD;
    }

    public String createReferenceToFlowDataSetInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdProcessPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdDatatypesPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?referenceToFlowDataSet a " + VocabularyILCD.reference + ";\n" +
                        VocabularyILCD.referenceType + " \"" + referenceToFlowDataSet.getType() + "\";\n" +
                        VocabularyILCD.referenceVersion + " \"" + referenceToFlowDataSet.getVersion() + "\";\n" +
                        VocabularyILCD.referenceURI + " \"" + referenceToFlowDataSet.getUri() + "\";\n" +
                        VocabularyILCD.referenceShortDescription + " \"" + referenceToFlowDataSet.getShortDescription() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI(" + VocabularyILCD.referenceToFlowDataSetIRI + activityIdILCD + "') AS ?referenceToFlowDataSet)" + "\n" +
                        "}";

        return query;

    }

}