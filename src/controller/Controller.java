package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Conditions;
import model.Parser;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Controller{

    @FXML private Label labelTest;
    @FXML private TextField stateTextField;
    @FXML private TextField cityTextField;
    private String city;
    private String state;
    private String userURL;

    Parser newParser = new Parser();
    Conditions yourTown = new Conditions();


    @FXML
    public void buttonClicked() throws MalformedURLException, URISyntaxException {






        state = stateTextField.getText();
        city = cityTextField.getText();
        userURL = "http://api.wunderground.com/api/184245b00544774c/conditions/q/"+state+"/"+city+".xml";
        userURL = userURL.replaceAll(" ", "%20");
        System.out.println(userURL);

        URI uri = new URI(userURL);
        URL url = uri.toURL();



        newParser.newParse(yourTown, url);

        labelTest.setText(yourTown.currentConditions());
        System.out.println(yourTown.currentConditions());

    }





}

