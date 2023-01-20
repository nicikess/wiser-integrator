package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.DataGenerator;
import ch.unisg.ics.interactions.wiser.data.ilcd.ReferenceToPersonOrEntityGeneratingTheDataSet;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class DataGeneratorQueryBuilder {

    private DataGenerator dataGenerator;
    private String activityIdILCD;

    public DataGeneratorQueryBuilder(DataGenerator dataGenerator, String activityIdILCD) {
        this.dataGenerator = dataGenerator;
        this.activityIdILCD = activityIdILCD;
    }

    public String createDataGeneratorInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdProcessPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?dataGenerator a " + VocabularyILCD.dataGenerator + ";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI(" + VocabularyILCD.dataGeneratorIRI + activityIdILCD + "') AS ?dataGenerator)" + "\n" +
                        "}";

        return query;

    }

}