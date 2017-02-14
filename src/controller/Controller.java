package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Conditions;
import model.Parser;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Controller{

    @FXML private Label labelTest;
    @FXML private TextField stateTextField;
    @FXML private TextField cityTextField;
    @FXML public ComboBox myComboBox;
    private String city;
    private String state;
    private String userURL;
    private String stateReader;
    String[] statesArray = new String[50];

    private Parser newParser = new Parser();
    private Conditions yourTown = new Conditions();


    public void setData() throws FileNotFoundException {

        InputStream is = null;
        BufferedReader br = null;

        is = new FileInputStream("src\\resources\\states.txt");
        br = new BufferedReader(new InputStreamReader(is));

        try {
            while ((stateReader = br.readLine()) != null) {

                for (int j = 0; j < statesArray.length; j++){
                    statesArray[j] = br.readLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Exception reading in state list");
        }

        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        myComboBox.getItems().clear();
        myComboBox.getItems().addAll(statesArray);

    }

    @FXML
    public void buttonClicked() throws URISyntaxException {

        //obtain user input from test fields
        state = stateTextField.getText();
        city = cityTextField.getText();

        //create URL from text field inputs and escape any spaces in URL
        userURL = "http://api.wunderground.com/api/184245b00544774c/conditions/q/"+state+"/"+city+".xml";
        userURL = userURL.replaceAll(" ", "%20");

        //printURL for testing
        System.out.println(userURL);

        //create URL from URI
        URI uri = new URI(userURL);
        URL url = null;


        try {
            url = uri.toURL();
        newParser.newParse(yourTown, url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            labelTest.setText("Please enter a valid city and state.");
        }

        labelTest.setText(yourTown.currentConditions());
        System.out.println(yourTown.currentConditions());

    }

//http://stackoverflow.com/questions/19065464/how-to-populate-a-list-values-to-a-combobox-in-javafx





}

