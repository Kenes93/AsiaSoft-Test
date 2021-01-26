package main.java.asia.soft.step4.repository.impl;

import main.java.asia.soft.step4.model.Number;
import main.java.asia.soft.step4.repository.NumberRepository;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.List;

public class NumberRepositoryXmlImol extends NumberRepository {
    private static NumberRepositoryXmlImol instance;

    private NumberRepositoryXmlImol() {
    }

    public static NumberRepositoryXmlImol getInstance() {
        if (instance == null) {
            instance = new NumberRepositoryXmlImol();
        }
        return instance;
    }

    @Override
    public void saveAll(List<Number> squaresArray, String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = builder.newDocument();
        Element numbers = document.createElement("numbers");
        document.appendChild(numbers);
        for (Number number:squaresArray) {

            Element elementNumber = document.createElement("value");
            Element isEven = document.createElement("isEven");
            Text numberValue = document.createTextNode(Long.toString(number.getValue()));
            Text parameterOfNumber = document.createTextNode(Boolean.toString(number.isEven()));

            numbers.appendChild(elementNumber);
            numbers.appendChild(isEven);
            elementNumber.appendChild(numberValue);
            isEven.appendChild(parameterOfNumber);
        }
        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        try {
            transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream(fileName)));
            System.out.println("Сохранение прошло успешно");
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
