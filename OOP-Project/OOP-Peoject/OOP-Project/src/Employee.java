
import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Employee extends User {
    Scanner input=new Scanner(System.in);
    private String Address;
    private String Position;
    private String GraduatedCollege;
    private int yearOfGraduation;
    private  String TotalGrade;
    public Employee(){

    }

    public  Employee( int id,String FirstName, String LastName,String Username, String Password, String Address, String Position,String GraduatedCollege, int yearOfGraduation, String TotalGrade)
    {
        super( id,FirstName, LastName, Username, Password);
        super.userType="Employee";
        this.Address = Address;
        this.Position = Position;
        this.GraduatedCollege = GraduatedCollege;
        this.yearOfGraduation = yearOfGraduation;
        this.TotalGrade = TotalGrade;

    }
    public Employee(String username,String password){
        setUsername(username);
        setPassword(password);
        super.userType="Employee";
    }

    public Employee(Employee e) {
        super(e.getID(),e.getFirstName(),e.getLastName(),e.getUsername(),e.getPassword());
      this.Address=e.Address;
      this.Position=e.Position;
      this.GraduatedCollege=e.GraduatedCollege;
      this.yearOfGraduation=e.yearOfGraduation;
      this.TotalGrade=e.TotalGrade;
        super.userType="Employee";
    }
    //----------------------------------Privileges of Employee----------------------------------------------------//
    //---------Function to edit his personal information (address,position)---------//
    public void EditPersonalinformation(){
        System.out.println("Enter the new address");
        String Address = input.next();
       this.Address=Address;
        System.out.println("Enter the new Position");
        String Position = input.next();
        this.Position=Position;

    }
    //---------Function to create new clients ---------//
    public void CreateClients(ArrayList<Client>c,ArrayList<Employee> e) {
        System.out.println("Enter  Firstname:");
        String firstName = input.next();
        System.out.println("Enter Lastname:");
        String lastName = input.next();
        System.out.println("Enter Username:");
        String Username = input.next();
        while(User.usernameFound(Username,c,e)){
            System.out.println("Username already exists!");
            System.out.println("Enter Username:");
            Username = input.next();
        }
        System.out.println("Enter password:");
        String password = input.next();
        System.out.println("Enter PhoneNumber:");
        String phoneNumber=input.next();
        //-------Generating Id for clients-------//
        Client client = new Client(10001+c.size(),firstName, lastName, Username, password, phoneNumber);
        c.add(client);
    }
    //------Function to search for a client by ID--------//
    public void searchclientbyId( ArrayList<Client> c)
    {
        int id;
        boolean userfound =false;
        while (true) {
            try {
                System.out.println("Enter the desired ID to search for a client : ");
                id=input.nextInt();
                for (int i = 0; i < c.size(); i++)
                {

                    if (id == c.get(i).getID()) {
                        c.get(i).DisplayClientDetails();
                        userfound=true;
                    }

                }
                if(userfound==false)
                {
                    System.out.println("User not found");
                }
                break;
            }catch(InputMismatchException exc)
            {
                System.out.println("Invalid Input please enter valid Id: ");
                input.nextLine();
            }
        }
    }
    //----Function to edit personal information of client by using client Id-----//
    public void EditClientAccount(ArrayList<Client> c) {
        int id;
        boolean userfound=false;
        while (true) {
            try {
                System.out.println("Enter the desired ID to edit the client  : ");
                id = input.nextInt();
                for (int i = 0; i < c.size(); i++) {
                    if (id == c.get(i).getID()) {
                        c.get(i).EditPersonalInformation();
                        userfound=true;
                    }
                }
                if(userfound==false){
                    System.out.println("User not found");
                }
                break;
            }catch(InputMismatchException exc){
                System.out.println("Invalid Input please enter valid Id: ");
                input.nextLine();
            }
        }
    }
    //----Function to delete client by using client Id-----//
    public void DeleteClient(ArrayList<Client> c ) {
        int id;
        boolean userfound = false;
        while (true) {
            try {
                System.out.println("Enter the desired ID to delete the client: ");
                id = input.nextInt();
                for (int i = 0; i < c.size(); i++) {
                    if (id == c.get(i).getID()) {
                        c.remove(c.get(i));
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
    //----Function to display employee's details-----//
    public void DisplayEmployeeDetails(){
        System.out.println("The Employee id: "+getID());
        System.out.println("The Employee first name: "+getFirstName());
        System.out.println("The Employee last name: "+getLastName());
        System.out.println("The Employee  username: "+getUsername());
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getGraduatedCollege() {
        return GraduatedCollege;
    }

    public void setGraduatedCollege(String graduatedCollege) {
        GraduatedCollege = graduatedCollege;
    }

    public int getYearOfGraduation() {
        return yearOfGraduation;
    }

    public void setYearOfGraduation(int yearOfGraduation) {
        this.yearOfGraduation = yearOfGraduation;
    }

    public String getTotalGrade() {
        return TotalGrade;
    }

    public void setTotalGrade(String totalGrade) {
        TotalGrade = totalGrade;
    }


}
