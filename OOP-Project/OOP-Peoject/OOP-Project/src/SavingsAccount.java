import java.time.LocalDate;

public class SavingsAccount extends Account {

    public SavingsAccount() {

    }
    public SavingsAccount(int id)
    {
    // Call the constructor of the superclass (Account) with specific parameters
    super(id,"5484","saving account");
    // Set the interest rate for this savings account
    this.DEFAULT_INTEREST_RATE = DEFAULT_INTEREST_RATE;
    // Set the creation date of the account to the current date
    this.local_Date = LocalDate.now();
    }


    @Override
    public void evaluateInterest() {
        LocalDate currentDate = LocalDate.now();
        // Check if a year has passed since the last interest evaluation
        if (local_Date.plusYears(1).isBefore(currentDate) || local_Date.equals(currentDate)) {
            // Calculate and add interest to the account balance
            double interest = getBalance() * DEFAULT_INTEREST_RATE;
            setBalance(getBalance() + interest);
            // Update the last interest evaluation date
            local_Date = currentDate;
            System.out.println("Interest evaluated. New balance: " + getBalance());
        } else {
            System.out.println("Interest evaluation is not due yet.");
        }
    }

    @Override
    public void applyFees()
    {
        // Savings accounts do not have fees
    }



}
