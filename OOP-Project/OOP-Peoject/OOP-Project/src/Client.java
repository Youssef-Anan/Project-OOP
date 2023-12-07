
import  java.util.Scanner;
import java.util.ArrayList;

public class Client extends User {
    SavingsAccount[] ArrAccount=new SavingsAccount[2];
    private   int TelephoneNumber;
    private    String TypeOfAccount;
    private   String StateOfAccount;

    Scanner scanner=new Scanner(System.in);
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////


    public Client(int ID, String FirstName, String LastName, String Username, String Password, SavingsAccount[] arrAccount, int telephoneNumber, String typeOfAccount, String stateOfAccount, Scanner scanner) {
        super(ID, FirstName, LastName, Username, Password);
        ArrAccount = arrAccount;
        TelephoneNumber = telephoneNumber;
        TypeOfAccount = typeOfAccount;
        StateOfAccount = stateOfAccount;
        this.scanner = scanner;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void DisplayClientDetails(){
        System.out.println("The client id: "+getID());
        System.out.println("The client first name: "+getFirstName());
        System.out.println("The client last name: "+getLastName());
        System.out.println("The client last user name: "+getUsername());
        System.out.println("The client phone number: "+TelephoneNumber);
        System.out.println("The account state (Active or closed): "+StateOfAccount);
        System.out.println("The account last type: "+TypeOfAccount);


    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void DisplayAccountDetails()
    {
        System.out.println("Enter 1 to see account 1 Enter 2 to see account 2");
        int x=scanner.nextInt();
        if (x==1)
        {
            System.out.println("The account id"+ArrAccount[0].getAccountNumber()+" The balance: "+ArrAccount[0].getBalance());
        }
        else if (x==2)
        {
            System.out.println("The account id"+ArrAccount[1].getAccountNumber()+" The balance: "+ArrAccount[1].getBalance());

        }

    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void EditPersonalInformation(String NewFirstName, String NewLastName,String NewUserName ,int NewPhoneNumber)
    {
        this.setFirstName(NewFirstName);
        this.setLastName(NewLastName);
        this.setUsername(NewUserName);
        this.TelephoneNumber=NewPhoneNumber;
        System.out.println("Personal information updated for " + getID());

    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////

    public void TransferMoney(Client Recipient, double amount,Account sourceAcc,Account destinationAcc) {

    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    public void ShowTransactionHistory()
    {
        System.out.println("Transaction History for " + getFirstName() + " " + getLastName() + " (ID: " + getID() + "):");
        // System.out.println(TransactionHistory);
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    public void TakeDeposit(double Amount) {
        try {

            ArrAccount[0].balance += Amount;
            System.out.println("Deposited $" + Amount + ". New balance: $" + ArrAccount[0].getBalance());


        } catch (Exception EX) {

            System.out.println("Invalid deposit amount. Amount must be greater than zero.");

        }
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



}
