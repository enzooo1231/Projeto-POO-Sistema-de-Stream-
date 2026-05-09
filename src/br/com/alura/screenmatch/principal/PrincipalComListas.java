package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Movie;
import br.com.alura.screenmatch.modelos.Series;
import br.com.alura.screenmatch.modelos.Title;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalComListas {
    static void main() {
        Movie meuFilme = new Movie("O poderoso chefão", 1970);
        meuFilme.avalia(9);
        Movie outroFilme = new Movie("Avatar", 2023);
        outroFilme.avalia(8);
        var movieEnzo = new Movie("DogVille", 2003);
        movieEnzo.avalia(10);
        Series lost = new Series("Lost",2000) ;


        List<Title> titleWacthed= new ArrayList<>();
        titleWacthed.add(movieEnzo);
        titleWacthed.add(meuFilme);
        titleWacthed.add(outroFilme);
        titleWacthed.add(lost);

        for(Title t : titleWacthed){
            System.out.println(t.getNome());
            if (t instanceof Movie movie && meuFilme.getRating() > 2)
                System.out.println("Classificação: " +movie.getRating());
        }

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Carol");
        System.out.println(buscaPorArtista);
        Collections.sort(buscaPorArtista);
        System.out.println(buscaPorArtista);

        Collections.sort(titleWacthed);
        System.out.println(titleWacthed);

        /* Utilizando a interface comparator para a ordenação por ano. */

        titleWacthed.sort(Comparator.comparing(Title::getAnoDeLancamento)); /* .Reverser, dentro do comparator para mudar a ordem! */
        System.out.println("Ordenando por ano:");
        System.out.println(titleWacthed);

    }
}
