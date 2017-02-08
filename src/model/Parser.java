package model;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Parser {

    public void newParse(Conditions manahawkin, URL userURL) throws MalformedURLException {

        //xmlReader
        DOMParser parser = new DOMParser();

        try {
            parser.parse(new InputSource((userURL).openStream()));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //example found here http://stackoverflow.com/questions/24446849/parse-xml-without-tagname
        Document doc = parser.getDocument();

        //this pulls elements from the child display location for location information
        Node locationInfo = doc.getElementsByTagName("display_location").item(0);
        NodeList childrenLocation = locationInfo.getChildNodes();

        for (int i = 0; i < childrenLocation.getLength(); i++) {

            if (childrenLocation.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) childrenLocation.item(i);

                if (elem.getTagName().equalsIgnoreCase("city")) {
                    manahawkin.setTownName(elem.getTextContent());
                }
                if (elem.getTagName().equalsIgnoreCase("state")) {
                    manahawkin.setStateName(elem.getTextContent());
                }
                if (elem.getTagName().equalsIgnoreCase("elevation")) {
                    manahawkin.setElevation(Double.parseDouble(elem.getTextContent()));
                }
                if (elem.getTagName().equalsIgnoreCase("zip")) {
                    manahawkin.setZipCode(elem.getTextContent());
                }
            }
        }

        //this pull elements from the child current_observation for current weather information
        Node WeatherInfo = doc.getElementsByTagName("current_observation").item(0);
        NodeList childrenWeather = WeatherInfo.getChildNodes();

        for (int i = 0; i < childrenWeather.getLength(); i++) {

            if (childrenWeather.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) childrenWeather.item(i);

                if (elem.getTagName().equalsIgnoreCase("observation_time")) {
                    manahawkin.setObservationTime(elem.getTextContent());
                }
                if (elem.getTagName().equalsIgnoreCase("weather")) {
                    manahawkin.setCurrentConditions(elem.getTextContent());
                }
                if (elem.getTagName().equalsIgnoreCase("temp_f")) {
                    manahawkin.setTemperatureF(elem.getTextContent());
                }
                if (elem.getTagName().equalsIgnoreCase("wind_mph")) {
                    manahawkin.setWindSpeed(Double.parseDouble(elem.getTextContent()));
                }
                if (elem.getTagName().equalsIgnoreCase("wind_dir")) {
                    manahawkin.setWindDirection(elem.getTextContent());
                }
            }
        }
    }


}