package gui;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener {
    JLabel jf;
    JButton jb;
    Bull gs;

    Listener(JLabel jt, JButton b, Bull gs) {
        jf = jt;
        jb = b;
        this.gs = gs;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jb.getText().equals("C")) {
            jf.setText(null);
            gs.seteq(true);
        } else if (gs.geteq()) {
            jf.setText(null);
            gs.seteq(true);
            jf.setText(jb.getText());
            gs.seteq(false);
        }  else {
            jf.setText(jf.getText() + jb.getText());
        }
    }

}
