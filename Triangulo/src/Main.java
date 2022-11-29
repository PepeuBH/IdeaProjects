import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Triangulo x = new Triangulo(); //instancia os triangulos
        Triangulo y = new Triangulo();

        System.out.println("Digite os valores da Base e Altura do triangulo X...");
        x.base = sc.nextDouble();
        x.altura = sc.nextDouble();


        System.out.println("Digite os valores da Base e Altura triangulo Y...");
        y.base = sc.nextDouble();
        y.altura = sc.nextDouble();

        double areaX = x.area();
        double areaY = y.area();

        System.out.println("Triangulo X - Area = " + areaX);
        System.out.println();
        System.out.println("Triangulo Y - Area = " + areaY);

        sc.close();
    }
}