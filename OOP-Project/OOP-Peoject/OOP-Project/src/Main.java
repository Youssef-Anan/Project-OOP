public class Main {
    public static void main(String[] args) {
        Bank testbank = new Bank();
        user=testbank.Authenticate();
        while(true){
        testbank.EmployeeOptions(user);
        }
    }
}
