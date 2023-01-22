package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.DataSetInformation;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class DataSetInformationQueryBuilder {

    private DataSetInformation dataSetInformation;
    private String identifier;

    public DataSetInformationQueryBuilder(DataSetInformation dataSetInformation, String activityIdILCD) {
        this.dataSetInformation = dataSetInformation;
        this.identifier = VocabularyILCD.datasetInformationIRI + activityIdILCD;
    }

    public String createDataSetInformationInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdProcessPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdDatatypesPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?dataSetInformation a " + VocabularyILCD.dataSetInformation + ";\n" +
                        VocabularyILCD.dataSetInformationUuid + " \"" + dataSetInformation.getUUID() + "\";\n" +
                        VocabularyILCD.dataSetInformationBaseName + " \"" + dataSetInformation.getName().getBaseName() + "\";\n" +
                        addClassificationInformationToQueryString() +
                        VocabularyILCD.dataSetInformationGeneralComment + " \"" + dataSetInformation.getGeneralComment() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI('" + identifier + "') AS ?dataSetInformation)" + "\n" +
                        "}";

        return query;

    }

    public String addClassificationInformationToQueryString() {

        String classificationInformation = "";

        for (String classInfo: dataSetInformation.getClassificationInformation().getClassification().getClassInfo()) {
            classificationInformation += VocabularyILCD.classifictionOther + " \"" + classInfo + "\";\n";
        }

        return classificationInformation;

    }

    public String getIdentifier() {
        return identifier;
    }

}