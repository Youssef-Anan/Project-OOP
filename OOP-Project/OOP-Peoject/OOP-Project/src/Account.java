import java.io.Serializable;

public abstract class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    private int AccountNumber;

    private static final String ACCOUNT_FILE_PATH = "accounts.txt";

    private String accountType;
    protected double balance;

    public Account(String accountType, double balance) {
        this.accountType = accountType;
        this.balance = balance;
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

    public static Account[] readAccountsFromFile() {
        try {
            return FileHandler.readAccountsFromFile();
        } catch (Exception e) {
            System.err.println("Error reading accounts from file: " + e.getMessage());
        }
        return null;
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
            FileHandler.writeAccountsToFile(updatedAccounts);
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

    public int getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        AccountNumber = accountNumber;
    }
}