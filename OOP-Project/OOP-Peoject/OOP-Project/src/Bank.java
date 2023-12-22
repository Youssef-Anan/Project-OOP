import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Bank {
    Scanner input =new Scanner(System.in);
    private static final String Transactions_File_Path = "transactions.txt";
    private static final String Employee_File_Path = "employee.txt";
    private static final String CLIENT_FILE_PATH = "client.txt";
    private ArrayList<Employee> Employees= new ArrayList<>();
    public ArrayList<Client> Clients= new ArrayList<>();
    private ArrayList<Transaction> Transactions = new ArrayList<>();

    public Bank(){}
    public void getBankData(){
       // FileHandler.ConvertStringtoTransaction(FileHandler.readData(Transactions_File_Path),Transactions);
        FileHandler.ConvertStringtoEmployee(FileHandler.readData(Employee_File_Path),Employees);
        FileHandler.ConvertStringtoClient(FileHandler.readData(CLIENT_FILE_PATH),Clients);
    }
    public void saveBankData(){
        FileHandler.writeData(FileHandler.ConvTransactiontoString(Transactions),Transactions_File_Path);
        FileHandler.writeData(FileHandler.ConvEmployeetoString(Employees),Employee_File_Path);
        FileHandler.writeData(FileHandler.ConvClientToString(Clients),CLIENT_FILE_PATH);
    }
    public User Authenticate() {
        String userType;
        boolean userFound = false;
        User user = null;
        while (true) {
            System.out.println("Choose who are you (Client-Employee-Admin)");
            userType = input.nextLine();
            if (userType.equals("Client") || userType.equals("Employee") || userType.equals("Admin")) {
                break;
            } else {
                System.out.println("Wrong input! Please try again.");
            }
        }
        loop :while (true) {
        System.out.println("Enter Username:");
        String username = input.nextLine();
        System.out.println("Enter Password:");
        String password = input.nextLine();
            if (userType.equals("Client")) {
                for (int i = 0; i < Clients.size(); i++) {
                    if (Clients.get(i).getUsername().equals(username) && Clients.get(i).getPassword().equals(password)) {
                        userFound = true;
                        user = new Client(Clients.get(i));
                        user.userType = "Client";
                        System.out.println("Login successful!");
                        break loop;

                    }
                }
                System.out.println("Wrong Credentials!");
                continue loop;
            } else if (userType.equals("Employee")) {
                for (int i = 0; i < Employees.size(); i++) {
                    if (Employees.get(i).getUsername().equals(username) && Employees.get(i).getPassword().equals(password)) {
                        userFound = true;
                        user = new Employee(Employees.get(i));
                        user.userType = "Employee";
                        System.out.println("Login successful!");
                        break loop;

                    }
                }
                System.out.println("Wrong Credentials!");
                continue loop;
            } else if (userType.equals("Admin")) {
                if (username.equals("admin") && password.equals("admin")) {
                    userFound = true;
                    user = new Admin();
                    user.userType = "Admin";
                    System.out.println("Login successful!");
                    break loop;
                }
                else{
                    System.out.println("Wrong Credentials!");
                    continue loop;
                }
            }

        }
            return user;
    }
    public void ClientOptions(Client user,ArrayList<Client> a){
       loop: while(true){
        System.out.println("1-Display Account Details");
        System.out.println("2-Edit Personal Information");
        System.out.println("3-Transfer Money");
        System.out.println("4-Show Transaction History");
        System.out.println("5-Deposit");
        System.out.println("6-Withdraw");
        System.out.println("7-Create Account");
        System.out.println("8-Logout");
        System.out.println("Choose From 1 to 8:");
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
                user.EditPersonalInformation();
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
            case 7:
                String c=null;
                while(true) {
                    System.out.println("What type of Account do you wish to create?[Current-Saving]");
                    c=input.next();
                    if(c.equals("Current")||c.equals("Saving")){
                        break;
                    }
                    else{
                        System.out.println("Wrong input! Please try again.");
                    }
                }
                switch (c){
                    case "Saving":
                        user.createSavings();
                        break;
                    case "Current":
                        user.createCurrent();
                        break;
                }
                break;
            case 8:
                break loop;
            default:
                System.out.println("Wrong input!");
                break;
        }
       }
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getID()== user.getID()){
                a.set(i,user);
                break;
            }
        }
    }
    public void EmployeeOptions(Employee user,ArrayList<Employee> a){
        loop :while(true) {
            System.out.println("1-Create Client");
            System.out.println("2-Edit Personal Information");
            System.out.println("3-Search for Client");
            System.out.println("4-Edit Client Account");
            System.out.println("5-Display Client Details");
            System.out.println("6-Logout");
            System.out.println("Choose From 1 to 6:");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    user.CreateClients(Clients);
                    break;
                case 2:
                    user.EditPersonalinformation();
                    break;
                case 3:
                    user.searchclientbyId(Clients);
                    break;
                case 4:
                    user.EditClientAccount(Clients);
                    break;
                case 5:
                    user.searchclientbyId(Clients);
                    break;
                case 6:
                    break loop;
                default:
                    System.out.println("Wrong input!");
                    break;
            }
        }
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getID()== user.getID()){
                a.set(i,user);
                break;
            }
        }
    }
    public void AdminOptions(Admin user){
        loop :while(true) {
            System.out.println("1-Create Employee");
            System.out.println("2-Delete Employee");
            System.out.println("3-Display Transactions");///By kza haga
            System.out.println("4-Authorize Employee");
            System.out.println("5-Display All Clients");
            System.out.println("6-Display All Employees");
            System.out.println("7-Logout");
            System.out.println("Choose From 1 to 7:");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    user.CreateEmployee(Employees);
                    break;
                case 2:
                    user.DeleteEmployee(Employees);
                    break;
                case 3:

                    break;
                case 4:
                    break;
                case 5:
                    user.Display_All_Clients(Clients);
                    break;
                case 6:
                    user.Display_All_Employees(Employees);
                    break;
                case 7:
                    break loop;
                default:
                    System.out.println("Wrong input!");
                    break;
            }
        }
    }

    public ArrayList<Client> getClients() {
        return Clients;
    }

    public ArrayList<Employee> getEmployees() {
        return Employees;
    }

    public ArrayList<Transaction> getTransactions() {
        return Transactions;
    }
}
