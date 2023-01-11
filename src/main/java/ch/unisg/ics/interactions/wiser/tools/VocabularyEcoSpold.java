package ch.unisg.ics.interactions.wiser.tools;

public class VocabularyEcoSpold{

    //Prefix
    public static String bridgingOntologyPrefix = "<http://wiser-flagship.org/>";
    public static String ecoSpoldDataBasePrefix = "ecobase: <http://www.EcoInvent.org/EcoSpold02/base#>";
    public static String ecoSpoldDataTypesPrefix = "ecotype: <http://www.EcoInvent.org/EcoSpold02/dataTypes#>";
    public static String ecoSpoldDataMetaInformationPrefix = "ecometa: <http://www.EcoInvent.org/EcoSpold02/metainformation#>";
    public static String ecoSpoldDataSourcePrefix = "ecosource: <http://www.EcoInvent.org/EcoSpold02/source#>";
    public static String ecoSpoldDataActivityPrefix = "ecoact: <http://www.EcoInvent.org/EcoSpold02/activity#>";


    //IRI
    public static String activityIRI = "'http://www.EcoInvent.org/EcoSpold02/activity/";
    public static String classificationIRI = "http://www.EcoInvent.org/EcoSpold02/classification/";
    public static String geographyIRI = "http://www.EcoInvent.org/EcoSpold02/geography/";
    public static String technologyIRI = "http://www.EcoInvent.org/EcoSpold02/technology/";

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

}
