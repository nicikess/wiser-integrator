package ch.unisg.ics.interactions.wiser.integrator;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.*;
import ch.unisg.ics.interactions.wiser.data.ilcd.ProcessDataSet;
import ch.unisg.ics.interactions.wiser.queries.ecoSpold.*;
import ch.unisg.ics.interactions.wiser.tools.GraphDBInterface;

import java.util.List;

public class InsertEcoSpoldData {

    private static EcoSpold ecoSpold;
    private static String activityIdEcoSpold;

    public InsertEcoSpoldData(EcoSpold ecoSpold) {

        this.ecoSpold = ecoSpold;
        this.activityIdEcoSpold = ecoSpold.getActivityDataset().getActivityDescription().getActivity().getId();

        insertEcoSpoldDataToGraphDB();

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

    public void insertDataEcoSpoldToGraphDB(String query) {

        GraphDBInterface graphDBInterface = new GraphDBInterface();
        try {
            graphDBInterface.queryEndpoint(query);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void insertActivity() {

        Activity activityData = ecoSpold.getActivityDataset().getActivityDescription().getActivity();
        String insertQueryActivity = new ActivityQueryBuilder(activityData).createActivityInsertionQuery();
        insertDataEcoSpoldToGraphDB(insertQueryActivity);

    }

    private void insertClassification() {

        List<Classification> classificationData = ecoSpold.getActivityDataset().getActivityDescription().getClassification();
        for (Classification classification: classificationData) {
            String insertQueryClassification = new ClassificationQueryBuilder(classification, activityIdEcoSpold).createClassificationInsertionQuery();
            insertDataEcoSpoldToGraphDB(insertQueryClassification);
        }

    }

    private void insertGeography() {

        Geography geographyData = ecoSpold.getActivityDataset().getActivityDescription().getGeography();
        String insertQueryGeography = new GeographyQueryBuilder(geographyData,activityIdEcoSpold).createGeographyInsertionQuery();
        insertDataEcoSpoldToGraphDB(insertQueryGeography);

    }

    private void insertTechnology() {

        Technology technology = ecoSpold.getActivityDataset().getActivityDescription().getTechnology();
        String insertQueryTechnology = new TechnologyQueryBuilder(technology,activityIdEcoSpold).createTechnologyInsertionQuery();
        insertDataEcoSpoldToGraphDB(insertQueryTechnology);

    }

    private void insertTimePeriod() {

        TimePeriod timePeriod = ecoSpold.getActivityDataset().getActivityDescription().getTimePeriod();
        String insertQueryTimePeriod = new TimePeriodQueryBuilder(timePeriod,activityIdEcoSpold).createTimePeriodInsertionQuery();
        insertDataEcoSpoldToGraphDB(insertQueryTimePeriod);

    }

    private void insertMacroEconomicScenario() {

        MacroEconomicScenario macroEconomicScenario = ecoSpold.getActivityDataset().getActivityDescription().getMacroEconomicScenario();
        String insertMacroEconomicScenario = new MacroEconomicScenarioQueryBuilder(macroEconomicScenario,activityIdEcoSpold).createMacroEconomicScenarioInsertionQuery();
        insertDataEcoSpoldToGraphDB(insertMacroEconomicScenario);

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
