package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Conditions;
import model.Parser;

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
    public void buttonClicked(){

        userURL = "test";
        newParser.newParse(yourTown);

        labelTest.setText(yourTown.currentConditions());
        System.out.println(yourTown.currentConditions());

        state = stateTextField.getText();
        city = cityTextField.getText();
        userURL = "http://api.wunderground.com/api/184245b00544774c/conditions/q/"+state+"/"+city+".xml";
        System.out.println(userURL);

    }





}

