package study.Windows.Hello;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import study.Windows.Schedule.ScheduleWindow;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloController implements Initializable{
    @FXML
    AnchorPane anchorPane;
    @FXML
    TextField nickname;
    @FXML
    TextField les1_1;
    @FXML
    TextField les2_1;
    @FXML
    TextField les3_1;
    @FXML
    TextField les4_1;
    @FXML
    TextField les5_1;
    @FXML
    TextField les6_1;
    @FXML
    TextField les7_1;
    @FXML
    TextField les1_2;
    @FXML
    TextField les2_2;
    @FXML
    TextField les3_2;
    @FXML
    TextField les4_2;
    @FXML
    TextField les5_2;
    @FXML
    TextField les6_2;
    @FXML
    TextField les7_2;
    @FXML
    Button schedule;
    @FXML
    Button next;
    @FXML
    ImageView nickImage;
    @FXML
    ImageView lesImage1;
    @FXML
    ImageView lesImage2;
    @FXML
    ImageView lesImage3;
    @FXML
    ImageView lesImage4;
    @FXML
    ImageView lesImage5;
    @FXML
    ImageView lesImage6;
    @FXML
    ImageView lesImage7;

    ////////////////////
    private TextField[][] lesTime = new TextField[7][2];
    private ImageView[] imV = new ImageView[7];
    private void getLesTimeArray() {
        lesTime[0][0] = les1_1;
        lesTime[0][1] = les1_2;
        lesTime[1][0] = les2_1;
        lesTime[1][1] = les2_2;
        lesTime[2][0] = les3_1;
        lesTime[2][1] = les3_2;
        lesTime[3][0] = les4_1;
        lesTime[3][1] = les4_2;
        lesTime[4][0] = les5_1;
        lesTime[4][1] = les5_2;
        lesTime[5][0] = les6_1;
        lesTime[5][1] = les6_2;
        lesTime[6][0] = les7_1;
        lesTime[6][1] = les7_2;

        imV[0] = lesImage1;
        imV[1] = lesImage2;
        imV[2] = lesImage3;
        imV[3] = lesImage4;
        imV[4] = lesImage5;
        imV[5] = lesImage6;
        imV[6] = lesImage7;
    }
    ////////////////////
    private Pattern p = Pattern.compile("^((0[0-9])||([1-9])||(1[0-9])||(2[0-3]))[.,/\\:-][0-5][0-9]$");
    private Matcher m;
    private int posP1 = 0;
    private int posP2 = 0;
    private boolean lesTimeGood[][] = new boolean[7][2];

    private Pattern badValue = Pattern.compile("^(.)*[^0-9.,\\/:-](.)*$");
    private Pattern badSymbs = Pattern.compile("^(.)*[,\\/:-](.)*$");
    ////////////////////


    private void setListeners() {
        nickname.textProperty().addListener((observable, oldValue, newValue) -> {
            focus(1);
            if (nickname.getText().length() < 5) {
                next.setDisable(true);
                nickImage.setImage(new Image(new File(System.getProperty("user.home") + "/Study/src/study/res/markBad.png").toURI().toString()));
            } else if (nickname.getText().length() < 20) {
                if (nickname.getText().trim().length() > 4) {
                    nickBool = true;
                    canWeNext();
                    nickImage.setImage(new Image(new File(System.getProperty("user.home") + "/Study/src/study/res/markGood.png").toURI().toString()));
                }
            }
            else nickname.setText(oldValue);
        });

        for (TextField t1[] : lesTime) {
            for (TextField t2 : t1) {
                t2.textProperty().addListener(((observable, oldValue, newValue) -> {
                    focus(0);
                    if ((m = badValue.matcher(newValue)).matches()) {
                        t2.setText(oldValue);
                    } else if (newValue.length() > 5) t2.setText(oldValue);
                    else if ((m = badSymbs.matcher(newValue)).matches()) {
                        int pos = t2.getCaretPosition();
                        t2.setText(oldValue.substring(0, pos) + "." + oldValue.substring(pos));
                    } else {
                        m = p.matcher(newValue);
                        if (m.matches() || newValue.length() == 0) {
                            lesTimeGood[posP1][posP2] = true;
                            if (lesTimeGood[posP1][posP2 == 0 ? 1 : 0]) {
                                imV[posP1].setImage(new Image(new File(System.getProperty("user.home") + "/Study/src/study/res/markGood.png").toURI().toString()));
                                canWeNext();
                            }

                        } else {
                            next.setDisable(true);
                            lesTimeGood[posP1][posP2] = false;
                            imV[posP1].setImage(new Image(new File(System.getProperty("user.home") + "/Study/src/study/res/markBad.png").toURI().toString()));
                        }
                    }
                }));
            }
        }
    }
    ////////////////////

    private boolean lastNum1 = false;

    private void focus(int num) {
        //num = 1 -> nickChange focused
        //num = 0 -> lesTime focused
        if (num == 0) {
            if (lastNum1) {
                nickname.setText(nickname.getText().trim());
                lastNum1 = false;
            }
        }
        else if (num == 1) {
            lastNum1 = true;
        }
    }

    private boolean nickBool = false;
    private void canWeNext() {
        for(boolean[] b1 : lesTimeGood) {
            for(boolean b2 : b1) if (b2 && nickBool) next.setDisable(false);
        }
    }

    public void goShed() {
        try {
            new ScheduleWindow();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 2; j++) {
                lesTimeGood[i][j] = true;
            }
        }
        getLesTimeArray();
        setListeners();

        goShed();
    }
}
