package ch.unisg.ics.interactions.wiser.tests.units;

import ch.unisg.ics.interactions.wiser.WiserIntegrator;
import ch.unisg.ics.interactions.wiser.data.ecoSpold.EcoSpold;
import ch.unisg.ics.interactions.wiser.data.ilcd.ProcessDataSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.bind.UnmarshalException;


public class UnmarshallingTest {

    String ILCDTestFileName = "ilcd-file.xml";
    String EcoSpoldTestFileName = "ecospold-file.xml";

    WiserIntegrator integrator = new WiserIntegrator();

    EcoSpold ecoSpold = integrator.unmarshalEcoSpold(EcoSpoldTestFileName);
    ProcessDataSet ilcd = integrator.unmarshalILCD(ILCDTestFileName);

    @Test
    void correctUnmarshallingOfActivity() throws UnmarshalException {

        Assertions.assertEquals("9d3d1721-a5a6-4e5e-a11b-4a62847bdf5", ecoSpold.getActivityDataset().getActivityDescription().getActivity().getId());
        Assertions.assertEquals("Electricity Mix, consumption mix, at consumer, AC, 230V", ilcd.getProcessInformation().getDataSetInformation().getName().getBaseName());

    }

    @Test
    void correctUnmarshallingOfClassification() throws UnmarshalException {

        Assertions.assertEquals("EcoSpold01Categories", ecoSpold.getActivityDataset().getActivityDescription().getClassification().get(0).getclassificationSystem());
        Assertions.assertEquals("Energy carriers and technologies", ilcd.getProcessInformation().getDataSetInformation().getClassificationInformation().getClassification().getClassInfo().get(0));

    }

    @Test
    void correctUnmarshallingOfGeography() throws UnmarshalException {

        Assertions.assertEquals("IAI Area, Asia, without China and GCC", ecoSpold.getActivityDataset().getActivityDescription().getGeography().getShortname());
        Assertions.assertEquals("CH", ilcd.getProcessInformation().getGeography().getLocationOfOperationSupplyOrProduction().getLocation());

    }

    @Test
    void correctUnmarshallingOfTime() throws UnmarshalException {

        Assertions.assertEquals("2015-12-31", ecoSpold.getActivityDataset().getActivityDescription().getTimePeriod().getEndDate());
        Assertions.assertEquals("2010", ilcd.getProcessInformation().getTime().getDataSetValidUntil());

    }

    @Test
    void correctUnmarshallingOfExchanges() throws UnmarshalException {

        Assertions.assertEquals("1344-28-1", ecoSpold.getActivityDataset().getFlowData().getIntermediateExchange().get(0).getCasNumber());
        Assertions.assertEquals("82", ilcd.getExchanges().getExchange().get(0).getDataSetInternalID());

    }

    @Test
    void correctUnmarshallingOfProperties() throws UnmarshalException {

        Assertions.assertEquals("false", ecoSpold.getActivityDataset().getFlowData().getIntermediateExchange().get(0).getProperty().get(0).getIsDefiningValue());
        Assertions.assertEquals("a6ad3fc7-c019-454f-a899-43be7913a598", ilcd.getExchanges().getExchange().get(0).getReferenceToFlowDataSet().getRefObjectId());

    }

}
