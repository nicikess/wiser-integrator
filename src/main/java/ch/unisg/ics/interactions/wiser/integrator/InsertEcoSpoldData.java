package ch.unisg.ics.interactions.wiser.integrator;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.*;
import ch.unisg.ics.interactions.wiser.queries.ConnectIndividualsQuery;
import ch.unisg.ics.interactions.wiser.queries.ecoSpold.*;
import ch.unisg.ics.interactions.wiser.tools.GraphDBInterface;
import ch.unisg.ics.interactions.wiser.tools.VocabularyEcoSpold;
import org.apache.jena.base.Sys;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class InsertEcoSpoldData {

    private static EcoSpold ecoSpold;
    private static String activityIdEcoSpold;
    private static String activityIdentifier;

    Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    public InsertEcoSpoldData(EcoSpold ecoSpold) {

        this.ecoSpold = ecoSpold;
        this.activityIdEcoSpold = ecoSpold.getActivityDataset().getActivityDescription().getActivity().getId();

        insertEcoSpoldDataToGraphDB();

    }

    public void insertEcoSpoldDataToGraphDB() {

        //ActivityDescription
        LOGGER.info("Insert EcoSpold activity data");
        insertActivity();
        LOGGER.info("Insert EcoSpold classification data");
        insertClassification();
        LOGGER.info("Insert EcoSpold geography data");
        insertGeography();
        LOGGER.info("Insert EcoSpold technology data");
        insertTechnology();
        LOGGER.info("Insert EcoSpold time period data");
        insertTimePeriod();
        LOGGER.info("Insert EcoSpold macroeconomic scenario data");
        insertMacroEconomicScenario();

        //FlowData
        LOGGER.info("Insert EcoSpold exchange data");
        insertIntermediateExchange();

        //ModellingAndValidation
        LOGGER.info("Insert EcoSpold representativeness data");
        insertRepresentativeness();
        LOGGER.info("Insert EcoSpold review data");
        insertReview();

        //AdministrativeInformation
        LOGGER.info("Insert EcoSpold data entry by data");
        insertDataEntryBy();
        LOGGER.info("Insert EcoSpold data generator and publication data");
        insertDataGeneratorAndPublication();
        LOGGER.info("Insert EcoSpold file attributes data");
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

    private void connectIndividuals(String identifierOne, String objectProperty, String identifierTwo) {

        String statement = new ConnectIndividualsQuery(identifierOne, objectProperty, identifierTwo).getConnectorStatement();
        insertDataEcoSpoldToGraphDB(statement);

    }

    private void insertActivity() {

        Activity activityData = ecoSpold.getActivityDataset().getActivityDescription().getActivity();
        ActivityQueryBuilder activityQueryBuilder = new ActivityQueryBuilder(activityData);
        String insertQueryActivity = activityQueryBuilder.createActivityInsertionQuery();
        activityIdentifier = activityQueryBuilder.getIdentifier();
        insertDataEcoSpoldToGraphDB(insertQueryActivity);

    }

    private void insertClassification() {

        List<Classification> classificationData = ecoSpold.getActivityDataset().getActivityDescription().getClassification();
        for (Classification classification: classificationData) {
            ClassificationQueryBuilder classificationQueryBuilder = new ClassificationQueryBuilder(classification, activityIdEcoSpold);
            String insertQueryClassification = classificationQueryBuilder.createClassificationInsertionQuery();
            insertDataEcoSpoldToGraphDB(insertQueryClassification);
            connectIndividuals(activityIdentifier, VocabularyEcoSpold.classificationIndividual, classificationQueryBuilder.getIdentifier());
        }

    }

    private void insertGeography() {

        Geography geographyData = ecoSpold.getActivityDataset().getActivityDescription().getGeography();
        GeographyQueryBuilder geographyQueryBuilder = new GeographyQueryBuilder(geographyData,activityIdEcoSpold);
        String insertQueryGeography = geographyQueryBuilder.createGeographyInsertionQuery();
        insertDataEcoSpoldToGraphDB(insertQueryGeography);
        connectIndividuals(activityIdentifier, VocabularyEcoSpold.geographyIndividual, geographyQueryBuilder.getIdentifier());

    }

    private void insertTechnology() {

        Technology technology = ecoSpold.getActivityDataset().getActivityDescription().getTechnology();
        TechnologyQueryBuilder technologyQueryBuilder = new TechnologyQueryBuilder(technology,activityIdEcoSpold);
        String insertQueryTechnology = technologyQueryBuilder.createTechnologyInsertionQuery();
        insertDataEcoSpoldToGraphDB(insertQueryTechnology);
        connectIndividuals(activityIdentifier, VocabularyEcoSpold.technologyIndividual, technologyQueryBuilder.getIdentifier());

    }

    private void insertTimePeriod() {

        TimePeriod timePeriod = ecoSpold.getActivityDataset().getActivityDescription().getTimePeriod();
        TimePeriodQueryBuilder timePeriodQueryBuilder = new TimePeriodQueryBuilder(timePeriod,activityIdEcoSpold);
        String insertQueryTimePeriod = timePeriodQueryBuilder.createTimePeriodInsertionQuery();
        String timePeriodIdentifier = timePeriodQueryBuilder.getIdentifier();
        insertDataEcoSpoldToGraphDB(insertQueryTimePeriod);
        connectIndividuals(activityIdentifier, VocabularyEcoSpold.timePeriodIndividual, timePeriodIdentifier);

    }

    private void insertMacroEconomicScenario() {

        MacroEconomicScenario macroEconomicScenario = ecoSpold.getActivityDataset().getActivityDescription().getMacroEconomicScenario();
        MacroEconomicScenarioQueryBuilder macroEconomicScenarioQueryBuilder = new MacroEconomicScenarioQueryBuilder(macroEconomicScenario,activityIdEcoSpold);
        String insertMacroEconomicScenario = macroEconomicScenarioQueryBuilder.createMacroEconomicScenarioInsertionQuery();
        insertDataEcoSpoldToGraphDB(insertMacroEconomicScenario);
        connectIndividuals(activityIdentifier, VocabularyEcoSpold.macroEconomicScenarioIndividual, macroEconomicScenarioQueryBuilder.getIdentifier());

    }

    private void insertIntermediateExchange() {

        List<IntermediateExchange> intermediateExchanges = ecoSpold.getActivityDataset().getFlowData().getIntermediateExchange();

        for (IntermediateExchange intermediateExchange: intermediateExchanges) {

            List<String> propertyIdentifier = new ArrayList<>();
            List<String> classificationIdentifier = new ArrayList<>();

            //Add properties
            for (Property property: intermediateExchange.getProperty()) {
                PropertyQueryBuilder propertyQueryBuilder = new PropertyQueryBuilder(property, activityIdEcoSpold, intermediateExchange.getId());
                String insertProperty = propertyQueryBuilder.createPropertyInsertionQuery();
                propertyIdentifier.add(propertyQueryBuilder.getIdentifier());
                insertDataEcoSpoldToGraphDB(insertProperty);
            }

            //Add classification
            for (Classification classification: intermediateExchange.getClassification()) {
                ClassificationQueryBuilder classificationQueryBuilder = new ClassificationQueryBuilder(classification, activityIdEcoSpold);
                String insertClassification = classificationQueryBuilder.createClassificationInsertionQuery();
                classificationIdentifier.add(classificationQueryBuilder.getIdentifier());
                insertDataEcoSpoldToGraphDB(insertClassification);
            }

            IntermediateExchangeQueryBuilder intermediateExchangeQueryBuilder = new IntermediateExchangeQueryBuilder(intermediateExchange,activityIdEcoSpold);
            String insertIntermediateExchange = intermediateExchangeQueryBuilder.createIntermediateExchangeInsertionQuery();
            insertDataEcoSpoldToGraphDB(insertIntermediateExchange);

            //Connect properties
            for(String property: propertyIdentifier) {
                connectIndividuals(intermediateExchangeQueryBuilder.getIdentifier(), VocabularyEcoSpold.propertyExchangeIndividual, property);
            }

            //Connect classification
            for(String property: propertyIdentifier) {
                connectIndividuals(intermediateExchangeQueryBuilder.getIdentifier(), VocabularyEcoSpold.classificationExchangeIndividual, property);
            }

            //Connect to activity
            connectIndividuals(activityIdentifier, VocabularyEcoSpold.customExchangeIndividual, intermediateExchangeQueryBuilder.getIdentifier());

        }

    }

    private void insertRepresentativeness() {

        Representativeness representativeness = ecoSpold.getActivityDataset().getModellingAndValidation().getRepresentativeness();
        RepresentativenessQueryBuilder representativenessQueryBuilder = new RepresentativenessQueryBuilder(representativeness, activityIdEcoSpold);
        String intersertRepresentativeness = representativenessQueryBuilder.createRepresentativenessInsertionQuery();
        insertDataEcoSpoldToGraphDB(intersertRepresentativeness);
        connectIndividuals(activityIdentifier, VocabularyEcoSpold.representativenessIndividual, representativenessQueryBuilder.getIdentifier());

    }

    private void insertReview() {

        List<Review> reviewData = ecoSpold.getActivityDataset().getModellingAndValidation().getReviews();
        for (Review review: reviewData) {
            ReviewQueryBuilder reviewQueryBuilder = new ReviewQueryBuilder(review, activityIdEcoSpold);
            String insertQueryReview = reviewQueryBuilder.createReviewInsertionQuery();
            insertDataEcoSpoldToGraphDB(insertQueryReview);
            connectIndividuals(activityIdentifier, VocabularyEcoSpold.reviewIndividual, reviewQueryBuilder.getIdentifier());
        }

    }

    private void insertDataEntryBy() {

        DataEntryBy dataEntryBy = ecoSpold.getActivityDataset().getAdministrativeInformation().getDataEntryBy();
        DataEntryByQueryBuilder dataEntryByQueryBuilder = new DataEntryByQueryBuilder(dataEntryBy, activityIdEcoSpold);
        String insertDataEntryBy = dataEntryByQueryBuilder.createDataEntryByInsertionQuery();
        insertDataEcoSpoldToGraphDB(insertDataEntryBy);
        connectIndividuals(activityIdentifier, VocabularyEcoSpold.dataEntryByIndividual, dataEntryByQueryBuilder.getIdentifier());

    }

    private void insertDataGeneratorAndPublication() {

        DataGeneratorAndPublication dataGeneratorAndPublication = ecoSpold.getActivityDataset().getAdministrativeInformation().getDataGeneratorAndPublication();
        DataGeneratorAndPublicationQueryBuilder dataGeneratorAndPublicationQueryBuilder = new DataGeneratorAndPublicationQueryBuilder(dataGeneratorAndPublication, activityIdEcoSpold);
        String insertDataGeneratorAndPublication = dataGeneratorAndPublicationQueryBuilder.createDataGeneratorAndPublicationInsertionQuery();
        insertDataEcoSpoldToGraphDB(insertDataGeneratorAndPublication);
        connectIndividuals(activityIdentifier, VocabularyEcoSpold.dataGeneratorAndPublicationIndividual, dataGeneratorAndPublicationQueryBuilder.getIdentifier());

    }

    private void insertFileAttributes() {

        FileAttributes fileAttributes = ecoSpold.getActivityDataset().getAdministrativeInformation().getFileAttributes();
        FileAttributesQueryBuilder fileAttributesQueryBuilder = new FileAttributesQueryBuilder(fileAttributes, activityIdEcoSpold);
        String insertFileAttributes = fileAttributesQueryBuilder.createFileAttributesInsertionQuery();
        insertDataEcoSpoldToGraphDB(insertFileAttributes);
        connectIndividuals(activityIdentifier, VocabularyEcoSpold.fileAttributesIndividual, fileAttributesQueryBuilder.getIdentifier());

    }

}
