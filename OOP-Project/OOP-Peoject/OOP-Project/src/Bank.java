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
        boolean userFound=false;
        while(true) {
            System.out.println("Choose who are you (Client-Employee-Admin)");
            userType = input.nextLine();
            if(userType.equals("Client")||userType.equals("Employee")||userType.equals("Admin")){
                break;
            }
            else{
                System.out.println("Wrong input! Please try again.");
            }
        }
        System.out.println("Enter Username:");
        String username = input.nextLine();
        System.out.println("Enter Password:");
        String password = input.nextLine();
        switch (userType){
            case "Client":
                for (int i = 0; i < numOfClients; i++) {
                    if (listOfClients[i].getUsername().equals(username)&&listOfClients[i].getPassword().equals(password)){
                        userFound=true;
                        break;
                    }
                }
                break;
            case "Employee":
                System.out.println("Employee");
            case "Admin":
                System.out.println("Admin");
        }

    }
}
