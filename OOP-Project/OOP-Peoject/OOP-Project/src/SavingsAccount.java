import java.time.LocalDate;

public class SavingsAccount extends Account  {
    private static final long serialVersionUID = 1L;

    private static final String ACCOUNT_TYPE = "Savings";
    private static final double DEFAULT_INTEREST_RATE = 0.12;


    public SavingsAccount(int id)
    {
    super(id,"5484");
    this.interestRate = DEFAULT_INTEREST_RATE;
        this.local_Date = LocalDate.now();
    }
    public SavingsAccount() {

    }

    public SavingsAccount(double balance, double interestRate)
    {
        super(ACCOUNT_TYPE, balance);
        this.interestRate = interestRate;
        this.AccountNumber = generateUniqueAccountNumber("5484");
    }


    @Override
    public void evaluateInterest() {
        LocalDate currentDate = LocalDate.now();
        if (local_Date.plusYears(1).isBefore(currentDate) || local_Date.equals(currentDate)) {
            double interest = getBalance() * interestRate;
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

    public  SavingsAccount createSavingsAccount(double initialBalance, double interestRate) {
        SavingsAccount savingsAccount = new SavingsAccount(initialBalance, interestRate);
        savingsAccount.writeAccountToFile();
        return savingsAccount;
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
