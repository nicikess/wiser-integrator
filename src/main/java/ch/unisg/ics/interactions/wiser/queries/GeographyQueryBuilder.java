package ch.unisg.ics.interactions.wiser.queries;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.Geography;
import ch.unisg.ics.interactions.wiser.tools.VocabularyEcoSpold;

public class GeographyQueryBuilder {

    private Geography geography;
    private String activityIdEcoSpold;

    public GeographyQueryBuilder(Geography geography, String activityIdEcoSpold) {
        this.geography = geography;
        this.activityIdEcoSpold = activityIdEcoSpold;
    }

    public String createGeographyInsertionQuery() {

        String query =
                "PREFIX " + VocabularyEcoSpold.ecoSpoldDataTypesPrefix + "\n" +
                "PREFIX " + VocabularyEcoSpold.bridgingOntologyPrefix + "\n" +
                "PREFIX " + VocabularyEcoSpold.ecoSpoldDataSourcePrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?geography a " + VocabularyEcoSpold.geography + ";\n" +
                        VocabularyEcoSpold.geographyId + " " + geography.getGeographyId() + ";\n" +
                        VocabularyEcoSpold.geographyShortName + " \"" + geography.getShortname() + "\";\n" +
                        VocabularyEcoSpold.geographyComment + " \"" + geography.getComment() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI(" + VocabularyEcoSpold.geographyIRI + activityIdEcoSpold + "') AS ?geography)" + "\n" +
                        "}";

        return query;

    }
    
}
