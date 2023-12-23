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
        FileHandler.ConvertStringtoTransaction(FileHandler.readData(Transactions_File_Path),Transactions);
        FileHandler.ConvertStringtoEmployee(FileHandler.readData(Employee_File_Path),Employees);
        FileHandler.ConvertStringtoClient(FileHandler.readData(CLIENT_FILE_PATH),Clients);
    }
    public void saveBankData(){
        FileHandler.writeData(FileHandler.ConvTransactiontoString(Transactions),Transactions_File_Path,"Transactions");
        FileHandler.writeData(FileHandler.ConvEmployeetoString(Employees),Employee_File_Path,"Employees");
        FileHandler.writeData(FileHandler.ConvClientToString(Clients),CLIENT_FILE_PATH,"Clients");
    }
    public User Authenticate() {
        User user = null;
        loop :while (true) {
        System.out.println("Enter Username:");
        String username = input.next();
        System.out.println("Enter Password:");
        String password = input.next();

            if (username.equals("admin") && password.equals("admin")) {
                user = new Admin();
                user.userType = "Admin";
                System.out.println("Login successful!");
                break loop;
            }
                for (int i = 0; i < Employees.size(); i++) {
                    if (Employees.get(i).getUsername().equals(username) && Employees.get(i).getPassword().equals(password)) {
                        user = new Employee(Employees.get(i));
                        user.userType = "Employee";
                        System.out.println("Login successful!");
                        break loop;
                    }
                }
                for (int i = 0; i < Clients.size(); i++) {
                    if (Clients.get(i).getUsername().equals(username) && Clients.get(i).getPassword().equals(password)) {
                        user = new Client(Clients.get(i));
                        user.userType = "Client";
                        System.out.println("Login successful!");
                        break loop;
                    }
                }
                System.out.println("Wrong Credentials! Do you want to continue? (Yes-No)");
                String choice=input.next();
                if ("yes".equalsIgnoreCase(choice)){
                continue loop;
                }
                else break;

        }
            return user;
    }
    public void ClientOptions(Client user){
       loop: while(true){
           int choice;
        System.out.println("1-Display Account Details");
        System.out.println("2-Edit Personal Information");
        System.out.println("3-Transfer Money");
        System.out.println("4-Show Transaction History");
        System.out.println("5-Deposit");
        System.out.println("6-Withdraw");
        System.out.println("7-Create Account");
        System.out.println("8-Logout");
        System.out.println("Choose From 1 to 8:");
        while(true) {
            try {
                choice = input.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("You must only enter numbers!");
                input.nextLine();
            }
        }
        switch (choice){
            case 1:
                user.DisplayClientDetails();
                break;
            case 2:
                user.EditPersonalInformation();
                break;
            case 3:
                long source,dest;
                while(true){
                System.out.println("Choose which account you want to transfer money from[Enter Account Number]:");
                user.DisplayAccounts();
                while (true){
                try{
                 source= input.nextLong();
                 break;
                } catch (Exception e) {
                    System.out.println("You must only enter numbers!");
                    input.nextLine();
                }}
                if (Account.getUserAccount(user,source)==null){
                    System.out.println("Account not found, Try again!");
                    System.out.println("Do you want to continue? (Yes-No)");
                    String choice1=input.next();
                    if ("yes".equalsIgnoreCase(choice1)){
                        continue ;
                    }
                    else break;
                }
                }
                while(true){
                    System.out.println("Choose which account you want to transfer money to[Enter Account Number]:");
                    user.DisplayAccounts();
                    while (true){
                        try{
                            dest= input.nextLong();
                            break;
                        } catch (Exception e) {
                            System.out.println("You must only enter numbers!");
                            input.nextLine();
                        }}
                    if (Account.getAccountbyID(Clients,dest)==null){
                        System.out.println("Account not found, Try again!");
                    System.out.println("Do you want to continue? (Yes-No)");
                    String choice1=input.next();
                    if ("yes".equalsIgnoreCase(choice1)){
                        continue ;
                    }
                    else break;
                    }
                }
                System.out.println("Enter the amount:");
                double amount;
                while(true){
                    try{
                        amount= input.nextDouble();
                        break;
                    } catch (Exception e){
                        System.out.println("You must only enter numbers!");
                        input.nextLine();
                    }
                }
                user.TransferMoney(amount,Account.getUserAccount(user,source),Account.getAccountbyID(Clients,dest));
                Transaction.createTransaction(user,null,amount,Account.getUserAccount(user,source),Account.getAccountbyID(Clients,dest),Transactions);
                break;
            case 4:
                user.ShowTransactionHistory(Transactions);
                break;
            case 5:
                long Dacc;
                while(true){
                    System.out.println("Choose which account you want to Deposit to[Enter Account Number]:");
                    user.DisplayAccounts();
                    while (true){
                        try{
                            Dacc= input.nextLong();
                            break;
                        } catch (Exception e) {
                            System.out.println("You must only enter numbers!");
                            input.nextLine();
                        }}
                    if (Account.getUserAccount(user,Dacc)==null) {
                        System.out.println("Account not found, Try again!");
                        System.out.println("Do you want to continue? (Yes-No)");
                        String choice1 = input.next();
                        if (!"yes".equalsIgnoreCase(choice1)) {
                            break;
                        }
                    }
                    else break;
                }
                System.out.println("Enter the amount:");
                double Damount;
                while (true){
                    try{
                        Damount= input.nextDouble();
                        break;
                    } catch (Exception e) {
                        System.out.println("You must only enter numbers!");
                        input.nextLine();
                    }}
                user.TakeDeposit(Damount,Account.getUserAccount(user,Dacc));
                Transaction.createTransaction(user,null,Damount,Account.getAccountbyID(Clients,Dacc),null,Transactions);

                break;
            case 6:
                long Wacc;
                while(true){
                    System.out.println("Choose which account you want to Withdraw from[Enter Account Number]:");
                    user.DisplayAccounts();
                    while (true){
                        try{
                            Wacc= input.nextLong();
                            break;
                        } catch (Exception e) {
                            System.out.println("You must only enter numbers!");
                            input.nextLine();
                        }}
                    if (Account.getUserAccount(user,Wacc)==null){
                        System.out.println("Account not found, Try again!");
                    System.out.println("Do you want to continue? (Yes-No)");
                    String choice1=input.next();
                    if (!"yes".equalsIgnoreCase(choice1)) {
                        break;
                    }
                    }
                }
                System.out.println("Enter the amount:");
                double Wamount;
                while (true){
                    try{
                        Wamount= input.nextDouble();
                        break;
                    } catch (Exception e) {
                        System.out.println("You must only enter numbers!");
                        input.nextLine();
                    }}
                user.Withdraw(Wamount,Account.getUserAccount(user,Wacc));
                Transaction.createTransaction(user,null,-Wamount,Account.getUserAccount(user,Wacc),null,Transactions);
                break;
            case 7:
                String c=null;
                while(true) {
                    System.out.println("What type of Account do you wish to create?[Current-Saving]");
                    c=input.next();
                    if(c.equalsIgnoreCase("Current")||c.equalsIgnoreCase("Saving")){
                        break;
                    }
                    else{
                        System.out.println("Wrong input! Please try again.");
                        System.out.println("Do you want to continue? (Yes-No)");
                        String choice1=input.next();
                        if (!"yes".equalsIgnoreCase(choice1)) {
                            break;
                        }
                    }
                }
                c=c.toLowerCase();
                switch (c){
                    case "saving":
                        user.createSavings();
                        break;
                    case "current":
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
        for (int i = 0; i < Clients.size(); i++) {
            if (Clients.get(i).getID() == user.getID()){
                Clients.set(i,user);
                break;
            }
        }
    }
    public void EmployeeOptions(Employee user){
        loop :while(true) {
            int choice;
            System.out.println("1-Display Account Details");
            System.out.println("2-Edit Personal Information");
            System.out.println("3-Create Client");
            System.out.println("4-Delete Client");
            System.out.println("5-Search for Client");
            System.out.println("6-Edit Client Account");
            System.out.println("7-Logout");
            System.out.println("Choose From 1 to 7:");
            while(true) {
                try {
                    choice = input.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("You must only enter numbers!");
                    input.nextLine();
                }
            }
            switch (choice) {
                case 1:
                    user.DisplayEmployeeDetails();
                    break;
                case 2:
                    user.EditPersonalinformation();
                    break;
                case 3:
                    user.CreateClients(Clients,Employees);
                    break;
                case 4:
                    user.DeleteClient(Clients);
                    break;
                case 5:
                    user.searchclientbyId(Clients);
                    break;
                case 6:
                    user.EditClientAccount(Clients);
                    break;
                case 7:
                    break loop;
                default:
                    System.out.println("Wrong input!");
                    break;
            }
        }
        for (int i = 0; i < Employees.size(); i++) {
            if (Employees.get(i).getID()== user.getID()){
                Employees.set(i,user);
                break;
            }
        }
    }
    public void AdminOptions(Admin user){
        loop :while(true) {
            int choice;
            System.out.println("1-Create Employee");
            System.out.println("2-Delete Employee");
            System.out.println("3-Display Transactions");
            System.out.println("4-Authorize Employee");
            System.out.println("5-Display All Clients");
            System.out.println("6-Display All Employees");
            System.out.println("7-Logout");
            System.out.println("Choose From 1 to 7:");
            while(true) {
                try {
                    choice = input.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("You must only enter numbers!");
                    input.nextLine();
                }
            }
            switch (choice) {
                case 1:
                    user.CreateEmployee(Employees,Clients);
                    break;
                case 2:
                    user.DeleteEmployee(Employees);
                    break;
                case 3:
                        String sType;
                    while (true) {
                        System.out.println("Search by (Client-Employee-Date)?");
                        sType = input.next();
                        if (sType.equalsIgnoreCase("Client") || sType.equalsIgnoreCase("Employee") || sType.equalsIgnoreCase("Date")) {
                            break;
                        } else {
                            System.out.println("Wrong input! Please try again.");
                            System.out.println("Do you want to continue? (Yes-No)");
                            String choice1=input.next();
                            if (!"yes".equalsIgnoreCase(choice1)) {
                                break;
                            }
                        }
                        }
                        if(sType.equalsIgnoreCase("Client")){
                                user.displayAllTransactionsbyClientID(Transactions);
                        }
                        else if (sType.equalsIgnoreCase("Employee")){
                                user.displayAllTransactionsbyEmployeeID(Transactions);
                        }
                        else if (sType.equalsIgnoreCase("Date")){
                                user.displayAllTransactionsbydate(Transactions);
                        }
                    break;
                case 4:
                    user.AuthorizeNewEmp(Employees);
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
