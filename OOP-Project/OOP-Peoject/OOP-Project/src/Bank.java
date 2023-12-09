import java.util.Scanner;

public class Bank {
    Scanner input =new Scanner(System.in);
    private Employee listOfEmployees[]= new Employee[1000];
    private Client listOfClients[]=new Client[1000];
    private Transaction listOfTransactions[]=new Transaction[1000];
    private static int numOfEmloyees=0;
    private static int numOfClients=0;
    private static int numOfTransactions=0;
    public Bank(){}
    void Authenticate(){
        String userType;
        while(true) {
            System.out.println("Choose who are you (Client-Employee-Admin)");
            userType = input.nextLine();
            if(userType.equals("Client"||))
            break;
        }
        System.out.println("Enter Username:");
        String username = input.nextLine();
        System.out.println("Enter Password:");
        String password = input.nextLine();
        switch (userType){
            case "Client":
            case "Employee":
            case "Admin":
        }

    }
}
