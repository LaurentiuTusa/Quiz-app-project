package com.presenter;

import com.model.Test;
import com.model.User;
import com.view.EditSelectedQuestionView;
import com.model.Question;
import com.view.EditSelectedTestView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class EditSelectedQuestionPresenter {
    private EditSelectedQuestionView editSelectedQuestionView;
    private Test test;
    private User user;
    private Question question;

    public EditSelectedQuestionPresenter(EditSelectedQuestionView editSelectedQuestionView, Test test, User user, Question Q) {
        this.editSelectedQuestionView = editSelectedQuestionView;
        this.test = test;
        this.user = user;
        this.question = Q;

        editSelectedQuestionView.addDeleteTheQuestionButton(new DeleteTheQuestion());
        editSelectedQuestionView.addUpdateQuestionButton(new UpdateTheQuestion());
    }

    private class DeleteTheQuestion implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent aE) {
            try {
                Question.delete(question.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            editSelectedQuestionView.dispose();
            EditSelectedTestPresenter editSelectedTestPresenter = new EditSelectedTestPresenter(new EditSelectedTestView(), test, user);
        }
    }

    public void updateQuestion() {
        String questionText=editSelectedQuestionView.getQuestionText();
        String v1Text=editSelectedQuestionView.getTextFieldV1Text();
        String v2Text=editSelectedQuestionView.getTextFieldV2Text();
        String v3Text=editSelectedQuestionView.getTextFieldV3Text();
        String v4Text=editSelectedQuestionView.getTextFieldV4Text();
        Integer answer=editSelectedQuestionView.getComboBoxAnswer();
        try {
            question.update(questionText,v1Text,v2Text,v3Text,v4Text,answer,test.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private class UpdateTheQuestion implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent aE) {
            updateQuestion();
            editSelectedQuestionView.dispose();
            EditSelectedTestPresenter editSelectedTestPresenter = new EditSelectedTestPresenter(new EditSelectedTestView(), test, user);
        }
    }
}
