package Exercicios;

public class Compras implements Comparable <Compras>{

    private double valor;
    private String descr;

    public Compras(double valor, String descr) {
        this.valor = valor;
        this.descr = descr;
    }


    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public String toString() {
        return "Exercicios.Compras (" +
                "valor=" + valor +
                ", Descr='" + descr + '\'' +
                ')';
    }

    @Override
    public int compareTo(Compras outraCompra) {
        return Double.valueOf(this.valor).compareTo(outraCompra.valor);
    }
}
