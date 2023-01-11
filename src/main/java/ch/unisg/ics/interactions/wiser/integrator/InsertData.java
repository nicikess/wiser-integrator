package ch.unisg.ics.interactions.wiser.integrator;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.Activity;
import ch.unisg.ics.interactions.wiser.data.ecoSpold.Classification;
import ch.unisg.ics.interactions.wiser.data.ecoSpold.EcoSpold;
import ch.unisg.ics.interactions.wiser.data.ecoSpold.Geography;
import ch.unisg.ics.interactions.wiser.data.ilcd.ProcessDataSet;
import ch.unisg.ics.interactions.wiser.data.ecoSpold.Technology;
import ch.unisg.ics.interactions.wiser.queries.ActivityQueryBuilder;
import ch.unisg.ics.interactions.wiser.queries.ClassificationQueryBuilder;
import ch.unisg.ics.interactions.wiser.queries.GeographyQueryBuilder;
import ch.unisg.ics.interactions.wiser.queries.TechnologyQueryBuilder;
import ch.unisg.ics.interactions.wiser.tools.GraphDBInterface;

import java.util.List;

public class InsertData {

    private static EcoSpold ecoSpold;
    private static ProcessDataSet ilcd;
    private static String activityIdEcoSpold;

    public InsertData(EcoSpold ecoSpold, ProcessDataSet ilcd) {

        this.ecoSpold = ecoSpold;
        this.ilcd = ilcd;
        this.activityIdEcoSpold = ecoSpold.getActivityDataset().getActivityDescription().getActivity().getId();

        insertEcoSpoldDataToGraphDB();
        //insertILCDDataToGraphDB();

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

    public void insertDataToGraphDB(String query) {

        GraphDBInterface graphDBInterface = new GraphDBInterface();
        System.out.println(query);
        try {
            graphDBInterface.queryEndpoint(query);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void insertActivity() {

        Activity activityData = ecoSpold.getActivityDataset().getActivityDescription().getActivity();
        String insertQueryActivity = new ActivityQueryBuilder(activityData).createActivityInsertionQuery();
        insertDataToGraphDB(insertQueryActivity);

    }

    private void insertClassification() {

        List<Classification> classificationData = ecoSpold.getActivityDataset().getActivityDescription().getClassification();
        for (Classification classification: classificationData) {
            String insertQueryClassification = new ClassificationQueryBuilder(classification, activityIdEcoSpold).createClassificationInsertionQuery();
            insertDataToGraphDB(insertQueryClassification);
        }

    }

    private void insertGeography() {

        Geography geographyData = ecoSpold.getActivityDataset().getActivityDescription().getGeography();
        String insertQueryGeography = new GeographyQueryBuilder(geographyData,activityIdEcoSpold).createGeographyInsertionQuery();
        insertDataToGraphDB(insertQueryGeography);

    }

    private void insertTechnology() {

        Technology technology = ecoSpold.getActivityDataset().getActivityDescription().getTechnology();
        String insertQueryTechnology = new TechnologyQueryBuilder(technology,activityIdEcoSpold).createTechnologyInsertionQuery();
        insertDataToGraphDB(insertQueryTechnology);

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

    

}
