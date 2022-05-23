package org.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class MainController {

    /**
     * Method of main scene which have function for button that sets question scene.
     * @throws IOException
     */
    @FXML
    private void switchToQuestions() throws IOException {
        App.setRoot("questions");
    }
}
