import java.io.Serializable;

public class SavingsAccount extends Account implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final String ACCOUNT_TYPE = "Savings";
    private static final double DEFAULT_INTEREST_RATE = 0.12;


    public SavingsAccount(int id) {
super(id);
    }

    public SavingsAccount(double balance, double interestRate) {
        super(ACCOUNT_TYPE, balance);
        this.interestRate = interestRate;
    }


    @Override
    public void evaluateInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
        System.out.println("Interest evaluated. New balance: " + getBalance());
    }

    @Override
    public void applyFees() {
        // Savings accounts do not have fees
    }

    public static SavingsAccount createSavingsAccount(double initialBalance, double interestRate) {
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