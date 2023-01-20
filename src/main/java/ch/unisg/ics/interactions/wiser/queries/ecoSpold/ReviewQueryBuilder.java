package ch.unisg.ics.interactions.wiser.queries.ecoSpold;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.Review;
import ch.unisg.ics.interactions.wiser.tools.VocabularyEcoSpold;

public class ReviewQueryBuilder {

    private Review review;
    private String activityIdEcoSpold;

    public ReviewQueryBuilder(Review review, String activityIdEcoSpold) {
        this.review = review;
        this.activityIdEcoSpold = activityIdEcoSpold;
    }

    public String createReviewInsertionQuery() {

        String query =
                "PREFIX " + VocabularyEcoSpold.ecoSpoldTypesPrefix + "\n" +
                "PREFIX " + VocabularyEcoSpold.bridgingOntologyPrefix + "\n" +
                "PREFIX " + VocabularyEcoSpold.ecoSpoldSourcePrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?review a " + VocabularyEcoSpold.review + ";\n" +
                        VocabularyEcoSpold.majorReleaseReview + " \"" + review.getReviewedMajorRelease() + ";\n" +
                        VocabularyEcoSpold.minorReleaseReview + " \"" + review.getReviewedMinorRelease() + "\";\n" +
                        VocabularyEcoSpold.majorRevisionReview + " \"" + review.getReviewedMajorRevision() + "\";\n" +
                        VocabularyEcoSpold.minorRevisionReview + " \"" + review.getReviewedMinorRevision() + "\";\n" +
                        VocabularyEcoSpold.reviewerId + " \"" + review.getReviewerId() + "\";\n" +
                        VocabularyEcoSpold.reviewerName + " \"" + review.getReviewerName() + "\";\n" +
                        VocabularyEcoSpold.reviewerEmail + " \"" + review.getReviewerEmail() + "\";\n" +
                        VocabularyEcoSpold.reviewDate + " \"" + review.getReviewDate() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI(" + VocabularyEcoSpold.reviewIRI + activityIdEcoSpold + "') AS ?review)" + "\n" +
                        "}";

        return query;

    }
    
}
