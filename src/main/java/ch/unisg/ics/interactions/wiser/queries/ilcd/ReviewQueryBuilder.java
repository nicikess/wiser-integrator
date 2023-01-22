package ch.unisg.ics.interactions.wiser.queries.ilcd;

import ch.unisg.ics.interactions.wiser.data.ilcd.Review;
import ch.unisg.ics.interactions.wiser.tools.VocabularyILCD;

public class ReviewQueryBuilder {

    private Review review;
    private String identifier;

    public ReviewQueryBuilder(Review review, String activityIdILCD) {
        this.review = review;
        this.identifier = VocabularyILCD.reviewIRI + activityIdILCD;
    }

    public String createReviewInsertionQuery() {

        String query =
                "PREFIX " + VocabularyILCD.ilcdProcessPrefix + "\n" +
                "PREFIX " + VocabularyILCD.ilcdCommonGroupsPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?review a " + VocabularyILCD.review + ";\n" +
                        VocabularyILCD.reviewType + " \"" + review.getType() + "\";\n" +
                        VocabularyILCD.reviewDetails + " \"" + review.getReviewDetails() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI('" + identifier + "') AS ?review)" + "\n" +
                        "}";

        return query;

    }

    public String getIdentifier() {
        return identifier;
    }


}