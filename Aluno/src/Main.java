import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Aluno aluno = new Aluno();

        System.out.println("Nome do Aluno:");
        aluno.nome = sc.nextLine();


        System.out.println("Nota primeiro Trimestre:");
        aluno.nota1 = sc.nextDouble();

        System.out.println("Nota segundo Trimestre:");
        aluno.nota2 = sc.nextDouble();

        System.out.println("Nota terceiro Trimestre:");
        aluno.nota3 = sc.nextDouble();

        System.out.println("Aluno: " + aluno.nome + "\nResultado Final: " + aluno.finalGrade());

        if(aluno.finalGrade() >= 60){
            System.out.println("APROVADO");
        }else
            System.out.println("REPROVADO\nFaltando " + aluno.missing() + " pontos");

        sc.close();
    }
}