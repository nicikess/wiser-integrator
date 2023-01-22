package ch.unisg.ics.interactions.wiser.integrator;

import ch.unisg.ics.interactions.wiser.WiserIntegrator;
import ch.unisg.ics.interactions.wiser.data.ecoSpold.*;
import ch.unisg.ics.interactions.wiser.queries.ecoSpold.*;
import ch.unisg.ics.interactions.wiser.tools.VocabularyEcoSpold;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class InsertEcoSpoldData {

    private static EcoSpold ecoSpold;
    private static String activityIdEcoSpold;
    private static String activityIdentifier;
    private WiserIntegrator integrator;

    Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    public InsertEcoSpoldData(EcoSpold ecoSpold) {

        this.ecoSpold = ecoSpold;
        this.activityIdEcoSpold = ecoSpold.getActivityDataset().getActivityDescription().getActivity().getId();
        this.integrator = new WiserIntegrator();

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
        insertReview();

        //AdministrativeInformation
        insertDataEntryBy();
        insertDataGeneratorAndPublication();
        insertFileAttributes();

    }

    private void insertActivity() {

        LOGGER.info("Start " + getClass().getName() + " " + "insertActivity");

        Activity activityData = ecoSpold.getActivityDataset().getActivityDescription().getActivity();
        ActivityQueryBuilder activityQueryBuilder = new ActivityQueryBuilder(activityData);
        String insertQueryActivity = activityQueryBuilder.createActivityInsertionQuery();
        activityIdentifier = activityQueryBuilder.getIdentifier();
        integrator.insertDataToGraphDB(insertQueryActivity);

        LOGGER.info("End " + getClass().getName() + " " + "insertActivity");

    }

    private void insertClassification() {

        LOGGER.info("Start " + getClass().getName() + " " + "insertClassification");

        List<Classification> classificationData = ecoSpold.getActivityDataset().getActivityDescription().getClassification();
        for (Classification classification: classificationData) {
            ClassificationQueryBuilder classificationQueryBuilder = new ClassificationQueryBuilder(classification, activityIdEcoSpold);
            String insertQueryClassification = classificationQueryBuilder.createClassificationInsertionQuery();
            integrator.insertDataToGraphDB(insertQueryClassification);
            integrator.connectIndividuals(activityIdentifier, VocabularyEcoSpold.classificationIndividual, classificationQueryBuilder.getIdentifier());
        }

        LOGGER.info("End " + getClass().getName() + " " + "insertClassification");

    }

    private void insertGeography() {

        LOGGER.info("Start " + getClass().getName() + " " + "insertGeography");


        Geography geographyData = ecoSpold.getActivityDataset().getActivityDescription().getGeography();
        GeographyQueryBuilder geographyQueryBuilder = new GeographyQueryBuilder(geographyData,activityIdEcoSpold);
        String insertQueryGeography = geographyQueryBuilder.createGeographyInsertionQuery();
        integrator.insertDataToGraphDB(insertQueryGeography);
        integrator.connectIndividuals(activityIdentifier, VocabularyEcoSpold.geographyIndividual, geographyQueryBuilder.getIdentifier());

        LOGGER.info("End " + getClass().getName() + " " + "insertGeography");

    }

    private void insertTechnology() {

        LOGGER.info("Start " + getClass().getName() + " " + "insertTechnology");

        Technology technology = ecoSpold.getActivityDataset().getActivityDescription().getTechnology();
        TechnologyQueryBuilder technologyQueryBuilder = new TechnologyQueryBuilder(technology,activityIdEcoSpold);
        String insertQueryTechnology = technologyQueryBuilder.createTechnologyInsertionQuery();
        integrator.insertDataToGraphDB(insertQueryTechnology);
        integrator.connectIndividuals(activityIdentifier, VocabularyEcoSpold.technologyIndividual, technologyQueryBuilder.getIdentifier());

        LOGGER.info("End " + getClass().getName() + " " + "insertTechnology");

    }

    private void insertTimePeriod() {

        LOGGER.info("Start " + getClass().getName() + " " + "insertTimePeriod");

        TimePeriod timePeriod = ecoSpold.getActivityDataset().getActivityDescription().getTimePeriod();
        TimePeriodQueryBuilder timePeriodQueryBuilder = new TimePeriodQueryBuilder(timePeriod,activityIdEcoSpold);
        String insertQueryTimePeriod = timePeriodQueryBuilder.createTimePeriodInsertionQuery();
        String timePeriodIdentifier = timePeriodQueryBuilder.getIdentifier();
        integrator.insertDataToGraphDB(insertQueryTimePeriod);
        integrator.connectIndividuals(activityIdentifier, VocabularyEcoSpold.timePeriodIndividual, timePeriodIdentifier);

        LOGGER.info("End " + getClass().getName() + " " + "insertTimePeriod");

    }

    private void insertMacroEconomicScenario() {

        LOGGER.info("Start " + getClass().getName() + " " + "insertMacroEconomicScenario");

        MacroEconomicScenario macroEconomicScenario = ecoSpold.getActivityDataset().getActivityDescription().getMacroEconomicScenario();
        MacroEconomicScenarioQueryBuilder macroEconomicScenarioQueryBuilder = new MacroEconomicScenarioQueryBuilder(macroEconomicScenario,activityIdEcoSpold);
        String insertMacroEconomicScenario = macroEconomicScenarioQueryBuilder.createMacroEconomicScenarioInsertionQuery();
        integrator.insertDataToGraphDB(insertMacroEconomicScenario);
        integrator.connectIndividuals(activityIdentifier, VocabularyEcoSpold.macroEconomicScenarioIndividual, macroEconomicScenarioQueryBuilder.getIdentifier());

        LOGGER.info("End " + getClass().getName() + " " + "insertMacroEconomicScenario");

    }

    private void insertIntermediateExchange() {

        LOGGER.info("Start " + getClass().getName() + " " + "insertIntermediateExchange");


        List<IntermediateExchange> intermediateExchanges = ecoSpold.getActivityDataset().getFlowData().getIntermediateExchange();

        for (IntermediateExchange intermediateExchange: intermediateExchanges) {

            List<String> propertyIdentifier = new ArrayList<>();
            List<String> classificationIdentifier = new ArrayList<>();

            //Add properties
            for (Property property: intermediateExchange.getProperty()) {
                PropertyQueryBuilder propertyQueryBuilder = new PropertyQueryBuilder(property, activityIdEcoSpold, intermediateExchange.getId());
                String insertProperty = propertyQueryBuilder.createPropertyInsertionQuery();
                propertyIdentifier.add(propertyQueryBuilder.getIdentifier());
                integrator.insertDataToGraphDB(insertProperty);
            }

            //Add classification
            for (Classification classification: intermediateExchange.getClassification()) {
                ClassificationQueryBuilder classificationQueryBuilder = new ClassificationQueryBuilder(classification, activityIdEcoSpold);
                String insertClassification = classificationQueryBuilder.createClassificationInsertionQuery();
                classificationIdentifier.add(classificationQueryBuilder.getIdentifier());
                integrator.insertDataToGraphDB(insertClassification);
            }

            IntermediateExchangeQueryBuilder intermediateExchangeQueryBuilder = new IntermediateExchangeQueryBuilder(intermediateExchange,activityIdEcoSpold);
            String insertIntermediateExchange = intermediateExchangeQueryBuilder.createIntermediateExchangeInsertionQuery();
            integrator.insertDataToGraphDB(insertIntermediateExchange);

            //Connect properties
            for(String property: propertyIdentifier) {
                integrator.connectIndividuals(intermediateExchangeQueryBuilder.getIdentifier(), VocabularyEcoSpold.propertyExchangeIndividual, property);
            }

            //Connect classification
            for(String property: propertyIdentifier) {
                integrator.connectIndividuals(intermediateExchangeQueryBuilder.getIdentifier(), VocabularyEcoSpold.classificationExchangeIndividual, property);
            }

            //Connect to activity
            integrator.connectIndividuals(activityIdentifier, VocabularyEcoSpold.customExchangeIndividual, intermediateExchangeQueryBuilder.getIdentifier());

        }

        LOGGER.info("End " + getClass().getName() + " " + "insertIntermediateExchange");

    }

    private void insertRepresentativeness() {

        LOGGER.info("Start " + getClass().getName() + " " + "insertRepresentativeness");


        Representativeness representativeness = ecoSpold.getActivityDataset().getModellingAndValidation().getRepresentativeness();
        RepresentativenessQueryBuilder representativenessQueryBuilder = new RepresentativenessQueryBuilder(representativeness, activityIdEcoSpold);
        String intersertRepresentativeness = representativenessQueryBuilder.createRepresentativenessInsertionQuery();
        integrator.insertDataToGraphDB(intersertRepresentativeness);
        integrator.connectIndividuals(activityIdentifier, VocabularyEcoSpold.representativenessIndividual, representativenessQueryBuilder.getIdentifier());

        LOGGER.info("End " + getClass().getName() + " " + "insertRepresentativeness");

    }

    private void insertReview() {

        LOGGER.info("Start " + getClass().getName() + " " + "insertReview");

        List<Review> reviewData = ecoSpold.getActivityDataset().getModellingAndValidation().getReviews();
        for (Review review: reviewData) {
            ReviewQueryBuilder reviewQueryBuilder = new ReviewQueryBuilder(review, activityIdEcoSpold);
            String insertQueryReview = reviewQueryBuilder.createReviewInsertionQuery();
            integrator.insertDataToGraphDB(insertQueryReview);
            integrator.connectIndividuals(activityIdentifier, VocabularyEcoSpold.reviewIndividual, reviewQueryBuilder.getIdentifier());
        }

        LOGGER.info("End " + getClass().getName() + " " + "insertReview");

    }

    private void insertDataEntryBy() {

        LOGGER.info("Start " + getClass().getName() + " " + "insertDataEntryBy");

        DataEntryBy dataEntryBy = ecoSpold.getActivityDataset().getAdministrativeInformation().getDataEntryBy();
        DataEntryByQueryBuilder dataEntryByQueryBuilder = new DataEntryByQueryBuilder(dataEntryBy, activityIdEcoSpold);
        String insertDataEntryBy = dataEntryByQueryBuilder.createDataEntryByInsertionQuery();
        integrator.insertDataToGraphDB(insertDataEntryBy);
        integrator.connectIndividuals(activityIdentifier, VocabularyEcoSpold.dataEntryByIndividual, dataEntryByQueryBuilder.getIdentifier());

        LOGGER.info("End " + getClass().getName() + " " + "insertDataEntryBy");

    }

    private void insertDataGeneratorAndPublication() {

        LOGGER.info("Start " + getClass().getName() + " " + "insertDataGeneratorAndPublication");

        DataGeneratorAndPublication dataGeneratorAndPublication = ecoSpold.getActivityDataset().getAdministrativeInformation().getDataGeneratorAndPublication();
        DataGeneratorAndPublicationQueryBuilder dataGeneratorAndPublicationQueryBuilder = new DataGeneratorAndPublicationQueryBuilder(dataGeneratorAndPublication, activityIdEcoSpold);
        String insertDataGeneratorAndPublication = dataGeneratorAndPublicationQueryBuilder.createDataGeneratorAndPublicationInsertionQuery();
        integrator.insertDataToGraphDB(insertDataGeneratorAndPublication);
        integrator.connectIndividuals(activityIdentifier, VocabularyEcoSpold.dataGeneratorAndPublicationIndividual, dataGeneratorAndPublicationQueryBuilder.getIdentifier());

        LOGGER.info("End " + getClass().getName() + " " + "insertDataGeneratorAndPublication");

    }

    private void insertFileAttributes() {

        LOGGER.info("Start " + getClass().getName() + " " + "insertFileAttributes");

        FileAttributes fileAttributes = ecoSpold.getActivityDataset().getAdministrativeInformation().getFileAttributes();
        FileAttributesQueryBuilder fileAttributesQueryBuilder = new FileAttributesQueryBuilder(fileAttributes, activityIdEcoSpold);
        String insertFileAttributes = fileAttributesQueryBuilder.createFileAttributesInsertionQuery();
        integrator.insertDataToGraphDB(insertFileAttributes);
        integrator.connectIndividuals(activityIdentifier, VocabularyEcoSpold.fileAttributesIndividual, fileAttributesQueryBuilder.getIdentifier());

        LOGGER.info("End " + getClass().getName() + " " + "insertFileAttributes");

    }

}
