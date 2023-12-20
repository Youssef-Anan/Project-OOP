import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private static final String ACCOUNT_FILE_PATH = "accounts.txt";
    private static final String USER_FILE_PATH = "users.txt";

    static final String CLIENT_FILE_PATH = "client.txt";

    //-------------------------------Converting Object to String-----------------------------------------------------
    public static String ConvClientToString(ArrayList<Client> c){
        String data="";
        for (int i=0;i<c.size();i++){
            data+=c.get(i).userType+","+c.get(i).getID()+","+c.get(i).getFirstName()+","+c.get(i).getLastName()+","+c.get(i).getUsername()+","+c.get(i).getPassword()+","+c.get(i).getTelephoneNumber()+",Accounts:\n"+ConvAccountsToString(c.get(i).getSavingAccount())+"\n";
        }
        return data;
    }
    public static String ConvAccountsToString(ArrayList<SavingsAccount> s){
        String data="";
        for (int i=0;i<s.size();i++){
            data+=i+1+"- "+s.get(i).AccountNumber+","+s.get(i).local_Date+","+s.get(i).interestRate+","+s.get(i).getBalance()+"\n";
        }
        return data;
    }

    public static void writeData(String data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CLIENT_FILE_PATH))) {
            oos.writeObject(data);
            System.out.println("User data has been written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User[] readData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_FILE_PATH))) {
            return (User[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}