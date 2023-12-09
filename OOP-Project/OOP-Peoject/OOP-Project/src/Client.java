
import java.util.Scanner;
import java.util.ArrayList;

public class Client extends User {
    ArrayList<SavingsAccount> savingAccount = new ArrayList<>();
    CurrentAccount currentAccount ;

    private int TelephoneNumber;


    Scanner scanner = new Scanner(System.in);

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public Client() {
    }

    public Client(String firstName, String lastName, String username, String password, int telephoneNumber) {
        super(firstName, lastName, username, password);

        TelephoneNumber = telephoneNumber;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void DisplayClientDetails() {
        System.out.println("The client id: " + getID());
        System.out.println("The client first name: " + getFirstName());
        System.out.println("The client last name: " + getLastName());
        System.out.println("The client last user name: " + getUsername());
        System.out.println("The client phone number: " + TelephoneNumber);


    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void DisplayAccounts() {
        for (int i = 0; i < savingAccount.size(); i++) {
            System.out.println("Saving Account " + i + 1 + " the number of account " + savingAccount.get(i).getAccountNumber() + " the account balance: $" + savingAccount.get(i).getBalance());
        }

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void EditPersonalInformation(String NewFirstName, String NewLastName, int NewPhoneNumber) {
        setFirstName(NewFirstName);
        setLastName(NewLastName);
        TelephoneNumber = NewPhoneNumber;
        System.out.println("Personal information updated for " + getID());

    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////

    public void TransferMoney(double amount, Account sourceAcc, Account destinationAcc) {
        if (sourceAcc.balance >= amount) {
            destinationAcc.setBalance(destinationAcc.balance + amount);
            sourceAcc.setBalance(sourceAcc.balance - amount);
            System.out.println("Transfer successful.");
            TransactionHistory.add("trancfer money form account number :" + sourceAcc.getAccountNumber() + " to :" + destinationAcc + " the amount is :" + amount);
        } else {
            System.out.println("Insufficient funds for transfer.");
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    public void ShowTransactionHistory() {
        System.out.println("Transaction History for " + getFirstName() + " " + getLastName() + " (ID: " + getID() + "):");

    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    public void TakeDeposit(double Amount, Account a) {
        try {
            if (a.balance >= Amount) {
                a.balance += Amount;
                System.out.println("Deposited +$" + Amount + ". New balance: $" + a.balance);


            }
        } catch (Exception EX) {

            System.out.println("Invalid deposit amount. Amount must be greater than zero.");

        }
    }

    public void Withdraw(double amount, Account sourceAcc) {
        if (sourceAcc.balance >= amount) {
            sourceAcc.setBalance(sourceAcc.getBalance() - amount);
            System.out.println("Withdraw -$" + amount + ". New balance: $" + sourceAcc.balance);


        }
    }


    public int getTelephoneNumber() {
        return TelephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        TelephoneNumber = telephoneNumber;
    }


}
