package Exercicios;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class buscaCep {

    static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();


    static void main() throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);

        String busca;

        try{
            System.out.println("Digite seu CEP | Neste formato ---> (123456789): ");
            busca = sc.nextLine();

            String url = "https://viacep.com.br/ws/"+ busca +"/json/";


            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(" - ");

            String json = response.body();

            CepAPI cepAPI = gson.fromJson(json, CepAPI.class);
            Cep meuCep = new Cep(cepAPI);
            System.out.println("Cep convertido!");

            System.out.println(meuCep);

            FileWriter arquivoJson = new FileWriter("Cep.json");
            arquivoJson.write(gson.toJson(meuCep));
            arquivoJson.close();

        }catch (JsonSyntaxException e){
            System.out.println("CEP digitado incorretamente");
        }finally {
            System.out.println();
            System.out.println("O programa finalizou corretamente!");
        }



    }

}
