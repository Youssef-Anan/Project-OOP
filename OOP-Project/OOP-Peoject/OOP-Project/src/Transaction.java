import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Transaction {

    private final LocalDateTime date = LocalDateTime.now();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm");
    private String formattedDateTime = date.format(formatter); //it formats the LocalDatetime

    private int clientId;  // clientId is now assigned based on the Client class
    private int employeeId;//employeeId is now assigned based on the Employee class
    private double amount;
    private long srcAccnum; // the Account that sends the money
    private  long dstAccnum; // the Account that receives the money

    public Transaction( Client client, Employee employee, double amount, Account srcAcc, Account dstAcc) {
        if (client==null) this.clientId =0;
        else this.clientId = client.getID(); //It takes the client id from Client class
        if (employee==null) this.employeeId=0;
        else this.employeeId= employee.getID();//It takes the employee id from Employee class
        this.amount = amount;
        if (srcAcc==null) this.srcAccnum =0;
        else this.srcAccnum = srcAcc.getAccountNumber();
        if (dstAcc==null) this.dstAccnum =0;
        else this.dstAccnum = dstAcc.getAccountNumber();
    }

    public Transaction() {

    }

    public static void createTransaction( Client client, Employee employee, double amount, Account srcAcc, Account dstAcc, ArrayList<Transaction> transactions) {
        Transaction trans = new Transaction( client, employee, amount, srcAcc, dstAcc);
        transactions.add(trans);
    }


    public String getFormattedDateTime() {
        return formattedDateTime;
    }
    public void setFormatterDateTime(String formattedDateTime){
        this.formattedDateTime=formattedDateTime;

    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId=employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getSrcAccnum() {
        return srcAccnum;
    }

    public void setSrcAccnum(long srcAccnum) {
        this.srcAccnum = srcAccnum;
    }

    public long getDstAccnum() {
        return dstAccnum;
    }

    public void setDstAccnum(long dstAccnum) {
        this.dstAccnum = dstAccnum;
    }

    public void displayTransaction() {
        System.out.println("Transaction Details:");
        System.out.println("Date: " + formattedDateTime);
        System.out.println("Client ID: " + clientId);  // Display clientId
        System.out.println("Amount: " + amount);
        System.out.println("Employee: " + employeeId);
        System.out.println("Source Account: " + srcAccnum);
        System.out.println("Destination Account: " + dstAccnum);
    }
}
