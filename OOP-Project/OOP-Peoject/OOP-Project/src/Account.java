import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Random;


public abstract class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    protected long AccountNumber;
    protected double interestRate;
    private static final String ACCOUNT_FILE_PATH = "accounts.txt";

    private int Client_Id;

    private String accountType;
    protected double balance=0;
    private static final Set<Long> generatedAccountNumbers = new HashSet<>();
    private static final Random random = new Random();

    public Account(String accountType, double balance) {
        this.accountType = accountType;
        this.balance = balance;
    }
    public Account(int Clieint_id ) {
        this.Client_Id=Clieint_id;
        this.AccountNumber = generateUniqueAccountNumber();
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract void evaluateInterest();

    public abstract void applyFees();
    private static synchronized long generateUniqueAccountNumber() {
        long newAccountNumber;
        do {
            newAccountNumber = Math.abs(random.nextLong() % 9000000000000000L) + 1000000000000000L;
        } while (generatedAccountNumbers.contains(newAccountNumber));
        generatedAccountNumbers.add(newAccountNumber);
        return newAccountNumber;
    }

    public static Account[] readAccountsFromFile() {
        try {

        } catch (Exception e) {
            System.err.println("Error reading accounts from file: " + e.getMessage());
        }
        return null;
    }

    public Account() {
    }

    public void writeAccountToFile() {
        try {
            Account[] accounts = readAccountsFromFile();
            if (accounts == null) {
                accounts = new Account[0];
            }

            // Check if the account already exists
            for (Account existingAccount : accounts) {
                if (existingAccount.equals(this)) {
                    throw new RuntimeException("Account already exists.");
                }
            }

            // Add the new account
            Account[] updatedAccounts = new Account[accounts.length + 1];
            System.arraycopy(accounts, 0, updatedAccounts, 0, accounts.length);
            updatedAccounts[accounts.length] = this;

            // Write updated accounts to file

            System.out.println("Account data has been written to file.");
        } catch (Exception e) {
            System.err.println("Error writing account to file: " + e.getMessage());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Account account = (Account) obj;

        return accountType.equals(account.accountType);
    }

    @Override
    public int hashCode() {
        return accountType.hashCode();
    }

    public long getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        AccountNumber = accountNumber;
    }


}