package Main;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import Users.*;
import System.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        User user = null; // Initialize a variable to store the authenticated user
        Client convClient = null; // Variable to store user as Client
        Admin convAdmin = null; // Variable to store user as Admin
        Employee convEmployee = null; // Variable to store user as Employee

        Bank bank = new Bank(); // Create an instance of the Bank class to handle banking operations

        // Program
        bank.getBankData(); // Load data from files into the bank

        program: while (true) {

            // Authentication loop
            loop: while (true) {
                int n = 0;
                System.out.println("---------------------------------Bank System-----------------------------------");
                System.out.println("1-Login\n2-Close Program");

                // Checking that input is only an integer
                while (true) {
                    try {
                        n = input.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.println("1-Login\n2-Close Program");
                        System.out.println("You must enter only numbers!");
                        input.nextLine(); // Clear the buffer to avoid an infinite loop
                    }
                }

                switch (n) {
                    case 1:
                        user = bank.Authenticate(); // Authenticate the user
                        if (user==null) break program;
                        break loop;
                    case 2:
                        break program; // Exit the program
                    default:
                        System.out.println("Wrong Number!");
                        break;
                }
            }

            // Giving User Authorities based on UserType
            if (user.getUserType().equals("Client")) {
                convClient = (Client) user; // Cast user to Client type
            } else if (user.getUserType().equals("Employee")) {
                convEmployee = (Employee) user; // Cast user to Employee type
            } else {
                convAdmin = (Admin) user; // Cast user to Admin type
            }
            // Showing User Options based on UserType
            if (user.getUserType().equals("Client")) {
                bank.ClientOptions(convClient); // Display client options
            } else if (user.getUserType().equals("Employee")) {
                bank.EmployeeOptions(convEmployee); // Display employee options
            } else {
                bank.AdminOptions(convAdmin); // Display admin options
            }
        }

        bank.saveBankData(); // Save data to files
    }
}
