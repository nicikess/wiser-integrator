package ch.unisg.ics.interactions.wiser.queries.ecoSpold;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.Property;
import ch.unisg.ics.interactions.wiser.tools.VocabularyEcoSpold;

public class PropertyQueryBuilder {

    private Property property;
    private String activityIdEcoSpold;
    private String exchangeId;
    private String identifier;

    public PropertyQueryBuilder(Property property, String activityIdEcoSpold, String exchangeId) {
        this.property = property;
        this.activityIdEcoSpold = activityIdEcoSpold;
        this.exchangeId = exchangeId;
        this.identifier = VocabularyEcoSpold.propertyIRI + activityIdEcoSpold + "/"+ exchangeId + "/"+ property.getPropertyId();
    }

    public String createPropertyInsertionQuery() {

        String query =
                "PREFIX " + VocabularyEcoSpold.ecoSpoldTypesPrefix + "\n" +
                "PREFIX " + VocabularyEcoSpold.ecoSpoldMetaInformationPrefix + "\n" +
                "PREFIX " + VocabularyEcoSpold.ecoSpoldFlowdataPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?property a " + VocabularyEcoSpold.property + ";\n" +
                        VocabularyEcoSpold.propertyId + " \"" + property.getPropertyId() + "\";\n" +
                        VocabularyEcoSpold.propertyAmount + " " + property.getAmount() + ";\n" +
                        VocabularyEcoSpold.propertyIsDefiningValue + " \"" + property.getIsDefiningValue() + "\";\n" +
                        VocabularyEcoSpold.propertyUnitId + " \"" + property.getUnitId() + "\";\n" +
                        VocabularyEcoSpold.propertyName + " \"" + property.getName() + "\";\n" +
                        VocabularyEcoSpold.propertyUnitName + " \"" + property.getUnitName() + "\";\n" +
                        VocabularyEcoSpold.propertyComment + " \"" + property.getComment() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI('" + VocabularyEcoSpold.propertyIRI + activityIdEcoSpold + "/"+ this.exchangeId + "/"+ property.getPropertyId() +"') AS ?property)" + "\n" +
                        "}";

        return query;

    }

    public String getIdentifier() {
        return identifier;
    }

}
