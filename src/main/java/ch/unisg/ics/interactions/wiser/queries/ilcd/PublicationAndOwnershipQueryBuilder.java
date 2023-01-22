package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.PublicationAndOwnership;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class PublicationAndOwnershipQueryBuilder {

    private PublicationAndOwnership publicationAndOwnership;
    private String identifier;

    public PublicationAndOwnershipQueryBuilder(PublicationAndOwnership publicationAndOwnership, String activityIdILCD) {
        this.publicationAndOwnership = publicationAndOwnership;
        this.identifier = VocabularyILCD.publicationAndOwnershipIRI + activityIdILCD;
    }

    public String createPublicationAndOwnershipInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdProcessPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?publicationAndOwnership a " + VocabularyILCD.publicationAndOwnership + ";\n" +
                        VocabularyILCD.dateOfLastRevision + " \"" + publicationAndOwnership.getDateOfLastRevision() + "\";\n" +
                        VocabularyILCD.dataSetVersion + " \"" + publicationAndOwnership.getDataSetVersion() + "\";\n" +
                        VocabularyILCD.copyright + " " + publicationAndOwnership.getCopyright()+ ";\n" +
                        VocabularyILCD.accessRestrictions + " \"" + publicationAndOwnership.getAccessRestrictions() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI('" + identifier + "') AS ?publicationAndOwnership)" + "\n" +
                        "}";

        return query;

    }

    public String getIdentifier() {
        return identifier;
    }


}