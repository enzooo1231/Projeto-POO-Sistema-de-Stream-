package br.com.alura.screenmatch.calculo;

public class Recommended {

    public void filtra(Rating rating){
        if (rating.getRating() >= 4){
            System.out.println("Está entre os preferidos do momento");
        }else if (rating.getRating() >= 2){
            System.out.println("Muito bem avaliado no momento!");
        }else {
            System.out.println("Coloque na sua lista e assista depois!");
        }
    }
}
