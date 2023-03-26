package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestView extends JFrame {

    static int currentQuestion = 1;
    int nrOfQuestions = 1;
    int corectCount = 0;
    private static final JRadioButton V1Button = new JRadioButton();
    private static final JRadioButton V2Button = new JRadioButton();
    private static final JRadioButton V3Button = new JRadioButton();
    private static final JRadioButton V4Button = new JRadioButton();
    private static final JRadioButton corectAnswer = V4Button;
    private static final JButton SubmitButton = new JButton("Submit");
    private static final String QuestionText = "What is the capital of Spain?";
    private static final JLabel QNr = new JLabel("Question " + currentQuestion);
    private static final JLabel QText = new JLabel(QuestionText);
    private static final String V1 = "Paris";
    private static final String V2 = "Cluj";
    private static final String V3 = "Berlin";
    private static final String V4 = "Madrid";
    private static final JLabel V1Text = new JLabel(V1);
    private static final JLabel V2Text = new JLabel(V2);
    private static final JLabel V3Text = new JLabel(V3);
    private static final JLabel V4Text = new JLabel(V4);

    public TestView(){
        setTitle("Test_page");
        setSize(1200, 900);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addComponents();
    }

    private void addComponents() {
        this.addQuestionNumber();
        this.addQuestionText();
        this.addV1Text();
        this.addV2Text();
        this.addV3Text();
        this.addV4Text();
        this.addV1Button();
        this.addV2Button();
        this.addV3Button();
        this.addV4Button();
        this.addSubmitButton();
    }

    private void addQuestionNumber() {
        QNr.setBounds(500, 10, 300, 40);
        QNr.setFont(new Font("Serif", Font.PLAIN, 32));
        add(QNr);
    }

    private void addQuestionText() {
        QText.setBounds(10, 40, 1100, 40);
        QText.setFont(new Font("Serif", Font.PLAIN, 18));
        add(QText);
    }

    private void addV1Text() {
        V1Text.setBounds(70, 250, 500, 40);
        V1Text.setFont(new Font("Serif", Font.PLAIN, 22));
        add(V1Text);
    }

    private void addV1Button() {
        V1Button.setBounds(20, 250, 40, 40);
        V1Button.setFont(new Font("Serif", Font.PLAIN, 32));
        add(V1Button);
    }

    private void addV2Text() {
        V2Text.setBounds(570, 250, 500, 40);
        V2Text.setFont(new Font("Serif", Font.PLAIN, 22));
        add(V2Text);
    }

    private void addV2Button() {
        V2Button.setBounds(520, 250, 40, 40);
        V2Button.setFont(new Font("Serif", Font.PLAIN, 32));
        add(V2Button);
    }

    private void addV3Text() {
        V3Text.setBounds(70, 350, 500, 40);
        V3Text.setFont(new Font("Serif", Font.PLAIN, 22));
        add(V3Text);
    }

    private void addV3Button() {
        V3Button.setBounds(20, 350, 40, 40);
        V3Button.setFont(new Font("Serif", Font.PLAIN, 32));
        add(V3Button);
    }

    private void addV4Text() {
        V4Text.setBounds(570, 350, 500, 40);
        V4Text.setFont(new Font("Serif", Font.PLAIN, 22));
        add(V4Text);
    }

    private void addV4Button() {
        V4Button.setBounds(520, 350, 40, 40);
        V4Button.setFont(new Font("Serif", Font.PLAIN, 32));
        add(V4Button);
    }

    private void addSubmitButton() {
        SubmitButton.setBounds(450, 650, 300, 40);
        SubmitButton.setFont(new Font("Serif", Font.PLAIN, 32));
        add(SubmitButton);

        if (currentQuestion == nrOfQuestions) {//on press go the Results page
            SubmitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if (corectAnswer.isSelected()) {
                        corectCount++;
                    }
                    dispose();
                    ResultsView resultsView = new ResultsView();
                    resultsView.setVisible(true);
                }
            });
        }
        else {//mergi la urmatoarea intrebare
            SubmitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if (corectAnswer.isSelected()) {
                        corectCount++;
                    }
                    currentQuestion++;
                }
            });
        }

    }


}
