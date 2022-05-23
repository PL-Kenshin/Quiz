package org.example;

import com.opencsv.bean.CsvBindByName;

public class UserAnswer {

    @CsvBindByName(column = "QUESTION_ID")
    private Integer questionID;

    @CsvBindByName(column = "CORRECT_ANSWER")
    private String correctAnswer;

    @CsvBindByName(column = "USER_ANSWER")
    private String userAnswer;

    @CsvBindByName(column = "POINTS")
    private Integer points;

    //  getters, setters, toString

    /**
     *
     * @return questionID
     */
    public Integer getQuestionID(){
        return questionID;
    }

    /**
     *
     * @return correctAnswer
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     *
     * @return userAnswer
     */
    public String getUserAnswer() {
        return userAnswer;
    }

    /**
     *
     * @return points
     */
    public Integer getPoints() {
        return points;
    }

}
