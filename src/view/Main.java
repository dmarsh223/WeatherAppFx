package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controller.Controller;
import model.Parser;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        //create new Parser object and new Controller object
        Parser newParser = new Parser();
        Controller manahawkin = new Controller();

        //pass new Controller object to new parser object and run test output
        newParser.newParse(manahawkin);

        //code example here http://docs.oracle.com/javafx/2/get_started/jfxpub-get_started.htm
        primaryStage.setTitle("Manahawkin Weather");

        String townTest = manahawkin.currentConditions();
        System.out.println(townTest);



        //create scene and specify h & w
        Scene scene = new Scene(root, 500, 475);

        //start scene
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
