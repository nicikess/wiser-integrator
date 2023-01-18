package ch.unisg.ics.interactions.wiser.tools;

public class VocabularyEcoSpold{

    //Prefix
    public static String bridgingOntologyPrefix = "<http://wiser-flagship.org/>";
    public static String ecoSpoldBasePrefix = "ecobase: <http://www.EcoInvent.org/EcoSpold02/base#>";
    public static String ecoSpoldTypesPrefix = "ecotype: <http://www.EcoInvent.org/EcoSpold02/dataTypes#>";
    public static String ecoSpoldMetaInformationPrefix = "ecometa: <http://www.EcoInvent.org/EcoSpold02/metainformation#>";
    public static String ecoSpoldSourcePrefix = "ecosource: <http://www.EcoInvent.org/EcoSpold02/source#>";
    public static String ecoSpoldActivityPrefix = "ecoact: <http://www.EcoInvent.org/EcoSpold02/activity#>";
    public static String ecoSpoldFlowdataPrefix = "ecoflow: <http://www.EcoInvent.org/EcoSpold02/flowdata#>";

    //IRI
    public static String activityIRI = "'http://www.EcoInvent.org/EcoSpold02/activity/";
    public static String classificationIRI = "'http://www.EcoInvent.org/EcoSpold02/classification/";
    public static String geographyIRI = "'http://www.EcoInvent.org/EcoSpold02/geography/";
    public static String technologyIRI = "'http://www.EcoInvent.org/EcoSpold02/technology/";
    public static String timePeriodIRI = "'http://www.EcoInvent.org/EcoSpold02/timePeriod/";
    public static String macroEconomicScenarioIRI = "'http://www.EcoInvent.org/EcoSpold02/macroEconomicScenario/";

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

    //IntermediateExchange ProductionUncertainty
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
    public static String propertyId = "ecotype:propertyId";
    public static String propertyAmount = "ecoflow:amount";
    public static String propertyIsDefiningValue = "ecotype:isDefiningValue";
    public static String propertyUnitId = "ecoflow:unitId";
    public static String propertyName = "ecoflow:name";
    public static String propertyUnitName = "ecoflow:unitName";
    public static String propertyComment = "ecometa:comment";




}
