package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculo.Rating;

public class Movie extends Title implements Rating {
    private String diretor;

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
}
