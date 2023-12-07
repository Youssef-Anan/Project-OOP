
import java.lang.IllegalArgumentException;

public class Employee extends User {
    private String Address;
    private String Postion;
    private String GraduatedCollege;
    private int yearOfGraduation;
    private  float TotalGrade;

    public  Employee(int ID, String FirstName, String LastName,String Username, String Password, String Address, String Postion,String GraduatedCollege, int yearOfGraduation, float TotalGrade)
    {
        super(ID, FirstName, LastName, Username, Password);
        this.Address = Address;
        this.Postion = Postion;
        this.GraduatedCollege = GraduatedCollege;
        this.yearOfGraduation = yearOfGraduation;
        this.TotalGrade = TotalGrade;

    }
    public void EditPersonalinformation(String Address,String Postion){
        this.Address=Address;
        this.Postion=Postion;
    }
    public Client CreateClients(String firstName, String lastName, int accountNumber, int phoneNumber, String stateOfAccount, String typeOfAccount, double balance){
      Client client=new Client(firstName,lastName,accountNumber,phoneNumber,stateOfAccount,typeOfAccount,balance);
      return client;
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
