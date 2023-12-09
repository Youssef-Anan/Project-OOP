
import java.lang.IllegalArgumentException;
import java.util.ArrayList;

public class Employee extends User {
    private String Address;
    private String Postion;
    private String GraduatedCollege;
    private int yearOfGraduation;
    private  float TotalGrade;

    public  Employee( String FirstName, String LastName,String Username, String Password, String Address, String Postion,String GraduatedCollege, int yearOfGraduation, float TotalGrade)
    {
        super( FirstName, LastName, Username, Password);
        this.Address = Address;
        this.Postion = Postion;
        this.GraduatedCollege = GraduatedCollege;
        this.yearOfGraduation = yearOfGraduation;
        this.TotalGrade = TotalGrade;

    }


    public void EditPersonalinformation(String Address,String Postion){
        setAddress(Address);
        setPostion(Postion);
    }
    public Client CreateClients(String firstName, String lastName,  int phoneNumber,String username,String password ) {
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

    public String getPostion() {
        return Postion;
    }

    public void setPostion(String postion) {
        Postion = postion;
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
