import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Random;
import java.time.LocalDate;

public abstract class Account{
    protected long AccountNumber;
    protected   LocalDate local_Date;
    protected double DEFAULT_INTEREST_RATE = 0.12;
    private int Client_Id;

    protected double balance=0;
    protected String AccountType;

    // This set is used to keep track of account numbers that have been generated to avoid generating the same account number more than once
    private static final Set<Long> generatedAccountNumbers = new HashSet<>();
    private static final Random random = new Random();

    public Account(String accountType, double balance) {
        this.AccountType = accountType;
        this.balance = balance;
    }
    public Account(int Client_id,String s ,String AccountType) {
        this.Client_Id=Client_id;
        this.AccountNumber = generateUniqueAccountNumber(s);
        this.AccountType=AccountType;
    }
    // Method to generate a unique account number that takes a definitely the first 4 numbers of account number and the rest is random
    static synchronized long generateUniqueAccountNumber(String x) {
        long newAccountNumber;
        do {
            long randomNumber = Math.abs(random.nextLong() % 900000000000L) + 100000000000L;
            newAccountNumber = Long.parseLong(x + Long.toString(randomNumber));
        } while (generatedAccountNumbers.contains(newAccountNumber));
        generatedAccountNumbers.add(newAccountNumber);
        return newAccountNumber;
    }
    static Account getAccountbyID(ArrayList<Client> users,long AccountNumber){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).currentAccount.getAccountNumber()==AccountNumber)return users.get(i).currentAccount;
            else for (int j = 0; j < users.get(i).savingAccount.size(); j++) {
                if (users.get(i).savingAccount.get(j).getAccountNumber()==AccountNumber)return users.get(i).savingAccount.get(j);
            }
        }
        return null;
    }
    static Account getUserAccount(Client user,long AccountNumber){
            if (user.currentAccount.getAccountNumber()==AccountNumber)return user.currentAccount;
            else for (int j = 0; j < user.savingAccount.size(); j++) {
                if (user.savingAccount.get(j).getAccountNumber()==AccountNumber)return user.savingAccount.get(j);
            }
        return null;
    }

    public abstract void evaluateInterest();

    public abstract void applyFees();

    public long getAccountNumber() {
        return AccountNumber;
    }

    public LocalDate getLocal_Date() {
        return local_Date;
    }

    public void setLocal_Date(LocalDate local_Date) {
        this.local_Date = local_Date;
    }
    public Account(){}

    public String getAccountType() {
        return AccountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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
        this.AccountType = accountType;
    }


}