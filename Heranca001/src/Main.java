import javax.swing.plaf.nimbus.NimbusStyle;

public class Main {
    public static void main(String[] args) {
        Account acc = new Account(1001, "Pedro", 10000.00);
        BusinessAccount bacc = new BusinessAccount(1002, "João", 10002.00, 500);



        // UPCASTING (transformar um objeto de uma "SUBCLASSE" em um objeto de "SUPERCLASSE")
        Account acc1 = bacc; // Uma subclasse pode ser atribuida para uma superclasse

        Account acc2 = new BusinessAccount(1003, "Daniel", 10003.00, 600); // Uma subclasse pode ser atribuida para uma superclasse

        Account acc3 = new SavingsAccount(1004, "Ana", 10004.00, 0.01); // Uma subclasse pode ser atribuida para uma superclasse


        //DOWNCASTING (transformar um objeto de uma "SUPERCLASSE" em um objeto de "SUBCLASSE")

        // BusinessAccount acc4 = acc2; //Não é possível realizar o casting pois uma Superclasse nao pode passar para subclasse, "**para funcionar, tem que fazer o casting na mão**";

         BusinessAccount acc4 = (BusinessAccount) acc2; // FAZENDO O CASTING NA MÃO

         // BusinessAccount acc5 = (BusinessAccount) acc3; //Não será possível converter uma BusinessAccount para uma SavingsAccount, o erro só irá aparecer após a execução do programa


        if(acc3 instanceof BusinessAccount){
            BusinessAccount acc5 = (BusinessAccount) acc3; //Para realizar o casting entre duas subclasses, usa-se o "INTANCEOF"
        }


    }
}