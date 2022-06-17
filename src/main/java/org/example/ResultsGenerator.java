package org.example;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ResultsGenerator {

    private static final String fileName = System.getProperty("user.dir") + "/src/main/resources/org/example/userResults.csv";
    private static List<UserAnswer> userAnswerList;

    /**
     * Method that create list of UserAnswer type objects.
     * @throws FileNotFoundException
     */
    public static void setUserAnswerList() throws FileNotFoundException {
        userAnswerList= new CsvToBeanBuilder(new FileReader(fileName))
                .withType(UserAnswer.class)
                .build()
                .parse();
    }

    /**
     *
     * @return userAnswerList
     */
    public static List<UserAnswer> getUserAnswerList(){
        return userAnswerList;
    }
}
