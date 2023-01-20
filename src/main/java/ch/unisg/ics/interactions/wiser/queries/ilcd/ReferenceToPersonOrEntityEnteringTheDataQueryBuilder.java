package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.ReferenceToPersonOrEntityEnteringTheData;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class ReferenceToPersonOrEntityEnteringTheDataQueryBuilder {

    private ReferenceToPersonOrEntityEnteringTheData referenceToPersonOrEntityEnteringTheData;
    private String activityIdILCD;

    public ReferenceToPersonOrEntityEnteringTheDataQueryBuilder(ReferenceToPersonOrEntityEnteringTheData referenceToPersonOrEntityEnteringTheData, String activityIdILCD) {
        this.referenceToPersonOrEntityEnteringTheData = referenceToPersonOrEntityEnteringTheData;
        this.activityIdILCD = activityIdILCD;
    }

    public String createReferenceToPersonOrEntityEnteringTheDataInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdDatatypesPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?referenceToPersonOrEntityEnteringTheData a " + VocabularyILCD.reference + ";\n" +
                        VocabularyILCD.referenceType + " \"" + referenceToPersonOrEntityEnteringTheData.getType() + "\";\n" +
                        VocabularyILCD.referenceVersion + " \"" + referenceToPersonOrEntityEnteringTheData.getVersion() + "\";\n" +
                        VocabularyILCD.referenceURI + " \"" + referenceToPersonOrEntityEnteringTheData.getUri() + "\";\n" +
                        VocabularyILCD.referenceShortDescription + " \"" + referenceToPersonOrEntityEnteringTheData.getShortDescription() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI(" + VocabularyILCD.referenceToPersonOrEntityEnteringTheDataIRI + activityIdILCD + "') AS ?referenceToPersonOrEntityEnteringTheData)" + "\n" +
                        "}";

        return query;

    }

}