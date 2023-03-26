package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SelectTestView extends JFrame{
    private JLabel titleLabel;
    private JPanel selectTestPanel;
    private JScrollPane scrollPane;
    private JPanel panelInScroll;

    public SelectTestView() {
        this.setVisible(true);
        this.setSize(1200, 900);
        this.setContentPane(selectTestPanel);
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
