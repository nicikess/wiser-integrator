package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.Geography;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class GeographyQueryBuilder {

    private Geography geography;
    private String activityIdILCD;

    public GeographyQueryBuilder(Geography geography, String activityIdILCD) {
        this.geography = geography;
        this.activityIdILCD = activityIdILCD;
    }

    public String createGeographyInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdProcessPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?geography a " + VocabularyILCD.geography + ";\n" +
                        VocabularyILCD.geographyLocation + " \"" + geography.getLocationOfOperationSupplyOrProduction().getLocation() + "\";\n" +
                        VocabularyILCD.geographyLatitudeAndLongitude + " \"" + geography.getLocationOfOperationSupplyOrProduction().getLatitudeAndLongitude() + "\";\n" +
                        VocabularyILCD.geographyDescriptionOfRestrictions + " \"" + geography.getLocationOfOperationSupplyOrProduction().getDescriptionOfRestrictions() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI(" + VocabularyILCD.geographyIRI + activityIdILCD + "') AS ?geography)" + "\n" +
                        "}";

        return query;

    }


}