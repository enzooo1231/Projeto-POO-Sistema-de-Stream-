import java.util.Scanner;

public class Livro {

    private String titulo;
    private String autor;

    static Scanner sc = new Scanner(System.in);

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void exibirDetalhes(){

        String resp;

        System.out.println("Deseja exibir detalhes?(Sim/Não)");
        resp = sc.next();

        if (resp.equalsIgnoreCase("Sim")){
            System.out.println("Títulos: "+getTitulo());
            System.out.println("Autor: "+ getAutor());
        }else {
            System.out.println("OK, detalhes não exibidos!");
        }

    }
}
