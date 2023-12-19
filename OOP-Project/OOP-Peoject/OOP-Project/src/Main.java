import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Client convClient=null;
        Admin convAdmin=null;
        Employee convEmployee=null;
        Bank testbank = new Bank();
        //Employee test=new Employee(1,"First Name","Last Name","emp","emp","abc","pos","asu",202,"4");
        //testbank.Employees.add(test);
        while(true){
        User user=testbank.Authenticate();

        if(user.getUserType().equals("Client")){
            convClient= (Client) user;
        }
        else if (user.getUserType().equals("Employee")) {
            convEmployee= (Employee) user;
        }
        else {
            convAdmin = (Admin) user;
        }
            if(user.getUserType().equals("Client")){
                testbank.ClientOptions(convClient);
            }
            else if (user.getUserType().equals("Employee")) {
                testbank.EmployeeOptions(convEmployee);
            }
            else {
                testbank.AdminOptions(convAdmin);
            }

        }
    }
}
