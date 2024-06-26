package Users;

import System.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends User {

    Scanner input = new Scanner(System.in);

    //-------setting static username and password for the admin--------//
    @Override
    public void setUsername(String username) {
        super.setUsername("admin");
    }

    @Override
    public void setPassword(String password) {
        super.setPassword("admin");
    }

    //----------------------------------privileges for the admin---------------------------------------//
    //---------Function to display all employees--------------//
    public void Display_All_Employees(ArrayList<Employee> e) {
        for (int i = 0; i < e.size(); i++) {
            System.out.println("------------------------------------------------");
            e.get(i).DisplayEmployeeDetails();
        }
    }

    //---------Function to display all clients--------------//
    public void Display_All_Clients(ArrayList<Client> c) {
        for (int i = 0; i < c.size(); i++) {
            System.out.println("------------------------------------------------");
            c.get(i).DisplayClientDetails();
        }
    }

    //-----------Function to authorize new employees-----------//
    public void AuthorizeNewEmp(ArrayList<Employee> e) {
        System.out.println("Enter username of the employee :");
        String User = input.next();
        System.out.println("Enter password of the employee :");
        String Pass = input.next();
        for (int i = 0; i < e.size(); i++) {
            if (User.equals(e.get(i).getUsername()) && Pass.equals(e.get(i).getPassword())) {
                System.out.println("This employee is authorized .");
            } else {
                System.out.println("Employee is not authorized");
            }
        }
    }

    //-------------Function for creating new employees-----------//
    public void CreateEmployee(ArrayList<Employee> e, ArrayList<Client> c) {
        Employee emp;
        System.out.println("Enter Firstname:");
        String FirstName = input.next();
        System.out.println("Enter Lastname:");
        String LastName = input.next();
        System.out.println("Enter Username:");
        String Username = input.next();
        while (User.usernameFound(Username, c, e)) {
            System.out.println("Username already exists!");
            System.out.println("Enter Username:");
            Username = input.next();
        }
        System.out.println("Enter password:");
        String Password = input.next();
        System.out.println("Enter Address:");
        String Address = input.next();
        System.out.println("Enter position:");
        String Position = input.next();
        System.out.println("Enter Graduated college:");
        String GraduatedCollege;
        while(true){
            GraduatedCollege = input.next();
            if(GraduatedCollege.matches("[a-zA-Z]+")){
                break;
            }else System.out.println("Please Enter Only Letters");}
        int yearOfGraduation = 0;
        while (true) {
            try {
                System.out.println("Enter Year of Graduation:");
                yearOfGraduation = input.nextInt();
                break;
            } catch (InputMismatchException exc) {
                System.out.println("Error: Please enter a valid integer year .");
                input.nextLine();
            }
        }
        System.out.println("Enter Total Grade(Excellent/Good/Bad):");
        String TotalGrade = input.next();
        if(e.size()==0) emp = new Employee(20001, FirstName, LastName, Username, Password, Address, Position, GraduatedCollege, yearOfGraduation, TotalGrade);
        else  emp = new Employee(1 + e.getLast().getID(), FirstName, LastName, Username, Password, Address, Position, GraduatedCollege, yearOfGraduation, TotalGrade);
        System.out.println("Employee Created Successfully");
        e.add(emp);
    }

    //----------Function for deleting an employee------------//
    public void DeleteEmployee(ArrayList<Employee> e) {
        Display_All_Employees(e);
        int id;
        boolean userfound = false;
        while (true) {
            try {
                System.out.println("Choose the Employee by ID: ");
                id = input.nextInt();
                for (int i = 0; i < e.size(); i++) {
                    if (id == e.get(i).getID()) {
                        e.remove(e.get(i));
                        System.out.println("Employee "+id+" has been deleted ");
                        userfound = true;
                    }
                }
                if (userfound == false) {
                    System.out.println("User not found");
                }
                break;
            } catch (InputMismatchException exc) {
                System.out.println("Invalid Input please enter valid Id: ");
                input.nextLine();
            }
        }
    }

    //--------Function for displaying transactions by date-------//
    public void displayAllTransactionsbydate(ArrayList<Transaction> t) {
        System.out.print("Enter the desired date to show all transactions (dd/MM/yyyy  HH:mm): ");
        String date = input.next();

        for (int i = 0; i < t.size(); i++) {
            if (date.equals(t.get(i).getFormattedDateTime())) {
                System.out.println("--------------------------------------------");
                t.get(i).displayTransaction();
            }
        }
    }

    //--------Function for displaying transactions by client's Id--------//
    public void displayAllTransactionsbyClientID(ArrayList<Transaction> t) {
        int clientId;
        boolean userfound = false;
        while (true) {
            try {
                System.out.print("Enter the desired Client ID to show all transactions: ");
                clientId = input.nextInt();
                for (int i = 0; i < t.size(); i++) {
                    if (clientId == t.get(i).getClientId()) {
                        System.out.println("--------------------------------------------");
                        t.get(i).displayTransaction();
                        userfound = true;
                    }
                }
                if (userfound == false) {
                    System.out.println("User not found");
                }
                break;
            } catch (InputMismatchException exc) {
                System.out.println("Invalid Input please enter valid Id: ");
                input.nextLine();
            }
        }
    }

    //--------Function for displaying transactions by employee's Id--------//
    public void displayAllTransactionsbyEmployeeID(ArrayList<Transaction> t) {
        int EmpId;
        boolean userfound = false;
        while (true) {
            try {
                System.out.print("Enter the desired Employee ID to show all transactions: ");
                EmpId = input.nextInt();
                for (int i = 0; i < t.size(); i++) {
                    if (EmpId == t.get(i).getClientId()) {
                        System.out.println("--------------------------------------------");
                        t.get(i).displayTransaction();
                        userfound=true;
                    }
                }
                if(userfound==false){
                    System.out.println("User not found");
                }
                break;
            }catch (InputMismatchException exc){
                System.out.println("Invalid Input please enter valid Id: ");
                input.nextLine();
            }
        }
    }
}
