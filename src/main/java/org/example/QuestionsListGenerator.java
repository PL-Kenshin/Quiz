package org.example;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class QuestionsListGenerator {

    private static final String fileName = System.getProperty("user.dir") + "/src/main/resources/org/example/questions.csv";
    private static List<Question> questionsList;

    /**
     * Method that create list of Question type objects.
     * @throws FileNotFoundException
     */
    public static void setQuestionsList() throws FileNotFoundException {
        questionsList = new CsvToBeanBuilder(new FileReader(fileName))
                .withType(Question.class)
                .build()
                .parse();
    }

    /**
     *
     * @return questionsList
     */
    public static List<Question> getQuestionsList(){
        return questionsList;
    }
}
