package ch.unisg.ics.interactions.wiser.integrator;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.Activity;
import ch.unisg.ics.interactions.wiser.data.ilcd.*;
import ch.unisg.ics.interactions.wiser.data.ilcd.ProcessDataSet;
import ch.unisg.ics.interactions.wiser.queries.ecoSpold.ActivityQueryBuilder;
import ch.unisg.ics.interactions.wiser.queries.ilcd.*;
import ch.unisg.ics.interactions.wiser.tools.GraphDBInterface;

import java.util.List;

public class InsertILCDData {

    private static ProcessDataSet ilcd;
    private static String activityIdILCD;

    public InsertILCDData(ProcessDataSet ilcd) {

        this.ilcd = ilcd;
        this.activityIdILCD = ilcd.getProcessInformation().getDataSetInformation().getUUID();

        //insertILCDDataToGraphDB();

    }

    public void insertILCDDataToGraphDB() {

        //ProcessInformation
        insertDataSetInformation();
        insertQuantitativeReference();

        //ModellingAndValidation


    }

    public void insertDataILCDToGraphDB(String query) {

        GraphDBInterface graphDBInterface = new GraphDBInterface();
        try {
            graphDBInterface.queryEndpoint(query);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void insertDataSetInformation() {

        DataSetInformation dataSetInformation = ilcd.getProcessInformation().getDataSetInformation();
        String insertQueryActivity = new DataSetInformationQueryBuilder(dataSetInformation, activityIdILCD).createDataSetInformationInsertionQuery();
        insertDataILCDToGraphDB(insertQueryActivity);

    }

    public void insertQuantitativeReference() {

        QuantitativeReference quantitativeReference = ilcd.getProcessInformation().getQuantitativeReference();
        String insertQueryActivity = new QuantitativeReferenceQueryBuilder(quantitativeReference, activityIdILCD).createQuantitativeReferenceInsertionQuery();
        insertDataILCDToGraphDB(insertQueryActivity);

    }

}
