package com.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultsView extends JFrame{
    private JPanel Results;
    private JLabel CorrectAnswersLabel;
    private JButton MENUButton;
    private JLabel amount;
    private JLabel percent;


    public ResultsView() {
        setVisible(true);
        setContentPane(Results);
        setSize(1200, 900);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void setAmountText(String text){
        amount.setText(text);
    }

    public void setPercentText(String text){
        percent.setText(text);
    }

    public  void setMENUButtonAction(ActionListener action){
        MENUButton.addActionListener(action);
    }
}
