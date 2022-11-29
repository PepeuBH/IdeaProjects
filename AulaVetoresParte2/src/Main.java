import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tamVetor = 2;
        Produto[] vetorProdutos = new Produto[tamVetor];

        for(int i = 0; i < vetorProdutos.length; i++){
            String nome = sc.nextLine();
            String cor = sc.nextLine();
            vetorProdutos[i] = new Produto(nome, cor);
        }

        for (Produto p : vetorProdutos) {
            System.out.println(p.toString());
        }


        sc.close();
    }
}