import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //============Scanner Lendo apenas 1 palavra
//        String nome;
//        int idade;
//        System.out.println("Aguardando um Nome...");
//        nome = sc.next();
//        System.out.println("A partir de agora vou te chamar de " + nome);
//
//        System.out.println("Aguardando uma Idade...");
//        idade = sc.nextInt();
//        System.out.println(nome + " possui " + idade + " anos.");



        //===========Scanner Lendo uma Linha até pressionar ENTER
//        String frase1, frase2, frase3;
//        int oi;
//        frase1 = sc.nextLine();// nextLine para ler uma linha inteira
//        frase2 = sc.nextLine();
//        frase3 = sc.nextLine();
//
//        System.out.println("Frases digitadas:");
//        System.out.println(frase1);
//        System.out.println(frase2);
//        System.out.println(frase3);



        //================Operações Matemáticas
        double x = 3.0;
        double y = 4.0;
        double z = -5.0;
        double A, B, C;

        A = Math.sqrt(x);
        B = Math.sqrt(y);
        C = Math.sqrt(z);
        System.out.println("Raiz Quadrada de " + x + " = " + A);
        System.out.println("Raiz Quadrada de " + y + " = " + B);
        System.out.println("Raiz Quadrada de " + z + " = " + C);


        A = Math.pow(x, y);
        B = Math.pow(x, 2.0);
        C = Math.pow(5.0, 2.0);
        System.out.println(x + " elevado a " + y + " = " + A);
        System.out.println(x + " elevado ao quadrado = " + B);
        System.out.println("5 elevado ao quadrado = " + C);


        A = Math.abs(y);
        B = Math.abs(z);
        System.out.println("Valor Absoluto de " + y + " = " + A);
        System.out.println("Valor Absoluto de " + z + " = " + B);
        sc.close();
        }
}