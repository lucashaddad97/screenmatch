package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.exceçao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite filme para busca: ");
        var busca = leitura.nextLine();
        String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") +"&apikey=d38c455f" ;
        try{

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request,HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

//        Titulo meutitulo = gson.fromJson(response.body(), Titulo.class);
        TituloOmdb meuTituloOmdb = gson.fromJson(response.body(), TituloOmdb.class);
      System.out.println(meuTituloOmdb);
//        try{
            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println(meuTitulo);
        } catch (NumberFormatException e) {
            System.out.println("Erro ao buscar Titulo Omdb");
            System.out.println(e.getMessage());;
        }catch (ErroDeConversaoDeAnoException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Programa finailizou correto");



    }
}
