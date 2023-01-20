package ch.unisg.ics.interactions.wiser.queries.ecoSpold;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.Representativeness;
import ch.unisg.ics.interactions.wiser.tools.VocabularyEcoSpold;

public class RepresentativenessQueryBuilder {

    private Representativeness representativeness;
    private String activityIdEcoSpold;

    public RepresentativenessQueryBuilder(Representativeness representativeness, String activityIdEcoSpold) {
        this.representativeness = representativeness;
        this.activityIdEcoSpold = activityIdEcoSpold;
    }

    public String createRepresentativenessInsertionQuery() {

        String query =
                "PREFIX " + VocabularyEcoSpold.ecoSpoldMetaInformationPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?representativeness a " + VocabularyEcoSpold.representativeness + ";\n" +
                        VocabularyEcoSpold.systemModelId + " \"" + representativeness.getSystemModelId() + "\";\n" +
                        VocabularyEcoSpold.systemModelName + " \"" + representativeness.getSystemModelName() + "\";\n" +
                        VocabularyEcoSpold.samplingProcedure + " \"" + representativeness.getSamplingProcedure() + "\";\n" +
                        VocabularyEcoSpold.extrapolations + " \"" + representativeness.getExtrapolations() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI(" + VocabularyEcoSpold.representativenessIRI + activityIdEcoSpold + "') AS ?representativeness)" + "\n" +
                        "}";

        return query;

    }
    
}
