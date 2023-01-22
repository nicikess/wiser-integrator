package ch.unisg.ics.interactions.wiser.integrator;

import ch.unisg.ics.interactions.wiser.WiserIntegrator;
import ch.unisg.ics.interactions.wiser.data.ilcd.*;
import ch.unisg.ics.interactions.wiser.data.ilcd.ProcessDataSet;
import ch.unisg.ics.interactions.wiser.queries.ilcd.*;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;
import java.util.logging.Logger;

import java.util.ArrayList;
import java.util.List;


public class InsertILCDData {

    private static ProcessDataSet ilcd;
    private static String activityIdILCD;
    private static String activityIdentifier;
    WiserIntegrator integrator;

    Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public InsertILCDData(ProcessDataSet ilcd) {

        this.ilcd = ilcd;
        this.activityIdILCD = ilcd.getProcessInformation().getDataSetInformation().getUUID();
        integrator = new WiserIntegrator();
        
        insertILCDDataToGraphDB();

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
        insertReview();

        //AdministrativeInformation
        insertCommissionerAndGoal();
        insertDataGenerator();
        insertDataEntryBy();
        insertPublicationAndOwnership();

        //Exchanges
        insertExchanges();

    }

    public void insertDataSetInformation() {

        LOGGER.info("Start " + getClass().getName() + " " + "insertDataSetInformation");

        DataSetInformation dataSetInformation = ilcd.getProcessInformation().getDataSetInformation();
        DataSetInformationQueryBuilder dataSetInformationQueryBuilder = new DataSetInformationQueryBuilder(dataSetInformation, activityIdILCD);
        String insertDataSetInformation = dataSetInformationQueryBuilder.createDataSetInformationInsertionQuery();
        activityIdentifier = dataSetInformationQueryBuilder.getIdentifier();
        integrator.insertDataToGraphDB(insertDataSetInformation);

        LOGGER.info("End " + getClass().getName() + " " + "insertDataSetInformation");

    }

    public void insertQuantitativeReference() {

        LOGGER.info("Start " + getClass().getName() + " " + "insertQuantitativeReference");

        QuantitativeReference quantitativeReference = ilcd.getProcessInformation().getQuantitativeReference();
        QuantitativeReferenceQueryBuilder quantitativeReferenceQueryBuilder = new QuantitativeReferenceQueryBuilder(quantitativeReference, activityIdILCD);
        String insertQuantitativeReference = quantitativeReferenceQueryBuilder.createQuantitativeReferenceInsertionQuery();
        integrator.insertDataToGraphDB(insertQuantitativeReference);
        integrator.connectIndividuals(activityIdentifier, VocabularyILCD.quantitativeInformationIndividual, quantitativeReferenceQueryBuilder.getIdentifier());

        LOGGER.info("End " + getClass().getName() + " " + "insertQuantitativeReference");

    }

    private void insertTime() {

        LOGGER.info("Start " + getClass().getName() + " " + "insertTime");

        Time time = ilcd.getProcessInformation().getTime();
        TimeQueryBuilder timeQueryBuilder = new TimeQueryBuilder(time, activityIdILCD);
        String insertTime = timeQueryBuilder.createTimeInsertionQuery();
        integrator.insertDataToGraphDB(insertTime);
        integrator.connectIndividuals(activityIdentifier, VocabularyILCD.timeIndividual, timeQueryBuilder.getIdentifier());

        LOGGER.info("End " + getClass().getName() + " " + "insertTime");

    }

    private void insertGeography() {

        LOGGER.info("Start " + getClass().getName() + " " + "insertGeography");

        Geography geography = ilcd.getProcessInformation().getGeography();
        GeographyQueryBuilder geographyQueryBuilder = new GeographyQueryBuilder(geography, activityIdILCD);
        String insertGeography = geographyQueryBuilder.createGeographyInsertionQuery();
        integrator.insertDataToGraphDB(insertGeography);
        integrator.connectIndividuals(activityIdentifier, VocabularyILCD.locationOfOperationSupplyOrProductionIndividual, geographyQueryBuilder.getIdentifier());

        LOGGER.info("End " + getClass().getName() + " " + "insertGeography");

    }

    private void insertTechnology() {

        LOGGER.info("Start " + getClass().getName() + " " + "insertTechnology");

        Technology technology = ilcd.getProcessInformation().getTechnology();
        TechnologyQueryBuilder technologyQueryBuilder = new TechnologyQueryBuilder(technology, activityIdILCD);
        String insertTechnology = technologyQueryBuilder.createTechnologyInsertionQuery();
        integrator.insertDataToGraphDB(insertTechnology);
        integrator.connectIndividuals(activityIdentifier, VocabularyILCD.technologyIndividual, technologyQueryBuilder.getIdentifier());

        LOGGER.info("End " + getClass().getName() + " " + "insertTechnology");

    }

    private void insertLCIMethodAndAllocation() {

        LOGGER.info("Start " + getClass().getName() + " " + "insertLCIMethodAndAllocation");

        LCIMethodAndAllocation lciMethodAndAllocation = ilcd.getModellingAndValidation().getLCIMethodAndAllocation();
        LCIMethodAndAllocationQueryBuilder lciMethodAndAllocationQueryBuilder = new LCIMethodAndAllocationQueryBuilder(lciMethodAndAllocation, activityIdILCD);
        String insertLCIMethodAndAllocation = lciMethodAndAllocationQueryBuilder.createLCIMethodAndAllocationInsertionQuery();
        integrator.insertDataToGraphDB(insertLCIMethodAndAllocation);
        integrator.connectIndividuals(activityIdentifier, VocabularyILCD.lciMethodAndAllocationIndividual, lciMethodAndAllocationQueryBuilder.getIdentifier());

        LOGGER.info("End " + getClass().getName() + " " + "insertLCIMethodAndAllocation");

    }

    private void insertDataSourcesTreatmentAndRepresentativeness() {

        LOGGER.info("Start " + getClass().getName() + " " + "insertDataSourcesTreatmentAndRepresentativeness");

        DataSourcesTreatmentAndRepresentativeness dataSourcesTreatmentAndRepresentativeness = ilcd.getModellingAndValidation().getDataSourcesTreatmentAndRepresentativeness();
        DataSourcesTreatmentAndRepresentativenessQueryBuilder dataSourcesTreatmentAndRepresentativenessQueryBuilder = new DataSourcesTreatmentAndRepresentativenessQueryBuilder(dataSourcesTreatmentAndRepresentativeness, activityIdILCD);

        List<String> referenceToDataSourceIdentifier = new ArrayList<>();

        //References to data source
        for (ReferenceToDataSource referenceToDataSource: dataSourcesTreatmentAndRepresentativeness.getReferenceToDataSources()) {
            ReferenceToDataSourceQueryBuilder referenceToDataSourceQueryBuilder = new ReferenceToDataSourceQueryBuilder(referenceToDataSource, activityIdILCD);
            String insertReferenceToDataSource = referenceToDataSourceQueryBuilder.createReferenceToDataSourceInsertionQuery();
            referenceToDataSourceIdentifier.add(referenceToDataSourceQueryBuilder.getIdentifier());
            integrator.insertDataToGraphDB(insertReferenceToDataSource);
        }

        String insertQueryTreatmentAndRepresentativeness = dataSourcesTreatmentAndRepresentativenessQueryBuilder.createDataSourcesTreatmentAndRepresentativenessInsertionQuery();
        integrator.insertDataToGraphDB(insertQueryTreatmentAndRepresentativeness);

        //Connect properties
        for (String reference: referenceToDataSourceIdentifier) {
            integrator.connectIndividuals(dataSourcesTreatmentAndRepresentativenessQueryBuilder.getIdentifier(), VocabularyILCD.referenceToDataSourceIndividual, reference);
        }

        //Connect to activity
        integrator.connectIndividuals(activityIdentifier, VocabularyILCD.dataSourcesTreatmentAndRepresentativenessIndividual, dataSourcesTreatmentAndRepresentativenessQueryBuilder.getIdentifier());

        LOGGER.info("End " + getClass().getName() + " " + "insertDataSourcesTreatmentAndRepresentativeness");

    }

    private void insertReview() {

        LOGGER.info("Start " + getClass().getName() + " " + "insertReview");

        Review review = ilcd.getModellingAndValidation().getValidation().getReview();
        ReviewQueryBuilder reviewQueryBuilder = new ReviewQueryBuilder(review, activityIdILCD);
        String insertReview = reviewQueryBuilder.createReviewInsertionQuery();
        integrator.insertDataToGraphDB(insertReview);

        List<String> referenceToNameOfReviewerAndInstitutionIdentifier = new ArrayList<>();

        //Add references
        for (ReferenceToNameOfReviewerAndInstitution referenceToNameOfReviewerAndInstitution: review.getReferenceToNameOfReviewerAndInstitution()) {
            ReferenceToNameOfReviewerAndInstitutionQueryBuilder referenceToNameOfReviewerAndInstitutionQueryBuilder = new ReferenceToNameOfReviewerAndInstitutionQueryBuilder(referenceToNameOfReviewerAndInstitution, activityIdILCD);
            String insertReferenceToNameOfReviewerAndInstitution = referenceToNameOfReviewerAndInstitutionQueryBuilder.createReferenceToDataSourceInsertionQuery();
            referenceToNameOfReviewerAndInstitutionIdentifier.add(referenceToNameOfReviewerAndInstitutionQueryBuilder.getIdentifier());
            integrator.insertDataToGraphDB(insertReferenceToNameOfReviewerAndInstitution);
        }

        //Connect references
        for (String reference: referenceToNameOfReviewerAndInstitutionIdentifier) {
            integrator.connectIndividuals(reviewQueryBuilder.getIdentifier(), VocabularyILCD.referenceToNameOfReviewerAndInstitutionIndividual, reference);
        }

        integrator.connectIndividuals(activityIdentifier, VocabularyILCD.validationIndividual, reviewQueryBuilder.getIdentifier());

        LOGGER.info("End " + getClass().getName() + " " + "insertReview");

    }

    private void insertCommissionerAndGoal() {

        LOGGER.info("Start " + getClass().getName() + " " + "insertCommissionerAndGoal");

        CommissionerAndGoal commissionerAndGoal = ilcd.getAdministrativeInformation().getCommissionerAndGoal();
        CommissionerAndGoalQueryBuilder commissionerAndGoalQueryBuilder = new CommissionerAndGoalQueryBuilder(commissionerAndGoal, activityIdILCD);
        String insertCommissionerAndGoal = commissionerAndGoalQueryBuilder.createCommissionerAndGoalInsertionQuery();
        integrator.insertDataToGraphDB(insertCommissionerAndGoal);
        integrator.connectIndividuals(activityIdentifier, VocabularyILCD.commissionerAndGoalIndividual, commissionerAndGoalQueryBuilder.getIdentifier());

        LOGGER.info("End " + getClass().getName() + " " + "insertCommissionerAndGoal");

    }

    private void insertDataGenerator() {

        LOGGER.info("Start " + getClass().getName() + " " + "insertDataGenerator");

        DataGenerator dataGenerator = ilcd.getAdministrativeInformation().getDataGenerator();
        DataGeneratorQueryBuilder dataGeneratorQueryBuilder = new DataGeneratorQueryBuilder(dataGenerator, activityIdILCD);
        String insertDataGenerator = dataGeneratorQueryBuilder.createDataGeneratorInsertionQuery();
        integrator.insertDataToGraphDB(insertDataGenerator);

        List<String> referenceToPersonOrEntityGeneratingTheDataSetIdentifier = new ArrayList<>();

        //Add references
        for (ReferenceToPersonOrEntityGeneratingTheDataSet referenceToPersonOrEntityGeneratingTheDataSet: dataGenerator.getReferenceToPersonOrEntityGeneratingTheDataSet()) {
            ReferenceToPersonOrEntityGeneratingTheDataSetQueryBuilder referenceToPersonOrEntityGeneratingTheDataSetQueryBuilder = new ReferenceToPersonOrEntityGeneratingTheDataSetQueryBuilder(referenceToPersonOrEntityGeneratingTheDataSet, activityIdILCD);
            String insertReferenceToPersonOrEntityGeneratingTheDataSet = referenceToPersonOrEntityGeneratingTheDataSetQueryBuilder.createReferenceToPersonOrEntityGeneratingTheDataInsertionQuery();
            referenceToPersonOrEntityGeneratingTheDataSetIdentifier.add(referenceToPersonOrEntityGeneratingTheDataSetQueryBuilder.getIdentifier());
            integrator.insertDataToGraphDB(insertReferenceToPersonOrEntityGeneratingTheDataSet);
        }

        //Connect references
        for (String reference: referenceToPersonOrEntityGeneratingTheDataSetIdentifier) {
            integrator.connectIndividuals(dataGeneratorQueryBuilder.getIdentifier(), VocabularyILCD.referenceToPersonOrEntityGeneratingTheDataSetIndividual, reference);
        }

        integrator.connectIndividuals(activityIdentifier, VocabularyILCD.dataGeneratorIndividual, dataGeneratorQueryBuilder.getIdentifier());

        LOGGER.info("End " + getClass().getName() + " " + "insertDataGenerator");

    }

    private void insertDataEntryBy() {

        LOGGER.info("Start " + getClass().getName() + " " + "insertDataEntryBy");

        DataEntryBy dataEntryBy = ilcd.getAdministrativeInformation().getDataEntryBy();
        DataEntryByQueryBuilder dataEntryByQueryBuilder = new DataEntryByQueryBuilder(dataEntryBy, activityIdILCD);
        String insertDataEntryBy = dataEntryByQueryBuilder.createDataEntryByInsertionQuery();
        integrator.insertDataToGraphDB(insertDataEntryBy);

        ReferenceToDataSetFormat referenceToDataSetFormat = ilcd.getAdministrativeInformation().getDataEntryBy().getReferenceToDataSetFormat();
        ReferenceToDataSetFormatQueryBuilder referenceToDataSetFormatQueryBuilder = new ReferenceToDataSetFormatQueryBuilder(referenceToDataSetFormat, activityIdILCD);
        String insertReferenceToDataSetFormat = referenceToDataSetFormatQueryBuilder.createReferenceToDataSetFormatInsertionQuery();
        integrator.insertDataToGraphDB(insertReferenceToDataSetFormat);

        ReferenceToPersonOrEntityEnteringTheData referenceToPersonOrEntityEnteringTheData = ilcd.getAdministrativeInformation().getDataEntryBy().getReferenceToPersonOrEntityEnteringTheData();
        ReferenceToPersonOrEntityEnteringTheDataQueryBuilder referenceToPersonOrEntityEnteringTheDataQueryBuilder = new ReferenceToPersonOrEntityEnteringTheDataQueryBuilder(referenceToPersonOrEntityEnteringTheData, activityIdILCD);
        String insertReferenceToPersonOrEntityEnteringTheData = referenceToPersonOrEntityEnteringTheDataQueryBuilder.createReferenceToPersonOrEntityEnteringTheDataInsertionQuery();
        integrator.insertDataToGraphDB(insertReferenceToPersonOrEntityEnteringTheData);

        //Connect references to data entry by
        integrator.connectIndividuals(dataEntryByQueryBuilder.getIdentifier(), VocabularyILCD.referenceToDataSetFormatIndividual, referenceToDataSetFormatQueryBuilder.getIdentifier());
        integrator.connectIndividuals(activityIdentifier, VocabularyILCD.referenceToPersonOrEntityEnteringTheDataIndividual, referenceToPersonOrEntityEnteringTheDataQueryBuilder.getIdentifier());

        //Connect data entry by to activity
        integrator.connectIndividuals(activityIdentifier, VocabularyILCD.dataEntryByIndividual, dataEntryByQueryBuilder.getIdentifier());

        LOGGER.info("End " + getClass().getName() + " " + "insertDataEntryBy");

    }

    private void insertPublicationAndOwnership() {

        LOGGER.info("Start " + getClass().getName() + " " + "insertPublicationAndOwnership");

        PublicationAndOwnership publicationAndOwnerShip = ilcd.getAdministrativeInformation().getPublicationAndOwnership();
        PublicationAndOwnershipQueryBuilder publicationAndOwnerShipQueryBuilder = new PublicationAndOwnershipQueryBuilder(publicationAndOwnerShip, activityIdILCD);
        String insertPublicationAndOwnerShip = publicationAndOwnerShipQueryBuilder.createPublicationAndOwnershipInsertionQuery();
        integrator.insertDataToGraphDB(insertPublicationAndOwnerShip);

        ReferenceToOwnershipOfDataSet referenceToOwnershipOfDataSet = ilcd.getAdministrativeInformation().getPublicationAndOwnership().getReferenceToOwnershipOfDataSet();
        ReferenceToOwnershipOfDataSetQueryBuilder referenceToOwnershipOfDataSetQueryBuilder = new ReferenceToOwnershipOfDataSetQueryBuilder(referenceToOwnershipOfDataSet, activityIdILCD);
        String insertReferenceToOwnershipOfDataSet = referenceToOwnershipOfDataSetQueryBuilder.createReferenceToOwnershipOfDataSetInsertionQuery();
        integrator.insertDataToGraphDB(insertReferenceToOwnershipOfDataSet);

        ReferenceToUnchangedRepublication referenceToUnchangedRepublication = ilcd.getAdministrativeInformation().getPublicationAndOwnership().getReferenceToUnchangedRepublication();
        ReferenceToUnchangedRepublicationQueryBuilder referenceToUnchangedRepublicationQueryBuilder = new ReferenceToUnchangedRepublicationQueryBuilder(referenceToUnchangedRepublication, activityIdILCD);
        String insertReferenceToUnchangedRepublication = referenceToUnchangedRepublicationQueryBuilder.createReferenceToUnchangedRepublicationInsertionQuery();
        integrator.insertDataToGraphDB(insertReferenceToUnchangedRepublication);

        //Connect references to data entry by
        integrator.connectIndividuals(publicationAndOwnerShipQueryBuilder.getIdentifier(), VocabularyILCD.referenceToOwnershipOfDataSetIndividual, referenceToOwnershipOfDataSetQueryBuilder.getIdentifier());
        integrator.connectIndividuals(activityIdentifier, VocabularyILCD.referenceToUnchangedRepublicationIndividual, referenceToUnchangedRepublicationQueryBuilder.getIdentifier());

        //Connect data entry by to activity
        integrator.connectIndividuals(activityIdentifier, VocabularyILCD.publicationAndOwnershipTypeIndividual, publicationAndOwnerShipQueryBuilder.getIdentifier());

        LOGGER.info("End " + getClass().getName() + " " + "insertPublicationAndOwnership");

    }

    private void insertExchanges() {

        LOGGER.info("Start " + getClass().getName() + " " + "insertExchanges");

        for (Exchange exchange: ilcd.getExchanges().getExchange()) {
            ExchangeQueryBuilder exchangeQueryBuilder = new ExchangeQueryBuilder(exchange, activityIdILCD);
            String insertPublicationAndOwnerShip = exchangeQueryBuilder.createExchangeInsertionQuery();
            integrator.insertDataToGraphDB(insertPublicationAndOwnerShip);

            ReferenceToFlowDataSet referenceToFlowDataSet = exchange.getReferenceToFlowDataSet();
            ReferenceToFlowDataSetQueryBuilder referenceToFlowDataSetQueryBuilder = new ReferenceToFlowDataSetQueryBuilder(referenceToFlowDataSet, activityIdILCD);
            String insertReferenceToFlowDataSet = referenceToFlowDataSetQueryBuilder.createReferenceToFlowDataSetInsertionQuery();
            integrator.insertDataToGraphDB(insertReferenceToFlowDataSet);

            //Connect references to data entry by
            integrator.connectIndividuals(exchangeQueryBuilder.getIdentifier(), VocabularyILCD.referenceToFlowDataSetIndividual, referenceToFlowDataSetQueryBuilder.getIdentifier());

            //Connect data entry by to activity
            integrator.connectIndividuals(activityIdentifier, VocabularyILCD.exchangesIndividual, exchangeQueryBuilder.getIdentifier());

        }

        LOGGER.info("End " + getClass().getName() + " " + "insertExchanges");

    }

}
