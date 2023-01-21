package ch.unisg.ics.interactions.wiser.integrator;

import ch.unisg.ics.interactions.wiser.data.ilcd.*;
import ch.unisg.ics.interactions.wiser.data.ilcd.ProcessDataSet;
import ch.unisg.ics.interactions.wiser.queries.ilcd.*;
import ch.unisg.ics.interactions.wiser.tools.GraphDBInterface;
import ch.unisg.ics.interactions.wiser.queries.ConnectIndividualsQuery;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;
import java.util.logging.Logger;

import java.util.ArrayList;
import java.util.List;


public class InsertILCDData {

    private static ProcessDataSet ilcd;
    private static String activityIdILCD;
    private static String activityIdentifier;

    Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public InsertILCDData(ProcessDataSet ilcd) {

        this.ilcd = ilcd;
        this.activityIdILCD = ilcd.getProcessInformation().getDataSetInformation().getUUID();

        insertILCDDataToGraphDB();

    }

    public void insertILCDDataToGraphDB() {

        //ProcessInformation
        LOGGER.info("Insert ILCD data set information");
        insertDataSetInformation();
        LOGGER.info("Insert ILCD quantitative reference");
        insertQuantitativeReference();
        LOGGER.info("Insert ILCD time data");
        insertTime();
        LOGGER.info("Insert ILCD geography data");
        insertGeography();
        LOGGER.info("Insert ILCD technology data");
        insertTechnology();

        //ModellingAndValidation
        LOGGER.info("Insert ILCD LCI data");
        insertLCIMethodAndAllocation();
        LOGGER.info("Insert ILCD treatment and representation");
        insertDataSourcesTreatmentAndRepresentativeness();
        LOGGER.info("Insert ILCD review data");
        insertReview();

        //AdministrativeInformation
        LOGGER.info("Insert ILCD commissioner and goal data");
        insertCommissionerAndGoal();
        LOGGER.info("Insert ILCD generator data");
        insertDataGenerator();
        LOGGER.info("Insert ILCD data entry by");
        insertDataEntryBy();
        LOGGER.info("Insert ILCD publication and ownership data");
        insertPublicationAndOwnership();

        //Exchanges
        LOGGER.info("Insert ILCD exchanges data");
        insertExchanges();

    }

    public void insertDataILCDToGraphDB(String query) {

        GraphDBInterface graphDBInterface = new GraphDBInterface();
        try {
            graphDBInterface.queryEndpoint(query);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void connectIndividuals(String identifierOne, String objectProperty, String identifierTwo) {

        String statement = new ConnectIndividualsQuery(identifierOne, objectProperty, identifierTwo).getConnectorStatement();
        insertDataILCDToGraphDB(statement);
    }

    public void insertDataSetInformation() {

        DataSetInformation dataSetInformation = ilcd.getProcessInformation().getDataSetInformation();
        DataSetInformationQueryBuilder dataSetInformationQueryBuilder = new DataSetInformationQueryBuilder(dataSetInformation, activityIdILCD);
        String insertDataSetInformation = dataSetInformationQueryBuilder.createDataSetInformationInsertionQuery();
        activityIdentifier = dataSetInformationQueryBuilder.getIdentifier();
        insertDataILCDToGraphDB(insertDataSetInformation);

    }

    public void insertQuantitativeReference() {

        QuantitativeReference quantitativeReference = ilcd.getProcessInformation().getQuantitativeReference();
        QuantitativeReferenceQueryBuilder quantitativeReferenceQueryBuilder = new QuantitativeReferenceQueryBuilder(quantitativeReference, activityIdILCD);
        String insertQuantitativeReference = quantitativeReferenceQueryBuilder.createQuantitativeReferenceInsertionQuery();
        insertDataILCDToGraphDB(insertQuantitativeReference);
        connectIndividuals(activityIdentifier, VocabularyILCD.quantitativeInformationIndividual, quantitativeReferenceQueryBuilder.getIdentifier());

    }

    private void insertTime() {

        Time time = ilcd.getProcessInformation().getTime();
        TimeQueryBuilder timeQueryBuilder = new TimeQueryBuilder(time, activityIdILCD);
        String insertTime = timeQueryBuilder.createTimeInsertionQuery();
        insertDataILCDToGraphDB(insertTime);
        connectIndividuals(activityIdentifier, VocabularyILCD.timeIndividual, timeQueryBuilder.getIdentifier());

    }

    private void insertGeography() {

        Geography geography = ilcd.getProcessInformation().getGeography();
        GeographyQueryBuilder geographyQueryBuilder = new GeographyQueryBuilder(geography, activityIdILCD);
        String insertGeography = geographyQueryBuilder.createGeographyInsertionQuery();
        insertDataILCDToGraphDB(insertGeography);
        connectIndividuals(activityIdentifier, VocabularyILCD.locationOfOperationSupplyOrProductionIndividual, geographyQueryBuilder.getIdentifier());

    }

    private void insertTechnology() {

        Technology technology = ilcd.getProcessInformation().getTechnology();
        TechnologyQueryBuilder technologyQueryBuilder = new TechnologyQueryBuilder(technology, activityIdILCD);
        String insertTechnology = technologyQueryBuilder.createTechnologyInsertionQuery();
        insertDataILCDToGraphDB(insertTechnology);
        connectIndividuals(activityIdentifier, VocabularyILCD.technologyIndividual, technologyQueryBuilder.getIdentifier());

    }

    private void insertLCIMethodAndAllocation() {

        LCIMethodAndAllocation lciMethodAndAllocation = ilcd.getModellingAndValidation().getLCIMethodAndAllocation();
        LCIMethodAndAllocationQueryBuilder lciMethodAndAllocationQueryBuilder = new LCIMethodAndAllocationQueryBuilder(lciMethodAndAllocation, activityIdILCD);
        String insertLCIMethodAndAllocation = lciMethodAndAllocationQueryBuilder.createLCIMethodAndAllocationInsertionQuery();
        insertDataILCDToGraphDB(insertLCIMethodAndAllocation);
        connectIndividuals(activityIdentifier, VocabularyILCD.lciMethodAndAllocationIndividual, lciMethodAndAllocationQueryBuilder.getIdentifier());

    }

    private void insertDataSourcesTreatmentAndRepresentativeness() {

        DataSourcesTreatmentAndRepresentativeness dataSourcesTreatmentAndRepresentativeness = ilcd.getModellingAndValidation().getDataSourcesTreatmentAndRepresentativeness();
        DataSourcesTreatmentAndRepresentativenessQueryBuilder dataSourcesTreatmentAndRepresentativenessQueryBuilder = new DataSourcesTreatmentAndRepresentativenessQueryBuilder(dataSourcesTreatmentAndRepresentativeness, activityIdILCD);

        List<String> referenceToDataSourceIdentifier = new ArrayList<>();

        //References to data source
        for (ReferenceToDataSource referenceToDataSource: dataSourcesTreatmentAndRepresentativeness.getReferenceToDataSources()) {
            ReferenceToDataSourceQueryBuilder referenceToDataSourceQueryBuilder = new ReferenceToDataSourceQueryBuilder(referenceToDataSource, activityIdILCD);
            String insertReferenceToDataSource = referenceToDataSourceQueryBuilder.createReferenceToDataSourceInsertionQuery();
            referenceToDataSourceIdentifier.add(referenceToDataSourceQueryBuilder.getIdentifier());
            insertDataILCDToGraphDB(insertReferenceToDataSource);
        }

        String insertQueryTreatmentAndRepresentativeness = dataSourcesTreatmentAndRepresentativenessQueryBuilder.createDataSourcesTreatmentAndRepresentativenessInsertionQuery();
        insertDataILCDToGraphDB(insertQueryTreatmentAndRepresentativeness);

        //Connect properties
        for (String reference: referenceToDataSourceIdentifier) {
            connectIndividuals(dataSourcesTreatmentAndRepresentativenessQueryBuilder.getIdentifier(), VocabularyILCD.referenceToDataSourceIndividual, reference);
        }

        //Connect to activity
        connectIndividuals(activityIdentifier, VocabularyILCD.dataSourcesTreatmentAndRepresentativenessIndividual, dataSourcesTreatmentAndRepresentativenessQueryBuilder.getIdentifier());

    }

    private void insertReview() {

        Review review = ilcd.getModellingAndValidation().getValidation().getReview();
        ReviewQueryBuilder reviewQueryBuilder = new ReviewQueryBuilder(review, activityIdILCD);
        String insertReview = reviewQueryBuilder.createReviewInsertionQuery();
        insertDataILCDToGraphDB(insertReview);

        List<String> referenceToNameOfReviewerAndInstitutionIdentifier = new ArrayList<>();

        //Add references
        for (ReferenceToNameOfReviewerAndInstitution referenceToNameOfReviewerAndInstitution: review.getReferenceToNameOfReviewerAndInstitution()) {
            ReferenceToNameOfReviewerAndInstitutionQueryBuilder referenceToNameOfReviewerAndInstitutionQueryBuilder = new ReferenceToNameOfReviewerAndInstitutionQueryBuilder(referenceToNameOfReviewerAndInstitution, activityIdILCD);
            String insertReferenceToNameOfReviewerAndInstitution = referenceToNameOfReviewerAndInstitutionQueryBuilder.createReferenceToDataSourceInsertionQuery();
            referenceToNameOfReviewerAndInstitutionIdentifier.add(referenceToNameOfReviewerAndInstitutionQueryBuilder.getIdentifier());
            insertDataILCDToGraphDB(insertReferenceToNameOfReviewerAndInstitution);
        }

        //Connect references
        for (String reference: referenceToNameOfReviewerAndInstitutionIdentifier) {
            connectIndividuals(reviewQueryBuilder.getIdentifier(), VocabularyILCD.referenceToNameOfReviewerAndInstitutionIndividual, reference);
        }

        connectIndividuals(activityIdentifier, VocabularyILCD.validationIndividual, reviewQueryBuilder.getIdentifier());

    }

    private void insertCommissionerAndGoal() {

        CommissionerAndGoal commissionerAndGoal = ilcd.getAdministrativeInformation().getCommissionerAndGoal();
        CommissionerAndGoalQueryBuilder commissionerAndGoalQueryBuilder = new CommissionerAndGoalQueryBuilder(commissionerAndGoal, activityIdILCD);
        String insertCommissionerAndGoal = commissionerAndGoalQueryBuilder.createCommissionerAndGoalInsertionQuery();
        insertDataILCDToGraphDB(insertCommissionerAndGoal);
        connectIndividuals(activityIdentifier, VocabularyILCD.commissionerAndGoalIndividual, commissionerAndGoalQueryBuilder.getIdentifier());

    }

    private void insertDataGenerator() {

        DataGenerator dataGenerator = ilcd.getAdministrativeInformation().getDataGenerator();
        DataGeneratorQueryBuilder dataGeneratorQueryBuilder = new DataGeneratorQueryBuilder(dataGenerator, activityIdILCD);
        String insertDataGenerator = dataGeneratorQueryBuilder.createDataGeneratorInsertionQuery();
        insertDataILCDToGraphDB(insertDataGenerator);

        List<String> referenceToPersonOrEntityGeneratingTheDataSetIdentifier = new ArrayList<>();

        //Add references
        for (ReferenceToPersonOrEntityGeneratingTheDataSet referenceToPersonOrEntityGeneratingTheDataSet: dataGenerator.getReferenceToPersonOrEntityGeneratingTheDataSet()) {
            ReferenceToPersonOrEntityGeneratingTheDataSetQueryBuilder referenceToPersonOrEntityGeneratingTheDataSetQueryBuilder = new ReferenceToPersonOrEntityGeneratingTheDataSetQueryBuilder(referenceToPersonOrEntityGeneratingTheDataSet, activityIdILCD);
            String insertReferenceToPersonOrEntityGeneratingTheDataSet = referenceToPersonOrEntityGeneratingTheDataSetQueryBuilder.createReferenceToPersonOrEntityGeneratingTheDataInsertionQuery();
            referenceToPersonOrEntityGeneratingTheDataSetIdentifier.add(referenceToPersonOrEntityGeneratingTheDataSetQueryBuilder.getIdentifier());
            insertDataILCDToGraphDB(insertReferenceToPersonOrEntityGeneratingTheDataSet);
        }

        //Connect references
        for (String reference: referenceToPersonOrEntityGeneratingTheDataSetIdentifier) {
            connectIndividuals(dataGeneratorQueryBuilder.getIdentifier(), VocabularyILCD.referenceToPersonOrEntityGeneratingTheDataSetIndividual, reference);
        }

        connectIndividuals(activityIdentifier, VocabularyILCD.dataGeneratorIndividual, dataGeneratorQueryBuilder.getIdentifier());

    }

    private void insertDataEntryBy() {

        DataEntryBy dataEntryBy = ilcd.getAdministrativeInformation().getDataEntryBy();
        DataEntryByQueryBuilder dataEntryByQueryBuilder = new DataEntryByQueryBuilder(dataEntryBy, activityIdILCD);
        String insertDataEntryBy = dataEntryByQueryBuilder.createDataEntryByInsertionQuery();
        insertDataILCDToGraphDB(insertDataEntryBy);

        ReferenceToDataSetFormat referenceToDataSetFormat = ilcd.getAdministrativeInformation().getDataEntryBy().getReferenceToDataSetFormat();
        ReferenceToDataSetFormatQueryBuilder referenceToDataSetFormatQueryBuilder = new ReferenceToDataSetFormatQueryBuilder(referenceToDataSetFormat, activityIdILCD);
        String insertReferenceToDataSetFormat = referenceToDataSetFormatQueryBuilder.createReferenceToDataSetFormatInsertionQuery();
        insertDataILCDToGraphDB(insertReferenceToDataSetFormat);

        ReferenceToPersonOrEntityEnteringTheData referenceToPersonOrEntityEnteringTheData = ilcd.getAdministrativeInformation().getDataEntryBy().getReferenceToPersonOrEntityEnteringTheData();
        ReferenceToPersonOrEntityEnteringTheDataQueryBuilder referenceToPersonOrEntityEnteringTheDataQueryBuilder = new ReferenceToPersonOrEntityEnteringTheDataQueryBuilder(referenceToPersonOrEntityEnteringTheData, activityIdILCD);
        String insertReferenceToPersonOrEntityEnteringTheData = referenceToPersonOrEntityEnteringTheDataQueryBuilder.createReferenceToPersonOrEntityEnteringTheDataInsertionQuery();
        insertDataILCDToGraphDB(insertReferenceToPersonOrEntityEnteringTheData);

        //Connect references to data entry by
        connectIndividuals(dataEntryByQueryBuilder.getIdentifier(), VocabularyILCD.referenceToDataSetFormatIndividual, referenceToDataSetFormatQueryBuilder.getIdentifier());
        connectIndividuals(activityIdentifier, VocabularyILCD.referenceToPersonOrEntityEnteringTheDataIndividual, referenceToPersonOrEntityEnteringTheDataQueryBuilder.getIdentifier());

        //Connect data entry by to activity
        connectIndividuals(activityIdentifier, VocabularyILCD.dataEntryByIndividual, dataEntryByQueryBuilder.getIdentifier());

    }

    private void insertPublicationAndOwnership() {

        PublicationAndOwnership publicationAndOwnerShip = ilcd.getAdministrativeInformation().getPublicationAndOwnership();
        PublicationAndOwnershipQueryBuilder publicationAndOwnerShipQueryBuilder = new PublicationAndOwnershipQueryBuilder(publicationAndOwnerShip, activityIdILCD);
        String insertPublicationAndOwnerShip = publicationAndOwnerShipQueryBuilder.createPublicationAndOwnershipInsertionQuery();
        insertDataILCDToGraphDB(insertPublicationAndOwnerShip);

        ReferenceToOwnershipOfDataSet referenceToOwnershipOfDataSet = ilcd.getAdministrativeInformation().getPublicationAndOwnership().getReferenceToOwnershipOfDataSet();
        ReferenceToOwnershipOfDataSetQueryBuilder referenceToOwnershipOfDataSetQueryBuilder = new ReferenceToOwnershipOfDataSetQueryBuilder(referenceToOwnershipOfDataSet, activityIdILCD);
        String insertReferenceToOwnershipOfDataSet = referenceToOwnershipOfDataSetQueryBuilder.createReferenceToOwnershipOfDataSetInsertionQuery();
        insertDataILCDToGraphDB(insertReferenceToOwnershipOfDataSet);

        ReferenceToUnchangedRepublication referenceToUnchangedRepublication = ilcd.getAdministrativeInformation().getPublicationAndOwnership().getReferenceToUnchangedRepublication();
        ReferenceToUnchangedRepublicationQueryBuilder referenceToUnchangedRepublicationQueryBuilder = new ReferenceToUnchangedRepublicationQueryBuilder(referenceToUnchangedRepublication, activityIdILCD);
        String insertReferenceToUnchangedRepublication = referenceToUnchangedRepublicationQueryBuilder.createReferenceToUnchangedRepublicationInsertionQuery();
        insertDataILCDToGraphDB(insertReferenceToUnchangedRepublication);

        //Connect references to data entry by
        connectIndividuals(publicationAndOwnerShipQueryBuilder.getIdentifier(), VocabularyILCD.referenceToOwnershipOfDataSetIndividual, referenceToOwnershipOfDataSetQueryBuilder.getIdentifier());
        connectIndividuals(activityIdentifier, VocabularyILCD.referenceToUnchangedRepublicationIndividual, referenceToUnchangedRepublicationQueryBuilder.getIdentifier());

        //Connect data entry by to activity
        connectIndividuals(activityIdentifier, VocabularyILCD.publicationAndOwnershipTypeIndividual, publicationAndOwnerShipQueryBuilder.getIdentifier());

    }

    private void insertExchanges() {

        for (Exchange exchange: ilcd.getExchanges().getExchange()) {
            ExchangeQueryBuilder exchangeQueryBuilder = new ExchangeQueryBuilder(exchange, activityIdILCD);
            String insertPublicationAndOwnerShip = exchangeQueryBuilder.createExchangeInsertionQuery();
            insertDataILCDToGraphDB(insertPublicationAndOwnerShip);

            ReferenceToFlowDataSet referenceToFlowDataSet = exchange.getReferenceToFlowDataSet();
            ReferenceToFlowDataSetQueryBuilder referenceToFlowDataSetQueryBuilder = new ReferenceToFlowDataSetQueryBuilder(referenceToFlowDataSet, activityIdILCD);
            String insertReferenceToFlowDataSet = referenceToFlowDataSetQueryBuilder.createReferenceToFlowDataSetInsertionQuery();
            insertDataILCDToGraphDB(insertReferenceToFlowDataSet);

            //Connect references to data entry by
            connectIndividuals(exchangeQueryBuilder.getIdentifier(), VocabularyILCD.referenceToFlowDataSetIndividual, referenceToFlowDataSetQueryBuilder.getIdentifier());

            //Connect data entry by to activity
            connectIndividuals(activityIdentifier, VocabularyILCD.exchangesIndividual, exchangeQueryBuilder.getIdentifier());

        }

    }

}
