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
}
