package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excecao.ErroDeCoversaoDeAno;
import com.google.gson.annotations.SerializedName;

public class Title implements Comparable<Title> {

    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;


    public Title(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Title(TituloOmdb tituloOmdb) {
        this.nome = tituloOmdb.title();

        if (tituloOmdb.year().length() > 4 ){
            throw new ErroDeCoversaoDeAno("Conversão inválida!" +
                    " Ano possui mais de 04 caracteres");
        }

        this.anoDeLancamento = Integer.valueOf(tituloOmdb.year());

        this.duracaoEmMinutos = Integer.valueOf(tituloOmdb.runtime().substring(0, 3));
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public int getTotalDeAvaliacoes(){
        return totalDeAvaliacoes;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome do Titulo: " +nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double media (){

        return somaDasAvaliacoes/totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Title outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "Title{" +
                "nome='" + nome + '\'' +
                ", anoDeLancamento=" + anoDeLancamento +
                ", duracaoEmMinutos=" + duracaoEmMinutos +
                '}';
    }
}
