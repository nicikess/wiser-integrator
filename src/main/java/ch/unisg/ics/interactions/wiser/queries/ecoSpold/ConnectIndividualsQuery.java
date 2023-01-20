package ch.unisg.ics.interactions.wiser.queries.ecoSpold;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.Activity;
import ch.unisg.ics.interactions.wiser.tools.VocabularyEcoSpold;

public class ConnectIndividualsQuery {

    private String identifierOne;
    private String objectProperty;
    private String identifierTwo;

    public ConnectIndividualsQuery(String identifierOne, String objectProperty, String identifierTwo) {
        this.identifierOne = identifierOne;
        this.objectProperty = objectProperty;
        this.identifierTwo = identifierTwo;
    }

    public String getConnectorStatement() {

        String statement =
                "PREFIX " + VocabularyEcoSpold.ecoSpoldBasePrefix + "\n" +
                "PREFIX " + VocabularyEcoSpold.ecoSpoldActivityPrefix + "\n" +
                "PREFIX " + VocabularyEcoSpold.ecoSpoldFlowdataPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "<" + identifierOne + ">" + objectProperty + "<" + identifierTwo + ">." + "\n" +
                        "} where {}";

        return statement;
    }

}

