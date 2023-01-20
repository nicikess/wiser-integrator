package ch.unisg.ics.interactions.wiser.queries.ecoSpold;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.Activity;
import ch.unisg.ics.interactions.wiser.tools.VocabularyEcoSpold;

public class ActivityQueryBuilder {

    private Activity activity;
    private String identifier;

    public ActivityQueryBuilder(Activity activity) {
        this.activity = activity;
        this.identifier = VocabularyEcoSpold.activityIRI + activity.getId();
    }

    public String createActivityInsertionQuery() {

        String query =
                "PREFIX " + VocabularyEcoSpold.ecoSpoldMetaInformationPrefix + "\n" +
                "PREFIX " + VocabularyEcoSpold.ecoSpoldBasePrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?activity a " + VocabularyEcoSpold.activity + ";\n" +
                        VocabularyEcoSpold.specialActivityType + " " + activity.getSpecialActivityType() + ";\n" +
                        VocabularyEcoSpold.id + " \"" + "testID" + "\";\n" +
                        VocabularyEcoSpold.activityNameId + " \"" + activity.getActivityNameId() + "\";\n" +
                        VocabularyEcoSpold.inheritanceDepth + " " + activity.getInheritanceDepth() + ";\n" +
                        VocabularyEcoSpold.type + " " + activity.getType() + ";\n" +
                        VocabularyEcoSpold.energyValues + " " + activity.getEnergyValues() + ";\n" +
                        VocabularyEcoSpold.activityName + " \"" + activity.getActivityName() + "\";\n" +
                        addSynonymsToQueryString() +
                        VocabularyEcoSpold.includedActivitiesStart + " \"" + activity.getIncludedActivitiesStart() + "\";\n" +
                        VocabularyEcoSpold.includedActivitiesEnd + " \"" + activity.getIncludedActivitiesEnd() + "\";\n" +
                        VocabularyEcoSpold.generalComment + " " + addCommentsToQueryString() + ".\n" +
                        "} where {" + "\n" +
                        "BIND(IRI('" + identifier + "') AS ?activity)" + "\n" +
                        "}";

        return query;

    }

    public String addSynonymsToQueryString() {

        String synonyms = "";

        for (int i = 0; i < activity.getSynonyms().size(); i++) {
            synonyms += VocabularyEcoSpold.synonym + " \"" + activity.getSynonyms().get(i) + "\";\n";
        }

        return synonyms;

    }

    public String addCommentsToQueryString() {

        String comment = "\"";

        for (int i = 0; i < activity.getComment().size(); i++) {
            comment += activity.getComment().get(0).getText().get(i) + " ";
        }

        comment += "\"";

        return comment;

    }

    public String getIdentifier() {
        return identifier;
    }
}
