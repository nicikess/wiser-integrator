package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.ReferenceToFlowDataSet;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class ReferenceToFlowDataSetQueryBuilder {

    private ReferenceToFlowDataSet referenceToFlowDataSet;
    private String identifier;

    public ReferenceToFlowDataSetQueryBuilder(ReferenceToFlowDataSet referenceToFlowDataSet, String activityIdILCD) {
        this.referenceToFlowDataSet = referenceToFlowDataSet;
        this.identifier = VocabularyILCD.referenceToFlowDataSetIRI + activityIdILCD;
    }

    public String createReferenceToFlowDataSetInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdDatatypesPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?referenceToFlowDataSet a " + VocabularyILCD.reference + ";\n" +
                        VocabularyILCD.refObject + " \"" + referenceToFlowDataSet.getRefObjectId() + "\";\n" +
                        VocabularyILCD.referenceType + " \"" + referenceToFlowDataSet.getType() + "\";\n" +
                        VocabularyILCD.referenceVersion + " \"" + referenceToFlowDataSet.getVersion() + "\";\n" +
                        VocabularyILCD.referenceURI + " \"" + referenceToFlowDataSet.getUri() + "\";\n" +
                        VocabularyILCD.referenceShortDescription + " \"" + referenceToFlowDataSet.getShortDescription() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI('" + identifier + "') AS ?referenceToFlowDataSet)" + "\n" +
                        "}";

        return query;

    }

    public String createReferenceToFlowDataSetInsertionWithoutPrefixQuery() {

        String query =
                        VocabularyILCD.referenceType + " \"" + referenceToFlowDataSet.getType() + "\";\n" +
                        VocabularyILCD.referenceVersion + " \"" + referenceToFlowDataSet.getVersion() + "\";\n" +
                        VocabularyILCD.referenceURI + " \"" + referenceToFlowDataSet.getUri() + "\";\n" +
                        VocabularyILCD.referenceShortDescription + " \"" + referenceToFlowDataSet.getShortDescription() + "\";\n";

        return query;

    }

    public String getIdentifier() {
        return identifier;
    }

}