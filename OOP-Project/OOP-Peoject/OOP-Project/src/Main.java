import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Client convClient=null;     Admin convAdmin=null;       Employee convEmployee=null;
        Bank testbank = new Bank();
        //Program
        while(true){

//--------------------------------------Authentication--------------------------------------------------//
//Authenticating User
        User user=testbank.Authenticate();
//Giving User Client Authorities
        if(user.getUserType().equals("Client")){
            convClient= (Client) user;
        }
//Giving User Employee Authorities
        else if (user.getUserType().equals("Employee")) {
            convEmployee= (Employee) user;
        }
//Giving User Admin Authorities
        else {
            convAdmin = (Admin) user;
        }
//--------------------------------------Showing User Options--------------------------------------------//
//Client Options
            if(user.getUserType().equals("Client")){
                testbank.ClientOptions(convClient);
            }
//Employee Options
            else if (user.getUserType().equals("Employee")) {
                testbank.EmployeeOptions(convEmployee);
            }
//Admin Options
            else {
                testbank.AdminOptions(convAdmin);
            }

        }
    }
}
