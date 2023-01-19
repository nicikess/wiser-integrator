package ch.unisg.ics.interactions.wiser.integrator;

import ch.unisg.ics.interactions.wiser.data.ilcd.*;
import ch.unisg.ics.interactions.wiser.data.ilcd.ProcessDataSet;
import ch.unisg.ics.interactions.wiser.queries.ilcd.*;
import ch.unisg.ics.interactions.wiser.tools.GraphDBInterface;

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
        insertTime();
        insertGeography();
        insertTechnology();

        //ModellingAndValidation
        insertLCIMethodAndAllocation();
        insertDataSourcesTreatmentAndRepresentativeness();
        insertReferenceToDataSource();

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

    private void insertTime() {

        Time time = ilcd.getProcessInformation().getTime();
        String insertQueryTime = new TimeQueryBuilder(time, activityIdILCD).createTimeInsertionQuery();
        insertDataILCDToGraphDB(insertQueryTime);

    }

    private void insertGeography() {

        Geography geography = ilcd.getProcessInformation().getGeography();
        String insertQueryGeography = new GeographyQueryBuilder(geography, activityIdILCD).createGeographyInsertionQuery();
        insertDataILCDToGraphDB(insertQueryGeography);

    }

    private void insertTechnology() {

        Technology technology = ilcd.getProcessInformation().getTechnology();
        String insertQueryGeography = new TechnologyQueryBuilder(technology, activityIdILCD).createTechnologyInsertionQuery();
        insertDataILCDToGraphDB(insertQueryGeography);

    }

    private void insertLCIMethodAndAllocation() {

        LCIMethodAndAllocation lciMethodAndAllocation = ilcd.getModellingAndValidation().getLCIMethodAndAllocation();
        String insertQueryGeography = new LCIMethodAndAllocationQueryBuilder(lciMethodAndAllocation, activityIdILCD).createLCIMethodAndAllocationInsertionQuery();
        insertDataILCDToGraphDB(insertQueryGeography);

    }

    private void insertDataSourcesTreatmentAndRepresentativeness() {

        DataSourcesTreatmentAndRepresentativeness dataSourcesTreatmentAndRepresentativeness = ilcd.getModellingAndValidation().getDataSourcesTreatmentAndRepresentativeness();
        String insertQueryTreatmentAndRepresentativeness = new DataSourcesTreatmentAndRepresentativenessQueryBuilder(dataSourcesTreatmentAndRepresentativeness, activityIdILCD).createDataSourcesTreatmentAndRepresentativenessInsertionQuery();
        insertDataILCDToGraphDB(insertQueryTreatmentAndRepresentativeness);

    }

    private void insertReferenceToDataSource() {

        for (ReferenceToDataSource referenceToDataSource: ilcd.getModellingAndValidation().getDataSourcesTreatmentAndRepresentativeness().getReferenceToDataSources()) {
            String insertQueryReferenceToDataSource = new ReferenceQueryBuilder(referenceToDataSource,activityIdILCD).createDataSourceInsertionQuery();
            insertDataILCDToGraphDB(insertQueryReferenceToDataSource);

        }

    }


}
