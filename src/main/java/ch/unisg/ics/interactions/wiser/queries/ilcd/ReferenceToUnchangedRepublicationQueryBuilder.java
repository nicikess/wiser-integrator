package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.ReferenceToUnchangedRepublication;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class ReferenceToUnchangedRepublicationQueryBuilder {

    private ReferenceToUnchangedRepublication referenceToUnchangedRepublication;
    private String identifier;

    public ReferenceToUnchangedRepublicationQueryBuilder(ReferenceToUnchangedRepublication referenceToUnchangedRepublication, String activityIdILCD) {
        this.referenceToUnchangedRepublication = referenceToUnchangedRepublication;
        this.identifier = VocabularyILCD.referenceToUnchangedRepublicationIRI + activityIdILCD;
    }

    public String createReferenceToUnchangedRepublicationInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdDatatypesPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?referenceToUnchangedRepublication a " + VocabularyILCD.reference + ";\n" +
                        VocabularyILCD.refObject + " \"" + referenceToUnchangedRepublication.getRefObjectId() + "\";\n" +
                        VocabularyILCD.referenceType + " \"" + referenceToUnchangedRepublication.getType() + "\";\n" +
                        VocabularyILCD.referenceVersion + " \"" + referenceToUnchangedRepublication.getVersion() + "\";\n" +
                        VocabularyILCD.referenceURI + " \"" + referenceToUnchangedRepublication.getUri() + "\";\n" +
                        VocabularyILCD.referenceShortDescription + " \"" + referenceToUnchangedRepublication.getShortDescription() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI('" + identifier + "') AS ?referenceToUnchangedRepublication)" + "\n" +
                        "}";

        return query;

    }

    public String getIdentifier() {
        return identifier;
    }

}