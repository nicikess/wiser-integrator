package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.Review;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class ReviewQueryBuilder {

    private Review review;
    private String activityIdILCD;

    public ReviewQueryBuilder(Review review, String activityIdILCD) {
        this.review = review;
        this.activityIdILCD = activityIdILCD;
    }

    public String createReviewInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdProcessPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdDatatypesPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?review a " + VocabularyILCD.review + ";\n" +
                        VocabularyILCD.reviewType + " \"" + review.getType() + "\";\n" +
                        VocabularyILCD.reviewDetails + " \"" + review.getReviewDetails() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI(" + VocabularyILCD.reviewIRI + activityIdILCD + "') AS ?review)" + "\n" +
                        "}";

        return query;

    }


}