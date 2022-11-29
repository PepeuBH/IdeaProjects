import java.util.Scanner;

public class Main {
 //Métodos STATIC dentro da main na precisam ser instanciados, quando passados para uma classe
 // separar, pode-se remover o STATIC porém precisa instanciá-los na MAIN e ao chamá-los, precisa referenciar o objeto.
 // Exemplo: (usando classes separadas) -> Caculator calc = new Calculator(); || calc.circumference(radius)
 // Exemplo: (usando tudo dentro da main de forma STATIC -> circumference(radius)
    public static final double PI = 3.14;//declaração de uma constante PI, tem que ser fora do MAIN

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Radius:");
        double radius = sc.nextDouble();

        double c = circumference(radius);

        double v = volume(radius);

        System.out.printf("Circunference: %.2f%n" , c);
        System.out.printf("Volume: %.2f%n", v);
        System.out.printf("PI value: %.2f%n", PI );
        sc.close();
    }
    public static double circumference(double radius){
        return 2.0 * PI * radius;
    }

    public static double volume(double radius){
        return 4.0 * PI * radius * radius * radius / 3.0;
    }
}