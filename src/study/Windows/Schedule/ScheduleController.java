package study.Windows.Schedule;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScheduleController implements Initializable {
    @FXML
    TextField lesson_0_0;
    @FXML
    TextField lesson_0_1;
    @FXML
    TextField lesson_0_2;
    @FXML
    TextField lesson_0_3;
    @FXML
    TextField lesson_0_4;
    @FXML
    TextField lesson_0_5;
    @FXML
    TextField lesson_1_0;
    @FXML
    TextField lesson_1_1;
    @FXML
    TextField lesson_1_2;
    @FXML
    TextField lesson_1_3;
    @FXML
    TextField lesson_1_4;
    @FXML
    TextField lesson_1_5;
    @FXML
    TextField lesson_2_0;
    @FXML
    TextField lesson_2_1;
    @FXML
    TextField lesson_2_2;
    @FXML
    TextField lesson_2_3;
    @FXML
    TextField lesson_2_4;
    @FXML
    TextField lesson_2_5;
    @FXML
    TextField lesson_3_0;
    @FXML
    TextField lesson_3_1;
    @FXML
    TextField lesson_3_2;
    @FXML
    TextField lesson_3_3;
    @FXML
    TextField lesson_3_4;
    @FXML
    TextField lesson_3_5;
    @FXML
    TextField lesson_4_0;
    @FXML
    TextField lesson_4_1;
    @FXML
    TextField lesson_4_2;
    @FXML
    TextField lesson_4_3;
    @FXML
    TextField lesson_4_4;
    @FXML
    TextField lesson_4_5;
    @FXML
    TextField lesson_5_0;
    @FXML
    TextField lesson_5_1;
    @FXML
    TextField lesson_5_2;
    @FXML
    TextField lesson_5_3;
    @FXML
    TextField lesson_5_4;
    @FXML
    TextField lesson_5_5;
    @FXML
    TextField lesson_6_0;
    @FXML
    TextField lesson_6_1;
    @FXML
    TextField lesson_6_2;
    @FXML
    TextField lesson_6_3;
    @FXML
    TextField lesson_6_4;
    @FXML
    TextField lesson_6_5;
    @FXML
    TextField lesson_7_0;
    @FXML
    TextField lesson_7_1;
    @FXML
    TextField lesson_7_2;
    @FXML
    TextField lesson_7_3;
    @FXML
    TextField lesson_7_4;
    @FXML
    TextField lesson_7_5;
    @FXML
    TextField lesson_8_0;
    @FXML
    TextField lesson_8_1;
    @FXML
    TextField lesson_8_2;
    @FXML
    TextField lesson_8_3;
    @FXML
    TextField lesson_8_4;
    @FXML
    TextField lesson_8_5;
    @FXML
    TextField lesson_9_0;
    @FXML
    TextField lesson_9_1;
    @FXML
    TextField lesson_9_2;
    @FXML
    TextField lesson_9_3;
    @FXML
    TextField lesson_9_4;
    @FXML
    TextField lesson_9_5;
    @FXML
    TextField lesson_10_0;
    @FXML
    TextField lesson_10_1;
    @FXML
    TextField lesson_10_2;
    @FXML
    TextField lesson_10_3;
    @FXML
    TextField lesson_10_4;
    @FXML
    TextField lesson_10_5;
    @FXML
    TextField lesson_11_0;
    @FXML
    TextField lesson_11_1;
    @FXML
    TextField lesson_11_2;
    @FXML
    TextField lesson_11_3;
    @FXML
    TextField lesson_11_4;
    @FXML
    TextField lesson_11_5;
    @FXML
    TextField mainLesson;
    @FXML
    ChoiceBox typeOfLesson;
    @FXML
    TextArea fullName;
    @FXML
    TextField teacherName;
    @FXML
    TextField cabinet;

    ////////////////////
    private TextField[][] lessons = new TextField[12][6]; //[0-5][0-5] = lesson; [6-11][0-5] = weeks;
    private Control[] lesInfoBar = new Control[4];

    private String[][][][] lessonsInfo = new String[2][6][6][4]; //page-day-dayOfWeek-info
    private void getLessonsArrays() {
        lessons[0][0] = lesson_0_0;
        lessons[0][1] = lesson_0_1;
        lessons[0][2] = lesson_0_2;
        lessons[0][3] = lesson_0_3;
        lessons[0][4] = lesson_0_4;
        lessons[0][5] = lesson_0_5;
        lessons[1][0] = lesson_2_0;
        lessons[1][1] = lesson_2_1;
        lessons[1][2] = lesson_2_2;
        lessons[1][3] = lesson_2_3;
        lessons[1][4] = lesson_2_4;
        lessons[1][5] = lesson_2_5;
        lessons[2][0] = lesson_4_0;
        lessons[2][1] = lesson_4_1;
        lessons[2][2] = lesson_4_2;
        lessons[2][3] = lesson_4_3;
        lessons[2][4] = lesson_4_4;
        lessons[2][5] = lesson_4_5;
        lessons[3][0] = lesson_6_0;
        lessons[3][1] = lesson_6_1;
        lessons[3][2] = lesson_6_2;
        lessons[3][3] = lesson_6_3;
        lessons[3][4] = lesson_6_4;
        lessons[3][5] = lesson_6_5;
        lessons[4][0] = lesson_8_0;
        lessons[4][1] = lesson_8_1;
        lessons[4][2] = lesson_8_2;
        lessons[4][3] = lesson_8_3;
        lessons[4][4] = lesson_8_4;
        lessons[4][5] = lesson_8_5;
        lessons[5][0] = lesson_10_0;
        lessons[5][1] = lesson_10_1;
        lessons[5][2] = lesson_10_2;
        lessons[5][3] = lesson_10_3;
        lessons[5][4] = lesson_10_4;
        lessons[5][5] = lesson_10_5;
        lessons[6][0] = lesson_1_0;
        lessons[6][1] = lesson_1_1;
        lessons[6][2] = lesson_1_2;
        lessons[6][3] = lesson_1_3;
        lessons[6][4] = lesson_1_4;
        lessons[6][5] = lesson_1_5;
        lessons[7][0] = lesson_3_0;
        lessons[7][1] = lesson_3_1;
        lessons[7][2] = lesson_3_2;
        lessons[7][3] = lesson_3_3;
        lessons[7][4] = lesson_3_4;
        lessons[7][5] = lesson_3_5;
        lessons[8][0] = lesson_5_0;
        lessons[8][1] = lesson_5_1;
        lessons[8][2] = lesson_5_2;
        lessons[8][3] = lesson_5_3;
        lessons[8][4] = lesson_5_4;
        lessons[8][5] = lesson_5_5;
        lessons[9][0] = lesson_7_0;
        lessons[9][1] = lesson_7_1;
        lessons[9][2] = lesson_7_2;
        lessons[9][3] = lesson_7_3;
        lessons[9][4] = lesson_7_4;
        lessons[9][5] = lesson_7_5;
        lessons[10][0] = lesson_9_0;
        lessons[10][1] = lesson_9_1;
        lessons[10][2] = lesson_9_2;
        lessons[10][3] = lesson_9_3;
        lessons[10][4] = lesson_9_4;
        lessons[10][5] = lesson_9_5;
        lessons[11][0] = lesson_11_0;
        lessons[11][1] = lesson_11_1;
        lessons[11][2] = lesson_11_2;
        lessons[11][3] = lesson_11_3;
        lessons[11][4] = lesson_11_4;
        lessons[11][5] = lesson_11_5;

        lesInfoBar[0] = fullName;
        lesInfoBar[1] = typeOfLesson;
        lesInfoBar[2] = teacherName;
        lesInfoBar[3] = cabinet;
    }
    ////////////////////
    private Pattern goodSymb = Pattern.compile("^[A-ZА-Я][a-zа-яA-ZА-Я]{0,13}\\s?[a-zа-яА-ЯA-Z]{0,14}$");
    private Pattern goodSpace = Pattern.compile("^[a-zA-Zа-яА-Я]{1,15}\\s?[a-zA-Zа-яА-Я]*$");

    private Pattern goodWeek = Pattern.compile("^((([1-9]|(1[0-9]))(-([1-9]|(1[0-9])))?,\\s*)*([1-9]|(1[0-9]))(-([1-9]|(1[0-9])))?\\s*)$");
    private Pattern badWeekSymb = Pattern.compile("^([0-9-,]||\\s)*$");

    private Matcher m;

    private void setListeners() {
        for (int i = 0; i < 6; i++) {
            for (TextField tf : lessons[i]) {
                tf.textProperty().addListener(((observable, oldValue, newValue) -> {
                    if (!newValue.isEmpty()) {
                        if (newValue.length() > 15 || !(m = goodSpace.matcher(newValue)).matches()) {
                            tf.setText(oldValue);
                        } else if (!(m = goodSymb.matcher(newValue)).matches()) {
                            tf.setText(Character.toUpperCase(newValue.charAt(0)) + newValue.substring(1));
                        }
                    }
                    mainLesson.setText(lessons[fLes[0]][fLes[1]].getText());
                    fullName.setPromptText(lessons[fLes[0]][fLes[1]].getText());
                }));

                tf.focusedProperty().addListener(((observable, oldValue, newValue) -> {
                    if (newValue) {
                        focus(0);
                        mainLesson.setText(lessons[fLes[0]][fLes[1]].getText());
                        fullName.setPromptText(lessons[fLes[0]][fLes[1]].getText());
                    }
                    else {
                        focus(3);
                        for (int j = 0; j < 4; j++) {
                            if (lesInfoBar[j].isFocused()) {
                                tf.setStyle(tf.getStyle() + "; -fx-border-width: 3px");
                                return;
                            }
                        }
                    }
                }));
            }
        }

        for (int i = 6; i < 12; i++) {
            for (TextField tf : lessons[i]) {
                tf.textProperty().addListener(((observable, oldValue, newValue) -> {
                    if (!newValue.isEmpty()) {
                        if (newValue.length() > 19) tf.setText(oldValue);
                        else if (!(m = badWeekSymb.matcher(newValue)).matches()) tf.setText(oldValue);
                        else if (!(m = goodWeek.matcher(newValue)).matches()) {
                            if (!tf.getText().trim().isEmpty()) tf.setStyle("-fx-border-color: red");
                            //Attention block
                        } else {
                            //Analis
                            //Attention block
                            tf.setStyle("-fx-border-color: black");
                        }
                    } else tf.setStyle("-fx-border-color: black");
                    mainLesson.setText(lessons[fLes[0]][fLes[1]].getText());
                    fullName.setPromptText(lessons[fLes[0]][fLes[1]].getText());
                }));

                tf.focusedProperty().addListener(((observable, oldValue, newValue) -> {
                    if (newValue) {
                        focus(1);
                        mainLesson.setText(lessons[fLes[0]][fLes[1]].getText());
                        fullName.setPromptText(lessons[fLes[0]][fLes[1]].getText());
                    } else {
                        focus(3);
                        for (int j = 0; j < 4; j++) {
                            if (lesInfoBar[j].isFocused()) {
                                if (tf.getStyle().equals("-fx-border-color: red")) tf.setStyle(tf.getStyle() + "; -fx-border-width: 3px");
                                else tf.setStyle("-fx-border-width: 3px");
                                return;
                            }
                        }
                    }
                }));
            }
        }

        for (int i = 0; i < 4; i++) {
            lesInfoBar[i].focusedProperty().addListener(((observable, oldValue, newValue) -> {
                if (!newValue) {
                    for (int j = 0; j < 4; j++) {
                        if (lesInfoBar[j].isFocused()) return;
                    }
                    System.out.println(lessons[fLes[0]][fLes[1]].getStyle());
                    int num = fLes[0];
                    if (lessons[fLes[0]][fLes[1]].getStyle().isEmpty()) num += 6;
                    lessons[num][fLes[1]].setStyle(lessons[num][fLes[1]].getStyle().substring(0, lessons[num][fLes[1]].getStyle().length()-3) + "2px");
                }
            }));
        }
    }
    ////////////////////
    private int[] fLes = new int[2];

    private void focus(int num) {
        //num == 0 -> lessons
        //num == 1 -> weeks
        int i1 = num == 0 ? 0 : 6;
        int i2 = num == 0 ? 6 : 12;
        for (int i = i1; i < i2; i++) {
            for (int j = 0; j < 6; j++) {
                if (lessons[i][j].isFocused()) {
                    fLes[0] = num == 0 ? i : i - 6;
                    fLes[1] = j;
                    return;
                }
            }
        }
    }
    ////////////////////
    //num == 1 -> 1st page
    //num == 2 -> 2nd page
    private void saveInfo(int num) {
        lessonsInfo[num==1?0:1][fLes[0]][fLes[1]][0] = fullName.getText();
        lessonsInfo[num==1?0:1][fLes[0]][fLes[1]][1] = typeOfLesson.getValue().toString();
        lessonsInfo[num==1?0:1][fLes[0]][fLes[1]][2] = teacherName.getText();
        lessonsInfo[num==1?0:1][fLes[0]][fLes[1]][3] = cabinet.getText();
    }

    private void loadInfo(int num) {
        fullName.setText(lessonsInfo[num==1?0:1][fLes[0]][fLes[1]][0]);
        typeOfLesson.setValue(lessonsInfo[num==1?0:1][fLes[0]][fLes[1]][1]==null?"Лекция":lessonsInfo[num==1?0:1][fLes[0]][fLes[1]][1]);
        teacherName.setText(lessonsInfo[num==1?0:1][fLes[0]][fLes[1]][2]);
        cabinet.setText(lessonsInfo[num==1?0:1][fLes[0]][fLes[1]][3]);
    }
    ////////////////////
    //savelessons()
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getLessonsArrays();
        setListeners();
        typeOfLesson.setItems(FXCollections.observableArrayList("Лекция", "Практика", "Лабораторная"));
        typeOfLesson.setValue("Лекция");
        lesson_0_0.requestFocus();
        //OK -> if all good
        //RexEx for fullName and cabinet
    }
    //onclick
}