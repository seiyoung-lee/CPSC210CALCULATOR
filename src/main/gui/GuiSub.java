package gui;



import javax.swing.*;
import java.awt.*;

public class GuiSub implements Runnable {

    @Override
    public void run() {
        JFrame frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(500,1000));

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        createcontainer(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void createcontainer(Container c) {
        Bull bull = new Bull();
        GridLayout glt = new GridLayout(6,1);
        JLabel jt = new JLabel();
        jt.setFont(new Font("Verdana",Font.BOLD,30));
        c.setLayout(glt);
        c.add(jt);
        c.add(makepanelonoff(jt, bull, c));
        c.add(makepanel(9,7,jt,"+",bull));
        c.add(makepanel(6,4,jt,"-",bull));
        c.add(makepanel(3,1,jt, "*",bull));
        c.add(makepanel0(jt, bull));
    }

    private JPanel makepanelonoff(JLabel jt, Bull bull, Container c) {
        GridLayout gl = new GridLayout(1,4);
        JPanel jp = new JPanel();
        jp.setLayout(gl);
        JRadioButton on = new JRadioButton("on");
        JRadioButton off = new JRadioButton("off");
        addlisteners(on, off, c);
        jp.add(makepanelforon(on,off));
        jp.add(new JButton("."));
        jp.add(new JButton("l"));
        jp.add(new JButton("^"));
        JButton b;
        for (int i = 3; i >= 1; i--) {
            b = (JButton) jp.getComponent(i);
            b.addActionListener(new CalcListener(jt, b, bull));
        }
        return jp;
    }

    private JPanel makepanelforon(JRadioButton on, JRadioButton off) {
        GridLayout gl = new GridLayout(2,1);
        JPanel jp = new JPanel();
        jp.setLayout(gl);
        jp.add(on);
        jp.add(off);
        return jp;
    }

    private void addlisteners(JRadioButton on, JRadioButton off, Container c) {
        ButtonGroup bg = new ButtonGroup();
        bg.add(on);
        bg.add(off);
        on.addActionListener(new NotifyContainer(on, c));
        off.addActionListener(new NotifyContainer(off, c));
    }


    private JPanel makepanel(int f, int l, JLabel jt, String ope, Bull bull) {
        GridLayout gl = new GridLayout(1,4);
        JPanel jp = new JPanel();
        jp.setLayout(gl);
        JButton b;
        for (int i = f; i >= l; i--) {
            jp.add(new JButton("" + i));
        }
        jp.add(new JButton(ope));
        for (int i = 3; i >= 0; i--) {
            b = (JButton) jp.getComponent(i);
            b.addActionListener(new Listener(jt,b,bull));
        }
        return jp;
    }

    private JPanel makepanel0(JLabel jt, Bull bull) {
        GridLayout gl = new GridLayout(1,4);
        JPanel jp = new JPanel();
        jp.setLayout(gl);
        JButton b;
        jp.add(new JButton("C"));
        jp.add(new JButton("" + 0));
        jp.add(new JButton("="));
        jp.add(new JButton("/"));
        for (int i = 3; i >= 0; i--) {
            b = (JButton) jp.getComponent(i);
            b.addActionListener(new CalcListener(jt, b, bull));
        }
        return jp;
    }
}
