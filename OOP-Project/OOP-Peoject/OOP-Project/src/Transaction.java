import java.time.LocalDate;
import java.util.ArrayList;

public class Transaction {



    LocalDate date = LocalDate.now();
    private Client client;
    private Employee employee;
    private float amount;
    private Account srcAcc;

    public Transaction(LocalDate date, Client client, Employee employee, float amount, Account srcAcc, Account dstAcc) {
        this.date = date;
        this.client = client;
        this.employee = employee;
        this.amount = amount;
        this.srcAcc = srcAcc;
    }

    public static void createTransaction(LocalDate date, Client client, Employee employee, float amount, Account srcAcc, Account dstAcc, ArrayList<Transaction> transactions) {
        Transaction trans = new Transaction(date, client, employee, amount, srcAcc, dstAcc);
        transactions.add(trans);
    }

   /* private Client Client;
    private Employee Employee;
    //private String Date;
    private float Amount;
    private Account SrcAcc,DstAcc;

    LocalDate Date=LocalDate.now();

    Transaction(Client Client,Employee Employee,float Amount,Account SrcAcc, Account DstAcc){
        //this.Date=Date;
        this.Client=Client;
        this.Employee=Employee;
        this.Amount=Amount;
        this.SrcAcc=SrcAcc;
        this.DstAcc=DstAcc;
    }*/


        // public  static void createTransaction(LocalDate Date,Client Client,Employee Employee,float Amount,Account SrcAcc, Account DstAcc){
        //    Transaction trans = new Transaction(Date, Client, Employee, Amount, SrcAcc);
        //}


        // Do something with the 'trans' object, if needed

        // Assuming you want to perform some operation with the 'dstAcc', you can include it here


    // public void GetTransactionDetail(String Date,float Amount,String SrcAcc, String DstAcc ,String Client){
    //System.out.println("The transaction of The account named"+Client+" transaction is complete! \n  It was on "+Date+"\nThe Amount is "+ Amount+ "It was from the account: "+SrcAcc+"\nIt was sent to the account"+DstAcc );
    //  }


}
