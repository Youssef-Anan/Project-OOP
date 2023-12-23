import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        User user=null;      Client convClient=null;     Admin convAdmin=null;       Employee convEmployee=null;
        Bank bank = new Bank();
        //Program
        bank.getBankData();
        program:while(true){

//--------------------------------------Authentication--------------------------------------------------//
//Authenticating User
            loop:while (true){
            int n = 0;
            System.out.println("1-Login\n2-Close Program");
            while(true) {
                try {
                    n = input.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("You must enter only numbers!");
                    input.nextLine();
                }
            }
            switch (n){
                case 1:
                    user=bank.Authenticate();
                    break loop;
                case 2:
                    break program;
                default:
                    System.out.println("Wrong Number!");
                    break;
            }
        }
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
                bank.ClientOptions(convClient);
            }
//Employee Options
            else if (user.getUserType().equals("Employee")) {
                bank.EmployeeOptions(convEmployee);
            }
//Admin Options
            else {
                bank.AdminOptions(convAdmin);
            }

        }
        bank.saveBankData();
    }
}
