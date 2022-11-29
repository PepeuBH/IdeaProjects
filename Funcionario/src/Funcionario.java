public class Funcionario {
    public String nome;
    public double grossSalary;
    public double tax;


    public double netSalary(){
        return this.grossSalary - tax;
    }

    public void increaseSalary( double percentage){
        grossSalary += grossSalary * percentage / 100;
    }
}
