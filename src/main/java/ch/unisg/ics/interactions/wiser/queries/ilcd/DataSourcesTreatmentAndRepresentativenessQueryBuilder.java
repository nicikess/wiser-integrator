package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.DataSourcesTreatmentAndRepresentativeness;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class DataSourcesTreatmentAndRepresentativenessQueryBuilder {

    private DataSourcesTreatmentAndRepresentativeness dataSourcesTreatmentAndRepresentativeness;
    private String identifier;

    public DataSourcesTreatmentAndRepresentativenessQueryBuilder(DataSourcesTreatmentAndRepresentativeness dataSourcesTreatmentAndRepresentativeness, String activityIdILCD) {
        this.dataSourcesTreatmentAndRepresentativeness = dataSourcesTreatmentAndRepresentativeness;
        this.identifier = VocabularyILCD.dataSourcesTreatmentAndRepresentativenessIRI + activityIdILCD;
    }

    public String createDataSourcesTreatmentAndRepresentativenessInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdProcessPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?dataSourcesTreatmentAndRepresentativeness a " + VocabularyILCD.dataSourcesTreatmentAndRepresentativenessType + ";\n" +
                        VocabularyILCD.dataCutOffAndCompletenessPrinciples + " \"" + dataSourcesTreatmentAndRepresentativeness.getDataCutOffAndCompletenessPrinciples() + "\";\n" +
                        VocabularyILCD.deviationsFromCutOffAndCompletenessPrinciples + " \"" + dataSourcesTreatmentAndRepresentativeness.getDeviationsFromCutOffAndCompletenessPrinciples() + "\";\n" +
                        VocabularyILCD.dataSelectionAndCombinationPrinciples + " \"" + dataSourcesTreatmentAndRepresentativeness.getDataSelectionAndCombinationPrinciples() + "\";\n" +
                        VocabularyILCD.deviationsFromSelectionAndCombinationPrinciples + " \"" + dataSourcesTreatmentAndRepresentativeness.getDeviationsFromSelectionAndCombinationPrinciples() + "\";\n" +
                        VocabularyILCD.dataTreatmentAndExtrapolationsPrinciples + " \"" + dataSourcesTreatmentAndRepresentativeness.getDataTreatmentAndExtrapolationsPrinciples() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI('" + identifier + "') AS ?dataSourcesTreatmentAndRepresentativeness)" + "\n" +
                        "}";

        return query;

    }

    public String getIdentifier() {
        return identifier;
    }

}