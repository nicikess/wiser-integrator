package ch.unisg.ics.interactions.wiser.queries;

import ch.unisg.ics.interactions.wiser.tools.VocabularyEcoSpold;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

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
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdProcessPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "<" + identifierOne + ">" + objectProperty + "<" + identifierTwo + ">." + "\n" +
                        "} where {}";

        return statement;
    }

}

