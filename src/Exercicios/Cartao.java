package Exercicios;

import java.util.List;

public class Cartao {

    private double limite;
    private double saldo;
    private List <Compras> compras;

    public Cartao(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.compras = compras;
    }

    public Boolean debitar(Compras compra){
        if (this.saldo > compra.getValor()){
            saldo = saldo - compra.getValor();
            return true;
        }else {
            return false;
        }

    }

    public double getLimite() {
        return limite;
    }



    public double getSaldo() {
        return saldo;
    }



    public List<Compras> getCompras() {
        return compras;
    }

    public void setCompras(List<Compras> compras) {
        this.compras = compras;
    }
}
