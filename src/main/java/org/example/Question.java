package org.example;

import com.opencsv.bean.CsvBindByName;

public class Question {

    @CsvBindByName(column = "ID")
    private Integer questionID;

    @CsvBindByName(column = "QUESTION")
    private String questionDescription;

    @CsvBindByName(column = "ANSWER1")
    private String answer1;

    @CsvBindByName(column = "ANSWER2")
    private String answer2;

    @CsvBindByName(column = "ANSWER3")
    private String answer3;

    @CsvBindByName(column = "ANSWER4")
    private String answer4;

    @CsvBindByName(column = "CORRECT_ANSWER")
    private Integer correctAnswer;

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
     * @return questionDescription
     */
    public String getQuestionDescription(){
        return questionDescription;
    }

    /**
     *
     * @return answer1
     */
    public String getAnswer1(){
        return answer1;
    }

    /**
     *
     * @return answer2
     */
    public String getAnswer2(){
        return answer2;
    }

    /**
     *
     * @return answer3
     */
    public String getAnswer3(){
        return answer3;
    }

    /**
     *
     * @return answer4
     */
    public String getAnswer4(){
        return answer4;
    }

    /**
     *
     * @return correctAnswer
     */
    public Integer getCorrectAnswer(){
        return correctAnswer;
    }

    /**
     *
     * @return correct answer Description
     */
    public String getCorrectAnswerDesc(){
        switch(correctAnswer){
            case 1:
                return answer1;
            case 2:
                return answer2;
            case 3:
                return answer3;
            case 4:
                return answer4;
            default:
                return "QUESTION ERROR";
        }
    }

    /**
     *
     * @return points
     */
    public Integer getPoints(){
        return points;
    }


}