package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.LCIMethodAndAllocation;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class LCAMethodAndValidationQueryBuilder {

    private LCIMethodAndAllocation LCIMethodAndAllocation;
    private String activityIdILCD;

    public LCAMethodAndValidationQueryBuilder(LCIMethodAndAllocation LCIMethodAndAllocation, String activityIdILCD) {
        this.LCIMethodAndAllocation = LCIMethodAndAllocation;
        this.activityIdILCD = activityIdILCD;
    }

    public String createLCIMethodAndAllocationInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdProcessPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?LCIMethodAndAllocation a " + VocabularyILCD.lciMethodAndAllocationType + ";\n" +
                        VocabularyILCD.lciTypeOfDataSet + " \"" + LCIMethodAndAllocation.getTypeOfDataSet() + "\";\n" +
                        VocabularyILCD.lciMethodPrinciple + " \"" + LCIMethodAndAllocation.getLCIMethodPrinciple() + "\";\n" +
                        VocabularyILCD.lciDeviationsFromLCIMethodPrinciple + " \"" + LCIMethodAndAllocation.getDeviationsFromLCIMethodPrinciple() + "\";\n" +
                        VocabularyILCD.lciMethodApproaches + " \"" + LCIMethodAndAllocation.getLCIMethodApproaches() + "\";\n" +
                        VocabularyILCD.lciModellingConstants + " \"" + LCIMethodAndAllocation.getModellingConstants() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI(" + VocabularyILCD.lciIRI + activityIdILCD + "') AS ?LCIMethodAndAllocation)" + "\n" +
                        "}";

        return query;

    }


}