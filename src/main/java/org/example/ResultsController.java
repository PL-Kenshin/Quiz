package org.example;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class ResultsController implements Initializable {

    @FXML
    private Label result, userPointsResult, maxPointsResult;
    @FXML
    private TableView resultsTable;

    private final List<UserAnswer> userAnswersList = ResultsGenerator.getUserAnswerList();

    private final ObservableList<UserAnswer> data = FXCollections.observableArrayList(userAnswersList);

    static final int grade5 = 27;
    static final int grade4 = 21;
    static final int grade3 = 15;
    private final Integer maxPoints = 30;
    private Integer userPoints = 0;

    /**
     * Method that show our results on scene. It calculates user points and check them for grade requirements.
     * Also, it sets answered questions data in table.
     */
    @FXML
    private void resultsController() {

        int i = 0;
        while (i < userAnswersList.size()){
            userPoints += userAnswersList.get(i).getPoints();
            i++;
        }

        maxPointsResult.setText(maxPoints.toString());
        userPointsResult.setText(userPoints.toString());

        if(userPoints>=grade5){
            result.setText("Test zaliczony na ocenę 5.");
        }
        else if(userPoints>=grade4){
            result.setText("Test zaliczony na ocenę 4.");
        }
        else if(userPoints>=grade3){
            result.setText("Test zaliczony na ocenę 3.");
        }
        else {
            result.setText("Test niezaliczony.");
        }

        resultsTable.setItems(data);
    }

    /**
     * Method for restarting the Quiz.
     * @throws IOException
     */
    public void restart() throws IOException {
        App.setRoot("main");
    }

    /**
     * Method that is initialized on the start of the scene. It calls resultsController() method.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            resultsController();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
