public class Produto {

    private String nome;
    private double [] notas;

    public double[] getNotas() {
        return notas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNotas(double [] notas) {
        this.notas = notas;

    }

    public double media (){

        double soma = 0;
        for (int i=0; i < notas.length; i++){
            soma += notas[i];
        }

        return soma/ notas.length;
    }
}
