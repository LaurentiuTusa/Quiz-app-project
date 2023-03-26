package com.model;

import java.util.List;

public class OngoingTest {
    private Integer testID;
    private List<Question> questionList;
    private Integer nrOfQuestions;


    public OngoingTest(Integer testID) {
        this.testID=testID;
        questionList=Question.getAllFromTest(testID);
        this.nrOfQuestions =questionList.size();
    }

    public Boolean isListEmpty(){
        return questionList.isEmpty();
    }

    public Question getQuestion(Integer questionNumber){
        return questionList.get(questionNumber-1);
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public Integer getNrOfQuestions() {
        return nrOfQuestions;
    }

    public void setNrOfQuestions(Integer nrOfQuestions) {
        this.nrOfQuestions = nrOfQuestions;
    }

    public Integer getTestID() {
        return testID;
    }

    public void setTestID(Integer testID) {
        this.testID = testID;
    }
}
