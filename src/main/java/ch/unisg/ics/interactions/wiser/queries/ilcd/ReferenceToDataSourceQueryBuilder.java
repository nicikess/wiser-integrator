package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.ReferenceToDataSource;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class ReferenceToDataSourceQueryBuilder {

    private ReferenceToDataSource referenceToDataSource;
    private String identifier;

    public ReferenceToDataSourceQueryBuilder(ReferenceToDataSource referenceToDataSource, String activityIdILCD) {
        this.referenceToDataSource = referenceToDataSource;
        this.identifier = VocabularyILCD.referenceToDataSourceIRI + activityIdILCD + "/" + referenceToDataSource.getRefObjectId();
    }

    public String createReferenceToDataSourceInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdDatatypesPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?referenceToDataSource a " + VocabularyILCD.reference + ";\n" +
                        VocabularyILCD.refObject + " \"" + referenceToDataSource.getRefObjectId() + "\";\n" +
                        VocabularyILCD.referenceType + " \"" + referenceToDataSource.getType() + "\";\n" +
                        VocabularyILCD.referenceVersion + " \"" + referenceToDataSource.getVersion() + "\";\n" +
                        VocabularyILCD.referenceURI + " \"" + referenceToDataSource.getUri() + "\";\n" +
                        VocabularyILCD.referenceShortDescription + " \"" + referenceToDataSource.getShortDescription() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI('" + identifier + "') AS ?referenceToDataSource)" + "\n" +
                        "}";

        return query;

    }

    public String getIdentifier() {
        return identifier;
    }

}