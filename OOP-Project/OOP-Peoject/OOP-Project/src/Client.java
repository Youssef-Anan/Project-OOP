
import java.util.ArrayList;
public class Client extends User {
    private   int AccountNumber;
    private   int TelephoneNumber;
    private   String StateOfAccount;
    private    String TypeOfAccount;
    private    double balance;
    private ArrayList TransactionHistory;
    public Client(int ID, String FirstName, String LastName, String Username, String Password, int accountNumber, int telephoneNumber, String stateOfAccount, String typeOfAccount, double balance, ArrayList transactionHistory) {
        super(ID, FirstName, LastName, Username, Password);
        AccountNumber = accountNumber;
        TelephoneNumber = telephoneNumber;
        StateOfAccount = stateOfAccount;
        TypeOfAccount = typeOfAccount;
        this.balance = balance;
        TransactionHistory = transactionHistory;
    }

    public Client(int AccountNumber, int TelephoneNumber, String StateOfAccount, String TypeOfAccount, double balance) {
        this.AccountNumber = AccountNumber;
        this.TelephoneNumber = TelephoneNumber;
        this.StateOfAccount = StateOfAccount;
        this.TypeOfAccount = TypeOfAccount;
        this.balance = balance;
    }
    public void DisplayAccountDetails(){
        System.out.println("The account id: "+getID());
        System.out.println("The account first name: "+getFirstName());
        System.out.println("The account last name: "+getLastName());
        System.out.println("The account last user name: "+getUsername());
        System.out.println("The account number: "+AccountNumber);
        System.out.println("The account phone number: "+TelephoneNumber);
        System.out.println("The account state (Active or closed): "+StateOfAccount);
        System.out.println("The account last type: "+TypeOfAccount);
        System.out.println("Balance: $" + balance);


    }
    public void EditPersonalInformation(String NewFirstName, String NewLastName,String NewUserName ,int NewPhoneNumber)
    {
        this.setFirstName(NewFirstName);
        this.setLastName(NewLastName);
        this.setUsername(NewUserName);
        this.TelephoneNumber=NewPhoneNumber;
        System.out.println("Personal information updated for " + getID());

    }
    public void TransferMoney(Client Recipient, double amount) {

    }
    public void ShowTransactionHistory()
    {
        System.out.println("Transaction History for " + getFirstName() + " " + getLastName() + " (ID: " + getID() + "):");
        System.out.println(TransactionHistory);
    }

    public void TakeDeposit(double Amount) {
        try {

            balance += Amount;
            System.out.println("Deposited $" + Amount + ". New balance: $" + balance);
            TransactionHistory.add("Deposit: +$" + Amount);

        } catch (Exception EX) {

            System.out.println("Invalid deposit amount. Amount must be greater than zero.");

        }
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        AccountNumber = accountNumber;
    }

    public int getTelephoneNumber() {
        return TelephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        TelephoneNumber = telephoneNumber;
    }

    public String getStateOfAccount() {
        return StateOfAccount;
    }

    public void setStateOfAccount(String stateOfAccount) {
        StateOfAccount = stateOfAccount;
    }

    public String getTypeOfAccount() {
        return TypeOfAccount;
    }

    public void setTypeOfAccount(String typeOfAccount) {
        TypeOfAccount = typeOfAccount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList getTransactionHistory() {
        return TransactionHistory;
    }

    public void setTransactionHistory(ArrayList transactionHistory) {
        TransactionHistory = transactionHistory;
    }
}

