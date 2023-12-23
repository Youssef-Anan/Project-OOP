package System;

import Users.Accounts.CurrentAccount;
import Users.Accounts.SavingsAccount;
import Users.Client;
import Users.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class FileHandler {

    //-------------------------------Converting Object to String-----------------------------------------------------

    //Method to Convert Clients ArrayList to a String
    public static String ConvClientToString(ArrayList<Client> c) {
        String data = "";
        for (int i = 0; i < c.size(); i++) {
            data += c.get(i).getUserType() + "," + c.get(i).getID() + "," + c.get(i).getFirstName() + "," + c.get(i).getLastName() + ","
                    + c.get(i).getUsername() + "," + c.get(i).getPassword() + "," + c.get(i).getTelephoneNumber() + "&"
                    + ConvAccountsToString(c.get(i)) + "\n";
        }
        return data;
    }
    //------------------------------------------------------------------------------------------------------------
    //Method to Convert Accounts ArrayList to a String
    public static String ConvAccountsToString(Client user) {
        String data = "";
        if (user.getCurrentAccount() !=null)
        data+= user.getCurrentAccount().getAccountNumber() +"," + user.getCurrentAccount().getAccountType() + "," + user.getCurrentAccount().getLocal_Date() + ","
                + user.getCurrentAccount().getDEFAULT_INTEREST_RATE() + "," + user.getCurrentAccount().getBalance() + "$";

        for (int i = 0; i < user.getSavingAccount().size(); i++) {
            data += user.getSavingAccount().get(i).getAccountNumber() + ","  + user.getSavingAccount().get(i).getAccountType() +","+ user.getSavingAccount().get(i).getLocal_Date() +
                    "," + user.getSavingAccount().get(i).getDEFAULT_INTEREST_RATE() + "," + user.getSavingAccount().get(i).getBalance() + "$";
        }
        return data;
    }
    //------------------------------------------------------------------------------------------------------------
    //Method to Convert Employees ArrayList to a String
    public static String ConvEmployeetoString(ArrayList<Employee> e) {
        String data = "";
        for (int i = 0; i < e.size(); i++) {
            data +=e.get(i).getID() + "," + e.get(i).getUserType() + "," + e.get(i).getUsername() + "," + e.get(i).getPassword()+
                    "," + e.get(i).getFirstName() + "," + e.get(i).getLastName() + "," + e.get(i).getAddress() +
                    "," + e.get(i).getPosition() + "," + e.get(i).getGraduatedCollege() + "," + e.get(i).getYearOfGraduation()
                    + "," + e.get(i).getTotalGrade() + "\n";
        }
        return data;
    }
    //------------------------------------------------------------------------------------------------------------
    //Method to Convert Transactions ArrayList to a String
    public static String ConvTransactiontoString(ArrayList<Transaction> transactions) {
        String data = "";
        for (int i = 0; i < transactions.size(); i++) {
            data +=transactions.get(i).getFormattedDateTime() + "," + transactions.get(i).getClientId() +
                    "," + transactions.get(i).getEmployeeId() + "," + transactions.get(i).getAmount() +
                    "," + transactions.get(i).getSrcAccnum() + "," + transactions.get(i).getDstAccnum() + "\n";
        }
        return data;
    }
    //------------------------------------------------------------------------------------------------------------
    //Method to Put the Data in the Files
    public static void writeData(String data,String Path,String name) {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(Path), StandardCharsets.UTF_8))) {
            writer.write(data);
            System.out.println(name+" data has been written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//--------------------------------------------------Reading file-------------------------------------------------------------------//
    //------------------------------------------------------------------------------------------------------------
    //Method to Convert a String to Clients ArrayList
    public static void ConvertStringtoClient(String data, ArrayList<Client> c) {
        try {
            String[] objects = data.split("\n");//Splitting Objects--------------
            for (int i = 0; i < objects.length; i++) {
                Client dummy = new Client();
                String[] objPart = objects[i].split("&");//Splitting DataTypes------------
                //----------------------Client Data---------------------------ObjPart[0]
                String[] ClientData = objPart[0].split(",");//Splitting Client Data-------
                dummy.setUserType(ClientData[0]);
                dummy.setID(Integer.parseInt(ClientData[1]));
                dummy.setFirstName(ClientData[2]);
                dummy.setLastName(ClientData[3]);
                dummy.setUsername(ClientData[4]);
                dummy.setPassword(ClientData[5]);
                dummy.setTelephoneNumber(ClientData[6]);
                //----------------------Accounts Data------------------------ObjPart[1]
                if (objPart.length > 1)
                    ConvertStringtoAccount(objPart[1], dummy);
                c.add(dummy);
            }
        }catch (Exception t){
            System.out.println("Empty Client Data");
        }
    }
    //------------------------------------------------------------------------------------------------------------
    //Method to Convert a String to Employee ArrayList
    public static void ConvertStringtoEmployee(String data, ArrayList<Employee> e) {
        try {
            String[] objects = data.split("\n");//Splitting Objects---------------
            for (int i = 0; i < objects.length; i++) {
                Employee dummy = new Employee();
                //----------------------Employee Data---------------------------
                String[] Employeedata = objects[i].split(",");
                dummy.setID(Integer.parseInt(Employeedata[0]));
                dummy.setUserType(Employeedata[1]);
                dummy.setUsername(Employeedata[2]);
                dummy.setPassword(Employeedata[3]);
                dummy.setFirstName(Employeedata[4]);
                dummy.setLastName(Employeedata[5]);
                dummy.setAddress(Employeedata[6]);
                dummy.setPosition(Employeedata[7]);
                dummy.setGraduatedCollege(Employeedata[8]);
                dummy.setYearOfGraduation(Integer.parseInt(Employeedata[9]));
                dummy.setTotalGrade(Employeedata[10]);
                e.add(dummy);
            }
        } catch (Exception t){
            System.out.println("Empty Employee Data");
        }
    }
    //------------------------------------------------------------------------------------------------------------
    //Method to Convert a String to Transactions ArrayList
    public static void ConvertStringtoTransaction(String data,ArrayList<Transaction>transactions){
        try{
            String[] objects = data.split("\n");//Splitting Objects---------------
            for (int i = 0; i < objects.length; i++) {
                Transaction dummy = new Transaction();

                //----------------------Transactions data---------------------------//
                String[] Transdata = objects[i].split(",");
                dummy.setFormatterDateTime(Transdata[0]);
                dummy.setClientId(Integer.parseInt(Transdata[1]));
                dummy.setEmployeeId(Integer.parseInt(Transdata[2]));
                dummy.setAmount(Double.parseDouble(Transdata[3]));
                dummy.setSrcAccnum(Long.parseLong(Transdata[4]));
                dummy.setDstAccnum(Long.parseLong(Transdata[5]));
                transactions.add(dummy);
            }
        } catch (Exception t){
            System.out.println("Empty Transactions Data");
        }
    }
    //------------------------------------------------------------------------------------------------------------
    //Method to Convert a String to Accounts ArrayList
    public static void ConvertStringtoAccount(String data, Client user) {
        CurrentAccount current = new CurrentAccount();
        if (data!="" ||data!=null) {
            String[] objects = data.split("\\$");
            for (int i = 0; i < objects.length; i++) {
                SavingsAccount dummy = new SavingsAccount();
                String[] objData = objects[i].split(",");
                dummy.setAccountNumber(Long.parseLong(objData[0]));
                dummy.setAccountType(objData[1]);
                dummy.setLocal_Date(LocalDate.parse(objData[2]));
                dummy.setDEFAULT_INTEREST_RATE(Double.parseDouble(objData[3]));
                dummy.setBalance(Double.parseDouble(objData[4]));
                if (dummy.getAccountType().equals("saving account")) {
                    user.savingAccount.add(dummy);
                } else {
                    current.setAccountNumber(dummy.getAccountNumber());
                    current.setAccountType(dummy.getAccountType());
                    current.setLocal_Date(dummy.getLocal_Date());
                    current.setDEFAULT_INTEREST_RATE(dummy.getDEFAULT_INTEREST_RATE());
                    current.setBalance(dummy.getBalance());
                    user.setCurrentAccount(current);
                }
            }
        }
    }
    //------------------------------------------------------------------------------------------------------------
    //Method to Get the Data From the Files in the Shape of String
    public static String readData(String Path) {
        String data = "";
        try {
            File myObj = new File(Path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data += myReader.nextLine() + "\n";

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }
}




