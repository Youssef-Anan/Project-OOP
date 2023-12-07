import java.io.*;

public class FileHandler {
    private static final String USER_FILE_PATH = "users.txt";
    private static final String ACCOUNT_FILE_PATH = "accounts.txt";

    public static void writeUsersToFile(User[] users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_FILE_PATH))) {
            oos.writeObject(users);
            System.out.println("User data has been written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User[] readUsersFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_FILE_PATH))) {
            return (User[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeAccountsToFile(Account[] accounts) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ACCOUNT_FILE_PATH))) {
            oos.writeObject(accounts);
            System.out.println("Account data has been written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Account[] readAccountsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ACCOUNT_FILE_PATH))) {
            return (Account[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}