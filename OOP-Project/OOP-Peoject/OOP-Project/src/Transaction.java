import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Transaction {

    private final LocalDateTime date = LocalDateTime.now();
   private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm");
    String formattedDateTime = date.format(formatter); //it formats the LocalDatetime

    private int clientId;  // clientId is now assigned based on the Client class
    private int employeeId;//employeeId is now assigned based on the Employee class
    private float amount;
    private Account srcAcc; // the Account that sends the money
    private Account dstAcc; // the Account that recieves the money

    public Transaction( Client client, Employee employee, float amount, Account srcAcc, Account dstAcc) {
        this.clientId = client.getID(); //It takes the client id from Client class
        this.employeeId= employee.getID();//It takes the employee id from Employee class
        this.amount = amount;
        this.srcAcc = srcAcc;
        this.dstAcc = dstAcc;
    }

    public static void createTransaction( Client client, Employee employee, float amount, Account srcAcc, Account dstAcc, ArrayList<Transaction> transactions) {
        Transaction trans = new Transaction( client, employee, amount, srcAcc, dstAcc);
        transactions.add(trans);
    }


    public LocalDateTime getDate() {
        return date;
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
        System.out.println("Date: " + formattedDateTime);
        System.out.println("Client ID: " + clientId);  // Display clientId
        System.out.println("Amount: " + amount);
        System.out.println("Employee: " + employeeId);
        System.out.println("Source Account: " + (srcAcc.getAccountNumber()));
        System.out.println("Destination Account: " + (dstAcc.getAccountNumber()));
    }
}
