import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Produto produto = new Produto(); //instanciação de um produto

        //Lendo as informacoes do produto
        System.out.println("Enter product name:");
        produto.nome = sc.nextLine();

        System.out.println("Enter product price:");
        produto.preco = sc.nextDouble();

        System.out.println("Enter product Quantity in Stock");
        produto.quant = sc.nextInt();

        System.out.println("Product Data: " + produto.nome + ", $ " + produto.preco + ", " + produto.quant + " units, $" + produto.totalValueInStock() + " Total Value In Stock");

        //Inicio Menu de opções
        int op;

        do{
            System.out.println("Type 1 to add product to stock \nType 2 to remove product from stock\nType 0 to exit");
            op = sc.nextInt();

            switch (op){
                case 1:
                    System.out.println("Number of products to be add in stock.");
                    int quantToAdd = sc.nextInt();
                    produto.addProduto(quantToAdd);
                    System.out.println("Product update: " + produto.nome + ", " + produto.quant + " units, $ " + produto.totalValueInStock() + " Total Value In Stock");
                    break;

                case 2:
                    System.out.println("Number of products to be removed from stock.");
                    int quantToRemove = sc.nextInt();
                    produto.removeProduto(quantToRemove);
                    System.out.println("Product update: " + produto.nome + ", " + produto.quant + " units, $ " + produto.totalValueInStock() + " Total Value In Stock");
                    break;
            }
        }while(op != 0);

        System.out.println("Exiting...");



        sc.close();
    }
}