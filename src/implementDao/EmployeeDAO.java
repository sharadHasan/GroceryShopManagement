
package implementDao;

import daoPackage.EmployeeDao;
import java.sql.*;
import myPackage.*;

public class EmployeeDAO implements EmployeeDao {
    DBConnect myDB = new DBConnect();
    public int count;
    
    public int getCount(){
        return count;
    }
    public ResultSet showEmployee(){
        try{
           PreparedStatement ps = myDB.con.prepareStatement("select * from employee"); 
           myDB.rs = ps.executeQuery();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return myDB.rs;
    }
    
    public boolean addNewEmployee(Employee emp){
        boolean inserted = false;
        try{
            PreparedStatement ps = myDB.con.prepareStatement("insert into employee (name,address,mobileNumber,email,age,salary) values (?,?,?,?,?,?)");
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getAddress());
            ps.setString(3, emp.getMobileNumber());
            ps.setString(4, emp.getEmail());
            ps.setString(5, Integer.toString(emp.getAge()));
            ps.setString(6, Double.toString(emp.getSalary()));
            ps.executeUpdate();
            inserted = true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return inserted;
    }
    
    public boolean fireEmployee(String name){
        boolean deleted = false;
        try{
            PreparedStatement ps = myDB.con.prepareStatement("delete from employee where name = ?");
            ps.setString(1, name);
            ps.executeUpdate();
            deleted = true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return deleted;
    }
    
    public boolean updateEmployee(Employee e){
        boolean updated = false;
        try{
            PreparedStatement ps = myDB.con.prepareStatement("update employee set address = ?, mobileNumber = ?, email = ?, age = ?, salary = ? where name = ?");
            ps.setString(1, e.getAddress());
            ps.setString(2, e.getMobileNumber());
            ps.setString(3, e.getEmail());
            ps.setString(4, Integer.toString(e.getAge()));
            ps.setString(5, Double.toString(e.getSalary()));
            ps.setString(6, e.getName());
            ps.executeUpdate();
            updated = true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return updated;
    }
    
    public Employee searchEmployee(String empName){
        Employee e = new Employee();
        count  = 0;
        try{
            PreparedStatement ps = myDB.con.prepareStatement("select * from employee where name = ?");
            ps.setString(1, empName); 
            myDB.rs = ps.executeQuery(); 
            while(myDB.rs.next()){
                e.setEmployeeID(myDB.rs.getInt("employeeID"));
                e.setNmame(myDB.rs.getString("name"));
                e.setAddress(myDB.rs.getString("address"));
                e.setMobileNumber(myDB.rs.getString("mobileNumber"));
                e.setEmail(myDB.rs.getString("email"));
                e.setAge(myDB.rs.getInt("age"));
                e.setSalary(myDB.rs.getDouble("salary"));
                count ++;
            }
          }catch(SQLException ex){
              ex.printStackTrace();
          }
        return e;
    }
}
