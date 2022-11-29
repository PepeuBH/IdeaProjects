import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite dois valores...");

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int maior;
        maior = higher(a, b, c);

        System.out.println();
        showResults(maior);

        sc.close();
    }


    private static void showResults(int aux){
        System.out.println(aux);
    }
    private static int higher(int a, int b, int c) {
        int aux;
        if(a > b && a >c){
            aux = a;
        }else if(b > c){
            aux = b;
        }else
            aux = c;

        return aux;
    }


    
}