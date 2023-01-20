package ch.unisg.ics.interactions.wiser.queries.ecoSpold;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.DataEntryBy;
import ch.unisg.ics.interactions.wiser.tools.VocabularyEcoSpold;

public class DataEntryByQueryBuilder {

    private DataEntryBy dataEntryBy;
    private String activityIdEcoSpold;

    public DataEntryByQueryBuilder(DataEntryBy dataEntryBy, String activityIdEcoSpold) {
        this.dataEntryBy = dataEntryBy;
        this.activityIdEcoSpold = activityIdEcoSpold;
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
                        "BIND(IRI(" + VocabularyEcoSpold.dataEntryByIRI + activityIdEcoSpold + "') AS ?dataEntryBy)" + "\n" +
                        "}";

        return query;

    }
    
}
