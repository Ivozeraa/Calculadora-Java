import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class CalculadoraGUI extends JFrame {
    private JTextField campoResultado;
    private String operacao = "";
    private double num1, num2;
    private boolean novoNumero = true;
    private DecimalFormat df = new DecimalFormat("#.##");

    public CalculadoraGUI() {
        setTitle("Calculadora");
        setSize(350, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        // Campo de resultado estilo iOS
        campoResultado = new JTextField("0");
        campoResultado.setFont(new Font("Arial", Font.BOLD, 40));
        campoResultado.setHorizontalAlignment(JTextField.RIGHT);
        campoResultado.setEditable(false);
        campoResultado.setBackground(Color.BLACK);
        campoResultado.setForeground(Color.WHITE);
        add(campoResultado, BorderLayout.NORTH);
        
        // Painel de botões
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 4, 5, 5));
        painel.setBackground(Color.BLACK);
        
        // Definição dos botões
        String[] botoes = {
            "AC", "+/-", "%", "÷",
            "7", "8", "9", "×",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", "", ".", "="
        };
        
        for (String text : botoes) {
            JButton botao = criarBotao(text);
            painel.add(botao);
        }
        
        add(painel, BorderLayout.CENTER);
    }
    
    private JButton criarBotao(String text) {
        JButton botao = new JButton(text);
        botao.setFont(new Font("Arial", Font.BOLD, 20));
        botao.setFocusable(false);
        botao.setBorderPainted(false);
        botao.setOpaque(true);
        
        if (text.matches("[0-9]") || text.equals(".")) {
            botao.setBackground(new Color(51, 51, 51)); // Cinza escuro
            botao.setForeground(Color.WHITE);
        } else if (text.equals("AC") || text.equals("+/-") || text.equals("%")) {
            botao.setBackground(new Color(160, 160, 160)); // Cinza claro
            botao.setForeground(Color.BLACK);
        } else {
            botao.setBackground(new Color(255, 149, 0)); // Laranja (operações)
            botao.setForeground(Color.WHITE);
        }
        
        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processarEntrada(text);
            }
        });
        return botao;
    }
    
    private void processarEntrada(String input) {
        if (input.matches("[0-9]") || input.equals(".")) {
            if (novoNumero) {
                campoResultado.setText(input);
                novoNumero = false;
            } else {
                campoResultado.setText(campoResultado.getText() + input);
            }
        } else if (input.equals("AC")) {
            campoResultado.setText("0");
            num1 = num2 = 0;
            operacao = "";
            novoNumero = true;
        } else if (input.equals("+/-")) {
            double valor = Double.parseDouble(campoResultado.getText());
            campoResultado.setText(df.format(valor * -1));
        } else if (input.equals("%")) {
            double valor = Double.parseDouble(campoResultado.getText());
            campoResultado.setText(df.format(valor / 100));
        } else if (input.equals("=")) {
            num2 = Double.parseDouble(campoResultado.getText());
            double resultado = calcular(num1, num2, operacao);
            campoResultado.setText(df.format(resultado));
            novoNumero = true;
        } else {
            num1 = Double.parseDouble(campoResultado.getText());
            operacao = input;
            novoNumero = true;
        }
    }
    
    private double calcular(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "×": return a * b;
            case "÷": return (b != 0) ? a / b : 0;
            default: return 0;
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculadoraGUI().setVisible(true));
    }
}