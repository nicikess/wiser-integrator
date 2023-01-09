package ch.unisg.ics.interactions.wiser.tests.units;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.Classification;
import ch.unisg.ics.interactions.wiser.filter.XMLReaderWithoutNamespace;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class DatasetImporterTests {

    static String ecoSpoldTestFileName = "ecospold-test.xml";
    static String fruitTestFileName = "skill-test.xml";

    private void print(String output) {
        System.out.println(output);
    }


    @Test
    void ignoreNamespaceTest() {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(ecoSpoldTestFileName);

        try {

            InputStream is = new FileInputStream(resource.getFile());
            XMLStreamReader xsr = XMLInputFactory.newFactory().createXMLStreamReader(is);
            XMLReaderWithoutNamespace xr = new XMLReaderWithoutNamespace(xsr);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    void correctParsingOfClassification() {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(ecoSpoldTestFileName);

        try {

            InputStream is = new FileInputStream(resource.getFile());
            XMLStreamReader xsr = XMLInputFactory.newFactory().createXMLStreamReader(is);
            XMLReaderWithoutNamespace xr = new XMLReaderWithoutNamespace(xsr);

            JAXBContext jaxbContext = JAXBContext.newInstance(Classification.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Classification classification = (Classification) jaxbUnmarshaller.unmarshal(xr);

            print(classification.getclassificationSystem());

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

}
