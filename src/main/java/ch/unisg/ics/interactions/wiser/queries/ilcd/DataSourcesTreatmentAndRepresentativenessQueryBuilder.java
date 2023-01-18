package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.DataSourcesTreatmentAndRepresentativeness;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class DataSourcesTreatmentAndRepresentativenessQueryBuilder {

    private DataSourcesTreatmentAndRepresentativeness dataSourcesTreatmentAndRepresentativeness;
    private String activityIdILCD;

    public DataSourcesTreatmentAndRepresentativenessQueryBuilder(DataSourcesTreatmentAndRepresentativeness dataSourcesTreatmentAndRepresentativeness, String activityIdILCD) {
        this.dataSourcesTreatmentAndRepresentativeness = dataSourcesTreatmentAndRepresentativeness;
        this.activityIdILCD = activityIdILCD;
    }

    public String createDataSourcesTreatmentAndRepresentativenessInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdProcessPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdDatatypes + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?dataSourcesTreatmentAndRepresentativeness a " + VocabularyILCD.dataSourcesTreatmentAndRepresentativenessType + ";\n" +
                        VocabularyILCD.dataCutOffAndCompletenessPrinciples + " \"" + dataSourcesTreatmentAndRepresentativeness.getDataCutOffAndCompletenessPrinciples() + "\";\n" +
                        VocabularyILCD.deviationsFromCutOffAndCompletenessPrinciples + " \"" + dataSourcesTreatmentAndRepresentativeness.getDeviationsFromCutOffAndCompletenessPrinciples() + "\";\n" +
                        VocabularyILCD.dataSelectionAndCombinationPrinciples + " \"" + dataSourcesTreatmentAndRepresentativeness.getDataSelectionAndCombinationPrinciples() + "\";\n" +
                        VocabularyILCD.deviationsFromSelectionAndCombinationPrinciples + " \"" + dataSourcesTreatmentAndRepresentativeness.getDeviationsFromSelectionAndCombinationPrinciples() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI(" + VocabularyILCD.dataSourcesTreatmentAndRepresentativenessIRI + activityIdILCD + "') AS ?dataSourcesTreatmentAndRepresentativeness)" + "\n" +
                        "}";

        return query;

    }

}