package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import model.Conditions;
import model.Parser;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller{

    @FXML private Label labelTest;

    private String townName;
    private String stateName;
    private double elevation;
    private String zipCode;
    private String observationTime;
    private String currentConditions;
    private String temperatureF;
    private double windSpeed;
    private String windDirection;
    private String userURL;

    Parser newParser = new Parser();
    Conditions yourTown = new Conditions();


    @FXML
    public void buttonClicked(){

        userURL = "test";
        newParser.newParse(yourTown);

        labelTest.setText(yourTown.currentConditions());
        System.out.println(yourTown.currentConditions());

    }





}

