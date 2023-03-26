package com.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateQuestionView extends JFrame{
    private JPanel CreateQuestionPanel;
    private JTextField textFieldV1;
    private JTextField textFieldV2;
    private JTextField textFieldV3;
    private JTextField textFieldV4;
    private JTextField QuestionTextField;
    private JLabel V1;
    private JLabel V2;
    private JLabel QTxt;
    private JLabel Answer;
    private JButton createFinishButton;
    private JButton createAddMoreButton;
    private JLabel V3;
    private JLabel V4;
    private JComboBox answerComboBox;


    public CreateQuestionView() {

        setVisible(true);
        setContentPane(CreateQuestionPanel);
        setSize(1200, 900);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public String getTextFieldV1Text(){
        return textFieldV1.getText();
    }

    public String getTextFieldV2Text(){
        return textFieldV2.getText();
    }

    public String getTextFieldV3Text(){
        return textFieldV3.getText();
    }

    public String getTextFieldV4Text(){
        return textFieldV4.getText();
    }

    public String getQuestionText(){
        return QuestionTextField.getText();
    }

    public Integer getComboBoxAnswer(){
        return Integer.valueOf((String)answerComboBox.getSelectedItem());
    }

    public void setCreateFinishButtonAction(ActionListener action){
        createFinishButton.addActionListener(action);
    }

    public void setCreateAddMoreButton(ActionListener action){
        createAddMoreButton.addActionListener(action);
    }

}
