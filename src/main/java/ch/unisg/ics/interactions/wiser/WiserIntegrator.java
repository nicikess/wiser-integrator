package ch.unisg.ics.interactions.wiser;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.EcoSpold;
import ch.unisg.ics.interactions.wiser.data.ilcd.ProcessDataSet;
import ch.unisg.ics.interactions.wiser.filter.XMLReaderWithoutNamespace;
import ch.unisg.ics.interactions.wiser.integrator.InsertEcoSpoldData;
import ch.unisg.ics.interactions.wiser.integrator.InsertILCDData;
import ch.unisg.ics.interactions.wiser.queries.ConnectIndividualsQuery;
import ch.unisg.ics.interactions.wiser.tools.GraphDBInterface;

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

    public static void main(String [] args) {

        String ILCDTestFileName = "ilcd-file.xml";
        String EcoSpoldTestFileName = "ecospold-file.xml";

        WiserIntegrator integrator = new WiserIntegrator();

        EcoSpold ecoSpold = integrator.unmarshalEcoSpold(EcoSpoldTestFileName);
        ProcessDataSet ilcd = integrator.unmarshalILCD(ILCDTestFileName);

        new InsertEcoSpoldData(ecoSpold);
        new InsertILCDData(ilcd);

    }

    public ProcessDataSet unmarshalILCD(String fileName) {

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

    public EcoSpold unmarshalEcoSpold(String fileName) {

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

    public static void insertDataToGraphDB(String query) {

        GraphDBInterface graphDBInterface = new GraphDBInterface();
        try {
            graphDBInterface.queryEndpoint(query);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void connectIndividuals(String identifierOne, String objectProperty, String identifierTwo) {
        String statement = new ConnectIndividualsQuery(identifierOne, objectProperty, identifierTwo).getConnectorStatement();
        insertDataToGraphDB(statement);
    }

}
