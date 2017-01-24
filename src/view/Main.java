package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Information;
import model.Parser;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //create new Parser object and new Information object
        Parser newParser = new Parser();
        Information manahawkin = new Information();

        //pass new Information object to new parser object and run test output
        newParser.newParse(manahawkin);


        //test button that returns weather info to console
        //code example here http://docs.oracle.com/javafx/2/get_started/jfxpub-get_started.htm
        primaryStage.setTitle("Manahawkin Weather");
        Button btn = new Button();
        btn.setText("Click me for your weather!");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                manahawkin.returnInfo();
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}
