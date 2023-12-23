
import java.util.Scanner;
import java.util.ArrayList;

public class Client extends User {
     protected CurrentAccount currentAccount=null ;
     protected ArrayList<SavingsAccount> savingAccount=new ArrayList<>();

    private String TelephoneNumber;
    Scanner input = new Scanner(System.in);


    public Client() {

    }

    public Client(int id,String firstName, String lastName, String username, String password, String telephoneNumber) {
        super(id,firstName, lastName, username, password);
        super.userType="Client";
        TelephoneNumber = telephoneNumber;

    }
    public Client(Client other) {
        super(other.getID(),other.getFirstName(), other.getLastName(), other.getUsername(), other.getPassword());
        this.TelephoneNumber = other.TelephoneNumber;
        this.currentAccount = other.getCurrentAccount();
            for (int i = 0; i < other.savingAccount.size(); i++) {
                savingAccount.add(other.savingAccount.get(i));
            }
    }

public void createCurrent() //Creates a new current account for the client if one does not already exist.
{
    if(currentAccount==null)
    {
        System.out.println("Creating current account");
        currentAccount = new CurrentAccount(getID());//Creates a new current account

    }

else
    {
        System.out.println("the account  is already taken");
    }
}

public void createSavings()// Creates a new savings account and adds it to the client's list of savings accounts.
{
SavingsAccount savings=new SavingsAccount(getID());
    System.out.println("Added Successfully");
    savingAccount.add(savings);// Creates a new savings account

}

    public void DisplayClientDetails()   // Displays the client's personal and account details.
    {
        System.out.println("The client id: " + getID());
        System.out.println("The client first name: " + getFirstName());
        System.out.println("The client last name: " + getLastName());
        System.out.println("The client last user name: " + getUsername());
        System.out.println("The client phone number: " + TelephoneNumber);
        DisplayAccounts();
    }


    public void DisplayAccounts()    // Displays the client's account details.
    {
        int counter=1;
        if (currentAccount!=null)
        {
            System.out.println(counter +"-"+"Current Account " +  " the number of account " +currentAccount.getAccountNumber() + " the account balance: $" + currentAccount.getBalance());
        counter++;
        }
        for (int i = 0; i < savingAccount.size(); i++) {
            System.out.println(counter + "-" + "Saving Account "  + " the number of account " + savingAccount.get(i).getAccountNumber() + " the account balance: $" + savingAccount.get(i).getBalance());
            counter++;
        }
    }


    public void EditPersonalInformation() {
        try {
            System.out.println("Enter the new First Name:");
            String firstname = input.nextLine();
            System.out.println("Enter the new Last Name:");
            String lastname = input.nextLine();
            System.out.println("Enter the new Telephone Number:");
            String telephone = input.next();
            // Check if the telephone number is numeric
            if (!telephone.matches("\\d+")) {
                throw new IllegalArgumentException("Telephone number must contain only numbers.");
            }
            setFirstName(firstname);
            setLastName(lastname);
            setTelephoneNumber(telephone);
            System.out.println("Personal information updated for " + getID());
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


    public void TransferMoney(double amount, Account sourceAcc, Account destinationAcc) {
        if (sourceAcc.balance >= amount)
        {
            destinationAcc.setBalance(destinationAcc.balance + amount);
            sourceAcc.setBalance(sourceAcc.balance - amount);
            System.out.println("Transfer successful.");
        } else
        {
            System.out.println("Insufficient funds for transfer.");
        }
    }


    public void ShowTransactionHistory(ArrayList<Transaction> tran) {
        for (int i=0;i<tran.size();i++)
        {
            if (tran!=null)
            {
                if (tran.get(i).getClientId() == getID())
                {
                    tran.get(i).displayTransaction();
                }
            }
            else
                System.out.println("the transaction history is empty");{

            }

        }

    }
    public void TakeDeposit(double Amount, Account a) {
                a.balance += Amount;
                System.out.println("Deposited +$" + Amount + ". New balance: $" + a.balance);
    }
    public void Withdraw(double amount, Account sourceAcc) {
        if (sourceAcc.balance >= amount) {
            sourceAcc.setBalance(sourceAcc.getBalance() - amount);
            System.out.println("Withdraw -$" + amount + ". New balance: $" + sourceAcc.balance);
        }
        else {System.out.println("Insufficient Funds ");}
    }
    public String getTelephoneNumber() {
        return TelephoneNumber;
    }
    public void setTelephoneNumber(String telephoneNumber) {
        TelephoneNumber = telephoneNumber;
    }
    public ArrayList<SavingsAccount> getSavingAccount() {
        System.out.println("size: " + savingAccount.size());
        return new ArrayList<>(savingAccount); // Return a copy to prevent external modification
    }
    public void setSavingAccount(ArrayList<SavingsAccount> savingAccount) {
        this.savingAccount = savingAccount;
    }
    public CurrentAccount getCurrentAccount() {
        return currentAccount;
    }
    public void setCurrentAccount(CurrentAccount currentAccount) {
        this.currentAccount = currentAccount;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }
}
