package ch.unisg.ics.interactions.wiser.queries.ecoSpold;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.DataEntryBy;
import ch.unisg.ics.interactions.wiser.tools.VocabularyEcoSpold;

public class DataEntryByQueryBuilder {

    private DataEntryBy dataEntryBy;
    private String identifier;

    public DataEntryByQueryBuilder(DataEntryBy dataEntryBy, String activityIdEcoSpold) {
        this.dataEntryBy = dataEntryBy;
        this.identifier = VocabularyEcoSpold.dataEntryByIRI + activityIdEcoSpold;
    }

    public String createDataEntryByInsertionQuery() {

        String query =
                "PREFIX " + VocabularyEcoSpold.ecoSpoldMetaInformationPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?dataEntryBy a " + VocabularyEcoSpold.dataEntryBy + ";\n" +
                        VocabularyEcoSpold.dataEntryByPersonId + " \"" + dataEntryBy.getPersonId() + "\";\n" +
                        VocabularyEcoSpold.dataEntryByIsActiveAuthor+ " " + dataEntryBy.getIsActiveAuthor() + ";\n" +
                        VocabularyEcoSpold.dataEntryByPersonName + " \"" + dataEntryBy.getPersonName() + "\";\n" +
                        VocabularyEcoSpold.dataEntryByPersonEmail + " \"" + dataEntryBy.getPersonEmail() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI('" + identifier + "') AS ?dataEntryBy)" + "\n" +
                        "}";

        return query;

    }

    public String getIdentifier() {
        return identifier;
    }
}
