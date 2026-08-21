package br.com.alura.screenmatch.excecao;

public class ErroDeCoversaoDeAno extends RuntimeException {
    private String mensagem;

    public ErroDeCoversaoDeAno(String mensagem) {
        this.mensagem = mensagem;
    }

    

    @Override
    public String getMessage() {
        return this.mensagem;
    }


}
