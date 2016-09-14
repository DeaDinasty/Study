package study;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        String homePath = System.getProperty("user.home");
        File file = new File(homePath + "/homework/studylog.hui");
        Parent root;
        /*if (file.exists()) {
             root = FXMLLoader.load(getClass().getResource("Windows/Hello/HelloOld.fxml"));

        } else {*/
            file.mkdirs();
            root = FXMLLoader.load(getClass().getResource("Windows/Hello/HelloNew.fxml"));
        //}
        primaryStage.setTitle("Study Book");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}