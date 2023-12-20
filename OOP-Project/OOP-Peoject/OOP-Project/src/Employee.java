
import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee extends User {
    Scanner input=new Scanner(System.in);
    private  static int empcount=10000;
    private String Address;
    private String Position;
    private String GraduatedCollege;
    private int yearOfGraduation;
    private  String TotalGrade;

    public  Employee( int id,String FirstName, String LastName,String Username, String Password, String Address, String Position,String GraduatedCollege, int yearOfGraduation, String TotalGrade)
    {
        super( id,FirstName, LastName, Username, Password);
        this.Address = Address;
        this.Position = Position;
        this.GraduatedCollege = GraduatedCollege;
        this.yearOfGraduation = yearOfGraduation;
        this.TotalGrade = TotalGrade;

    }
    public Employee(String username,String password){
        setUsername(username);
        setPassword(password);
    }

    public Employee(Employee e) {
        super(e.getID(),e.getFirstName(),e.getLastName(),e.getUsername(),e.getPassword());
      this.Address=e.Address;
      this.Position=e.Position;
      this.GraduatedCollege=e.GraduatedCollege;
      this.yearOfGraduation=e.yearOfGraduation;
      this.TotalGrade=e.TotalGrade;
    }

    public void EditPersonalinformation(){
        System.out.println("Enter the new address");
        String Address = input.next();
       this.Address=Address;
        System.out.println("Enter the new Position");
        String Position = input.next();
        this.Position=Position;

    }
    public void CreateClients(ArrayList<Client>c) {
        System.out.println("Enter  Firstname:");
        String firstName = input.next();
        System.out.println("Enter Lastname:");
        String lastName = input.next();
        System.out.println("Enter Username:");
        String username = input.next();
        System.out.println("Enter password:");
        String password = input.next();
        System.out.println("Enter PhoneNumber:");
        String phoneNumber=input.next();
        Client client = new Client(10000+c.size(),firstName, lastName, username, password, phoneNumber);
        c.add(client);
    }
    public void searchclientbyId( ArrayList<Client> c)
    {
        System.out.println("Enter the desired ID to search for a client : ");
        int id=input.nextInt();
        for (int i = 0; i < c.size(); i++) {

        if(id == c.get(i).getID())
        {
            c.get(i).DisplayClientDetails();
        }
        }

    }
    public void EditClientAccount(ArrayList<Client> c){
        System.out.println("Enter the desired ID to edit the client  : ");
        int id=input.nextInt();
        for (int i = 0; i <c.size(); i++) {
            if (id == c.get(i).getID()) {
                c.get(i).EditPersonalInformation();

            }
        }

    }
    public void DeleteClient(ArrayList<Client> c )
    {
        System.out.println("Enter the desired ID to delete the client: ");
        int id=input.nextInt();
        for(int i=0;i<c.size();i++){
            if(id==c.get(i).getID()){
               c.remove(c.get(i));
            }

        }

    }

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
