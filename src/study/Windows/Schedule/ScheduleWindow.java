package study.Windows.Schedule;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ScheduleWindow {
    private Stage window;

    public ScheduleWindow() throws IOException {
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        Parent root = new FXMLLoader().load(getClass().getResource("ScheduleChoose.fxml"));
        window.setTitle("Schedule");
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }
}
