package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.ReferenceToPersonOrEntityEnteringTheData;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class ReferenceToPersonOrEntityEnteringTheDataQueryBuilder {

    private ReferenceToPersonOrEntityEnteringTheData referenceToPersonOrEntityEnteringTheData;
    private String identifier;

    public ReferenceToPersonOrEntityEnteringTheDataQueryBuilder(ReferenceToPersonOrEntityEnteringTheData referenceToPersonOrEntityEnteringTheData, String activityIdILCD) {
        this.referenceToPersonOrEntityEnteringTheData = referenceToPersonOrEntityEnteringTheData;
        this.identifier = VocabularyILCD.referenceToPersonOrEntityEnteringTheDataIRI + activityIdILCD;
    }

    public String createReferenceToPersonOrEntityEnteringTheDataInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdDatatypesPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?referenceToPersonOrEntityEnteringTheData a " + VocabularyILCD.reference + ";\n" +
                        VocabularyILCD.refObject + " \"" + referenceToPersonOrEntityEnteringTheData.getRefObjectId() + "\";\n" +
                        VocabularyILCD.referenceType + " \"" + referenceToPersonOrEntityEnteringTheData.getType() + "\";\n" +
                        VocabularyILCD.referenceVersion + " \"" + referenceToPersonOrEntityEnteringTheData.getVersion() + "\";\n" +
                        VocabularyILCD.referenceURI + " \"" + referenceToPersonOrEntityEnteringTheData.getUri() + "\";\n" +
                        VocabularyILCD.referenceShortDescription + " \"" + referenceToPersonOrEntityEnteringTheData.getShortDescription() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI('" + identifier + "') AS ?referenceToPersonOrEntityEnteringTheData)" + "\n" +
                        "}";

        return query;

    }

    public String getIdentifier() {
        return identifier;
    }

}