
import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee extends User {
    Scanner input=new Scanner(System.in);
    private String Address;
    private String Position;
    private String GraduatedCollege;
    private int yearOfGraduation;
    private  float TotalGrade;

    public  Employee( String FirstName, String LastName,String Username, String Password, String Address, String Position,String GraduatedCollege, int yearOfGraduation, float TotalGrade)
    {
        super( FirstName, LastName, Username, Password);
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
      this.setFirstName(e.getFirstName());
      this.setLastName(e.getLastName());
      this.setUsername(e.getUsername());
      this.setPassword(e.getPassword());
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
    public Client CreateClients(String firstName, String lastName, String username,String password, int phoneNumber) {
        Client client = new Client(firstName, lastName, username, password, phoneNumber);

        return client;
    }
    public void searchclientbyId(int id, ArrayList<Client> c)
    {
        for (int i = 0; i < c.size(); i++) {

        if(id == c.get(i).getID())
        {
            c.get(i).DisplayClientDetails();
        }
        }
    }
    public void EditClientAccount(int id,ArrayList<Client> c){
        for (int i = 0; i <c.size(); i++) {
            if (id == c.get(i).getID()) {
                c.get(i).EditPersonalInformation(c.get(i).getFirstName(), c.get(i).getLastName(), c.get(i).getTelephoneNumber());

            }
        }

    }
    public void DeleteClient(int id,ArrayList<Client> c )
    {
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
        System.out.println("The Employee last user name: "+getUsername());
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

    public float getTotalGrade() {
        return TotalGrade;
    }

    public void setTotalGrade(float totalGrade) {
        TotalGrade = totalGrade;
    }


}
