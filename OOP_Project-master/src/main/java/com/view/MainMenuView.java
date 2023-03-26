package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenuView extends JFrame {
    private JPanel MainMenuPanel;
    private JLabel titleLabel;
    private JButton selectTestButton;
    private JButton createTestButton;
    private JButton editTestButton;

    public MainMenuView() throws HeadlessException {
        this.setVisible(true);
        this.setSize(1200, 900);
        this.setContentPane(MainMenuPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setSelectTestButtonAction(ActionListener action){
        selectTestButton.addActionListener(action);
    }
    public void setCreateTestButtonAction(ActionListener action){
        createTestButton.addActionListener(action);
    }
    public void setEditTestButtonAction(ActionListener action){
        editTestButton.addActionListener(action);
    }
}
