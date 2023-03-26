package com.presenter;

import com.model.Question;
import com.model.Test;
import com.model.User;
import com.view.CreateQuestionView;
import com.view.EditSelectedQuestionView;
import com.view.EditSelectedTestView;
import com.view.SelectTestView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EditSelectedTestPresenter {
    private final EditSelectedTestView editSelectedTestView;
    private final List<Question> questionList;
    private final User user;
    private final Test test;

    public EditSelectedTestPresenter(EditSelectedTestView editSelectedTestView, Test test, User user) {
        this.editSelectedTestView = editSelectedTestView;
        this.test = test;
        this.user = user;
        this.questionList = Question.getAllFromTest(test.getId());
        questionList.forEach(question -> {
            editSelectedTestView.addButton(question.getQuestionText(), new OpenQuestionAction(question));
        });

        editSelectedTestView.add_addQuestionButton(new AddQuestion());
    }

        private class OpenQuestionAction implements ActionListener {
        Question question;
            public OpenQuestionAction(Question Q) {
                this.question = Q;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                EditSelectedQuestionPresenter editSelectedQuestionPresenter = new EditSelectedQuestionPresenter(new EditSelectedQuestionView(question), test, user, question);
                editSelectedTestView.dispose();
            }
        }

    private class AddQuestion implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CreateQuestionPresenter createQuestionPresenter = new CreateQuestionPresenter(new CreateQuestionView(), test, user);
            editSelectedTestView.dispose();
        }
    }
}
