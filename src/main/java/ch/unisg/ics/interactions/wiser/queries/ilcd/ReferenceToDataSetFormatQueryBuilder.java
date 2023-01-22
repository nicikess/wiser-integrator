package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.ReferenceToDataSetFormat;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class ReferenceToDataSetFormatQueryBuilder {

    private ReferenceToDataSetFormat referenceToDataSetFormat;
    private String identifier;

    public ReferenceToDataSetFormatQueryBuilder(ReferenceToDataSetFormat referenceToDataSetFormat, String activityIdILCD) {
        this.referenceToDataSetFormat = referenceToDataSetFormat;
        this.identifier = VocabularyILCD.referenceToDataSetFormatIRI + activityIdILCD;
    }

    public String createReferenceToDataSetFormatInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdDatatypesPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?referenceToDataSetFormat a " + VocabularyILCD.reference + ";\n" +
                        VocabularyILCD.refObject + " \"" + referenceToDataSetFormat.getRefObjectId() + "\";\n" +
                        VocabularyILCD.referenceType + " \"" + referenceToDataSetFormat.getType() + "\";\n" +
                        VocabularyILCD.referenceVersion + " \"" + referenceToDataSetFormat.getVersion() + "\";\n" +
                        VocabularyILCD.referenceURI + " \"" + referenceToDataSetFormat.getUri() + "\";\n" +
                        VocabularyILCD.referenceShortDescription + " \"" + referenceToDataSetFormat.getShortDescription() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI('" + identifier + "') AS ?referenceToDataSetFormat)" + "\n" +
                        "}";

        return query;

    }

    public String getIdentifier() {
        return identifier;
    }

}