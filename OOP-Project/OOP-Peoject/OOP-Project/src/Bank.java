import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Bank {
    Scanner input =new Scanner(System.in);
    //Current Date
    private final LocalDateTime date = LocalDateTime.now();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm");
    private String Time = date.format(formatter); //it formats the LocalDatetime
    // File paths for data persistence
    private static final String Transactions_File_Path = "transactions.txt";
    private static final String Employee_File_Path = "employee.txt";
    private static final String CLIENT_FILE_PATH = "client.txt";

    // Lists to store bank data
    private ArrayList<Employee> Employees= new ArrayList<>();
    public ArrayList<Client> Clients= new ArrayList<>();
    private ArrayList<Transaction> Transactions = new ArrayList<>();

    // Default constructor
    public Bank(){}

    // Load bank data from files
    public void getBankData(){
        FileHandler.ConvertStringtoTransaction(FileHandler.readData(Transactions_File_Path),Transactions);
        FileHandler.ConvertStringtoEmployee(FileHandler.readData(Employee_File_Path),Employees);
        FileHandler.ConvertStringtoClient(FileHandler.readData(CLIENT_FILE_PATH),Clients);
    }
    //----------------------------------------------------------------------------------------------------
    // Save bank data to files
    public void saveBankData(){
        FileHandler.writeData(FileHandler.ConvTransactiontoString(Transactions),Transactions_File_Path,"Transactions");
        FileHandler.writeData(FileHandler.ConvEmployeetoString(Employees),Employee_File_Path,"Employees");
        FileHandler.writeData(FileHandler.ConvClientToString(Clients),CLIENT_FILE_PATH,"Clients");
    }
    //----------------------------------------------------------------------------------------------------
    //Authenticates the user based on the entered username and password.
    public User Authenticate() {
        User user = null;

        // Infinite loop until valid authentication
        loop: while (true) {
            System.out.println("-----------------------------------Login---------------------------------------");

            System.out.println("Enter Username:");
            String username = input.next();
            System.out.println("Enter Password:");
            String password = input.next();
            System.out.println("-----------------------------------------------------------------------------------");

            // Check if the entered credentials match admin credentials
            if (username.equals("admin") && password.equals("admin")) {
                user = new Admin();
                user.userType = "Admin";
                System.out.println("Login successful!");

                break loop;
            }

            // Check if the entered credentials match employee credentials
            for (int i = 0; i < Employees.size(); i++) {
                if (Employees.get(i).getUsername().equals(username) && Employees.get(i).getPassword().equals(password)) {
                    user = new Employee(Employees.get(i));
                    user.userType = "Employee";
                    System.out.println("Login successful!");
                    break loop;
                }
            }

            // Check if the entered credentials match client credentials
            for (int i = 0; i < Clients.size(); i++) {
                if (Clients.get(i).getUsername().equals(username) && Clients.get(i).getPassword().equals(password)) {
                    user = new Client(Clients.get(i));
                    user.userType = "Client";
                    System.out.println("Login successful!");
                    break loop;
                }
            }

            // Prompt user to continue or exit in case of wrong credentials
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("Wrong Credentials! Do you want to continue? (Yes-No)");
            String choice = input.next();
            if ("yes".equalsIgnoreCase(choice)) {
                continue loop;
            } else {
                break;
            }
        }
        return user;
    }
    //----------------------------------------------------------------------------------------------------
    //Displays and manages client-specific options and operations in a loop until the user chooses to logout.
    public void ClientOptions(Client user) {
        loop: while (true) {
            int choice;

            // Displaying menu options
            System.out.println("Client:"+user.getFirstName()+" "+user.getLastName()+"-----------------------------Home---------------------------------------Date:"+Time);
            System.out.println("1-Display Account Details");
            System.out.println("2-Edit Personal Information");
            System.out.println("3-Transfer Money");
            System.out.println("4-Show Transaction History");
            System.out.println("5-Deposit");
            System.out.println("6-Withdraw");
            System.out.println("7-Create Account");
            System.out.println("8-Logout");
            System.out.println("Choose From 1 to 8:");

            // Input validation for user choice
            while (true) {
                try {
                    choice = input.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("You must only enter numbers!");
                    input.nextLine();
                }
            }

            // Switch case to handle user choices
            switch (choice) {
                case 1:
                    System.out.println("------------------------------------Display Account Details---------------------------------");
                    user.DisplayClientDetails();
                    break;
                case 2:
                    System.out.println("------------------------------------Edit Personal Information-------------------------------");
                    user.EditPersonalInformation();
                    break;
                case 3:
                    // Transfer money operation
                    long source, dest;
                    System.out.println("------------------------------------Transfer Money------------------------------------------");
                        user.DisplayAccounts();
                        System.out.println("-----------------");
                        System.out.println("Choose which account you want to transfer money from[Enter Account Number]:");
                        while (true) {
                            try {
                                source = input.nextLong();
                                break;
                            } catch (Exception e) {
                                System.out.println("-----------------------------------------------------------------------------------");
                                user.DisplayAccounts();
                                System.out.println("-----------------");
                                System.out.println("You must only enter numbers!");
                                input.nextLine();
                            }
                        }
                        if (Account.getUserAccount(user, source) == null) {
                            System.out.println("-----------------------------------------------------------------------------------");
                            System.out.println("Account not found, Try again!");
                            System.out.println("Do you want to continue? (Yes-No)");
                            String choice1 = input.next();
                            if ("yes".equalsIgnoreCase(choice1)) {
                                continue;
                            } else {
                                break ;
                            }
                        }

                        System.out.println("-----------------------------------------------------------------------------------");
                        user.DisplayAccounts();
                        System.out.println("-----------------");
                        System.out.println("Choose which account you want to transfer money to[Enter Account Number]:");
                        while (true) {
                            try {
                                dest = input.nextLong();
                                break;
                            } catch (Exception e) {
                                System.out.println("-----------------------------------------------------------------------------------");
                                user.DisplayAccounts();
                                System.out.println("-----------------");
                                System.out.println("You must only enter numbers!");
                                input.nextLine();
                            }
                        }
                        if (Account.getAccountbyID(Clients, dest) == null) {
                            System.out.println("-----------------------------------------------------------------------------------");
                            System.out.println("Account not found, Try again!");
                            System.out.println("Do you want to continue? (Yes-No)");
                            String choice1 = input.next();
                            if ("yes".equalsIgnoreCase(choice1)) {
                                continue;
                            } else {
                                break;
                            }
                        }
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.println("Enter the amount:");
                    double amount;
                    while (true) {
                        try {
                            amount = input.nextDouble();
                            break;
                        } catch (Exception e) {
                            System.out.println("-----------------------------------------------------------------------------------");
                            System.out.println("You must only enter numbers!");
                            input.nextLine();
                        }
                    }
                    user.TransferMoney(amount, Account.getUserAccount(user, source), Account.getAccountbyID(Clients, dest));
                    Transaction.createTransaction(user, null, amount, Account.getUserAccount(user, source),
                            Account.getAccountbyID(Clients, dest), Transactions);
                    break;
                case 4:
                    System.out.println("------------------------------------Show Transaction History--------------------------------");
                    user.ShowTransactionHistory(Transactions);
                    break;
                case 5:
                    // Deposit operation
                    long Dacc;
                        System.out.println("------------------------------------Deposit---------------------------------------------");
                        user.DisplayAccounts();
                        System.out.println("-----------------");
                        System.out.println("Choose which account you want to Deposit to[Enter Account Number]:");
                        while (true) {
                            try {
                                Dacc = input.nextLong();
                                break;
                            } catch (Exception e) {
                                System.out.println("-----------------------------------------------------------------------------------");
                                user.DisplayAccounts();
                                System.out.println("-----------------");
                                System.out.println("You must only enter numbers!");
                                input.nextLine();
                            }
                        }
                        if (Account.getUserAccount(user, Dacc) == null) {
                            System.out.println("-----------------------------------------------------------------------------------");
                            System.out.println("Account not found, Try again!");
                            System.out.println("Do you want to continue? (Yes-No)");
                            String choice1 = input.next();
                            if (!"yes".equalsIgnoreCase(choice1)) {
                                break;
                            }
                        }

                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.println("Enter the amount:");
                    double Damount;
                    while (true) {
                        try {
                            Damount = input.nextDouble();
                            break;
                        } catch (Exception e) {
                            System.out.println("-----------------------------------------------------------------------------------");
                            System.out.println("You must only enter numbers!");
                            input.nextLine();
                        }
                    }
                    user.TakeDeposit(Damount, Account.getUserAccount(user, Dacc));
                    Transaction.createTransaction(user, null, Damount, Account.getUserAccount(user, Dacc), null,
                            Transactions);
                    break;
                case 6:
                    // Withdraw operation
                    long Wacc;
                        System.out.println("------------------------------------Withdraw--------------------------------------------");
                        user.DisplayAccounts();
                        System.out.println("-----------------");
                        System.out.println("Choose which account you want to Withdraw from[Enter Account Number]:");
                        while (true) {
                            try {
                                Wacc = input.nextLong();
                                break;
                            } catch (Exception e) {
                                System.out.println("-----------------------------------------------------------------------------------");
                                user.DisplayAccounts();
                                System.out.println("-----------------");
                                System.out.println("You must only enter numbers!");
                                input.nextLine();
                            }
                        }
                        if (Account.getUserAccount(user, Wacc) == null) {
                            System.out.println("-----------------------------------------------------------------------------------");
                            System.out.println("Account not found, Try again!");
                            System.out.println("Do you want to continue? (Yes-No)");
                            String choice1 = input.next();
                            if (!"yes".equalsIgnoreCase(choice1)) {
                                break;
                            }
                        }

                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.println("Enter the amount:");
                    double Wamount;
                    while (true) {
                        try {
                            Wamount = input.nextDouble();
                            break;
                        } catch (Exception e) {
                            System.out.println("-----------------------------------------------------------------------------------");
                            System.out.println("You must only enter numbers!");
                            input.nextLine();
                        }
                    }
                    user.Withdraw(Wamount, Account.getUserAccount(user, Wacc));
                    Transaction.createTransaction(user, null, -Wamount, Account.getUserAccount(user, Wacc), null,
                            Transactions);
                    break;
                case 7:
                    // Create account operation
                    String c = null;
                    while (true) {
                        System.out.println("------------------------------------Create Account--------------------------------------");
                        System.out.println("What type of Account do you wish to create?[Current-Saving]");
                        c = input.next();
                        if (c.equalsIgnoreCase("Current") || c.equalsIgnoreCase("Saving")) {
                            break;
                        } else {
                            System.out.println("-----------------------------------------------------------------------------------");
                            System.out.println("Wrong input! Please try again.");
                            System.out.println("Do you want to continue? (Yes-No)");
                            String choice1 = input.next();
                            if (!"yes".equalsIgnoreCase(choice1)) {
                                break;
                            }
                        }
                    }
                    c = c.toLowerCase();
                    System.out.println("-----------------------------------------------------------------------------------");
                    switch (c) {
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
            for (int i = 0; i < Clients.size(); i++) {
                if (Clients.get(i).getID() == user.getID()) {
                    Clients.set(i, user);
                    break;
                }
            }
        }

        // Update the user data after completing client options

    }
    //----------------------------------------------------------------------------------------------------
    //Displays and manages employee-specific options and operations in a loop until the user chooses to logout.
    public void EmployeeOptions(Employee user) {
        loop: while (true) {
            int choice;
            // Displaying menu options
            System.out.println("Client:"+user.getFirstName()+" "+user.getLastName()+"-----------------------------Home---------------------------------------Date:"+Time);
            System.out.println("1-Display Account Details");
            System.out.println("2-Edit Personal Information");
            System.out.println("3-Create Client");
            System.out.println("4-Delete Client");
            System.out.println("5-Search for Client");
            System.out.println("6-Edit Client Account");
            System.out.println("7-Logout");
            System.out.println("Choose From 1 to 7:");

            // Input validation for user choice
            while (true) {
                try {
                    choice = input.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("You must only enter numbers!");
                    input.nextLine();
                }
            }

            // Switch case to handle user choices
            switch (choice) {
                case 1:
                    System.out.println("------------------------------------Display Account Details----------------------------");
                    user.DisplayEmployeeDetails();
                    break;
                case 2:
                    System.out.println("------------------------------------Edit Personal Information--------------------------");
                    user.EditPersonalinformation();
                    break;
                case 3:
                    // Create client operation
                    System.out.println("------------------------------------Create Client--------------------------------------");
                    user.CreateClients(Clients, Employees);
                    break;
                case 4:
                    // Delete client operation
                    System.out.println("------------------------------------Delete Client--------------------------------------");
                    user.DeleteClient(Clients);
                    break;
                case 5:
                    // Search for client operation
                    System.out.println("------------------------------------Search for Client----------------------------------");
                    user.searchclientbyId(Clients);
                    break;
                case 6:
                    // Edit client account operation
                    System.out.println("------------------------------------Edit Client Account--------------------------------");
                    user.EditClientAccount(Clients);
                    break;
                case 7:
                    // Logout operation
                    break loop;
                default:
                    System.out.println("Wrong input!");
                    break;
            }
            for (int i = 0; i < Employees.size(); i++) {
                if (Employees.get(i).getID() == user.getID()) {
                    Employees.set(i, user);
                    break;
                }
            }
        }
        // Update the user data after completing employee options
    }
    //----------------------------------------------------------------------------------------------------
    //Displays and manages admin-specific options and operations in a loop until the admin chooses to logout.
    public void AdminOptions(Admin user) {
        loop: while (true) {
            int choice;

            // Displaying menu options
            System.out.println("Admin-----------------------------Home---------------------------------------Date:"+Time);
            System.out.println("2-Delete Employee");
            System.out.println("3-Display Transactions");
            System.out.println("4-Authorize Employee");
            System.out.println("5-Display All Clients");
            System.out.println("6-Display All Employees");
            System.out.println("7-Logout");
            System.out.println("Choose From 1 to 7:");

            // Input validation for user choice
            while (true) {
                try {
                    choice = input.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("You must only enter numbers!");
                    input.nextLine();
                }
            }

            // Switch case to handle user choices
            switch (choice) {
                case 1:
                    // Create employee operation
                    System.out.println("-------------------------------------Delete Employee-------------------------------------");
                    user.CreateEmployee(Employees, Clients);
                    break;
                case 2:
                    // Delete employee operation
                    System.out.println("-------------------------------------Display Transactions--------------------------------");
                    user.DeleteEmployee(Employees);
                    break;
                case 3:
                    // Display transactions based on user input (client, employee, or date)
                    String sType;
                    while (true) {
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.println("Search by (Client-Employee-Date)?");
                        sType = input.next();
                        if (sType.equalsIgnoreCase("Client") || sType.equalsIgnoreCase("Employee") || sType.equalsIgnoreCase("Date")) {
                            break;
                        } else {
                            System.out.println("-----------------------------------------------------------------------------------");
                            System.out.println("Wrong input! Please try again.");
                            System.out.println("Do you want to continue? (Yes-No)");
                            String choice1 = input.next();
                            if (!"yes".equalsIgnoreCase(choice1)) {
                                break;
                            }
                        }
                    }
                    if (sType.equalsIgnoreCase("Client")) {
                        // Display transactions by client ID
                        System.out.println("-----------------------------------------------------------------------------------");
                        user.displayAllTransactionsbyClientID(Transactions);
                    } else if (sType.equalsIgnoreCase("Employee")) {
                        // Display transactions by employee ID
                        System.out.println("-----------------------------------------------------------------------------------");
                        user.displayAllTransactionsbyEmployeeID(Transactions);
                    } else if (sType.equalsIgnoreCase("Date")) {
                        // Display transactions by date
                        System.out.println("-----------------------------------------------------------------------------------");
                        user.displayAllTransactionsbydate(Transactions);
                    }
                    break;
                case 4:
                    // Authorize new employee operation
                    System.out.println("-------------------------------------Authorize Employee----------------------------------");
                    user.AuthorizeNewEmp(Employees);
                    break;
                case 5:
                    // Display all clients operation
                    System.out.println("-------------------------------------Display All Clients---------------------------------");
                    user.Display_All_Clients(Clients);
                    break;
                case 6:
                    // Display all employees operation
                    System.out.println("-------------------------------------Display All Employees-------------------------------");
                    user.Display_All_Employees(Employees);
                    break;
                case 7:
                    // Logout operation
                    break loop;
                default:
                    System.out.println("Wrong input!");
                    break;
            }
        }
    }
    //----------------------------------------------------------------------------------------------------
}
