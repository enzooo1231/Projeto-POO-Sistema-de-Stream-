
import br.com.alura.screenmatch.calculo.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculo.Recommended;
import br.com.alura.screenmatch.modelos.Chapter;
import br.com.alura.screenmatch.modelos.Movie;
import br.com.alura.screenmatch.modelos.Series;

import java.util.ArrayList;


public class Principal {
    static void main() {
        Movie meuFilme = new Movie("O poderoso chefão", 1970);

        meuFilme.setDuracaoEmMinutos(180);

        meuFilme.exibeFichaTecnica();

        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.media());
        System.out.println("Total de minutos: " + meuFilme.getDuracaoEmMinutos());


       /* meuFilme.somaDasAvaliacoes = 10;
        meuFilme.totalDeAvaliacoes = 1;

        System.out.println(meuFilme.media());*/

        Series lost = new Series("Lost",2000) ;

        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração para maratonar Lost: " +lost.getDuracaoEmMinutos());


        Movie outroFilme = new Movie("Avatar", 2023);
        outroFilme.setDuracaoEmMinutos(200);

        CalculadoraDeTempo calcula = new CalculadoraDeTempo();

        calcula.inclui(meuFilme);
        calcula.inclui(outroFilme);
        calcula.inclui(lost);
        System.out.println(calcula.getTempoTotal());

        Recommended filtro = new Recommended();
        filtro.filtra(meuFilme);

        Chapter ep = new Chapter();
        ep.setNumero(1);
        ep.setSerie(lost);
        ep.setTotalVisualizacoes(300);

        filtro.filtra(ep);

        var movieEnzo = new Movie("DogVille", 2003);
        movieEnzo.setDuracaoEmMinutos(200);

        movieEnzo.avalia(10);

        ArrayList<Movie> movieLists = new ArrayList<>();
        movieLists.add(movieEnzo);
        movieLists.add(meuFilme);
        movieLists.add(outroFilme);
        System.out.println("Tamanho da lista: " +movieLists.size());
        System.out.println("Primeiro Filme: " +movieLists.get(0).getNome());

        System.out.println("toString do filme: " + movieLists);

    }
}
