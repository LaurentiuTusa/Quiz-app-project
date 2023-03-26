package com.presenter;

import com.model.User;
import com.view.CreateUserView;
import com.view.LoginView;
import org.mindrot.jbcrypt.BCrypt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CreateUserPresenter {
    private final CreateUserView createUserView;
    private final User userModel= new User();

    public CreateUserPresenter(CreateUserView createUserView) {
        this.createUserView = createUserView;

        createUserView.addActionListenerToButton(new CreateUserAction());
    }

    private class CreateUserAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String name=createUserView.getName();
            String username=createUserView.getUserName();
            String password=createUserView.getPassword();
            password= BCrypt.hashpw(password,BCrypt.gensalt());
            try {
                User.create(username,name,password);
            } catch (SQLException ex) {

                createUserView.setErrorMessageVisible();
                ex.printStackTrace();
            }
            createUserView.dispose();
            LoginPresenter loginPresenter = new LoginPresenter(new LoginView());
        }
    }
}
