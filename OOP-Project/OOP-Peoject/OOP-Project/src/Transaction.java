import java.time.LocalDateTime;
import java.util.ArrayList;

public class Transaction {


    LocalDateTime date = LocalDateTime.now();
    private Client client;
    private Employee employee;
    private float amount;
    private Account srcAcc;

    public Transaction(LocalDateTime date, Client client, Employee employee, float amount, Account srcAcc, Account dstAcc) {
        this.date = date;
        this.client = client;
        this.employee = employee;
        this.amount = amount;
        this.srcAcc = srcAcc;
    }

    public static void createTransaction(LocalDateTime date, Client client, Employee employee, float amount, Account srcAcc, Account dstAcc, ArrayList<Transaction> transactions) {
        Transaction trans = new Transaction(date, client, employee, amount, srcAcc, dstAcc);
        transactions.add(trans);
    }



}
