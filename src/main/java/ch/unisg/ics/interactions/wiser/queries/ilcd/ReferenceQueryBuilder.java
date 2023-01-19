package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.ReferenceToDataSource;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class ReferenceQueryBuilder {

    private ReferenceToDataSource referenceToDataSource;
    private String activityIdILCD;

    public ReferenceQueryBuilder(ReferenceToDataSource referenceToDataSource, String activityIdILCD) {
        this.referenceToDataSource = referenceToDataSource;
        this.activityIdILCD = activityIdILCD;
    }

    public String createDataSourceInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdProcessPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdDatatypesPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?referenceToDataSource a " + VocabularyILCD.reference + ";\n" +
                        VocabularyILCD.referenceType + " \"" + referenceToDataSource.getType() + "\";\n" +
                        VocabularyILCD.referenceVersion + " \"" + referenceToDataSource.getVersion() + "\";\n" +
                        VocabularyILCD.referenceURI + " \"" + referenceToDataSource.getUri() + "\";\n" +
                        VocabularyILCD.referenceShortDescription + " \"" + referenceToDataSource.getShortDescription() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI(" + VocabularyILCD.referenceIRI + activityIdILCD + "') AS ?referenceToDataSource)" + "\n" +
                        "}";

        return query;

    }

}