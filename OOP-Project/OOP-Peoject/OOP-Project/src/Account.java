import java.util.HashSet;
import java.util.Set;
import java.util.Random;
import java.time.LocalDate;


public abstract class Account{
    private static final long serialVersionUID = 1L;
    protected long AccountNumber;
    protected   LocalDate local_Date;
    protected double DEFAULT_INTEREST_RATE = 0.12;
    private static final String ACCOUNT_FILE_PATH = "accounts.txt";

    private int Client_Id;

    private String accountType;
    protected double balance=0;
    protected String AccountType;
    private static final Set<Long> generatedAccountNumbers = new HashSet<>();
    private static final Random random = new Random();

    public Account(String accountType, double balance) {
        this.accountType = accountType;
        this.balance = balance;
    }
    public Account(int Client_id,String s ,String AccountType) {
        this.Client_Id=Client_id;
        this.AccountNumber = generateUniqueAccountNumber(s);
        this.AccountType=AccountType;
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
    static synchronized long generateUniqueAccountNumber(String x) {
        long newAccountNumber;
        do {
            long randomNumber = Math.abs(random.nextLong() % 900000000000L) + 100000000000L;
            newAccountNumber = Long.parseLong(x + Long.toString(randomNumber));
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

    public long getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        AccountNumber = accountNumber;
    }

    public LocalDate getLocal_Date() {
        return local_Date;
    }

    public void setLocal_Date(LocalDate local_Date) {
        this.local_Date = local_Date;
    }

    public void setAccountNumber(long accountNumber) {
        AccountNumber = accountNumber;
    }

    public double getDEFAULT_INTEREST_RATE() {
        return DEFAULT_INTEREST_RATE;
    }

    public void setDEFAULT_INTEREST_RATE(double DEFAULT_INTEREST_RATE) {
        this.DEFAULT_INTEREST_RATE = DEFAULT_INTEREST_RATE;
    }

    public int getClient_Id() {
        return Client_Id;
    }

    public void setClient_Id(int client_Id) {
        Client_Id = client_Id;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}