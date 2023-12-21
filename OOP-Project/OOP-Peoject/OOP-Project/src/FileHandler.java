import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class FileHandler {

    private static final String Transactions_File_Path = "transactions.txt";
    private static final String Employee_File_Path = "employee.txt";
    private static final String CLIENT_FILE_PATH = "client.txt";

    //-------------------------------Converting Object to String-----------------------------------------------------
    public static String ConvClientToString(ArrayList<Client> c) {
        String data = "";
        for (int i = 0; i < c.size(); i++) {
            data += c.get(i).userType + "," + c.get(i).getID() + "," + c.get(i).getFirstName() + "," + c.get(i).getLastName() + "," + c.get(i).getUsername() + "," + c.get(i).getPassword() + "," + c.get(i).getTelephoneNumber() + "&" + ConvAccountsToString(c.get(i).getSavingAccount()) + "\n";
        }
        return data;
    }

    public static String ConvAccountsToString(ArrayList<SavingsAccount> s) {
        String data = "";
        for (int i = 0; i < s.size(); i++) {
            data += s.get(i).AccountNumber + "," + s.get(i).local_Date + "," + s.get(i).DEFAULT_INTEREST_RATE + "," + s.get(i).getBalance() + "$";
        }
        return data;
    }

    public static String ConvEmployeetoString(ArrayList<Employee> e) {
        String data = "";
        for (int i = 0; i < e.size(); i++) {
            data += i + 1 + "- " + e.get(i).getID() + "," + e.get(i).userType + "," + e.get(i).getUsername() + "," + e.get(i).getFirstName() + "," + e.get(i).getLastName() + "," + e.get(i).getAddress() + "," + e.get(i).getPosition() + "," + e.get(i).getGraduatedCollege() + "," + e.get(i).getYearOfGraduation() + "," + e.get(i).getTotalGrade() + "\n";
        }
        return data;
    }

    public static String ConvTransactiontoString(ArrayList<Transaction> transactions) {
        String data = "";
        for (int i = 0; i < transactions.size(); i++) {
            data += i + 1 + "- " + transactions.get(i).getFormattedDateTime() + "," + transactions.get(i).getEmployeeId() + "," + transactions.get(i).getEmployeeId() + "," + transactions.get(i).getAmount() + "," + transactions.get(i).getSrcAccnum() + "," + transactions.get(i).getDstAccnum() + "\n";
        }
        return data;
    }

    public static void writeData(String data,String Path) {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(Path), StandardCharsets.UTF_8))) {
            writer.write(data);
            System.out.println("User data has been written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//--------------------------------------------------Reading file-------------------------------------------------------------------//

    //--------------------Convert String to Object----------------------------------------------------------------------//
    public static void ConvertStringtoClient(String data, ArrayList<Client> c) {
        //String[] dataArray = inputData.split("\n");
        String[] objects = data.split("\n");//Splitting Objects---------------
        for (int i = 0; i < objects.length; i++) {
            Client dummy = new Client();
            String[] objPart = objects[i].split("&");//Splitting DataTypes------------
            //----------------------Client Data---------------------------
            String[] ClientData = objPart[0].split(",");//Splitting Client Data-------
            dummy.userType = ClientData[0];
            dummy.setID(Integer.parseInt(ClientData[1]));
            dummy.setFirstName(ClientData[2]);
            dummy.setLastName(ClientData[3]);
            dummy.setUsername(ClientData[4]);
            dummy.setPassword(ClientData[5]);
            dummy.setTelephoneNumber(ClientData[6]);
            //----------------------Accounts Data------------------------
            ConvertStringtoAccount(objPart[1], dummy.savingAccount);
            c.add(dummy);
        }
    }

    // data +=s.get(i).AccountNumber + "," + s.get(i).local_Date + "," + s.get(i).DEFAULT_INTEREST_RATE + "," + s.get(i).getBalance();

    public static void ConvertStringtoAccount(String data, ArrayList<SavingsAccount> a) {
        //String[] dataArray = inputData.split("\n");
        SavingsAccount dummy = new SavingsAccount();
        String[] objects = data.split("\\$");
        for (int i = 0; i < objects.length; i++) {
            String[] objData = objects[i].split(",");
            dummy.setAccountNumber(Long.parseLong(objData[0]));
            dummy.setLocal_Date(LocalDate.parse(objData[1]));
            dummy.setDEFAULT_INTEREST_RATE(Double.parseDouble(objData[2]));
            dummy.setBalance(Double.parseDouble(objData[3]));
            a.add(dummy);
        }
    }


    //----------------------------------------------------------------------------------------------------------------------------------------//
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




