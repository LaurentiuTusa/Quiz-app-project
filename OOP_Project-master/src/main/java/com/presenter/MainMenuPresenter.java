package com.presenter;

import com.model.User;
import com.view.CreateTestView;
import com.view.MainMenuView;
import com.view.SelectTest2EditView;
import com.view.SelectTestView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPresenter {
    private final MainMenuView mainMenuView;
    private final User user;

    public MainMenuPresenter(MainMenuView mainMenuView, User user) {
        this.mainMenuView = mainMenuView;
        this.user = user;
        mainMenuView.setCreateTestButtonAction(new OpenCreateTest());
        mainMenuView.setEditTestButtonAction(new OpenEditTest());
        mainMenuView.setSelectTestButtonAction(new OpenSelectTest());
    }

    private class OpenSelectTest implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            SelectTestPresenter selectTestPresenter= new SelectTestPresenter(new SelectTestView(),user);
            mainMenuView.dispose();
        }
    }
    private class OpenCreateTest implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            CreateTestPresenter createTestPresenter=new CreateTestPresenter(new CreateTestView(),user);
            mainMenuView.dispose();
        }
    }
    private class OpenEditTest implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //Todo: open edit test list;
            SelectTest2EditPresenter selectTest2EditPresenter = new SelectTest2EditPresenter(new SelectTest2EditView(), user);
            mainMenuView.dispose();
        }
    }


}
