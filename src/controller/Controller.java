package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Conditions;
import model.Parser;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Controller{

    @FXML private Label labelTest;
    @FXML private TextField cityTextField;
    @FXML public ComboBox myComboBox;
    private String city;
    private String state;
    private String userURL;
    private String stateReader;
    String[] statesArray = new String[50];

    //image test
    @FXML ImageView imv = new ImageView();

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

        //clear combobox and set array of states to equal combobox
        myComboBox.getItems().clear();
        myComboBox.getItems().addAll(statesArray);
    }

    @FXML
    public void buttonClicked() throws URISyntaxException {

        //obtain user input from test fields
        state = (String) myComboBox.getValue();
        city = cityTextField.getText();

        //create URL from text field inputs and escape any spaces in URL
        userURL = "http://api.wunderground.com/api/184245b00544774c/conditions/q/"+state+"/"+city+".xml";
        userURL = userURL.replaceAll(" ", "%20");

        //printURL for testing
        System.out.println(userURL);

        //create URL from URI
        URI uri = new URI(userURL);
        URL url;

        //start new parse
        try {
            url = uri.toURL();
        newParser.newParse(yourTown, url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            labelTest.setText("Please enter a valid city and state.");
        }

        //set label to equal the current conditions test string and print to console for test of output
        labelTest.setText(yourTown.currentConditions());
        System.out.println(yourTown.currentConditions());

    //call weather image method
    weatherImage();
    }

    public void weatherImage(){

        File file;
        Image image;

        String currentConditions = yourTown.getCurrentConditions();

        //clear weather
        if (currentConditions.equals("Clear")){

            file = new File("src\\resources\\rain.jpg");
            image = new Image(file.toURI().toString());
            imv.setImage(image);
        }
        //rain
        if (currentConditions.equals("Rain")){

            file = new File("src\\resources\\rain.jpg");
            image = new Image(file.toURI().toString());
            imv.setImage(image);
        }
        //cloudy
        if (currentConditions.equals("Cloudy")){

            file = new File("src\\resources\\rain.jpg");
            image = new Image(file.toURI().toString());
            imv.setImage(image);
        }
        //partly cloudy
        if (currentConditions.equals("Party Cloudy")){

            file = new File("src\\resources\\rain.jpg");
            image = new Image(file.toURI().toString());
            imv.setImage(image);
        }
        //snow
        if (currentConditions.equals("Snow")){

            file = new File("src\\resources\\rain.jpg");
            image = new Image(file.toURI().toString());
            imv.setImage(image);
        }

    }

//http://stackoverflow.com/questions/19065464/how-to-populate-a-list-values-to-a-combobox-in-javafx

}

