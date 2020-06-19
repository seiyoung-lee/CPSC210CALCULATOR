package gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotifyContainer implements ActionListener {
    private JRadioButton jb;
    private Container con;

    NotifyContainer(JRadioButton b, Container c) {
        jb = b;
        this.con  = c;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (jb.getText().equals("off")) {
            change(false);
        } else {
            change(true);
        }
    }

    private void change(Boolean boo) {
        JPanel jp;
        JButton b;
        for (int i = 1; i <= 5; i++) {
            jp = (JPanel) con.getComponent(i);
            if (i == 1) {
                b = (JButton) jp.getComponent(1);
                b.setEnabled(boo);
                b = (JButton) jp.getComponent(2);
                b.setEnabled(boo);
                b = (JButton) jp.getComponent(3);
                b.setEnabled(boo);
            } else {
                for (int h = 0; h <= 3; h++) {
                    b = (JButton) jp.getComponent(h);
                    b.setEnabled(boo);
                }
            }
        }
    }

}
