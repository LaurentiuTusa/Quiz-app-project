package com.presenter;

import com.model.Test;
import com.model.User;
import com.view.QuestionView;
import com.view.SelectTestView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SelectTestPresenter {
    private final SelectTestView selectTestView;
    private final List<Test> testList=Test.getList();
    private final User user;

    public SelectTestPresenter(SelectTestView selectTestView, User user) {
        this.selectTestView = selectTestView;
        this.user=user;
        testList.forEach(test -> {selectTestView.addButton(test.getTestName(),new OpenTestAction(test.getId()));});
    }

    private class OpenTestAction implements ActionListener {
        private Integer testID;

        public OpenTestAction(Integer testID) {
            this.testID = testID;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            QuestionPresenter questionPresenter = new QuestionPresenter(new QuestionView(),testID,1,0,user);
            selectTestView.dispose();
        }
    }
}
