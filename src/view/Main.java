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

        //set gridpane for pop up window


        //add title to grid
//        Text scenetitle = new Text("Manahawkin, NJ Weather");
//        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//        grid.add(scenetitle, 0, 0, 2, 1);

        //add button
        //https://docs.oracle.com/javase/8/javafx/get-started-tutorial/form.htm
//        Button btn = new Button("Click to fetch");
//        HBox hbBtn = new HBox(10);
//        hbBtn.setAlignment(Pos.CENTER);
//        hbBtn.getChildren().add(btn);
//        grid.add(hbBtn, 1, 4);



        //create text object for weather output and set to grid location
//        Text actiontarget = new Text();
//        grid.add(actiontarget, 1, 6);

        //button to display weather when clicked
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent event) {
//                actiontarget.setText(manahawkin.currentConditions());
//            }
//        });

        //create scene and specify h & w
        Scene scene = new Scene(root, 500, 475);

        //link to css
//        scene.getStylesheets().add
//                (Main.class.getResource("/resources/style.css").toExternalForm());

        //start scene
        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public static void main(String[] args) {

        launch(args);
    }


}
