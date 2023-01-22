package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.ReferenceToDataSource;
import ch.unisg.ics.interactions.wiser.data.ilcd.ReferenceToNameOfReviewerAndInstitution;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class ReferenceToNameOfReviewerAndInstitutionQueryBuilder {

    private ReferenceToNameOfReviewerAndInstitution referenceToNameOfReviewerAndInstitution;
    private String identifier;

    public ReferenceToNameOfReviewerAndInstitutionQueryBuilder(ReferenceToNameOfReviewerAndInstitution referenceToNameOfReviewerAndInstitution, String activityIdILCD) {
        this.referenceToNameOfReviewerAndInstitution = referenceToNameOfReviewerAndInstitution;
        this.identifier = VocabularyILCD.referenceToNameOfReviewerAndInstitutionIRI + activityIdILCD;
    }

    public String createReferenceToDataSourceInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdProcessPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdDatatypesPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?referenceToNameOfReviewerAndInstitution a " + VocabularyILCD.referenceToNameOfReviewerAndInstitution + ";\n" +
                        VocabularyILCD.refObject + " \"" + referenceToNameOfReviewerAndInstitution.getRefObjectId() + "\";\n" +
                        VocabularyILCD.referenceType + " \"" + referenceToNameOfReviewerAndInstitution.getType() + "\";\n" +
                        VocabularyILCD.referenceVersion + " \"" + referenceToNameOfReviewerAndInstitution.getVersion() + "\";\n" +
                        VocabularyILCD.referenceURI + " \"" + referenceToNameOfReviewerAndInstitution.getUri() + "\";\n" +
                        VocabularyILCD.referenceShortDescription + " \"" + referenceToNameOfReviewerAndInstitution.getShortDescription() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI('" + identifier + "') AS ?referenceToNameOfReviewerAndInstitution)" + "\n" +
                        "}";

        return query;

    }

    public String getIdentifier() {
        return identifier;
    }

}