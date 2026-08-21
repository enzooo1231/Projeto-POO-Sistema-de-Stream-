package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeCoversaoDeAno;
import br.com.alura.screenmatch.modelos.Title;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PrincipalComBusca {
    static void main() throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome para a busca: ");
        var busca = sc.nextLine();
        var buscaTratada = URLEncoder.encode(busca, StandardCharsets.UTF_8);


        String endereco = "http://www.omdbapi.com/?t=" + buscaTratada + "&apikey=25ab2c31";

        try{

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());



            System.out.println(" - ");

            String json = response.body();

            // System.out.println(json);

            Gson gson =  new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

            //Title titulo = gson.fromJson(json, Title.class);

            TituloOmdb tituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(tituloOmdb);

            System.out.println();

            //try{
            Title titulo = new Title(tituloOmdb);
            System.out.println("Titulo convertido");
            System.out.println(titulo);

            FileWriter escrita = new FileWriter("filmes.txt");
            escrita.write(titulo.toString());
            escrita.close();

        }catch (NumberFormatException e){
            System.out.println("Aconteceu um erro: ");
            System.out.println(e.getMessage());


        }catch (IllegalArgumentException e ){
            System.out.println("Algum erro de argumento na busca, verifique o endereço!");

        }catch (ErroDeCoversaoDeAno e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("Aconteceu algo!");
        }
        finally {
            System.out.println("O programa finalizou corretamente!");
        }




    }
}
