package Users;

import java.util.ArrayList;

public abstract class User {
    String userType;
    private int ID;
    private String FirstName;
    private String LastName;
    private String Username;
    private String Password;

    public User() {

    }

    public User( int id,String FirstName, String LastName, String Username, String Password) {
        this.ID=id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Username = Username;
        this.Password = Password;

    }

    public static boolean usernameFound(String username, ArrayList<Client> c, ArrayList<Employee> e) {
        if (username.equals("admin")) return true;
        for (int i = 0; i < c.size(); i++) {
            if(username.equals(c.get(i).getUsername()))return true;
        }
        for (int i = 0; i < e.size(); i++) {
            if(username.equals(e.get(i).getUsername()))return true;
        }
    return false;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }

}

