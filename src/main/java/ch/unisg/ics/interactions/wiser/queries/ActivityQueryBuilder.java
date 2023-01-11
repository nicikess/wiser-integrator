package ch.unisg.ics.interactions.wiser.queries;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.Activity;
import ch.unisg.ics.interactions.wiser.tools.VocabularyEcoSpold;

public class ActivityQueryBuilder {

    private Activity activity;

    public ActivityQueryBuilder(Activity activity) {
        this.activity = activity;
    }

    public String createActivityInsertionQuery() {

        String query =
                "PREFIX " + VocabularyEcoSpold.ecoSpoldDataMetaInformationPrefix + "\n" +
                "PREFIX " + VocabularyEcoSpold.ecoSpoldDataBasePrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?activity a " + VocabularyEcoSpold.activity + ";\n" +
                        VocabularyEcoSpold.specialActivityType + " " + activity.getSpecialActivityType() + ";\n" +
                        VocabularyEcoSpold.id + " \"" + activity.getId() + "\";\n" +
                        VocabularyEcoSpold.activityNameId + " \"" + activity.getActivityNameId() + "\";\n" +
                        VocabularyEcoSpold.inheritanceDepth + " " + activity.getInheritanceDepth() + ";\n" +
                        VocabularyEcoSpold.type + " " + activity.getType() + ";\n" +
                        VocabularyEcoSpold.energyValues + " " + activity.getEnergyValues() + ";\n" +
                        VocabularyEcoSpold.activityName + " \"" + activity.getActivityName() + "\";\n" +
                        activitySynonyms() +
                        VocabularyEcoSpold.includedActivitiesStart + " \"" + activity.getIncludedActivitiesStart() + "\";\n" +
                        VocabularyEcoSpold.includedActivitiesEnd + " \"" + activity.getIncludedActivitiesEnd() + "\";\n" +
                        VocabularyEcoSpold.generalComment + " " + activityComment() + ".\n" +
                        "} where {" + "\n" +
                        "BIND(IRI(" + VocabularyEcoSpold.activityIRI + activity.getId() + "') AS ?activity)" + "\n" +
                        "}";

        return query;

    }

    public String activitySynonyms() {

        String synonyms = "";

        for (int i = 0; i < activity.getSynonyms().size(); i++) {
            synonyms += VocabularyEcoSpold.synonym + " \"" + activity.getSynonyms().get(i) + "\";\n";
        }

        return synonyms;

    }

    public String activityComment() {

        String comment = "\"";

        for (int i = 0; i < activity.getComment().size(); i++) {
            comment += activity.getComment().get(0).getText().get(i) + " ";
        }

        comment += "\"";

        return comment;

    }

}
