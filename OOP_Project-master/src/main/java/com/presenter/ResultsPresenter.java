package com.presenter;

import com.model.User;
import com.view.MainMenuView;
import com.view.ResultsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultsPresenter {
    private ResultsView resultsView;
    private User user;

    public ResultsPresenter(ResultsView resultsView, Integer nrOfQuestions, Integer correctQuestions, User user) {
        this.resultsView = resultsView;
        this.user=user;
        if(nrOfQuestions==0){
            resultsView.setAmountText("There Are No Questions");
            resultsView.setPercentText("");
        }else
        {
            resultsView.setAmountText(correctQuestions + "/" + nrOfQuestions);
            resultsView.setPercentText(correctQuestions * 100 / nrOfQuestions + "%");
        }
        resultsView.setMENUButtonAction(new MenuButtonAction());
    }

    private class MenuButtonAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            MainMenuPresenter mainMenuPresenter= new MainMenuPresenter(new MainMenuView(), user);
            resultsView.dispose();
        }
    }
}
