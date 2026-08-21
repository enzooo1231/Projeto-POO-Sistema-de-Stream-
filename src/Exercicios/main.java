package Exercicios;

import java.util.*;

public class main {

    static Scanner sc = new Scanner(System.in);
    static void main() {

        System.out.println("Digite o limite do seu cartão: ");
        double limite = sc.nextDouble();

        Cartao cartao = new Cartao(limite);

        int opcao;

        do {
            System.out.println("Digite a descrição do prodduto: ");
            String descr = sc.next();

            System.out.println("Digite o valor do produto: ");
            double valor = sc.nextDouble();

            Compras compras = new Compras(valor, descr);
            Boolean compraRealizada = cartao.debitar(compras);

            if (compraRealizada){
                System.out.println("Compra realizada!");
                System.out.println("Deseja continuar comprando? (Sim - 1 | Não - 0");
                opcao = sc.nextInt();
            }else {
                System.out.println("Compra negada!");
                opcao = 0;
            }


        }while (opcao == 1);

        System.out.println();
        System.out.println("**** Compra Realizada ****");
        Collections.sort(cartao.getCompras());
        for (Compras c : cartao.getCompras() ){
            System.out.println(c.getValor() + " |" + c.getDescr());
        }

        System.out.println("Saldo do cartão: " + cartao.getSaldo());
    }
}
