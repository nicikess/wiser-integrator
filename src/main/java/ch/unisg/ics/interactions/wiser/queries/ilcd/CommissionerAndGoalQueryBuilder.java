package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.CommissionerAndGoal;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class CommissionerAndGoalQueryBuilder {

    private CommissionerAndGoal commissionerAndGoal;
    private String activityIdILCD;

    public CommissionerAndGoalQueryBuilder(CommissionerAndGoal commissionerAndGoal, String activityIdILCD) {
        this.commissionerAndGoal = commissionerAndGoal;
        this.activityIdILCD = activityIdILCD;
    }

    public String createCommissionerAndGoalInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?commissionerAndGoal a " + VocabularyILCD.commissionerAndGoalType + ";\n" +
                        VocabularyILCD.intendedApplications + " \"" + commissionerAndGoal.getIntendedApplications() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI(" + VocabularyILCD.datasetCommissionerAndGoalIRI + activityIdILCD + "') AS ?commissionerAndGoal)" + "\n" +
                        "}";

        return query;

    }


}