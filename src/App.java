
import javax.swing.*;
import java.awt.*;


import classes.Calculadora;

public class App {
    public static void main(String[] args) throws Exception {

        JFrame frame = new JFrame("Calculadora");
        JLabel label = new JLabel("Opa");
        JButton button = new JButton("Clique aqui");

        frame.setVisible(true);
        frame.setBounds(1, 1, 1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        button.setBackground(new Color(128, 0, 128));
        button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Voce eh gado"));

        frame.add(label);
        frame.add(button);



    }
}
