package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.Exchange;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;
import org.eclipse.rdf4j.query.algebra.Str;

public class ExchangeQueryBuilder {

    private Exchange exchange;
    private String activityIdILCD;
    private String identifier;

    public ExchangeQueryBuilder(Exchange exchange, String activityIdILCD) {
        this.exchange = exchange;
        this.activityIdILCD = activityIdILCD;
        this.identifier = VocabularyILCD.exchangeIRI + activityIdILCD;
    }

    public String createExchangeInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdDatatypesPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdProcessPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?exchanges a " + VocabularyILCD.exchange + ";\n" +
                        addReferenceToFlowDataSet() +
                        VocabularyILCD.exchangeDirection + " \"" + exchange.getExchangeDirection() + "\";\n" +
                        VocabularyILCD.exchangeMeanAmount + " \"" + exchange.getMeanAmount() + "\";\n" +
                        VocabularyILCD.exchangeResultingAmount + " \"" + exchange.getResultingAmount() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI('" + identifier + "') AS ?exchanges)" + "\n" +
                        "}";

        return query;

    }

    public String addReferenceToFlowDataSet() {

        return new ReferenceToFlowDataSetQueryBuilder(exchange.getReferenceToFlowDataSet(), activityIdILCD).createReferenceToFlowDataSetInsertionWithoutPrefixQuery();

    }

    public String getIdentifier() {
        return identifier;
    }


}