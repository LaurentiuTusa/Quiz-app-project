package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateTestView extends JFrame {

    private static final JButton addQuestionButton = new JButton("Add Question");
    private static final JLabel testName = new JLabel("Test Name:");
    private static final JTextField testNameInput = new JTextField();

    public CreateTestView(){
        setVisible(true);
        setTitle("Create_Test_page");
        setSize(1200, 900);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addComponents();
    }

    private void addComponents() {
        this.addCreateQuestionButton();
        this.addTestNameLabel();
        this.addTestNameInputField();
    }

    private void addCreateQuestionButton() {
        addQuestionButton.setBounds(450, 300, 300, 40);
        addQuestionButton.setFont(new Font("Serif", Font.PLAIN, 32));
        add(addQuestionButton);
    }

    private void addTestNameLabel() {
        testName.setBounds(370, 150, 300, 40);
        testName.setFont(new Font("Serif", Font.PLAIN, 32));
        add(testName);
    }

    private void addTestNameInputField() {
        testNameInput.setBounds(520, 150, 300, 40);
        testNameInput.setFont(new Font("Serif", Font.PLAIN, 22));
        add(testNameInput);
    }

    public void setAddQuestionButtonAction(ActionListener action){
        addQuestionButton.addActionListener(action);
    }

    public String getTestName(){
        return testNameInput.getText();
    }
}
