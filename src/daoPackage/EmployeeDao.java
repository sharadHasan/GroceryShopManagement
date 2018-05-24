package daoPackage;

import java.sql.ResultSet;
import myPackage.*;

public interface EmployeeDao {
    public ResultSet showEmployee();
    public boolean addNewEmployee(Employee emp);
    public boolean fireEmployee(String name);
    public boolean updateEmployee(Employee e);
    public Employee searchEmployee(String empName);
}
