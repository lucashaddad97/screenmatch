package br.com.alura.screenmatch.desafio;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Titulo {
    public static void main(String[] args) throws IOException {
        List<Coisas> coisas = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        while (!input.equals("sair")) {
            Scanner input1 = new Scanner(System.in);
            String nome = input.nextLine();
            Integer.parseInt(ano) ano = input1.nextInt();
            System.out.println("voce digitou um nome ");
            System.out.println("voce digitou um ano");
            coisas.add(nome,ano);


            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).
                    setPrettyPrinting()
                    .create();

            FileWriter escrita = new FileWriter("desafio2.json");
            escrita.write(gson.toJson(nome));
            escrita.close();
            System.out.println("Programa finalizou correto");


        }
    }
}
