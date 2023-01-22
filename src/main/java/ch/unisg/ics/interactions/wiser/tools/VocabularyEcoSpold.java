package ch.unisg.ics.interactions.wiser.tools;

/**
 *Defines the prefixes for EcoSpold data and object properties
 */

public class VocabularyEcoSpold{

    //Prefix
    public static String bridgingOntologyPrefix = "bridge <http://wiser-flagship.org/>";
    public static String ecoSpoldBasePrefix = "ecobase: <http://www.EcoInvent.org/EcoSpold02/base#>";
    public static String ecoSpoldTypesPrefix = "ecotype: <http://www.EcoInvent.org/EcoSpold02/dataTypes#>";
    public static String ecoSpoldMetaInformationPrefix = "ecometa: <http://www.EcoInvent.org/EcoSpold02/metainformation#>";
    public static String ecoSpoldSourcePrefix = "ecosource: <http://www.EcoInvent.org/EcoSpold02/source#>";
    public static String ecoSpoldActivityPrefix = "ecoact: <http://www.EcoInvent.org/EcoSpold02/activity#>";
    public static String ecoSpoldFlowdataPrefix = "ecoflow: <http://www.EcoInvent.org/EcoSpold02/flowdata#>";
    public static String ecoSpoldDataTypesPrefix = "ecodata: <http://www.EcoInvent.org/EcoSpold02/dataTypes#>";

    //IRI
    public static String activityIRI = "http://www.EcoInvent.org/EcoSpold02/activity/";
    public static String classificationIRI = "http://www.EcoInvent.org/EcoSpold02/classification/";
    public static String geographyIRI = "http://www.EcoInvent.org/EcoSpold02/geography/";
    public static String technologyIRI = "http://www.EcoInvent.org/EcoSpold02/technology/";
    public static String timePeriodIRI = "http://www.EcoInvent.org/EcoSpold02/timePeriod/";
    public static String macroEconomicScenarioIRI = "http://www.EcoInvent.org/EcoSpold02/macroEconomicScenario/";
    public static String dataEntryByIRI = "http://www.EcoInvent.org/EcoSpold02/dataEntryBy/";
    public static String dataGeneratorAndPublicationIRI = "http://www.EcoInvent.org/EcoSpold02/dataGeneratorAndPublication/";
    public static String fileAttributesIRI = "http://www.EcoInvent.org/EcoSpold02/fileAttributes/";
    public static String reviewIRI = "http://www.EcoInvent.org/EcoSpold02/review/";
    public static String representativenessIRI = "http://www.EcoInvent.org/EcoSpold02/representativeness/";
    public static String propertyIRI = "http://www.EcoInvent.org/EcoSpold02/property/";
    public static String uncertaintyIRI = "http://www.EcoInvent.org/EcoSpold02/property/";
    public static String intermediateExchangeIRI = "http://www.EcoInvent.org/EcoSpold02/intermediateExchange/";

    //Activity
    public static String activity = "ecometa:TActivity";
    public static String specialActivityType = "ecobase:specialActivityType";
    public static String id = "ecometa:id";
    public static String activityNameId = "ecometa:activityNameId";
    public static String inheritanceDepth = "ecometa:inheritanceDepth";
    public static String type = "ecobase:type";
    public static String energyValues = "ecometa:energyValues";
    public static String activityName = "ecometa:activityName";
    public static String synonym = "ecometa:synonym";
    public static String includedActivitiesStart = "ecometa:includedActivitiesStart";
    public static String includedActivitiesEnd = "ecometa:includedActivitiesEnd";
    public static String generalComment = "ecometa:generalComment";

    //Classification
    public static String classification = "ecotype:TClassification";
    public static String classificationId = "ecotype:classificationId";
    public static String classificationSystem = "ecotype:classificationSystem";
    public static String classificationValue = "ecotype:classificationValue";

    //Geography
    public static String geography = "ecometa:TGeography";
    public static String geographyId = "ecometa:geographyId";
    public static String geographyShortName = "ecometa:shortName";
    public static String geographyComment = "ecometa:comment";

    //Technology
    public static String technology = "ecoact:TTechnology";
    public static String technologyLevel = "ecobase:technologyLevel";
    public static String technologyComment = "ecometa:comment";

    //TimePeriod
    public static String timePeriod = "ecobase:TTimePeriod";
    public static String startDate = "ecometa:startDate";
    public static String endDate = "ecometa:endDate";
    public static String isDataValidForEntirePeriod = "ecometa:isDataValidForEntirePeriod";

    //MacroEconomicScenario
    public static String macroEconomicScenario = "ecometa:TMacroEconomicScenario";
    public static String macroEconomicScenarioId = "ecometa:macroEconomicScenarioId";
    public static String macroEconomicScenarioName = "ecoflow:name";

    //IntermediateExchange Attributes
    public static String intermediateExchange = "ecoflow:TIntermediateExchange";
    public static String exchangeId = "ecometa:id";
    public static String exchangeUnitID = "ecoflow:exchangeUnitId";
    public static String exchangeVariableName = "ecoflow:variableName";
    public static String exchangeCasNumber = "ecoflow:casNumber";
    public static String exchangeAmount = "ecoflow:amount";
    public static String intermediateExchangeId = "ecoflow:exchangeId";
    public static String exchangeProductionVolumeAmount = "ecoflow:productionVolumeAmount";
    public static String exchangeProductionVolumeVariableName = "ecoflow:productionVolumeVariableName";
    public static String exchangeProductionVolumeMathematicalRelation = "ecoflow:productionVolumeMathematicalRelation";

    //IntermediateExchange Elements
    public static String exchangeName = "ecoflow:name";
    public static String exchangeUnitName = "ecoflow:unitName";
    public static String exchangeProductionVolumeComment = "ecoflow:productionVolumeComment";
    public static String exchangeOutputGroup = "ecoflow:outputGroup";
    public static String exchangeProperty = "ecoflow:property";

    //IntermediateExchange ProductionUncertainty
    public static String uncertainty = "ecotype:uncertainty";
    public static String meanValue = "ecotype:meanValue";
    public static String mu = "ecotype:mu";
    public static String variance = "ecotype:variance";
    public static String varianceWithPedigreeUncertainty = "ecotype:varianceWithPedigreeUncertainty";
    public static String reliability = "ecotype:reliability";
    public static String completeness = "ecotype:completeness";
    public static String temporalCorrelation = "ecotype:temporalCorrelation";
    public static String geographicalCorrelation = "ecotype:geographicalCorrelation";
    public static String furtherTechnologyCorrelation = "ecotype:furtherTechnologyCorrelation";
    public static String uncertaintyComment = "ecometa:comment";

    //Property
    public static String property = "ecometa:property";
    public static String propertyId = "ecotype:propertyId";
    public static String propertyAmount = "ecoflow:amount";
    public static String propertyIsDefiningValue = "ecotype:isDefiningValue";
    public static String propertyUnitId = "ecoflow:unitId";
    public static String propertyName = "ecoflow:name";
    public static String propertyUnitName = "ecoflow:unitName";
    public static String propertyComment = "ecometa:comment";

    //Data entry by
    public static String dataEntryBy = "ecometa:TDataEntryBy";
    public static String dataEntryByPersonId = "ecometa:personId";
    public static String dataEntryByIsActiveAuthor = "ecometa:isActiveAuthor";
    public static String dataEntryByPersonName = "ecometa:personName";
    public static String dataEntryByPersonEmail = "ecometa:personEmail";

    //Data generation and publication
    public static String dataGeneratorAndPublication = "ecometa:TDataGeneratorAndPublication";
    public static String dataGeneratorAndPublicationPersonId = "ecometa:personId";
    public static String dataGeneratorAndPublicationPersonName = "ecometa:personName";
    public static String dataGeneratorAndPublicationPersonEmail = "ecometa:personEmail";
    public static String dataGeneratorAndPublicationDataPublishedIn = "ecometa:dataPublishedIn";
    public static String dataGeneratorAndPublicationPublishedSourceId = "ecometa:publishedSourceId";
    public static String dataGeneratorAndPublicationPublishedSourceYear = "ecometa:publishedSourceYear";
    public static String dataGeneratorAndPublicationPublishedSourceFirstAuthor = "ecometa:publishedSourceFirstAuthor";
    public static String dataGeneratorAndPublicationIsCopyrightProtected = "ecometa:isCopyrightProtected";
    public static String dataGeneratorAndPublicationAccessRestrictedTo = "ecometa:accessRestrictedTo";
    public static String dataGeneratorAndPublicationCompanyIdOverwrittenByChild = "ecometa:companyIdOverwrittenByChild";

    //File attributes
    public static String fileAttributes = "ecometa:TFileAttributes";
    public static String majorRelease = "ecodata:majorRelease";
    public static String minorRelease = "ecodata:minorRelease";
    public static String majorRevision = "ecodata:majorRevision";
    public static String minorRevision = "ecodata:minorRevision";
    public static String internalSchemaVersion = "ecometa:internalSchemaVersion";
    public static String defaultLanguage = "ecometa:defaultLanguage";
    public static String creationTimestamp = "ecometa:creationTimestamp";
    public static String lastEditTimestamp = "ecometa:lastEditTimestamp";
    public static String fileGenerator = "ecometa:fileGenerator";
    public static String fileTimestamp = "ecometa:fileTimestamp";
    public static String contextId = "ecometa:contextId";

    //Review
    public static String review = "ecometa:TReview";
    public static String majorReleaseReview = "ecometa:majorRelease";
    public static String minorReleaseReview = "ecometa:minorRelease";
    public static String majorRevisionReview = "ecometa:majorRevision";
    public static String minorRevisionReview = "ecometa:minorRevision";
    public static String reviewerId = "ecometa:reviewerId";
    public static String reviewerName = "ecometa:reviewerName";
    public static String reviewerEmail = "ecometa:reviewerEmail";
    public static String reviewDate = "ecometa:reviewDate";

    //Representativeness
    public static String representativeness = "ecometa:TRepresentativeness";
    public static String systemModelId = "ecometa:systemModelId";
    public static String systemModelName = "ecometa:systemModelName";
    public static String samplingProcedure = "ecometa:samplingProcedure";
    public static String extrapolations = "ecometa:extrapolations";

    //Connect individuals
    public static String classificationIndividual = "ecobase:classification";
    public static String geographyIndividual = "ecoact:geography";
    public static String macroEconomicScenarioIndividual = "ecoact:macroEconomicScenario";
    public static String timePeriodIndividual = "ecobase:timePeriod";
    public static String technologyIndividual = "ecoact:technology";
    public static String representativenessIndividual = "ecoact:representativeness";
    public static String dataEntryByIndividual = "ecobase:dataEntryBy";
    public static String dataGeneratorAndPublicationIndividual = "ecoact:dataGeneratorAndPublication";
    public static String fileAttributesIndividual = "ecoact:fileAttributes";
    public static String reviewIndividual = "ecoact:review";
    public static String customExchangeIndividual = "ecobase:customExchange";

    //Connect properties with IntermediateExchange
    public static String propertyExchangeIndividual = "ecoflow:property";
    public static String classificationExchangeIndividual = "ecoflow:classification";

}
