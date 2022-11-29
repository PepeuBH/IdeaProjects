import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Lendo gabarito da prova
        String[] gabarito = new String[8];
        System.out.println("Preencha o Gabarito:");
        for (int i = 0; i < gabarito.length; i++) {
            System.out.println("Questao [" + i + "]:");
            gabarito[i] = sc.next();
        }

        //Lendo num e nota de aluno
        int numAlunos = 2;
        Alunos aluno = new Alunos();
        Alunos[] alunos = new Alunos[numAlunos];

        for (int pos = 0; pos < numAlunos; pos++) {
            alunos[pos] = new Alunos();
            for (int i = 0; i < 8; i++) {
                alunos[pos].setRespostas(i,sc.next());
            }
        }



        sc.close();
    }
}