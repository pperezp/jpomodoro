package cl.prezdev;

import javax.swing.*;

public class App {
    public static void main( String[] args ) {
        JFrame jframe = new JFrame("Main Frame");

        jframe.setContentPane(new MainFrame().getContainerPanel());
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.pack();
        jframe.setBounds(jframe.getX(), jframe.getY(), 150, 29);

        jframe.setAlwaysOnTop(true);
        jframe.setVisible(true);
    }
}
