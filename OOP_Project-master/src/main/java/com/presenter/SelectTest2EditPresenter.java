package com.presenter;

import com.model.Test;
import com.model.User;
import com.view.EditSelectedTestView;
import com.view.SelectTest2EditView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SelectTest2EditPresenter {
    private final SelectTest2EditView selectTest2EditView;
    private final List<Test> testList;
    private final User user;

    public SelectTest2EditPresenter(SelectTest2EditView selectTest2EditView, User user) {
        this.selectTest2EditView = selectTest2EditView;
        this.user = user;
        this.testList = Test.getListFromUser(user.getId());
        testList.forEach(test -> { selectTest2EditView.addButton(test.getTestName(),new OpenTestAction(test));});
    }

    private class OpenTestAction implements ActionListener {
        private Test test;

        public OpenTestAction(Test test) {
            this.test = test;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            EditSelectedTestPresenter editSelectedTestPresenter = new EditSelectedTestPresenter(new EditSelectedTestView(), test, user);
            selectTest2EditView.dispose();
        }
    }
}

