import java.time.LocalDateTime;
import java.util.ArrayList;

public class Transaction {

    private final LocalDateTime date = LocalDateTime.now();
    private int clientId;  // clientId is now assigned based on the Client class
    private int employeeId;
    private float amount;
    private Account srcAcc;
    private Account dstAcc;

    public Transaction( Client client, Employee employee, float amount, Account srcAcc, Account dstAcc) {
        this.clientId = client.getID();
        this.employeeId= employee.getID();
        this.amount = amount;
        this.srcAcc = srcAcc;
        this.dstAcc = dstAcc;
    }

    public static void createTransaction( Client client, Employee employee, float amount, Account srcAcc, Account dstAcc, ArrayList<Transaction> transactions) {
        Transaction trans = new Transaction( client, employee, amount, srcAcc, dstAcc);
        transactions.add(trans);
    }
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setEmployeeIdId(int employeeId) {
        this.employeeId=employeeId;
    }

    public int getEmployeeIdId() {
        return employeeId;
    }



    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Account getSrcAcc() {
        return srcAcc;
    }

    public void setSrcAcc(Account srcAcc) {
        this.srcAcc = srcAcc;
    }

    public Account getDstAcc() {
        return dstAcc;
    }

    public void setDstAcc(Account dstAcc) {
        this.dstAcc = dstAcc;
    }

    public void displayTransaction() {
        System.out.println("Transaction Details:");
        System.out.println("Date: " + date);
        System.out.println("Client ID: " + clientId);  // Display clientId
        System.out.println("Amount: " + amount);
        System.out.println("Employee: " + employeeId);
        System.out.println("Source Account: " + (srcAcc.getAccountNumber()));
        System.out.println("Destination Account: " + (dstAcc.getAccountNumber()));
    }
}
