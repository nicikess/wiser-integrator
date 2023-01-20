package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.ReferenceToUnchangedRepublication;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class ReferenceToUnchangedRepublicationQueryBuilder {

    private ReferenceToUnchangedRepublication referenceToUnchangedRepublication;
    private String activityIdILCD;

    public ReferenceToUnchangedRepublicationQueryBuilder(ReferenceToUnchangedRepublication referenceToUnchangedRepublication, String activityIdILCD) {
        this.referenceToUnchangedRepublication = referenceToUnchangedRepublication;
        this.activityIdILCD = activityIdILCD;
    }

    public String createReferenceToUnchangedRepublicationInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdProcessPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdDatatypesPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?referenceToUnchangedRepublication a " + VocabularyILCD.reference + ";\n" +
                        VocabularyILCD.referenceType + " \"" + referenceToUnchangedRepublication.getType() + "\";\n" +
                        VocabularyILCD.referenceVersion + " \"" + referenceToUnchangedRepublication.getVersion() + "\";\n" +
                        VocabularyILCD.referenceURI + " \"" + referenceToUnchangedRepublication.getUri() + "\";\n" +
                        VocabularyILCD.referenceShortDescription + " \"" + referenceToUnchangedRepublication.getShortDescription() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI(" + VocabularyILCD.referenceToUnchangedRepublicationIRI + activityIdILCD + "') AS ?referenceToUnchangedRepublication)" + "\n" +
                        "}";

        return query;

    }

}