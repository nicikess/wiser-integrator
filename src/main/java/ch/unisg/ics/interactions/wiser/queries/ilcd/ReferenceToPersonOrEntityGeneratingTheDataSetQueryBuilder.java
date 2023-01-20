package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.ReferenceToPersonOrEntityGeneratingTheDataSet;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class ReferenceToPersonOrEntityGeneratingTheDataSetQueryBuilder {

    private ReferenceToPersonOrEntityGeneratingTheDataSet referenceToPersonOrEntityGeneratingTheDataSet;
    private String activityIdILCD;

    public ReferenceToPersonOrEntityGeneratingTheDataSetQueryBuilder(ReferenceToPersonOrEntityGeneratingTheDataSet referenceToPersonOrEntityGeneratingTheDataSet, String activityIdILCD) {
        this.referenceToPersonOrEntityGeneratingTheDataSet = referenceToPersonOrEntityGeneratingTheDataSet;
        this.activityIdILCD = activityIdILCD;
    }

    public String createReferenceToPersonOrEntityGeneratingTheDataInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdProcessPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdDatatypesPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?referenceToPersonOrEntityGeneratingTheDataSet a " + VocabularyILCD.referenceToPersonOrEntityGeneratingTheData + ";\n" +
                        VocabularyILCD.referenceType + " \"" + referenceToPersonOrEntityGeneratingTheDataSet.getType() + "\";\n" +
                        VocabularyILCD.referenceVersion + " \"" + referenceToPersonOrEntityGeneratingTheDataSet.getVersion() + "\";\n" +
                        VocabularyILCD.referenceURI + " \"" + referenceToPersonOrEntityGeneratingTheDataSet.getUri() + "\";\n" +
                        VocabularyILCD.referenceShortDescription + " \"" + referenceToPersonOrEntityGeneratingTheDataSet.getShortDescription() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI(" + VocabularyILCD.referenceToPersonOrEntityGeneratingTheDataSetIRI + activityIdILCD + "') AS ?referenceToPersonOrEntityGeneratingTheDataSet)" + "\n" +
                        "}";

        return query;

    }

}