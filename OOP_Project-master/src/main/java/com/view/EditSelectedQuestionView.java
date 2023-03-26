package com.view;

import com.model.Question;

import javax.swing.*;
import java.awt.event.ActionListener;

public class EditSelectedQuestionView extends JFrame {

    private JPanel EditSelQuestion;
    private JLabel QTxt;
    private JTextField QuestionTextField;
    private JLabel V1;
    private JTextField textFieldV1;
    private JLabel V2;
    private JTextField textFieldV2;
    private JLabel V3;
    private JTextField textFieldV3;
    private JLabel V4;
    private JTextField textFieldV4;
    private JLabel Answer;
    private JButton updateButton;
    private JComboBox answerComboBox;
    private JButton deleteTheQuestionButton;
    private Question question;

    public EditSelectedQuestionView(Question Q) {

        this.question = Q;
        setVisible(true);
        setContentPane(EditSelQuestion);
        setSize(1200, 900);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        textFieldV1.setText(question.getVariant1());
        textFieldV2.setText(question.getVariant2());
        textFieldV3.setText(question.getVariant3());
        textFieldV4.setText(question.getVariant4());
        QuestionTextField.setText(question.getQuestionText());
        answerComboBox.setSelectedIndex(question.getAnswer()-1);
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

    public void addUpdateQuestionButton(ActionListener aL) {
        updateButton.addActionListener(aL);
    }

    public void addDeleteTheQuestionButton(ActionListener aL) {
        deleteTheQuestionButton.addActionListener(aL);
        deleteTheQuestionButton.setBounds(540, 600, 200, 30);
    }
}