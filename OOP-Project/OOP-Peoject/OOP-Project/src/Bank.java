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

    void saveClients(Client users[]){
        for (int i = 0; i < 1000; i++) {
            String saveInput=users[i].getFirstName()+"#"+users[i].getLastName()+"#";
        }
    }
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
                if (userFound){
                    System.out.println("Login successful!");
                }
                else {
                    System.out.println("User not found!");
                }
                break;
            case "Employee":
                for (int i = 0; i < numOfEmloyees; i++) {
                    if (listOfEmployees[i].getUsername().equals(username)&&listOfEmployees[i].getPassword().equals(password)){
                        userFound=true;
                        break;
                    }
                }
                if (userFound){
                    System.out.println("Login successful!");
                }
                else {
                    System.out.println("User not found!");
                }
                break;
            /*case "Admin":
                    if (admin.getUsername().equals(username)&&listOfClients[i].getPassword().equals(password)){
                        userFound=true;
                }
                if (userFound){
                    System.out.println("Login successful!");
                }
                else {
                    System.out.println("User not found!");
                }
                break;*/
        }

    }
    void ClientOptions(Client user){
        System.out.println("1-Display Account Details");
        System.out.println("2-Edit Personal Information");
        System.out.println("3-Transfer Money");
        System.out.println("4-Show Transaction History");
        System.out.println("5-Deposit");
        System.out.println("6-Withdraw");
        System.out.println("Choose From 1 to 6:");
        int choice = input.nextInt();
        switch (choice){
            case 1:
                user.DisplayClientDetails();
                break;
            case 2:
                System.out.println("Enter the new First Name:");
                String firstname= input.nextLine();
                System.out.println("Enter the new Last Name:");
                String lastname= input.nextLine();
                System.out.println("Enter the new Telephone Number:");
                int telephone= input.nextInt();
                user.EditPersonalInformation(firstname,lastname,telephone);
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                break;
        }
    }
}
