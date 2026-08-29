package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeCoversaoDeAno;
import br.com.alura.screenmatch.factory.FactoryRequest;
import br.com.alura.screenmatch.modelos.Title;

import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    static void main() throws IOException {


        List<Title> lista = new ArrayList<>();

        FactoryRequest factory = new FactoryRequest();

        Scanner sc = new Scanner(System.in);

        String busca = "";

        while(!busca.equalsIgnoreCase("sair")) {

            System.out.println("Digite o nome para a busca: ");
            busca = sc.nextLine();

            if (busca.equalsIgnoreCase("sair")){
                break;
            }

            try {
                lista.add(factory.pesquisa(busca));

            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());

            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço!");

            } catch (ErroDeCoversaoDeAno e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Aconteceu algo!");
            }

        }

        System.out.println(lista);

        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(factory.getGson().toJson(lista));
        escrita.close();
        System.out.println("O programa finalizou corretamente!");

    }


}
