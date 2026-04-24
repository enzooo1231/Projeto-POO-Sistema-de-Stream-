package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Movie;
import br.com.alura.screenmatch.modelos.Series;
import br.com.alura.screenmatch.modelos.Title;

import java.util.ArrayList;

public class PrincipalComListas {
    static void main() {
        Movie meuFilme = new Movie("O poderoso chefão", 1970);
        meuFilme.avalia(9);
        Movie outroFilme = new Movie("Avatar", 2023);
        outroFilme.avalia(8);
        var movieEnzo = new Movie("DogVille", 2003);
        movieEnzo.avalia(10);
        Series lost = new Series("Lost",2000) ;


        ArrayList<Title> titleWacthed= new ArrayList<>();
        titleWacthed.add(movieEnzo);
        titleWacthed.add(meuFilme);
        titleWacthed.add(outroFilme);
        titleWacthed.add(lost);

        for(Title t : titleWacthed){
            System.out.println(t);

            System.out.println("Classificação: " + meuFilme.getRating());
        }
    }
}
