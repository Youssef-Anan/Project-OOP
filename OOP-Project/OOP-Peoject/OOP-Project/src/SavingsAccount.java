import java.time.LocalDate;

public class SavingsAccount extends Account  {
    private static final long serialVersionUID = 1L;

    public SavingsAccount(int id)
    {
    super(id,"5484","saving account");
    this.DEFAULT_INTEREST_RATE = DEFAULT_INTEREST_RATE;
        this.local_Date = LocalDate.now();
    }
    public SavingsAccount() {

    }


    @Override
    public void evaluateInterest() {
        LocalDate currentDate = LocalDate.now();
        if (local_Date.plusYears(1).isBefore(currentDate) || local_Date.equals(currentDate)) {
            double interest = getBalance() * DEFAULT_INTEREST_RATE;
            setBalance(getBalance() + interest);
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

    public static SavingsAccount findSavingsAccountByType() {
        try {
            Account[] accounts = readAccountsFromFile();
            if (accounts != null) {
                for (Account account : accounts) {
                    if (account instanceof SavingsAccount) {
                        return (SavingsAccount) account;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error finding savings account: " + e.getMessage());
        }
        return null;
    }

}
