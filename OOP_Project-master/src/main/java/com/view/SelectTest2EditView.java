package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SelectTest2EditView extends JFrame {
    private JPanel selectTest2EditPanel;
    private JLabel titleLabel;
    private JScrollPane scrollPane;
    private JPanel panelInScroll;

    public SelectTest2EditView() {
        this.setVisible(true);
        this.setContentPane(selectTest2EditPanel);
        this.setSize(1200, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scrollPane.createVerticalScrollBar();
        panelInScroll.setLayout(new BoxLayout(panelInScroll,BoxLayout.Y_AXIS));
    }

    public void addButton(String name,ActionListener actionListener){
        JButton newButton = new JButton(name);
        newButton.addActionListener(actionListener);
        panelInScroll.add(newButton);
    }

}
