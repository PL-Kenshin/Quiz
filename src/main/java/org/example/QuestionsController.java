package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;


public class QuestionsController implements Initializable {
    @FXML
    private Label questionNumber, description;
    @FXML
    private ToggleGroup rGroup;
    @FXML
    private RadioButton rButton1, rButton2, rButton3, rButton4, selectedButton;
    @FXML
    private Button secondaryButton;

    private final List<Question> questionsList = QuestionsListGenerator.getQuestionsList();

    private Integer counter = 0;

    private final String filePath = "C:\\Users\\Admin\\Desktop\\Programming\\JAVA\\quiz\\src\\main\\resources\\org\\example\\userResults.csv";

    /**
     * Method that create new file writer which create new csv file for store data of answered questions.
     * Also, it sets first question.
     * @throws Exception
     */
    @FXML
    private void firstRun() throws Exception{
        FileWriter writer = new FileWriter(filePath);
        writer.append("QUESTION_ID,CORRECT_ANSWER,USER_ANSWER,POINTS");
        writer.append("\n");
        writer.close();

        questionNumber.setText(questionsList.get(0).getQuestionID().toString());
        description.setText(questionsList.get(0).getQuestionDescription());
        rButton1.setText(questionsList.get(0).getAnswer1());
        rButton2.setText(questionsList.get(0).getAnswer2());
        rButton3.setText(questionsList.get(0).getAnswer3());
        rButton4.setText(questionsList.get(0).getAnswer4());
    }

    /**
     * Method that switch to the next question and save answered questions data.
     * Also, if it is last question it sets results scene.
     * @throws IOException
     */
    @FXML
    private void questionController() throws IOException {

        selectedButton = (RadioButton) rGroup.getSelectedToggle();
        if(selectedButton == null){
            return;
        }

        FileWriter writer = new FileWriter(filePath,true);
        writer.append("\"" + questionsList.get(counter).getQuestionID().toString() + "\"");
        writer.append(",");
        writer.append("\"" + questionsList.get(counter).getCorrectAnswerDesc() + "\"");
        writer.append(",");
        writer.append("\"" + selectedButton.getText() + "\"");
        writer.append(",");
        if(Character.getNumericValue(selectedButton.getId().charAt(7)) == questionsList.get(counter).getCorrectAnswer()){
            writer.append("\"" + questionsList.get(counter).getPoints().toString() + "\"");
        }
        else {
            writer.append("\"0\"");
        }
        writer.append("\n");
        writer.close();

        counter++;
        if(counter < 20) {
            if(counter == 19){
                secondaryButton.setText("Zakończ test");
            }
            questionNumber.setText(questionsList.get(counter).getQuestionID().toString());
            description.setText(questionsList.get(counter).getQuestionDescription());
            rGroup.getSelectedToggle().setSelected(false);
            rButton1.setText(questionsList.get(counter).getAnswer1());
            rButton2.setText(questionsList.get(counter).getAnswer2());
            rButton3.setText(questionsList.get(counter).getAnswer3());
            rButton4.setText(questionsList.get(counter).getAnswer4());
        }
        else{

            ResultsGenerator.setUserAnswerList();
            App.setRoot("results");
        }
    }

    /**
     * Method that is initialized on start of the scene. It calls firstRun() method.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            firstRun();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}