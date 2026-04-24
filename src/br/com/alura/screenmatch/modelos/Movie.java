package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculo.Rating;

public class Movie extends Title implements Rating {
    private String diretor;

    public Movie(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }


    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getRating() {
           return (int) media()/2;
    }

    @Override
    public String toString() {
        return "Filme: " + this.getNome() + "(" + this.getAnoDeLancamento() + ")";
    }
}
