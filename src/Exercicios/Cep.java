package Exercicios;

public class Cep {

    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;

    public Cep(CepAPI cepAPI) {
        this.cep = cepAPI.cep();
        this.logradouro = cepAPI.logradouro();
        this.bairro = cepAPI.bairro();
        this.cidade = cepAPI.localidade();
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    @Override
    public String toString() {
        return "CEP: " + getCep() + " | " + "Logradouro: " + getLogradouro() + " | " + "Bairro: " +getBairro() + " | " + "Cidade: " +getCidade();
    }
}
