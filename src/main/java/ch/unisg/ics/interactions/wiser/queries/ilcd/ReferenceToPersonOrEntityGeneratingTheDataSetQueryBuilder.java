package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.ReferenceToPersonOrEntityGeneratingTheDataSet;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class ReferenceToPersonOrEntityGeneratingTheDataSetQueryBuilder {

    private ReferenceToPersonOrEntityGeneratingTheDataSet referenceToPersonOrEntityGeneratingTheDataSet;
    private String identifier;

    public ReferenceToPersonOrEntityGeneratingTheDataSetQueryBuilder(ReferenceToPersonOrEntityGeneratingTheDataSet referenceToPersonOrEntityGeneratingTheDataSet, String activityIdILCD) {
        this.referenceToPersonOrEntityGeneratingTheDataSet = referenceToPersonOrEntityGeneratingTheDataSet;
        this.identifier = VocabularyILCD.referenceToPersonOrEntityGeneratingTheDataSetIRI + activityIdILCD;
    }

    public String createReferenceToPersonOrEntityGeneratingTheDataInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdProcessPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdDatatypesPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?referenceToPersonOrEntityGeneratingTheDataSet a " + VocabularyILCD.referenceToPersonOrEntityGeneratingTheData + ";\n" +
                        VocabularyILCD.refObject + " \"" + referenceToPersonOrEntityGeneratingTheDataSet.getRefObjectId() + "\";\n" +
                        VocabularyILCD.referenceType + " \"" + referenceToPersonOrEntityGeneratingTheDataSet.getType() + "\";\n" +
                        VocabularyILCD.referenceVersion + " \"" + referenceToPersonOrEntityGeneratingTheDataSet.getVersion() + "\";\n" +
                        VocabularyILCD.referenceURI + " \"" + referenceToPersonOrEntityGeneratingTheDataSet.getUri() + "\";\n" +
                        VocabularyILCD.referenceShortDescription + " \"" + referenceToPersonOrEntityGeneratingTheDataSet.getShortDescription() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI('" + identifier + "') AS ?referenceToPersonOrEntityGeneratingTheDataSet)" + "\n" +
                        "}";

        return query;

    }

    public String getIdentifier() {
        return identifier;
    }

}