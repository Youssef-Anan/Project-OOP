
public class Account {
    private   int AccountNumber;
    protected     double balance=0;

    public Account(int accountNumber, double balance) {
        AccountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        AccountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
