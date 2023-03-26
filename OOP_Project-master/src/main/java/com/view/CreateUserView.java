package com.view;

import com.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CreateUserView extends JFrame {
    private JPanel createUser;
    private JTextField usernameField;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JLabel usernameLabel;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JButton createButton;
    private JLabel titleLabel;
    private JLabel errorMessage;

    public CreateUserView() {
        this.setVisible(true);
        this.setSize(1200, 900);
        this.setContentPane(createUser);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        errorMessage.setVisible(false);
    }

    public void addActionListenerToButton(ActionListener actionListener) {
        createButton.addActionListener(actionListener);
    }

    public String getUserName(){
        return usernameField.getText();
    }

    public String getName(){
        return nameField.getText();
    }

    public String getPassword(){
        return String.valueOf(passwordField.getPassword());
    }

    public void setErrorMessageVisible(){
        errorMessage.setVisible(true);
    }
}
