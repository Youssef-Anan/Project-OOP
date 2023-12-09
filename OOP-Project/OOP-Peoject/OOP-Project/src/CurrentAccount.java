public class CurrentAccount extends Account {

    private static final String ACCOUNT_TYPE = "Current";


    public CurrentAccount(double balance, double interestRate){
        super(ACCOUNT_TYPE,balance);
        this.interestRate=interestRate;
    }

    public void evaluateInterest() {
        if (balance >= 3000) {
            interestRate = 0;
        } else {
            interestRate=0.12;
        }
    }
    public void applyFees() {
        balance -= balance * interestRate;
    }


}
