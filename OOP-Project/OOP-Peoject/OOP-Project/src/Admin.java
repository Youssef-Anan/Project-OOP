import java.util.ArrayList;

public class Admin extends User {
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
    public Employee AuthorizeNewEmp(String FirstName, String LastName,String Username, String Password, String Address, String Position,String GraduatedCollege, int yearOfGraduation, float TotalGrade) {
        Employee employee= new Employee(FirstName,LastName,Username,Password,Address,Position,GraduatedCollege,yearOfGraduation,TotalGrade );
        return employee;
    }

    public void DeleteEmployee(int id,ArrayList<Employee> e)
    {
        for(int i=0;i<e.size();i++){
            if(id==e.get(i).getID()){
                e.remove(e.get(i));
            }

        }

    }
    public void Display_All_Transaction(ArrayList<Transaction> t)
    {
        for (int i = 0; i < t.size(); i++)
        {
            t.get(i).displaytransaction();
        }
    }
}
