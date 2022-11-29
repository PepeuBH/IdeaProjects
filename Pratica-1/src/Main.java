import java.util.Locale; // classe para muda o idioma
import java.util.Scanner; // entrada de dados padrão do Java

public class Main {
    public static void main(String[] args) {

        //Locale.setDefault(Locale.US); //transforma "," em "."

        // %n => quebra linha
        // %d => para Int
        // %f => para Float
        // %s => para String
        //System.out.printf() saída de dados formatada, usa-se %.2f por exemplo
//        System.out.println("Hello World!");
//        int num = 17;
//        System.out.println(num);
//        System.out.println("teste " + num);
//        double numFloat = 10.328594237;
//        System.out.printf("teste %.2f %n", numFloat);
//        System.out.printf("teste %.4f %n", numFloat);

        //=======================================================Pratica 1

        System.out.println("Pratica 1");
        String product1 = "Computer";
        String product2 = "Office Desk";

        int age = 30;
        int code = 5290;

        char gender = 'F';

        double price1 = 2100.0;
        double price2 = 650.50;
        double measure = 53.234567;

        System.out.println("Products:");
        System.out.printf(product1 + " which price is %.2f %n", price1);
        System.out.printf(product2 + " which price is %.2f %n", price2);

        System.out.println("Record: " + age + " years old, code " + code + " and gender " + gender);

        System.out.printf("Measure: %.8f %n", measure);
        System.out.printf("Measure (rouded): %.3f %n",measure);


        //=========================================================Pratica 2

        System.out.println("Pratica 2");

        double baseMenor, altura, baseMaior, area;

        baseMenor = 6.0;
        baseMaior = 8.0;
        altura = 5.0;

        area = (baseMenor + baseMaior) / 2 * altura;

        System.out.println("Area do trapezio = " + area);

        //=======================================================Pratica 3

        System.out.println("Pratica 3 - Casting");

        int a = 5;
        int b = 2;
        double resultado = 0;

        resultado = (double)a / b; // o (double) transforma o valor de int para double, sem ele o resultado seria 2.0 ao invés de 2.5

        System.out.println("O resultado e: " + resultado);


        //=======================================================Pratica 4

        System.out.println("Pratica 4 - Entrada de Dados Com Scanner");

        Scanner sc = new Scanner(System.in); // abrir o método de Entrada de dados

            System.out.println("Lendo String");
            String palavra;
            palavra = sc.next(); // aqui o programa aguarda o usuário digitar uma String
            System.out.println("Voce digitou: " + palavra);


            System.out.println("Lendo Inteiro");
            int numInteiro;
            numInteiro = sc.nextInt(); //aqui o programa aguarda o usuário digitar um número Inteiro
            System.out.println("Voce digitou: " + numInteiro);


            System.out.println("Lendo Double");
            double numeroDouble;
            numeroDouble = sc.nextDouble(); //aqui o programa aguarda o usuário digitar um número Double usando ","
            System.out.println("Voce digitou: " + numeroDouble);


            System.out.println("Lendo Char");
            char caractere;
            caractere = sc.next().charAt(0); //aqui o programa aguarda o usuário digitar um Char, caso digite mais de 1, usará apenas o primeiro
            System.out.println("Voce digitou: " + caractere);


            System.out.println("Lendo String, Int e Char");
            String stringA;
            int intB;
            char charC;
            stringA = sc.next();
            intB = sc.nextInt();
            charC = sc.next().charAt(0);
            System.out.println("Voce digitou: " + stringA + ", " + intB + ", " + charC);


        sc.close(); // fechar o método de Entrada de dados

    }
}