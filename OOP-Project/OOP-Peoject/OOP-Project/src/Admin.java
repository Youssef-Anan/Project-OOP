import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Admin extends User {
    Scanner input=new Scanner(System.in);
    @Override
    public void setUsername(String username) {
        super.setUsername("admin");
    }
    @Override
    public void setPassword(String password) {
        super.setPassword("admin");
    }
    public void Display_All_Employees(ArrayList <Employee> e)
    {
        for (int i = 0; i < e.size(); i++)
        {
            e.get(i).DisplayEmployeeDetails();
        }
    }

    public void Display_All_Clients(ArrayList <Client> c)
    {
        for (int i = 0; i < c.size(); i++)
        {
            c.get(i).DisplayClientDetails();
        }
    }
    /*public Employee AuthorizeNewEmp(String FirstName, String LastName,String Username, String Password, String Address, String Position,String GraduatedCollege, int yearOfGraduation, String TotalGrade) {
        Employee employee= new Employee(FirstName,LastName,Username,Password,Address,Position,GraduatedCollege,yearOfGraduation,TotalGrade );
        return employee;
    }*/
    public void CreateEmployee(ArrayList<Employee>e) {
        System.out.println("Enter Firstname:");
        String FirstName = input.next();
        System.out.println("Enter Lastname:");
        String LastName = input.next();
        System.out.println("Enter Username:");
        String Username = input.next();
        System.out.println("Enter password:");
        String Password = input.next();
        System.out.println("Enter Address:");
        String Address = input.next();
        System.out.println("Enter position:");
        String Position = input.next();
        System.out.println("Enter Graduated college:");
        String GraduatedCollege= input.next();
        System.out.println("Enter Year of Graduation:");
        int yearOfGraduation = input.nextInt();
        System.out.println("Enter Total Grade:");
        String TotalGrade = input.next();
        Employee emp= new Employee(FirstName,LastName,Username,Password,Address,Position,GraduatedCollege,yearOfGraduation,TotalGrade);
        e.add(emp);
    }

    public void DeleteEmployee(int id,ArrayList<Employee> e)
    {
        for(int i=0;i<e.size();i++){
            if(id==e.get(i).getID()){
                e.remove(e.get(i));
            }

        }

    }
    public void Display_All_Transaction(Date date, ArrayList<Transaction> t)
    {
        for (int i = 0; i < t.size(); i++)
        {
            if (date.equals(t.get(i).date))
             t.get(i).displaytransaction();
        }
    }
}
