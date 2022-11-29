public class Account {
    private int number;
    private String holder;
   protected double balance; //modificador de acesso "protected" permite acesso ao atributo para as subclasses;

    public Account(){
    }

    public Account(int number, String holder, double balance){
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public void withDraw(double ammount){
        balance -= ammount;
    }

    public void deposit(double ammount){
        balance += ammount;
    }


}
