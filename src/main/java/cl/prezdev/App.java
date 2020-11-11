package cl.prezdev;

import javax.swing.*;

public class App {
    public static void main( String[] args ) {
        JFrame jframe = new JFrame("Main Frame");

        jframe.setContentPane(new MainFrame().getContainerPanel());
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.pack();
        jframe.setVisible(true);
    }
}
