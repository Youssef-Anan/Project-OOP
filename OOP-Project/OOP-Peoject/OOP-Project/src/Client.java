
import java.util.Scanner;
import java.util.ArrayList;

public class Client extends User {
    ArrayList<SavingsAccount> savingAccount = new ArrayList<>();
    CurrentAccount currentAccount ;

    ArrayList TransactionHistory = new ArrayList();
    private String TelephoneNumber;

public static int clientC=1001;
    Scanner input = new Scanner(System.in);

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public Client() {
        clientC=1001;
        clientC++;
    }

    public Client(int id,String firstName, String lastName, String username, String password, String telephoneNumber) {
        super(id,firstName, lastName, username, password);
    super.userType="Client";
        TelephoneNumber = telephoneNumber;
        clientC=1001;
        clientC++;
    }

public void createcurrent()
{
    if(currentAccount==null) {
        currentAccount = new CurrentAccount(getID());

    }

else
    {
        System.out.println("the account number is already taken");
    }
}
    public Client(Client other) {
        super(other.getID(),other.getFirstName(), other.getLastName(), other.getUsername(), other.getPassword());
        this.TelephoneNumber = other.TelephoneNumber;
        this.currentAccount = new CurrentAccount(getID());

        // Deep copy of the savingAccount ArrayList
        this.savingAccount = new ArrayList<>();
        for (SavingsAccount acc : other.savingAccount) {
            this.savingAccount.add(new SavingsAccount());
        }

        // Deep copy of the TransactionHistory ArrayList
        this.TransactionHistory = new ArrayList<>(other.TransactionHistory);
        clientC=1001;
        clientC++;
    }
public void createsavings()
{
SavingsAccount savings=new SavingsAccount(getID());
savingAccount.add(savings);
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
        DisplayAccounts();


    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void DisplayAccounts() {
        String s=currentAccount.toString();

        for (int i = 0; i < savingAccount.size(); i++) {
            System.out.println("Saving Account " + i + 1 + " the number of account " + savingAccount.get(i).getAccountNumber() + " the account balance: $" + savingAccount.get(i).getBalance());
        }
        if (s!=null)
        {
            System.out.println("current Account " + 1 + " the number of account " +currentAccount.getAccountNumber() + " the account balance: $" + currentAccount.getBalance());

        }

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void EditPersonalInformation() {
        System.out.println("Enter the new First Name:");
        String firstname= input.nextLine();
        System.out.println("Enter the new Last Name:");
        String lastname= input.nextLine();
        System.out.println("Enter the new Telephone Number:");
        String telephone= input.next();
        setFirstName(firstname);
        setLastName(lastname);
        setTelephoneNumber(telephone);
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
        System.out.println(TransactionHistory);
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    public void TakeDeposit(double Amount, Account a) {
        try {
            if (a.balance >= Amount) {
                a.balance += Amount;
                System.out.println("Deposited +$" + Amount + ". New balance: $" + a.balance);

                TransactionHistory.add("deposit -$" + Amount);
            }
        } catch (Exception EX) {

            System.out.println("Invalid deposit amount. Amount must be greater than zero.");

        }
    }

    public void Withdraw(double amount, Account sourceAcc) {
        if (sourceAcc.balance >= amount) {
            sourceAcc.setBalance(sourceAcc.getBalance() - amount);
            System.out.println("Withdraw -$" + amount + ". New balance: $" + sourceAcc.balance);

            TransactionHistory.add("withdraw -$" + amount);
        }
    }


    public String getTelephoneNumber() {
        return TelephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        TelephoneNumber = telephoneNumber;
    }


}
