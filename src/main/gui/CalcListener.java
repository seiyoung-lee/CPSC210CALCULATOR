package gui;

import exceptions.CannotDivideByZero;
import exceptions.ForgotToWrite;
import functions.ComplexSimpleFunc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class CalcListener extends Listener {

    public CalcListener(JLabel jf, JButton b, Bull gs) {
        super(jf, b, gs);
    }

    @Override
    public void actionPerformed(ActionEvent e)  {
        if (jb.getText().equals("=")) {
            gs.seteq(true);
            try {
                ComplexSimpleFunc csf = new ComplexSimpleFunc(jf.getText());
                jf.setText(String.valueOf(csf.functionequals()));
            } catch (ForgotToWrite | CannotDivideByZero | IOException forgotToWrite) {
                jf.setText("ERROR");
            }
        } else {
            super.actionPerformed(e);
        }
    }

}
