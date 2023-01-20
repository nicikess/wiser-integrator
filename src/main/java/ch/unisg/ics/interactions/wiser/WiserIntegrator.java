package ch.unisg.ics.interactions.wiser;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.Activity;
import ch.unisg.ics.interactions.wiser.data.ecoSpold.EcoSpold;
import ch.unisg.ics.interactions.wiser.data.ecoSpold.FileAttributes;
import ch.unisg.ics.interactions.wiser.data.ilcd.ProcessDataSet;
import ch.unisg.ics.interactions.wiser.data.ilcd.ReferenceToDataSource;
import ch.unisg.ics.interactions.wiser.filter.XMLReaderWithoutNamespace;
import ch.unisg.ics.interactions.wiser.queries.ecoSpold.*;
import ch.unisg.ics.interactions.wiser.queries.ecoSpold.DataEntryByQueryBuilder;
import ch.unisg.ics.interactions.wiser.queries.ecoSpold.GeographyQueryBuilder;
import ch.unisg.ics.interactions.wiser.queries.ecoSpold.ReviewQueryBuilder;
import ch.unisg.ics.interactions.wiser.queries.ecoSpold.TechnologyQueryBuilder;
import ch.unisg.ics.interactions.wiser.queries.ilcd.*;
import ch.unisg.ics.interactions.wiser.tools.GraphDBInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

public class WiserIntegrator {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    public static void main(String [] args) {

        String ILCDTestFileName = "ilcd-test.xml";
        String EcoSpoldTestFileName = "ecospold-test.xml";

        WiserIntegrator integrator = new WiserIntegrator();

        EcoSpold ecoSpold = integrator.unmarshalEcoSpold(EcoSpoldTestFileName);
        ProcessDataSet ilcd = integrator.unmarshalILCD(ILCDTestFileName);

        String activity = new UncertaintyQueryBuilder(ecoSpold.getActivityDataset().getFlowData().getIntermediateExchange().get(0).getProductionVolumeUncertainty(), "100").createProductionVolumeUncertaintyInsertionQuery();
        System.out.println(activity);

        //Link EcoSpold
        //Link ILCD

        try {
            //graphDBInterface.queryEndpoint(query);
        } catch (Exception e) {
            //e.printStackTrace();
        }

    }

    private ProcessDataSet unmarshalILCD(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        ProcessDataSet processDataSet = new ProcessDataSet();

        try {

            //read stream
            InputStream is = new FileInputStream(resource.getFile());
            XMLStreamReader xsr = XMLInputFactory.newFactory().createXMLStreamReader(is);
            XMLReaderWithoutNamespace xr = new XMLReaderWithoutNamespace(xsr);

            //xr.nextTag();
            while(xr.hasNext()) {
                if(xr.isStartElement() && xr.getLocalName().equals("processDataSet")) {
                    break;
                }
                xr.next();
            }

            //unmarshal
            JAXBContext jaxbContext = JAXBContext.newInstance(ProcessDataSet.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            processDataSet = (ProcessDataSet) jaxbUnmarshaller.unmarshal(xr);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return processDataSet;

    }

    private EcoSpold unmarshalEcoSpold(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        EcoSpold ecoSpold = new EcoSpold();

        try {

            //read stream
            InputStream is = new FileInputStream(resource.getFile());
            XMLStreamReader xsr = XMLInputFactory.newFactory().createXMLStreamReader(is);
            XMLReaderWithoutNamespace xr = new XMLReaderWithoutNamespace(xsr);

            //xr.nextTag();
            while(xr.hasNext()) {
                if(xr.isStartElement() && xr.getLocalName().equals("ecoSpold")) {
                    break;
                }
                xr.next();
            }

            //unmarshal
            JAXBContext jaxbContext = JAXBContext.newInstance(EcoSpold.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            ecoSpold = (EcoSpold) jaxbUnmarshaller.unmarshal(xr);


        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return ecoSpold;

    }

}
