import java.util.ArrayList;

public class Transaction {
    private int Id;

    private Client Client;
    private Employee Employee;
    String Date;
    private float Amount;
    private Account SrcAcc, DstAcc;

    Transaction(String Date, Client Client, Employee Employee, float Amount, Account SrcAcc, Account DstAcc) {
        this.Date = Date;
        this.Client = Client;
        this.Employee = Employee;
        this.Amount = Amount;
        this.SrcAcc = SrcAcc;
        this.DstAcc = DstAcc;

    }

    public static void addTransaction(Account source, Account destination, ArrayList<Transaction> transactions) {
        Transaction trans = new trans("Date",Am )
    }

    public void GetTransactionDetail(String Date, float Amount, String SrcAcc, String DstAcc, String Client) {
        System.out.println("The transaction of The account named" + Client + " transaction is complete! \n  It was on " + Date + "\nThe Amount is " + Amount + "It was from the account: " + SrcAcc + "\nIt was sent to the account" + DstAcc);
    }


}
