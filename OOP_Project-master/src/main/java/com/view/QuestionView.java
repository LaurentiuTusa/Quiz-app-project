package com.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class QuestionView extends JFrame{
    private JPanel questionPanel;
    private JLabel titleLabel;
    private JLabel questionText;
    private JRadioButton v1RadioButton;
    private JRadioButton v2RadioButton;
    private JRadioButton v3RadioButton;
    private JRadioButton v4RadioButton;
    private JButton submitButton;
    private ButtonGroup answerButtonGroup;

    public QuestionView(){
        this.setVisible(true);
        this.setContentPane(questionPanel);
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v1RadioButton.setActionCommand("V1");
        v2RadioButton.setActionCommand("V2");
        v3RadioButton.setActionCommand("V3");
        v4RadioButton.setActionCommand("V4");
    }


    public void setSubmitButtonAction(ActionListener action){
        submitButton.addActionListener(action);
    }

    public void setV1RadioButtonAction(ActionListener action) {
        v1RadioButton.addActionListener(action);
    }

    public void setV2RadioButtonAction(ActionListener action) {
        v2RadioButton.addActionListener(action);
    }

    public void setV3RadioButtonAction(ActionListener action) {
        v3RadioButton.addActionListener(action);
    }

    public void setV4RadioButtonAction(ActionListener action) {
        v4RadioButton.addActionListener(action);
    }

    public void setQuestionText(String text){
        questionText.setText(text);
    }

    public void setV1RadioButtonText(String text){
        v1RadioButton.setText(text);
    }

    public void setV2RadioButtonText(String text){
        v2RadioButton.setText(text);
    }

    public void setV3RadioButtonText(String text){
        v3RadioButton.setText(text);
    }

    public void setV4RadioButtonText(String text){
        v4RadioButton.setText(text);
    }

    public void setTitle(String text){
        titleLabel.setText(text);
    }

}
