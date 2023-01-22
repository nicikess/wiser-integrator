package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.CommissionerAndGoal;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class CommissionerAndGoalQueryBuilder {

    private CommissionerAndGoal commissionerAndGoal;
    private String identifier;

    public CommissionerAndGoalQueryBuilder(CommissionerAndGoal commissionerAndGoal, String activityIdILCD) {
        this.commissionerAndGoal = commissionerAndGoal;
        this.identifier = VocabularyILCD.datasetCommissionerAndGoalIRI + activityIdILCD;
    }

    public String createCommissionerAndGoalInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?commissionerAndGoal a " + VocabularyILCD.commissionerAndGoalType + ";\n" +
                        VocabularyILCD.intendedApplications + " \"" + commissionerAndGoal.getIntendedApplications() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI('" + identifier + "') AS ?commissionerAndGoal)" + "\n" +
                        "}";

        return query;

    }

    public String getIdentifier() {
        return identifier;
    }
}