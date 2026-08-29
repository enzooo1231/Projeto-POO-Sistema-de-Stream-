package br.com.alura.screenmatch.factory;

import br.com.alura.screenmatch.modelos.Title;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;


public class FactoryRequest {

    Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    public Gson getGson() {
        return gson;
    }

    public Title pesquisa(String busca) throws IOException, InterruptedException {



        var buscaTratada = URLEncoder.encode(busca, StandardCharsets.UTF_8);

        String endereco = "http://www.omdbapi.com/?t=" + buscaTratada + "&apikey=";


        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(" - ");

        String json = response.body();


        TituloOmdb tituloOmdb = gson.fromJson(json, TituloOmdb.class);
        System.out.println(tituloOmdb);

        System.out.println();

        Title meuTitulo = new Title(tituloOmdb);
        System.out.println("Titulo convertido");


        return meuTitulo;
    }


}
