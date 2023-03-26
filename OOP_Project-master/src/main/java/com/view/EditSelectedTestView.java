package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EditSelectedTestView extends JFrame {

    private JPanel DisplayQuestions;
    private JLabel titleLabel;
    private JScrollPane scrollPane;
    private JPanel panelInScroll;
    private JButton createNewQuestionButton;

    public EditSelectedTestView() {
        this.setVisible(true);
        this.setContentPane(DisplayQuestions);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 900);
        scrollPane.createVerticalScrollBar();
        panelInScroll.setLayout(new BoxLayout(panelInScroll,BoxLayout.Y_AXIS));
    }

    public void addButton(String name, ActionListener actionListener){
        JButton newButton = new JButton(name);
        newButton.addActionListener(actionListener);
        panelInScroll.add(newButton);
    }

    public void add_addQuestionButton(ActionListener aL) {
        createNewQuestionButton.addActionListener(aL);
        panelInScroll.add(createNewQuestionButton);
    }
}
