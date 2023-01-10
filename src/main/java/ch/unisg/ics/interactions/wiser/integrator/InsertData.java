package ch.unisg.ics.interactions.wiser.integrator;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.Activity;
import ch.unisg.ics.interactions.wiser.data.ecoSpold.EcoSpold;
import ch.unisg.ics.interactions.wiser.data.ilcd.ProcessDataSet;
import ch.unisg.ics.interactions.wiser.queries.ActivityQueryBuilder;
import ch.unisg.ics.interactions.wiser.tools.GraphDBInterface;

public class InsertData {

    private static EcoSpold ecoSpold;
    private static ProcessDataSet ilcd;

    public InsertData(EcoSpold ecoSpold, ProcessDataSet ilcd) {

        this.ecoSpold = ecoSpold;
        this.ilcd = ilcd;

        insertEcoSpoldDataToGraphDB();
        insertILCDDataToGraphDB();

    }

    public void insertEcoSpoldDataToGraphDB() {

        //ActivityDescription
        insertActivity();
        insertClassification();
        insertGeography();
        insertTechnology();
        insertTimePeriod();
        insertMacroEconomicScenario();

        //FlowData
        insertIntermediateExchange();

        //ModellingAndValidation
        insertRepresentativeness();

        //AdministrativeInformation
        insertDataEntryBy();
        insertDataGeneratorAndPublication();
        insertFileAttributes();



    }

    private void insertActivity() {

        Activity activityData = ecoSpold.getActivityDataset().getActivityDescription().getActivity();
        String insertQueryActivity = new ActivityQueryBuilder(activityData).createActivityInsertionQuery();
        GraphDBInterface graphDBInterface = new GraphDBInterface();
        System.out.println(insertQueryActivity);
        try {
            graphDBInterface.queryEndpoint(insertQueryActivity);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void insertClassification() {
    }

    private void insertGeography() {
    }

    private void insertTechnology() {
    }

    private void insertTimePeriod() {
    }

    private void insertMacroEconomicScenario() {
    }

    private void insertIntermediateExchange() {
    }

    private void insertRepresentativeness() {
    }

    private void insertDataEntryBy() {
    }

    private void insertDataGeneratorAndPublication() {
    }

    private void insertFileAttributes() {
    }

    public void insertILCDDataToGraphDB() {

    }
    

}
