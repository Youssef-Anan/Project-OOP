import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Bank {
    Scanner input =new Scanner(System.in);
    private ArrayList<Employee> Employees= new ArrayList<>();
    private ArrayList<Client> Clients= new ArrayList<>();
    private ArrayList<Transaction> Transactions = new ArrayList<>();
    private static int numOfEmloyees=0;
    private static int numOfClients=0;
    private static int numOfTransactions=0;
    public Bank(){}

    void saveClients(Client users[]){
        for (int i = 0; i < 1000; i++) {
            String saveInput=users[i].getFirstName()+"#"+users[i].getLastName()+"#";
            //write function
            FileHandler.writeData(saveInput);
        }
    }
    User Authenticate(){
        String userType;
        boolean userFound=false;
        User user;
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
                    if (Clients.get(i).getUsername().equals(username)&&Clients.get(i).getPassword().equals(password)){
                        userFound=true;
                user = new Employee(Employees.get(i));
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
                    if (Employees.get(i).getUsername().equals(username)&&Employees.get(i).getPassword().equals(password)){
                        userFound=true;
                        user = new Employee(Employees.get(i));
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
    return user;
    }
    void ClientOptions(Client user){
        System.out.println("1-Display Account Details");
        System.out.println("2-Edit Personal Information");
        System.out.println("3-Transfer Money");
        System.out.println("4-Show Transaction History");
        System.out.println("5-Deposit");
        System.out.println("6-Withdraw");
        System.out.println("7-Create Account");
        System.out.println("Choose From 1 to 6:");
        int choice = input.nextInt();
        switch (choice){
            case 1:
                user.DisplayClientDetails();
                break;
            case 2:
                System.out.println("Enter the new First Name:");
                String firstname= input.next();
                System.out.println("Enter the new Last Name:");
                String lastname= input.next();
                System.out.println("Enter the new Telephone Number:");
                String telephone= input.next();
                user.EditPersonalInformation(firstname,lastname,telephone);
                break;
            case 3:
                System.out.println("Choose which account you want to transfer money from");
                user.DisplayAccounts();

                System.out.println("Choose which account you want to transfer money to");
                user.DisplayAccounts();
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
    void EmployeeOptions(Employee user){
        System.out.println("1-Create CLient");
        System.out.println("2-Edit Personal Information");
        System.out.println("3-Search for Client");
        System.out.println("4-Edit Client Account");
        System.out.println("5-Display Client Details");
        System.out.println("Choose From 1 to 5:");
        int choice = input.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter the First Name:");
                String firstname= input.next();
                System.out.println("Enter the Last Name:");
                String lastname= input.next();
                System.out.println("Enter the Telephone Number:");
                String telephone= input.next();
                System.out.println("Enter the username:");
                String username= input.next();
                System.out.println("Enter the password:");
                String password= input.next();
                Clients.add(user.CreateClients(firstname,lastname,telephone,username,password));
                break;
            case 2:
                System.out.println("Enter the Address:");
                String address= input.next();
                System.out.println("Enter the Position:");
                String position= input.next();
                user.EditPersonalinformation(address,position);
                break;
            case 3:
                user.searchclientbyId(101,Clients);
                break;
            case 4:
                break;
            case 5:

                break;
            default:
                break;
        }
    }
}
