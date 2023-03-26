package com.presenter;

import com.model.OngoingTest;
import com.model.Question;
import com.model.User;
import com.view.QuestionView;
import com.view.ResultsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class QuestionPresenter {
    private Integer currentQuestion;
    private Integer correctQuestions;
    private QuestionView questionView;
    private OngoingTest ongoingTest;
    private Question question;
    private Integer submittedAnswer=0;
    private User user;



    public QuestionPresenter(QuestionView questionView, Integer testID, Integer questionNumber,Integer correctQuestions,User user) {
        this.user=user;
        this.correctQuestions=correctQuestions;
        this.questionView = questionView;
        this.ongoingTest = new OngoingTest(testID);
        this.currentQuestion=questionNumber;
        if(ongoingTest.isListEmpty()) {
            ResultsPresenter resultsPresenter =new ResultsPresenter(new ResultsView(),0,0,user);
            questionView.dispose();
            return;
        }
        this.question = ongoingTest.getQuestion(currentQuestion);
        questionView.setQuestionText(question.getQuestionText());
        questionView.setTitle("Question "+ currentQuestion);
        questionView.setV1RadioButtonText(question.getVariant1());
        questionView.setV2RadioButtonText(question.getVariant2());
        questionView.setV3RadioButtonText(question.getVariant3());
        questionView.setV4RadioButtonText(question.getVariant4());
        questionView.setV1RadioButtonAction(new RadioButtonAction());
        questionView.setV2RadioButtonAction(new RadioButtonAction());
        questionView.setV3RadioButtonAction(new RadioButtonAction());
        questionView.setV4RadioButtonAction(new RadioButtonAction());
        questionView.setSubmitButtonAction(new SubmitButtonAction());
    }

    private class RadioButtonAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if("V1".equals(e.getActionCommand())){
                submittedAnswer=1;
            } else if ("V2".equals(e.getActionCommand())){
                submittedAnswer=2;
            } else if ("V3".equals(e.getActionCommand())){
                submittedAnswer=3;
            } else if ("V4".equals(e.getActionCommand())){
                submittedAnswer=4;
            }
        }
    }

    private class SubmitButtonAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (Objects.equals(submittedAnswer, question.getAnswer())) {
                if(currentQuestion<ongoingTest.getNrOfQuestions()) {
                    QuestionPresenter questionPresenter = new QuestionPresenter(new QuestionView(), ongoingTest.getTestID(), currentQuestion + 1, correctQuestions+1,user);
                }
                else {
                    ResultsPresenter resultsPresenter =new ResultsPresenter(new ResultsView(),ongoingTest.getNrOfQuestions(),correctQuestions+1,user);
                }
            } else {
                if(currentQuestion<ongoingTest.getNrOfQuestions()) {
                    QuestionPresenter questionPresenter = new QuestionPresenter(new QuestionView(), ongoingTest.getTestID(), currentQuestion + 1, correctQuestions,user);
                }
                else {
                    ResultsPresenter resultsPresenter =new ResultsPresenter(new ResultsView(),ongoingTest.getNrOfQuestions(),correctQuestions,user);
                }
            }

            questionView.dispose();
        }
    }



}
