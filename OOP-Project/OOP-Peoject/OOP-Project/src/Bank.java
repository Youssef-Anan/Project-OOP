import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Bank {
    Scanner input =new Scanner(System.in);
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
    /**
     * Authenticates the user based on the entered username and password.
     * If the user is an admin, employee, or client, a corresponding object is created.
     * The user is prompted to re-enter credentials in case of incorrect input.
     * @return The authenticated user object (Admin, Employee, or Client).
     */
    public User Authenticate() {
        User user = null;

        // Infinite loop until valid authentication
        loop: while (true) {
            System.out.println("Enter Username:");
            String username = input.next();
            System.out.println("Enter Password:");
            String password = input.next();

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
    /*
     * Displays and manages client-specific options and operations in a loop until the user chooses to logout.
     * The user can view account details, edit personal information, transfer money, view transaction history,
     * deposit, withdraw, create an account, or logout.
     */
    public void ClientOptions(Client user) {
        loop: while (true) {
            int choice;

            // Displaying menu options
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
                    user.DisplayClientDetails();
                    break;
                case 2:
                    user.EditPersonalInformation();
                    break;
                case 3:
                    // Transfer money operation
                    long source, dest;
                    while (true) {
                        System.out.println("Choose which account you want to transfer money from[Enter Account Number]:");
                        user.DisplayAccounts();
                        while (true) {
                            try {
                                source = input.nextLong();
                                break;
                            } catch (Exception e) {
                                System.out.println("You must only enter numbers!");
                                input.nextLine();
                            }
                        }
                        if (Account.getUserAccount(user, source) == null) {
                            System.out.println("Account not found, Try again!");
                            System.out.println("Do you want to continue? (Yes-No)");
                            String choice1 = input.next();
                            if ("yes".equalsIgnoreCase(choice1)) {
                                continue;
                            } else {
                                break;
                            }
                        }else break;
                    }
                    while (true) {
                        System.out.println("Choose which account you want to transfer money to[Enter Account Number]:");
                        user.DisplayAccounts();
                        while (true) {
                            try {
                                dest = input.nextLong();
                                break;
                            } catch (Exception e) {
                                System.out.println("You must only enter numbers!");
                                input.nextLine();
                            }
                        }
                        if (Account.getAccountbyID(Clients, dest) == null) {
                            System.out.println("Account not found, Try again!");
                            System.out.println("Do you want to continue? (Yes-No)");
                            String choice1 = input.next();
                            if ("yes".equalsIgnoreCase(choice1)) {
                                continue;
                            } else {
                                break;
                            }
                        }else break;
                    }
                    System.out.println("Enter the amount:");
                    double amount;
                    while (true) {
                        try {
                            amount = input.nextDouble();
                            break;
                        } catch (Exception e) {
                            System.out.println("You must only enter numbers!");
                            input.nextLine();
                        }
                    }
                    user.TransferMoney(amount, Account.getUserAccount(user, source), Account.getAccountbyID(Clients, dest));
                    Transaction.createTransaction(user, null, amount, Account.getUserAccount(user, source),
                            Account.getAccountbyID(Clients, dest), Transactions);
                    break;
                case 4:
                    user.ShowTransactionHistory(Transactions);
                    break;
                case 5:
                    // Deposit operation
                    long Dacc;
                    while (true) {
                        System.out.println("Choose which account you want to Deposit to[Enter Account Number]:");
                        user.DisplayAccounts();
                        while (true) {
                            try {
                                Dacc = input.nextLong();
                                break;
                            } catch (Exception e) {
                                System.out.println("You must only enter numbers!");
                                input.nextLine();
                            }
                        }
                        if (Account.getUserAccount(user, Dacc) == null) {
                            System.out.println("Account not found, Try again!");
                            System.out.println("Do you want to continue? (Yes-No)");
                            String choice1 = input.next();
                            if (!"yes".equalsIgnoreCase(choice1)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    System.out.println("Enter the amount:");
                    double Damount;
                    while (true) {
                        try {
                            Damount = input.nextDouble();
                            break;
                        } catch (Exception e) {
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
                    while (true) {
                        System.out.println("Choose which account you want to Withdraw from[Enter Account Number]:");
                        user.DisplayAccounts();
                        while (true) {
                            try {
                                Wacc = input.nextLong();
                                break;
                            } catch (Exception e) {
                                System.out.println("You must only enter numbers!");
                                input.nextLine();
                            }
                        }
                        if (Account.getUserAccount(user, Wacc) == null) {
                            System.out.println("Account not found, Try again!");
                            System.out.println("Do you want to continue? (Yes-No)");
                            String choice1 = input.next();
                            if (!"yes".equalsIgnoreCase(choice1)) {
                                break;
                            }
                        }else break;
                    }
                    System.out.println("Enter the amount:");
                    double Wamount;
                    while (true) {
                        try {
                            Wamount = input.nextDouble();
                            break;
                        } catch (Exception e) {
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
                        System.out.println("What type of Account do you wish to create?[Current-Saving]");
                        c = input.next();
                        if (c.equalsIgnoreCase("Current") || c.equalsIgnoreCase("Saving")) {
                            break;
                        } else {
                            System.out.println("Wrong input! Please try again.");
                            System.out.println("Do you want to continue? (Yes-No)");
                            String choice1 = input.next();
                            if (!"yes".equalsIgnoreCase(choice1)) {
                                break;
                            }
                        }
                    }
                    c = c.toLowerCase();
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
        }

        // Update the user data after completing client options
        for (int i = 0; i < Clients.size(); i++) {
            if (Clients.get(i).getID() == user.getID()) {
                Clients.set(i, user);
                break;
            }
        }
    }
    //----------------------------------------------------------------------------------------------------
    /**
     * Displays and manages employee-specific options and operations in a loop until the user chooses to logout.
     * The employee can view account details, edit personal information, create clients, delete clients,
     * search for clients, edit client accounts, or logout.
     */
    public void EmployeeOptions(Employee user) {
        loop: while (true) {
            int choice;

            // Displaying menu options
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
                    user.DisplayEmployeeDetails();
                    break;
                case 2:
                    user.EditPersonalinformation();
                    break;
                case 3:
                    // Create client operation
                    user.CreateClients(Clients, Employees);
                    break;
                case 4:
                    // Delete client operation
                    user.DeleteClient(Clients);
                    break;
                case 5:
                    // Search for client operation
                    user.searchclientbyId(Clients);
                    break;
                case 6:
                    // Edit client account operation
                    user.EditClientAccount(Clients);
                    break;
                case 7:
                    // Logout operation
                    break loop;
                default:
                    System.out.println("Wrong input!");
                    break;
            }
        }

        // Update the user data after completing employee options
        for (int i = 0; i < Employees.size(); i++) {
            if (Employees.get(i).getID() == user.getID()) {
                Employees.set(i, user);
                break;
            }
        }
    }
    //----------------------------------------------------------------------------------------------------
    /**
     * Displays and manages admin-specific options and operations in a loop until the admin chooses to logout.
     * The admin can create employees, delete employees, display transactions, authorize new employees,
     * display all clients, display all employees, or logout.
     */
    public void AdminOptions(Admin user) {
        loop: while (true) {
            int choice;

            // Displaying menu options
            System.out.println("1-Create Employee");
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
                    user.CreateEmployee(Employees, Clients);
                    break;
                case 2:
                    // Delete employee operation
                    user.DeleteEmployee(Employees);
                    break;
                case 3:
                    // Display transactions based on user input (client, employee, or date)
                    String sType;
                    while (true) {
                        System.out.println("Search by (Client-Employee-Date)?");
                        sType = input.next();
                        if (sType.equalsIgnoreCase("Client") || sType.equalsIgnoreCase("Employee") || sType.equalsIgnoreCase("Date")) {
                            break;
                        } else {
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
                        user.displayAllTransactionsbyClientID(Transactions);
                    } else if (sType.equalsIgnoreCase("Employee")) {
                        // Display transactions by employee ID
                        user.displayAllTransactionsbyEmployeeID(Transactions);
                    } else if (sType.equalsIgnoreCase("Date")) {
                        // Display transactions by date
                        user.displayAllTransactionsbydate(Transactions);
                    }
                    break;
                case 4:
                    // Authorize new employee operation
                    user.AuthorizeNewEmp(Employees);
                    break;
                case 5:
                    // Display all clients operation
                    user.Display_All_Clients(Clients);
                    break;
                case 6:
                    // Display all employees operation
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
