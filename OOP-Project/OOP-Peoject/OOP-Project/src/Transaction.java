import java.time.LocalDateTime;
import java.util.ArrayList;

public class Transaction {


    LocalDateTime date = LocalDateTime.now();
    private Client client;
    private Employee employee;
    private float amount;
    private Account srcAcc;
    private Account dstAcc;

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public void displaytransaction(){
        System.out.println("The transaction was in : " + date+ "to the client "+getClient()+ "of amount :"+getAmount()+" \nThe employee : "+getEmployee() );
        System.out.println("The transaction was sent from : "+getSrcAcc()+"to : "+getDstAcc());

}


}
