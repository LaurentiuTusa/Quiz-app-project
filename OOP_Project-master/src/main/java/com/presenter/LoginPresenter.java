package com.presenter;

import com.exceptions.EmptyException;
import com.model.User;
import com.view.CreateUserView;
import com.view.LoginView;
import com.view.MainMenuView;
import org.mindrot.jbcrypt.BCrypt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginPresenter {
    private final LoginView loginView;
    private final User userModel= new User();

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        loginView.setLoginButtonAction(new LoginAction());
        loginView.setCreateUserButtonAction(new OpenCreateUserAction());
    }


    private class LoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                userModel.set(loginView.getUsername());
            } catch (SQLException | EmptyException ex) {
                loginView.setErrorMessageVisible();
            }
            String usedPassword=loginView.getPassword();

            if (!BCrypt.checkpw(usedPassword,userModel.getEncryptedPassword())){
                loginView.setErrorMessageVisible();
                return;
            }
            MainMenuPresenter mainMenuPresenter= new MainMenuPresenter(new MainMenuView(), userModel);
            loginView.dispose();
        }
    }

    private class OpenCreateUserAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            CreateUserPresenter createUserPresenter= new CreateUserPresenter(new CreateUserView());
            loginView.dispose();
        }
    }
}
