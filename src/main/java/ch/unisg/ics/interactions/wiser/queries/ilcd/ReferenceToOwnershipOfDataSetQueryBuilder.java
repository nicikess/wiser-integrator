package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.ReferenceToOwnershipOfDataSet;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class ReferenceToOwnershipOfDataSetQueryBuilder {

    private ReferenceToOwnershipOfDataSet referenceToOwnershipOfDataSet;
    private String activityIdILCD;

    public ReferenceToOwnershipOfDataSetQueryBuilder(ReferenceToOwnershipOfDataSet referenceToOwnershipOfDataSet, String activityIdILCD) {
        this.referenceToOwnershipOfDataSet = referenceToOwnershipOfDataSet;
        this.activityIdILCD = activityIdILCD;
    }

    public String createReferenceToOwnershipOfDataSetInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdDatatypesPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?referenceToOwnershipOfDataSet a " + VocabularyILCD.reference + ";\n" +
                        VocabularyILCD.referenceType + " \"" + referenceToOwnershipOfDataSet.getType() + "\";\n" +
                        VocabularyILCD.referenceVersion + " \"" + referenceToOwnershipOfDataSet.getVersion() + "\";\n" +
                        VocabularyILCD.referenceURI + " \"" + referenceToOwnershipOfDataSet.getUri() + "\";\n" +
                        VocabularyILCD.referenceShortDescription + " \"" + referenceToOwnershipOfDataSet.getShortDescription() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI(" + VocabularyILCD.referenceToOwnershipOfDataSetIRI + activityIdILCD + "') AS ?referenceToOwnershipOfDataSet)" + "\n" +
                        "}";

        return query;

    }

}