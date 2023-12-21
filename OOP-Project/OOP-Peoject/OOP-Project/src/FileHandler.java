import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private static final String ACCOUNT_FILE_PATH = "accounts.txt";
    private static final String USER_FILE_PATH = "users.txt";
    private static final String Transactions_File_Path = "transactions.txt";
    private static final String Employee_File_Path = "employee.txt";
    static final String CLIENT_FILE_PATH = "client.txt";

    //-------------------------------Converting Object to String-----------------------------------------------------
    public static String ConvClientToString(ArrayList<Client> c) {
        String data = "";
        for (int i = 0; i < c.size(); i++) {
            data += c.get(i).userType + "," + c.get(i).getID() + "," + c.get(i).getFirstName() + "," + c.get(i).getLastName() + "," + c.get(i).getUsername() + "," + c.get(i).getPassword() + "," + c.get(i).getTelephoneNumber() + "," + ConvAccountsToString(c.get(i).getSavingAccount()) + "\n";
        }
        return data;
    }

    public static String ConvAccountsToString(ArrayList<SavingsAccount> s) {
        String data = "";
        for (int i = 0; i < s.size(); i++) {
            data += i + 1 + "- " + s.get(i).AccountNumber + "," + s.get(i).local_Date + "," + s.get(i).interestRate + "," + s.get(i).getBalance() + "\n";
        }
        return data;
    }

    public static String ConvEmployeetoString(ArrayList<Employee> e) {
        String data = "";
        for (int i = 0; i < e.size(); i++) {
            data += i + 1 + "- " + e.get(i).getID() + ","+e.get(i).userType+"," + e.get(i).getUsername() + "," + e.get(i).getFirstName() + "," + e.get(i).getLastName() + "," + e.get(i).getAddress() + "," + e.get(i).getPosition() + "," + e.get(i).getGraduatedCollege() + "," + e.get(i).getYearOfGraduation() + "," + e.get(i).getTotalGrade() + "\n";
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




    public static void writeData_C(String data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CLIENT_FILE_PATH))) {
            oos.writeObject(data);
            System.out.println("User data has been written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeData_E(String data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Employee_File_Path))) {
            oos.writeObject(data);
            System.out.println("User data has been written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeData_T(String data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Transactions_File_Path))) {
            oos.writeObject(data);
            System.out.println("User data has been written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//--------------------------------------------------Reading file-------------------------------------------------------------------//

    //--------------------Convert String to Object----------------------------------------------------------------------//
    public static void ConvertStringtoClient(String data,ArrayList<Client>c){

        Client cl =new Client();

    }






//----------------------------------------------------------------------------------------------------------------------------------------//
    public static String readData_E() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Employee_File_Path))) {
            Object read = ois.readObject();
            if (read instanceof String) {
                String data = (String) read;
                System.out.println("User data has been read from file.");
                return data;
            } else {
                System.out.println("Invalid data type in the file.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static String readData_t() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Transactions_File_Path))) {
            Object read = ois.readObject();
            if (read instanceof String) {
                String data = (String) read;
                System.out.println("User data has been read from file.");
                return data;
            } else {
                System.out.println("Invalid data type in the file.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}




