import java.time.LocalDate;

public class CurrentAccount extends Account {
    // Call the constructor of the superclass (Account) with specific parameters
    public CurrentAccount(int id ){
        super(id,"7385","current account");
        this.local_Date = LocalDate.now();
    }
    public CurrentAccount(){}

    @Override
    public void evaluateInterest()
    {
        // Check the balance to determine the interest rate for the current account
        if (balance >= 3000) {
            // If the balance is 3000 or more, set the interest rate to 0%
            DEFAULT_INTEREST_RATE = 0;
        } else {
            // If the balance is less than 3000, set the interest rate to the default rate (0.12)
            DEFAULT_INTEREST_RATE=0.12;
        }
    }

    public void applyFees()
    {
        // Calculate and add interest to the account balance based on the interest rate
        double interest = getBalance() * DEFAULT_INTEREST_RATE;
        setBalance(getBalance() + interest);
        System.out.println("Interest evaluated. New balance: " + getBalance());
    }


}

