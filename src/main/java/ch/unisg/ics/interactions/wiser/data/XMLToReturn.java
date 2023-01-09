package ch.unisg.ics.interactions.wiser.data;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.EcoSpold;
import ch.unisg.ics.interactions.wiser.data.ilcd.ProcessDataSet;

public class XMLToReturn {

    EcoSpold ecoSpold;
    ProcessDataSet processDataSet;

    public void setEcoSpold(EcoSpold ecoSpold) {
        this.ecoSpold = ecoSpold;
    }

    public void setProcessDataSet(ProcessDataSet processDataSet) {
        this.processDataSet = processDataSet;
    }

    public EcoSpold getEcoSpold() {
        return ecoSpold;
    }

    public ProcessDataSet getProcessDataSet() {
        return processDataSet;
    }
}
