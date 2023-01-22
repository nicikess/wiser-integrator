package ch.unisg.ics.interactions.wiser.tools;

/**
 *Defines the prefixes for ILCD data and object properties
 */

public class VocabularyILCD {

    //Prefix
    public static String bridgingOntologyPrefix = "<http://wiser-flagship.org/>";
    public static String ilcdCommonGroupsPrefix = "commonGroups: <http://lca.jrc.it/ILCD/Common_Groups#>";
    public static String ilcdProcessPrefix = "process: <http://lca.jrc.it/ILCD/Process_Data_Set#>";
    public static String ilcdCommonEnumerationPrefix = "commonEnumeration: <http://lca.jrc.it/ILCD/Common_Enumeration_Values#>";
    public static String ilcdDatatypesPrefix = "dataTypes: <http://lca.jrc.it/ILCD/Common_Data_Types#>";

    //Geography
    public static String geography = "process:LocationOfOperationSupplyOrProductionType";
    public static String geographyLocation = "process:location";
    public static String geographyLatitudeAndLongitude = "commonGroups:latitudeAndLongitude";
    public static String geographyDescriptionOfRestrictions = "process:descriptionOfRestrictions";

    //IRI
    public static String geographyIRI = "http://lca.jrc.it/ILCD/locationOfOperationSupplyOrProductionType/";
    public static String timeIRI = "http://lca.jrc.it/ILCD/timeRepresentativeness/";
    public static String technologyIRI = "http://lca.jrc.it/ILCD/technology/";
    public static String quantitativeReferenceIRI = "http://lca.jrc.it/ILCD/quantitativeReference/";
    public static String lciIRI = "http://lca.jrc.it/ILCD/LCI_MethodAndAllocation/";
    public static String datasetInformationIRI = "http://lca.jrc.it/ILCD/dataSetInformation/";
    public static String datasetCommissionerAndGoalIRI = "http://lca.jrc.it/ILCD/commissionerAndGoal/";
    public static String dataSourcesTreatmentAndRepresentativenessIRI = "http://lca.jrc.it/ILCD/dataSourcesTreatmentAndRepresentativeness/";
    public static String referenceToDataSourceIRI = "http://lca.jrc.it/ILCD/dataSource/";
    public static String reviewIRI = "http://lca.jrc.it/ILCD/review/";
    public static String referenceToNameOfReviewerAndInstitutionIRI = "http://lca.jrc.it/ILCD/referenceToReviewerAndInstitution/";
    public static String dataGeneratorIRI = "http://lca.jrc.it/ILCD/dataGenerator/";
    public static String referenceToPersonOrEntityGeneratingTheDataSetIRI = "http://lca.jrc.it/ILCD/referenceToPersonOrEntityGeneratingTheDataSet/";
    public static String dataEntryByIRI = "http://lca.jrc.it/ILCD/dataEntryBy";
    public static String referenceToDataSetFormatIRI = "http://lca.jrc.it/ILCD/referenceToDataSetFormat/";
    public static String referenceToPersonOrEntityEnteringTheDataIRI = "http://lca.jrc.it/ILCD/referenceToPersonOrEntityEnteringTheData/";
    public static String publicationAndOwnershipIRI = "http://lca.jrc.it/ILCD/publicationAndownership/";
    public static String referenceToOwnershipOfDataSetIRI = "http://lca.jrc.it/ILCD/referenceToOwnershipOfDataSet/";
    public static String referenceToUnchangedRepublicationIRI = "http://lca.jrc.it/ILCD/referenceToUnchangedRepublication/";
    public static String exchangeIRI = "http://lca.jrc.it/ILCD/exchanges/";
    public static String referenceToFlowDataSetIRI= "http://lca.jrc.it/ILCD/referenceToFlowDataSet/";

    //Time
    public static String time = "process:TimeRepresentativenessType";
    public static String timeReferenceYear = "commonGroups:referenceYear";;
    public static String timeDataSetValidUntil = "commonGroups:dataSetValidUntil";
    public static String timeRepresentativenessDescription = "commonGroups:timeRepresentativenessDescription";

    //Technology
    public static String technology = "process:TechnologicalRepresentativenessType";
    public static String technologyDescriptionAndIncludedProcesses = "process:technologyDescriptionAndIncludedProcesses";;

    //Quantitative reference
    public static String quantitativeReference = "process:QuantitativeReference";
    public static String quantitativeReferenceType = "commonGroups:type";
    public static String referenceToReferenceFlow = "process:referenceToReferenceFlow";

    //LCA method and validation
    public static String lciMethodAndAllocationType = "process:LCIMethodAndAllocationType";
    public static String lciTypeOfDataSet = "process:typeOfDataSet";
    public static String lciMethodPrinciple = "process:lciMethodPrinciple";
    public static String lciDeviationsFromLCIMethodPrinciple = "process:deviationsFromLCIMethodPrinciple";
    public static String lciMethodApproaches = "process:lciMethodApproaches";
    public static String lciModellingConstants = "process:modellingConstants";

    //Dataset information
    public static String dataSetInformation = "process:DataSetInformationType";
    public static String dataSetInformationUuid = "dataTypes:uuid";
    public static String dataSetInformationGeneralComment = "commonGroups:generalComment";
    public static String dataSetInformationBaseName = "process:baseName";

    //Commissioner and Goal
    public static String commissionerAndGoalType = "commonGroups:CommissionerAndGoalType";
    public static String intendedApplications = "commonGroups:intendedApplications";

    //Classifiction & Class
    public static String classifictionOther = "commonGroups:other";

    //Data sources treatment and representativeness
    public static String dataSourcesTreatmentAndRepresentativenessType = "process:DataSourcesTreatmentAndRepresentativenessType";
    public static String dataCutOffAndCompletenessPrinciples = "process:dataCutOffAndCompletenessPrinciples";
    public static String deviationsFromCutOffAndCompletenessPrinciples = "process:deviationsFromCutOffAndCompletenessPrinciples";
    public static String dataSelectionAndCombinationPrinciples = "process:dataSelectionAndCombinationPrinciples";
    public static String deviationsFromSelectionAndCombinationPrinciples = "process:deviationsFromSelectionAndCombinationPrinciples";
    public static String dataTreatmentAndExtrapolationsPrinciples = "process:dataTreatmentAndExtrapolationsPrinciples";

    //Reference
    public static String reference = "commonGroups:GlobalReferenceType";
    public static String refObject = "commonGroups:refObjectId";
    public static String referenceType = "commonGroups:type";
    public static String referenceVersion = "dataTypes:version";
    public static String referenceURI = "commonGroups:uri";
    public static String referenceShortDescription = "commonGroups:shortDescription";

    //Validation
    public static String review = "process:ReviewType";
    public static String reviewType = "commonGroups:Type";
    public static String reviewDetails = "commonGroups:reviewDetails";

    //Reference to name of reviewer and institution
    public static String referenceToNameOfReviewerAndInstitution = "commonGroups:referenceToNameOfReviewerAndInstitution";

    //Data generator
    public static String dataGenerator = "process:DataGeneratorType";
    public static String referenceToPersonOrEntityGeneratingTheDataSet = "commonGroups:referenceToPersonOrEntityGeneratingTheDataSet";

    //Reference to person or entity generating the data
    public static String referenceToPersonOrEntityGeneratingTheData = "process:ToPersonOrEntityGeneratingTheData";

    //Data entry by
    public static String dataEntryByType = "process:DataEntryByType";
    public static String dataEntryByTimeStamp = "commonGroups:timeStamp";

    //Reference to data set format
    public static String referenceToDataSetFormat = "commonGroups:GlobalReferenceType";

    //Publication and ownership
    public static String publicationAndOwnership = "process:PublicationAndOwnershipType";
    public static String dateOfLastRevision = "commonGroups:dateOfLastRevision";
    public static String dataSetVersion = "commonGroups:dataSetVersion";
    public static String copyright = "commonGroups:copyright";
    public static String accessRestrictions = "commonGroups:accessRestrictions";

    //Exchanges
    public static String exchange = "process:ExchangeType";
    public static String exchangeDirection = "process:exchangeDirection";
    public static String exchangeMeanAmount = "process:meanAmount";
    public static String exchangeResultingAmount = "process:resultingAmount";

    //Class
    public static String classInfo = "commonGroups:ClassType";
    public static String classLevelType = "dataTypes:levelType";
    public static String classId = "commonGroups:classId";
    public static String classNameData = "commonGroups:nameData";
    public static String classFormat = "bridge:bEcoSpoldILC";

    //Connect individuals
    public static String quantitativeInformationIndividual = "commonGroups:quantitativeInformation";
    public static String timeIndividual = "process:time";
    public static String locationOfOperationSupplyOrProductionIndividual = "process:locationOfOperationSupplyOrProduction";
    public static String technologyIndividual = "process:technology";
    public static String lciMethodAndAllocationIndividual = "process:lciMethodAndAllocation";
    public static String dataSourcesTreatmentAndRepresentativenessIndividual = "process:dataSourcesTreatmentAndRepresentativeness";
    public static String validationIndividual = "commonGroups:validation";
    public static String commissionerAndGoalIndividual = "commonGroups:commissionerAndGoal";
    public static String dataGeneratorIndividual = "process:dataGenerator";
    public static String dataEntryByIndividual = "process:dataEntryBy";
    public static String publicationAndOwnershipTypeIndividual = "process:publicationAndOwnershipType";
    public static String exchangesIndividual = "process:exchanges";
    public static String classIndividual = "commonGroups:class";

    //Other references to connect
    public static String referenceToDataSourceIndividual = "commonGroups:referenceToDataSource";
    public static String referenceToNameOfReviewerAndInstitutionIndividual = "commonGroups:referenceToNameOfReviewerAndInstitution";
    public static String referenceToPersonOrEntityGeneratingTheDataSetIndividual = "commonGroups:referenceToPersonOrEntityGeneratingTheDataSet";
    public static String referenceToPersonOrEntityEnteringTheDataIndividual = "commonGroups:referenceToPersonOrEntityEnteringTheData";
    public static String referenceToDataSetFormatIndividual = "commonGroups:referenceToDataSetFormat";
    public static String referenceToOwnershipOfDataSetIndividual = "commonGroups:referenceToOwnershipOfDataSet";
    public static String referenceToUnchangedRepublicationIndividual = "commonGroups:referenceToUnchangedRepublication";
    public static String referenceToFlowDataSetIndividual = "process:referenceToFlowDataSet";

}
