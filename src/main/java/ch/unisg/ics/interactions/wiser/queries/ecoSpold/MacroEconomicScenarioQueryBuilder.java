package ch.unisg.ics.interactions.wiser.queries.ecoSpold;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.MacroEconomicScenario;
import ch.unisg.ics.interactions.wiser.tools.VocabularyEcoSpold;

public class MacroEconomicScenarioQueryBuilder {

    private MacroEconomicScenario macroEconomicScenario;
    private String identifier;

    public MacroEconomicScenarioQueryBuilder(MacroEconomicScenario macroEconomicScenario, String activityIdEcoSpold) {
        this.macroEconomicScenario = macroEconomicScenario;
        this.identifier = VocabularyEcoSpold.macroEconomicScenarioIRI + activityIdEcoSpold;
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
                        "BIND(IRI('" + identifier + "') AS ?macroEconomicScenario)" + "\n" +
                        "}";

        return query;

    }

    public String getIdentifier() {
        return identifier;
    }


}