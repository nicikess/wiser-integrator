package ch.unisg.ics.interactions.wiser.queries.ecoSpold;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.ProductionVolumeUncertainty;
import ch.unisg.ics.interactions.wiser.tools.VocabularyEcoSpold;

public class UncertaintyQueryBuilder {

    private ProductionVolumeUncertainty productionVolumeUncertainty;
    private String identifier;

    public UncertaintyQueryBuilder(ProductionVolumeUncertainty productionVolumeUncertainty, String activityIdEcoSpold) {
        this.productionVolumeUncertainty = productionVolumeUncertainty;
        this.identifier = VocabularyEcoSpold.uncertaintyIRI + activityIdEcoSpold;
    }

    public String createProductionVolumeUncertaintyInsertionQuery() {

        String query =
                "PREFIX " + VocabularyEcoSpold.ecoSpoldTypesPrefix + "\n" +
                "PREFIX " + VocabularyEcoSpold.ecoSpoldMetaInformationPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?productionVolumeUncertainty a " + VocabularyEcoSpold.uncertainty + ";\n" +
                        VocabularyEcoSpold.meanValue + " " + productionVolumeUncertainty.getLognormal().getMeanValue() + ";\n" +
                        VocabularyEcoSpold.mu + " " + productionVolumeUncertainty.getLognormal().getMu() + ";\n" +
                        VocabularyEcoSpold.variance + " " + productionVolumeUncertainty.getLognormal().getVariance()+ ";\n" +
                        VocabularyEcoSpold.varianceWithPedigreeUncertainty + " " + productionVolumeUncertainty.getLognormal().getVarianceWithPedigreeUncertainty() + ";\n" +
                        VocabularyEcoSpold.reliability + " " + productionVolumeUncertainty.getPedigreeMatrix().getReliability() + ";\n" +
                        VocabularyEcoSpold.completeness + " " + productionVolumeUncertainty.getPedigreeMatrix().getCompleteness() + ";\n" +
                        VocabularyEcoSpold.temporalCorrelation + " " + productionVolumeUncertainty.getPedigreeMatrix().getTemporalCorrelation() + ";\n" +
                        VocabularyEcoSpold.geographicalCorrelation + " " + productionVolumeUncertainty.getPedigreeMatrix().getGeographicalCorrelation() + ";\n" +
                        VocabularyEcoSpold.furtherTechnologyCorrelation + " " + productionVolumeUncertainty.getPedigreeMatrix().getFurtherTechnologyCorrelation() + ";\n" +
                        VocabularyEcoSpold.uncertaintyComment + " \"" + productionVolumeUncertainty.getComment() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI('" + identifier + "') AS ?productionVolumeUncertainty)" + "\n" +
                        "}";

        return query;

    }

    public String getIdentifier() {
        return identifier;
    }
    
}
