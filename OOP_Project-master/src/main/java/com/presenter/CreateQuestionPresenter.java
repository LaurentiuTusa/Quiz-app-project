package com.presenter;

import com.model.Question;
import com.model.Test;
import com.model.User;
import com.view.CreateQuestionView;
import com.view.MainMenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CreateQuestionPresenter {
    private CreateQuestionView createQuestionView;
    private Test test;
    private User user;

    public CreateQuestionPresenter(CreateQuestionView createQuestionView, Test test, User user) {
        this.createQuestionView = createQuestionView;
        this.test = test;
        this.user = user;
        createQuestionView.setCreateAddMoreButton(new AddMoreQuestion());
        createQuestionView.setCreateFinishButtonAction(new FinnishAction());
    }

    private void addQuestion(){
        String questionText=createQuestionView.getQuestionText();
        String v1Text=createQuestionView.getTextFieldV1Text();
        String v2Text=createQuestionView.getTextFieldV2Text();
        String v3Text=createQuestionView.getTextFieldV3Text();
        String v4Text=createQuestionView.getTextFieldV4Text();
        Integer answer=createQuestionView.getComboBoxAnswer();
        try {
            Question.create(questionText,v1Text,v2Text,v3Text,v4Text,answer,test.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private class FinnishAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            addQuestion();
            createQuestionView.dispose();
            MainMenuPresenter mainMenuPresenter= new MainMenuPresenter(new MainMenuView(),user);
        }
    }

    private class AddMoreQuestion implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            addQuestion();
            createQuestionView.dispose();
            CreateQuestionPresenter createQuestionPresenter= new CreateQuestionPresenter(new CreateQuestionView(),test,user);
        }
    }
}
