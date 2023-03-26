package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JPanel loginMain;
    private JLabel titleLabel;
    private JTextField usernameField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JLabel errorMessage;
    private JButton createUserButton;

    public LoginView(){
        this.setSize(1200, 900);
        this.setVisible(true);
        this.setContentPane(loginMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        errorMessage.setVisible(false);
    }
    public String getUsername(){
        return usernameField.getText();
    }

    public String getPassword(){
        return String.valueOf(passwordField1.getPassword());
    }

    public void setLoginButtonAction(ActionListener action){
        loginButton.addActionListener(action);
    }

    public void setCreateUserButtonAction(ActionListener action){
        createUserButton.addActionListener(action);
    }
    public void setErrorMessageVisible(){
        errorMessage.setVisible(true);
    }
    public void setErrorMessageText(String txt){
        errorMessage.setText(txt);
    }
}
