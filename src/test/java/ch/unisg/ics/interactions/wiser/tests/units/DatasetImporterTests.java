package ch.unisg.ics.interactions.wiser.tests.units;

import ch.unisg.ics.interactions.wiser.WiserIntegrator;
import ch.unisg.ics.interactions.wiser.data.ecoSpold.EcoSpold;
import ch.unisg.ics.interactions.wiser.data.ilcd.DataSetInformation;
import ch.unisg.ics.interactions.wiser.data.ilcd.ProcessDataSet;
import ch.unisg.ics.interactions.wiser.queries.ilcd.DataSetInformationQueryBuilder;
import ch.unisg.ics.interactions.wiser.tools.GraphDBInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


public class DatasetImporterTests {

    String ILCDTestFileName = "ilcd-file.xml";
    String EcoSpoldTestFileName = "ecospold-file.xml";
    WiserIntegrator integrator = new WiserIntegrator();

    EcoSpold ecoSpold = integrator.unmarshalEcoSpold(EcoSpoldTestFileName);
    ProcessDataSet ilcd = integrator.unmarshalILCD(ILCDTestFileName);

    private String szEndpoint = "https://wiser-flagship.interactions.ics.unisg.ch/repositories/test/statements";

    @Test
    void correctInsertOfActivity() throws Exception {

        DataSetInformation dataSetInformation = ilcd.getProcessInformation().getDataSetInformation();
        DataSetInformationQueryBuilder dataSetInformationQueryBuilder = new DataSetInformationQueryBuilder(dataSetInformation, "testId");
        String insertDataSetInformation = dataSetInformationQueryBuilder.createDataSetInformationInsertionQuery();
        integrator.insertDataToGraphDB(insertDataSetInformation);
        GraphDBInterface graphDBInterface = new GraphDBInterface();

        Assertions.assertDoesNotThrow(() -> {
            graphDBInterface.queryEndpoint(insertDataSetInformation);
        });

    }
    
}
