package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.hubspot.jinjava.*;
import java.util.Map;
import java.util.HashMap;

public class Main extends Application {

    @Override


    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        Jinjava newtest = new Jinjava();
        Map<String, Object> thing = new HashMap<>();
        thing.put("name","Templator v0.01");

        System.out.println(newtest.render("HEY {{ name }}",thing));
        primaryStage.setTitle(newtest.render("HEY {{name}} {{ name }}",thing));

    }


    public static void main(String[] args) {
        launch(args);
    }





}
