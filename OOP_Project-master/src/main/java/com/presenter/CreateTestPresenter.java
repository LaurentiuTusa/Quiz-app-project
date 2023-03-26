package com.presenter;

import com.exceptions.EmptyException;
import com.model.Test;
import com.model.User;
import com.view.CreateQuestionView;
import com.view.CreateTestView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CreateTestPresenter {
    private CreateTestView createTestView;
    private User user;

    public CreateTestPresenter(CreateTestView createTestView, User user) {
        this.createTestView = createTestView;
        this.user=user;
        createTestView.setAddQuestionButtonAction(new CreateTestButton());
    }

    private class CreateTestButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Test.create(createTestView.getTestName(), user.getId());
                Test createdTest= new Test();
                createdTest.set(createTestView.getTestName());
                CreateQuestionPresenter createQuestionPresenter= new CreateQuestionPresenter(new CreateQuestionView(),createdTest,user);
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (EmptyException loginException) {
                loginException.printStackTrace();
            }
            createTestView.dispose();
        }
    }
}
