package ch.unisg.ics.interactions.wiser.tests.units;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.*;
import ch.unisg.ics.interactions.wiser.filter.XMLReaderWithoutNamespace;

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

public class UnmarshalILCD {

    static String ILCDTestFileName = "ecospold-test.xml";

    public static void main(String args[]) {

        UnmarshalILCD unmarshalILCD = new UnmarshalILCD();
        unmarshalILCD.unmarshalILCD();

    }
    void unmarshalILCD() {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(ILCDTestFileName);

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

            EcoSpold ecoSpold = (EcoSpold) jaxbUnmarshaller.unmarshal(xr);

            System.out.println(ecoSpold.getActivityDataset().getAdministrativeInformation().getDataEntryBy().getPersonId());


        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    void unmarshalEcoSpoldActivity() {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(ILCDTestFileName);

        try {

            //read stream
            InputStream is = new FileInputStream(resource.getFile());
            XMLStreamReader xsr = XMLInputFactory.newFactory().createXMLStreamReader(is);
            XMLReaderWithoutNamespace xr = new XMLReaderWithoutNamespace(xsr);

            //xr.nextTag();
            while(xr.hasNext()) {
                if(xr.isStartElement() && xr.getLocalName().equals("activity")) {
                    break;
                }
                xr.next();
            }

            //unmarshal
            JAXBContext jaxbContext = JAXBContext.newInstance(Activity.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Activity activity = (Activity) jaxbUnmarshaller.unmarshal(xr);

            System.out.println(activity.getComment().get(0).getText().get(2));


        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }



}
