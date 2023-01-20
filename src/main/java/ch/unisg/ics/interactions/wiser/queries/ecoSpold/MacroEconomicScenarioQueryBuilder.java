package ch.unisg.ics.interactions.wiser.queries.ecoSpold;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.MacroEconomicScenario;
import ch.unisg.ics.interactions.wiser.tools.VocabularyEcoSpold;

public class MacroEconomicScenarioQueryBuilder {

    private MacroEconomicScenario macroEconomicScenario;
    private String activityIdEcoSpold;

    public MacroEconomicScenarioQueryBuilder(MacroEconomicScenario macroEconomicScenario, String activityIdEcoSpold) {
        this.macroEconomicScenario = macroEconomicScenario;
        this.activityIdEcoSpold = activityIdEcoSpold;
    }

    public String createMacroEconomicScenarioInsertionQuery() {

        String query =
                "PREFIX " + VocabularyEcoSpold.ecoSpoldMetaInformationPrefix + "\n" +
                "PREFIX " + VocabularyEcoSpold.ecoSpoldFlowdataPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?macroEconomicScenario a " + VocabularyEcoSpold.macroEconomicScenario + ";\n" +
                        VocabularyEcoSpold.macroEconomicScenarioId + " \"" + macroEconomicScenario.getMacroEconomicScenarioId() + "\";\n" +
                        VocabularyEcoSpold.macroEconomicScenarioName + " \"" + macroEconomicScenario.getName() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI(" + VocabularyEcoSpold.macroEconomicScenarioIRI + activityIdEcoSpold + "') AS ?macroEconomicScenario)" + "\n" +
                        "}";

        return query;

    }


}