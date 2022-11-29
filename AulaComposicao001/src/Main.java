import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter department name:");
        String departmentName = sc.nextLine();

        System.out.println("Enter worker data:");

        System.out.println("Name:");
        String workerName = sc.nextLine();

        System.out.println("Worker Level:");
        String workerLevel = sc.nextLine();

        System.out.println("Worker Base Salary:");
        double workerBaseSalary = sc.nextDouble();

        Trabalhador worker = new Trabalhador(workerName, NivelTrabalhador.valueOf(workerLevel), workerBaseSalary, new Departamento(departmentName));

        System.out.println("Number of contracts:");
        int numContracts = sc.nextInt();



        for (int i = 1; i <= numContracts; i++) {
            System.out.println("Enter contract #" + i + " data:");
            System.out.println("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next()); //este método pode gerar excessões, então utiliza-se o "throws ParseException" lá no "main(String[] args)"

            System.out.println("Value per Hour:");
            double valuePerHour = sc.nextDouble();

            System.out.println("Duration (hours):");
            int duration = sc.nextInt();


            ContratoHora contrato = new ContratoHora(contractDate, valuePerHour, duration);
            worker.adicionarContrato(contrato);
        }


        System.out.println("Enter month and year to calculate income (MM/YYYY):");
        String monthAndYear = sc.next();
        String[] eachElementOfDate = monthAndYear.split("/");
        int month = Integer.parseInt(eachElementOfDate[0]);
        int year = Integer.parseInt(eachElementOfDate[1]);

        System.out.println("Name: " + worker.getNome());
        System.out.println("Department: " + worker.getDepartamento().getNome());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));



        sc.close();
    }
}