package ch.unisg.ics.interactions.wiser.queries.ecoSpold;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.DataGeneratorAndPublication;
import ch.unisg.ics.interactions.wiser.tools.VocabularyEcoSpold;

public class DataGeneratorAndPublicationQueryBuilder {

    private DataGeneratorAndPublication dataGeneratorAndPublication;
    private String identifier;

    public DataGeneratorAndPublicationQueryBuilder(DataGeneratorAndPublication dataGeneratorAndPublication, String activityIdEcoSpold) {
        this.dataGeneratorAndPublication = dataGeneratorAndPublication;
        this.identifier = VocabularyEcoSpold.dataGeneratorAndPublicationIRI + activityIdEcoSpold;

    }

    public String createDataGeneratorAndPublicationInsertionQuery() {

        String query =
                "PREFIX " + VocabularyEcoSpold.ecoSpoldMetaInformationPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?dataGeneratorAndPublication a " + VocabularyEcoSpold.dataGeneratorAndPublication + ";\n" +
                        VocabularyEcoSpold.dataGeneratorAndPublicationPersonId + " \"" + dataGeneratorAndPublication.getPersonId() + "\";\n" +
                        VocabularyEcoSpold.dataGeneratorAndPublicationPersonName + " \"" + dataGeneratorAndPublication.getPersonName() + "\";\n" +
                        VocabularyEcoSpold.dataGeneratorAndPublicationPersonEmail + " \"" + dataGeneratorAndPublication.getPersonEmail() + "\";\n" +
                        VocabularyEcoSpold.dataGeneratorAndPublicationDataPublishedIn + " " + dataGeneratorAndPublication.getDataPublishedIn()+ ";\n" +
                        VocabularyEcoSpold.dataGeneratorAndPublicationPublishedSourceId + " \"" + dataGeneratorAndPublication.getPublishedSourceId() + "\";\n" +
                        VocabularyEcoSpold.dataGeneratorAndPublicationPublishedSourceYear + " " + dataGeneratorAndPublication.getPublishedSourceYear() + ";\n" +
                        VocabularyEcoSpold.dataGeneratorAndPublicationPublishedSourceFirstAuthor + " \"" + dataGeneratorAndPublication.getPublishedSourceFirstAuthor() + "\";\n" +
                        VocabularyEcoSpold.dataGeneratorAndPublicationIsCopyrightProtected + " " + dataGeneratorAndPublication.getIsCopyrightProtected() + ";\n" +
                        VocabularyEcoSpold.dataGeneratorAndPublicationAccessRestrictedTo + " " + dataGeneratorAndPublication.getAccessRestrictedTo() + ";\n" +
                        VocabularyEcoSpold.dataGeneratorAndPublicationCompanyIdOverwrittenByChild + " " + dataGeneratorAndPublication.getCompanyIdOverwrittenByChild() + ";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI('" + identifier + "') AS ?dataGeneratorAndPublication)" + "\n" +
                        "}";

        return query;

    }

    public String getIdentifier() {
        return identifier;
    }
    
}
