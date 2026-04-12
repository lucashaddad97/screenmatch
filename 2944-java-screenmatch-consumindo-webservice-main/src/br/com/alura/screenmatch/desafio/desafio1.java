package br.com.alura.screenmatch.desafio;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class desafio1 {
    public static void main(String[] args) throws IOException {
        System.out.println("Digite uma palavra a ser salva.");
        Scanner input = new Scanner(System.in);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        FileWriter escrita = new FileWriter("arquivo1.txt");
        escrita.write(input.nextLine());

        escrita.close();
        System.out.println("Programa finalizou correto");

    }
}
