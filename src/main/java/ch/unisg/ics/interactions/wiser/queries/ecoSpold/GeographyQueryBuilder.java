package ch.unisg.ics.interactions.wiser.queries.ecoSpold;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.Geography;
import ch.unisg.ics.interactions.wiser.tools.VocabularyEcoSpold;

public class GeographyQueryBuilder {

    private Geography geography;
    private String identifier;

    public GeographyQueryBuilder(Geography geography, String activityIdEcoSpold) {
        this.geography = geography;
        this.identifier = VocabularyEcoSpold.geographyIRI + activityIdEcoSpold;
    }

    public String createGeographyInsertionQuery() {

        String query =
                "PREFIX " + VocabularyEcoSpold.ecoSpoldMetaInformationPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?geography a " + VocabularyEcoSpold.geography + ";\n" +
                        VocabularyEcoSpold.geographyId + " \"" + geography.getGeographyId() + "\";\n" +
                        VocabularyEcoSpold.geographyShortName + " \"" + geography.getShortname() + "\";\n" +
                        VocabularyEcoSpold.geographyComment + " \"" + geography.getComment().get(0).getText().get(0) + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI('" + identifier + "') AS ?geography)" + "\n" +
                        "}";

        return query;

    }

    public String getIdentifier() {
        return identifier;
    }
    
}
