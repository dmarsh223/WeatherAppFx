package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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

        //code example here http://docs.oracle.com/javafx/2/get_started/jfxpub-get_started.htm
        primaryStage.setTitle("Manahawkin Weather");

        //set gridpane for pop up window
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //add title to grid
        Text scenetitle = new Text("Manahawkin, NJ Weather");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        //add button
        //https://docs.oracle.com/javase/8/javafx/get-started-tutorial/form.htm
        Button btn = new Button("Click to fetch");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.CENTER);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);



        //create text object for weather output and set to grid location
        Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        //button to display weather when clicked
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                actiontarget.setText(manahawkin.currentConditions());
            }
        });

        //create scene and specify h & w
        Scene scene = new Scene(grid, 500, 475);

        scene.getStylesheets().add
                (Main.class.getResource("/resources/style.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public static void main(String[] args) {

        launch(args);
    }
}
