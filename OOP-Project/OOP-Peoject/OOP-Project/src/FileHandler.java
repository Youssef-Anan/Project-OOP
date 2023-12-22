import java.io.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    //-------------------------------Converting Object to String-----------------------------------------------------
    public static String ConvClientToString(ArrayList<Client> c) {
        String data = "";
        for (int i = 0; i < c.size(); i++) {
            data += c.get(i).userType + "," + c.get(i).getID() + "," + c.get(i).getFirstName() + "," + c.get(i).getLastName() + "," + c.get(i).getUsername() + "," + c.get(i).getPassword() + "," + c.get(i).getTelephoneNumber() + "&" + ConvAccountsToString(c.get(i)) + "\n";
        }
        return data;
    }

    public static String ConvAccountsToString(Client user) {
        String data = "";
        if (user.currentAccount!=null)
        data+=user.currentAccount.AccountNumber +"," + user.currentAccount.getAccountType() + "," + user.currentAccount.local_Date + "," + user.currentAccount.DEFAULT_INTEREST_RATE + "," + user.currentAccount.getBalance() + "$";

        for (int i = 0; i < user.savingAccount.size(); i++) {
            data += user.savingAccount.get(i).AccountNumber + ","  + user.savingAccount.get(i).getAccountType() +","+ user.savingAccount.get(i).local_Date + "," + user.savingAccount.get(i).DEFAULT_INTEREST_RATE + "," + user.savingAccount.get(i).getBalance() + "$";
        }
        return data;
    }

    public static String ConvEmployeetoString(ArrayList<Employee> e) {
        String data = "";
        for (int i = 0; i < e.size(); i++) {
            data +=e.get(i).getID() + "," + e.get(i).userType + "," + e.get(i).getUsername() + "," + e.get(i).getPassword()+ "," + e.get(i).getFirstName() + "," + e.get(i).getLastName() + "," + e.get(i).getAddress() + "," + e.get(i).getPosition() + "," + e.get(i).getGraduatedCollege() + "," + e.get(i).getYearOfGraduation() + "," + e.get(i).getTotalGrade() + "\n";
        }
        return data;
    }

    public static String ConvTransactiontoString(ArrayList<Transaction> transactions) {
        String data = "";
        for (int i = 0; i < transactions.size(); i++) {
            data +=transactions.get(i).getFormattedDateTime() + "," + transactions.get(i).getEmployeeId() + "," + transactions.get(i).getEmployeeId() + "," + transactions.get(i).getAmount() + "," + transactions.get(i).getSrcAccnum() + "," + transactions.get(i).getDstAccnum() + "\n";
        }
        return data;
    }

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

    //--------------------Convert String to Object----------------------------------------------------------------------//
    public static void ConvertStringtoClient(String data, ArrayList<Client> c) {
        //String[] dataArray = inputData.split("\n");
        String[] objects = data.split("\n");//Splitting Objects--------------
        for (int i = 0; i < objects.length; i++) {
           Client dummy=new Client();
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
            if (objPart.length>1)
            ConvertStringtoAccount(objPart[1], dummy);
            c.add(dummy);
        }
    }
// data += i + 1 + "- " + e.get(i).getID() + "," + e.get(i).userType + "," + e.get(i).getUsername() + "," + e.get(i).getFirstName() + "," + e.get(i).getLastName() + "," + e.get(i).getAddress() + "," + e.get(i).getPosition() + "," + e.get(i).getGraduatedCollege() + "," + e.get(i).getYearOfGraduation() + "," + e.get(i).getTotalGrade() + "\n";

    public static void ConvertStringtoEmployee(String data, ArrayList<Employee> e) {
        //String[] dataArray = inputData.split("\n");
        String[] objects = data.split("\n");//Splitting Objects---------------
        for (int i = 0; i < objects.length; i++) {
            Employee dummy=new Employee();
            //----------------------Employee Data---------------------------
            String[] Employeedata = objects[i].split(",");
            dummy.setID(Integer.parseInt(Employeedata[0]));
            dummy.userType=Employeedata[1];
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
    }
    public static void ConvertStringtoTransaction(String data,ArrayList<Transaction>transactions){
        String[] objects = data.split("\n");//Splitting Objects---------------
        for (int i = 0; i < objects.length; i++) {
            Transaction dummy = new Transaction();

            //----------------------Transactions data---------------------------//
            String[] Transdata = objects[i].split(",");
            dummy.setFormatterDateTime(Transdata[0]);
            dummy.setClientId(Integer.parseInt(Transdata[1]));
            dummy.setEmployeeId(Integer.parseInt(Transdata[2]));
            dummy.setAmount(Float.parseFloat(Transdata[3]));
            dummy.setSrcAccnum(Long.parseLong(Transdata[4]));
            dummy.setDstAccnum(Long.parseLong(Transdata[5]));
        transactions.add(dummy);
        }

    }



    // data +=s.get(i).AccountNumber + "," + s.get(i).local_Date + "," + s.get(i).DEFAULT_INTEREST_RATE + "," + s.get(i).getBalance();

    public static void ConvertStringtoAccount(String data, Client user) {
        CurrentAccount current = new CurrentAccount();
        String[] objects = data.split("\\$");
        for (int i = 0; i < objects.length; i++) {
        SavingsAccount dummy = new SavingsAccount();
            String[] objData = objects[i].split(",");
            dummy.setAccountNumber(Long.parseLong(objData[0]));
            dummy.setAccountType(objData[1]);
            dummy.setLocal_Date(LocalDate.parse(objData[2]));
            dummy.setDEFAULT_INTEREST_RATE(Double.parseDouble(objData[3]));
            dummy.setBalance(Double.parseDouble(objData[4]));
            if (dummy.getAccountType().equals("saving account")){
                user.savingAccount.add(dummy);
            }
            else {
                current.setAccountNumber(dummy.getAccountNumber());
                current.setAccountType(dummy.getAccountType());
                current.setLocal_Date(dummy.getLocal_Date());
                current.setDEFAULT_INTEREST_RATE(dummy.getDEFAULT_INTEREST_RATE());
                current.setBalance(dummy.getBalance());
                user.setCurrentAccount(current);
            }
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




