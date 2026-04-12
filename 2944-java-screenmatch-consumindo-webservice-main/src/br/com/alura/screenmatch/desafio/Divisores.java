package br.com.alura.screenmatch.desafio;


import java.util.Scanner;

public class Divisores {
    static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        try {
            System.out.print("Digite o numerador: ");
            int numerador = leitura.nextInt();
            System.out.print("Digite o denominador: ");
            int denominador = leitura.nextInt();
            if (denominador == 0) {
                throw new RuntimeException("deve ser um valor diferente de zero");
            }
            int resultado = numerador / denominador;
            System.out.println(denominador + "/" + numerador + " = " + resultado);
        }catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println("entrad invalida");

        }
        leitura.close();
    }


}
