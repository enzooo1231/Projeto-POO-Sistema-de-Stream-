package br.com.alura.screenmatch.calculo;

import br.com.alura.screenmatch.modelos.Title;

public class CalculadoraDeTempo {

    private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

//    public void inclui(Movie f){
//        tempoTotal+= f.getDuracaoEmMinutos();
//    }
//
//    public void inclui(Series s){
//        tempoTotal+= s.getDuracaoEmMinutos();
//    }

    public void inclui (Title titulo){
        System.out.println("Adicionando duração em minutos de " + titulo);
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
