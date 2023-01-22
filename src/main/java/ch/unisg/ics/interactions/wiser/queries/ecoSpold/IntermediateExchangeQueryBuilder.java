
package ch.unisg.ics.interactions.wiser.queries.ecoSpold;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.IntermediateExchange;
import ch.unisg.ics.interactions.wiser.data.ecoSpold.Property;
import ch.unisg.ics.interactions.wiser.tools.VocabularyEcoSpold;

import java.util.List;

public class IntermediateExchangeQueryBuilder {

    private IntermediateExchange intermediateExchange;
    private String identifier;

    public IntermediateExchangeQueryBuilder(IntermediateExchange intermediateExchange, String activityIdEcoSpold) {
        this.intermediateExchange = intermediateExchange;
        this.identifier = VocabularyEcoSpold.intermediateExchangeIRI + activityIdEcoSpold;
    }

    public String createIntermediateExchangeInsertionQuery() {

        String query =
                "PREFIX " + VocabularyEcoSpold.ecoSpoldMetaInformationPrefix + "\n" +
                "PREFIX " + VocabularyEcoSpold.ecoSpoldFlowdataPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?intermediateExchange a " + VocabularyEcoSpold.intermediateExchange + ";\n" +
                        VocabularyEcoSpold.exchangeId + " \"" + intermediateExchange.getId() + "\";\n" +
                        VocabularyEcoSpold.exchangeUnitID + " \"" + intermediateExchange.getUnitId() + "\";\n" +
                        VocabularyEcoSpold.exchangeVariableName + " \"" + intermediateExchange.getVariableName() + "\";\n" +
                        VocabularyEcoSpold.exchangeCasNumber + " \"" + intermediateExchange.getCasNumber() + "\";\n" +
                        VocabularyEcoSpold.exchangeAmount + " \"" + intermediateExchange.getAmount() + "\";\n" +
                        VocabularyEcoSpold.intermediateExchangeId + " \"" + intermediateExchange.getIntermediateExchangeId() + "\";\n" +
                        VocabularyEcoSpold.exchangeProductionVolumeAmount + " \"" + intermediateExchange.getProductionVolumeAmount() + "\";\n" +
                        VocabularyEcoSpold.exchangeProductionVolumeVariableName + " \"" + intermediateExchange.getProductionVolumeVariableName() + "\";\n" +
                        VocabularyEcoSpold.exchangeProductionVolumeMathematicalRelation + " \"" + intermediateExchange.getProductionVolumeMathematicalRelation() + "\";\n" +
                        VocabularyEcoSpold.exchangeName + " \"" + intermediateExchange.getName() + "\";\n" +
                        VocabularyEcoSpold.exchangeUnitName + " \"" + intermediateExchange.getUnitName() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI('" + identifier + "') AS ?intermediateExchange)" + "\n" +
                        "}";

        return query;

    }

    public String getIdentifier() {
        return identifier;
    }



}
