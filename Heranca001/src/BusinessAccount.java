public class BusinessAccount extends Account { //herda os mesmo atributos da classe ACCOUNT

    private double loanLimit;


    public double getLoanLimit() {
        return loanLimit;
    }


    public void setLoanLimit(double loanLimit) {
        this.loanLimit = loanLimit;
    }


    public BusinessAccount(){
        super(); //super() se refere á SUPERCLASSE "ACCOUNT"
    }


    public BusinessAccount(int number, String holder, double balance, double loanLimit) {
        super(number, holder, balance); //super() se refere á classe "PAI", ACCOUNT
        this.loanLimit = loanLimit;
    }


    public void loan(double ammount){
        if(ammount <= loanLimit){
            deposit(ammount);
        }
    }

}
