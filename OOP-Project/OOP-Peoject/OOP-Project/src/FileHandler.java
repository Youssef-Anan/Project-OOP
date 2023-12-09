import java.io.*;

public class FileHandler {
    private static final String USER_FILE_PATH = "users.txt";
    private static final String ACCOUNT_FILE_PATH = "accounts.txt";

    public static void writeData(String data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_FILE_PATH))) {
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