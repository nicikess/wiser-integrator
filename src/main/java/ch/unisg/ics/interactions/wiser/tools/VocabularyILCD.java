package ch.unisg.ics.interactions.wiser.tools;

public class VocabularyILCD {

    //Prefix
    public static String bridgingOntologyPrefix = "<http://wiser-flagship.org/>";
    public static String ilcdCommonGroupsPrefix = "commonGroups: <http://lca.jrc.it/ILCD/Common_Groups#>";
    public static String ilcdProcessPrefix = "process: <http://lca.jrc.it/ILCD/Process_Data_Set#>";
    public static String ilcdCommonEnumeration = "commonEnumeration: <http://lca.jrc.it/ILCD/Common_Enumeration_Values#>";
    public static String ilcdDatatypes = "dataTypes: <http://lca.jrc.it/ILCD/Common_Data_Types#>";

    //Geography
    public static String geography = "process:LocationOfOperationSupplyOrProductionType";
    public static String geographyLocation = "process:location";
    public static String geographyLatitudeAndLongitude = "commonGroups:latitudeAndLongitude";
    public static String geographyDescriptionOfRestrictions = "process:descriptionOfRestrictions";

    //IRI
    public static String geographyIRI = "'http://lca.jrc.it/ILCD/locationOfOperationSupplyOrProductionType/";
    public static String timeIRI = "'http://lca.jrc.it/ILCD/timeRepresentativeness/";
    public static String technologyIRI = "'http://lca.jrc.it/ILCD/technology/";
    public static String quantitativeReferenceIRI = "'http://lca.jrc.it/ILCD/quantitativeReference/";
    public static String lciIRI = "'http://lca.jrc.it/ILCD/LCI_MethodAndAllocation/";
    public static String datasetInformationIRI = "'http://lca.jrc.it/ILCD/dataSetInformation/";
    public static String datasetCommissionerAndGoalIRI = "'http://lca.jrc.it/ILCD/commissionerAndGoal/";
    public static String dataSourcesTreatmentAndRepresentativenessIRI = "'http://lca.jrc.it/ILCD/dataSourcesTreatmentAndRepresentativeness/";

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

    //DataSourcesTreatmentAndRepresentativeness
    public static String dataSourcesTreatmentAndRepresentativenessType = "process:DataSourcesTreatmentAndRepresentativenessType";
    public static String dataCutOffAndCompletenessPrinciples = "process:dataCutOffAndCompletenessPrinciples";
    public static String deviationsFromCutOffAndCompletenessPrinciples = "process:deviationsFromCutOffAndCompletenessPrinciples";
    public static String dataSelectionAndCombinationPrinciples = "process:dataSelectionAndCombinationPrinciples";
    public static String deviationsFromSelectionAndCombinationPrinciples = "process:deviationsFromSelectionAndCombinationPrinciples";

}
