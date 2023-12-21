public class CurrentAccount extends Account {

    public CurrentAccount(int id ){
        super(id,"7385","current account");
    }

    @Override
    public void evaluateInterest()
    {
        if (balance >= 3000) {
            DEFAULT_INTEREST_RATE = 0;
        } else {
            DEFAULT_INTEREST_RATE=0.12;
        }
    }
    public void applyFees()
    {
        double interest = getBalance() * DEFAULT_INTEREST_RATE;
        setBalance(getBalance() + interest);
        System.out.println("Interest evaluated. New balance: " + getBalance());
    }


}

