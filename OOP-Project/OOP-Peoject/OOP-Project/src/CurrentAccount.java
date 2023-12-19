public class CurrentAccount extends Account {

    private static final String ACCOUNT_TYPE = "Current";


    public CurrentAccount(int id ){
        super(id,"7385");
    }

    public CurrentAccount(double balance, double interestRate)
    {
        super(ACCOUNT_TYPE, balance);
        this.interestRate = interestRate;
    }


    @Override
    public void evaluateInterest()
    {
        if (balance >= 3000) {
            interestRate = 0;
        } else {
            interestRate=0.12;
        }
    }
    public void applyFees()
    {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
        System.out.println("Interest evaluated. New balance: " + getBalance());
    }


}

