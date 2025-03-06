package classes;

import classes.operacoes.*;
import java.util.Scanner;

public class Calculadora {
    private int x;
    private int y;

    Scanner scan = new Scanner(System.in);

    public void menu() {
        System.out.println("Calculadora em Java\n");
        System.out.println("+ - Adicao");
        System.out.println("- - Subtracao");
        System.out.println("* - Multiplicacao");
        System.out.println("/ - Divisao");
        System.out.println("% - Porcentagem");
        System.out.println("Outro - Sair\n");

        char opc;

        System.out.print("Insira um numero: ");
        x = scan.nextInt();

        System.out.print("Selecione uma operacao: ");
        opc = scan.next().charAt(0);

        System.out.print("Insira outro numero: ");
        y = scan.nextInt();

        Adicao adicao = new Adicao(x, y);
        Subtracao subtracao = new Subtracao(x, y);
        Multiplicacao multiplicacao = new Multiplicacao(x, y);
        Divisao divisao = new Divisao(x, y);
        Porcentagem porcentagem = new Porcentagem(x, y);

        switch (opc) {
            case '+':
                System.out.println("Resultado: " + adicao.adicao());
                break;

            case '-':
                System.out.println("Resultado: " + subtracao.subtracao());
                break;

            case '*':
                System.out.println("Resultado: " + multiplicacao.multiplicacao());
                break;

            case '/':
                System.out.println("Resultado: " + divisao.divisao());
                break;

            case '%':
                System.out.println("Resultado: " + porcentagem.porcentagem());
                break;

            default:
                System.out.println("Encerrando...");
                break;
        }
    }
}
