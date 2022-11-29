import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Funcionario funcionario = new Funcionario();

        System.out.println("Digite o nome do Funcionario:");
        funcionario.nome = sc.nextLine();

        System.out.println("Digite o Salario Bruto desde funcionario:");
        funcionario.grossSalary = sc.nextDouble();

        System.out.println("Digite o total de imposto cobrado:");
        funcionario.tax = sc.nextDouble();

        System.out.println("Employee: " + funcionario.nome + ", $ " + funcionario.netSalary());

        System.out.println("Qual a % de aumento no salario?");
        double percent = sc.nextDouble();
        funcionario.increaseSalary(percent);
        System.out.println("Updated Data: " + funcionario.nome + ", $ " + funcionario.netSalary());


        sc.close();
    }


}