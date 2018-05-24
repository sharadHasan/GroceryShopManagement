
package implementDao;

import daoPackage.CustomerDao;
import java.sql.*;
import myPackage.Customer;
import myPackage.DBConnect;

public class CustomerDAO implements CustomerDao {
    
    DBConnect myDB = new DBConnect();
    public int count;
    
    public int getCount(){
        return count;
    }
    
    public ResultSet showCustomer(){
        try{
           PreparedStatement ps = myDB.con.prepareStatement("select * from customer"); 
           myDB.rs = ps.executeQuery();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return myDB.rs;
    }
    
    public boolean addNewCustomer(Customer c){
        boolean inserted = false;
        try{
            PreparedStatement ps = myDB.con.prepareStatement("insert into customer (name,address,mobileNumber,email,age) values (?,?,?,?,?)");
            ps.setString(1, c.getName());
            ps.setString(2, c.getAddress());
            ps.setString(3, c.getMobileNumber());
            ps.setString(4, c.getEmail());
            ps.setString(5, Integer.toString(c.getAge()));
            ps.executeUpdate();
            inserted = true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return inserted;
    }
    
    public boolean deleteCustomer(String name){
        boolean deleted = false;
        try{
            PreparedStatement ps = myDB.con.prepareStatement("delete from customer where name = ?");
            ps.setString(1, name);
            ps.executeUpdate();
            deleted = true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return deleted;
    }
    
    public boolean updateCustomer(Customer c){
        boolean updated = false;
        try{
            PreparedStatement ps = myDB.con.prepareStatement("update customer set address = ?, mobileNumber = ?, email = ?, age = ? where name = ?");
            ps.setString(1, c.getAddress());
            ps.setString(2, c.getMobileNumber());
            ps.setString(3, c.getEmail());
            ps.setString(4, Integer.toString(c.getAge()));
            ps.setString(5, c.getName());
            ps.executeUpdate();
            updated = true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return updated;
    }
    
    public Customer searchCustomer(String customerName){
        Customer c = new Customer();
        count  = 0;
        try{
            PreparedStatement ps = myDB.con.prepareStatement("select * from customer where name = ?");
            ps.setString(1, customerName); 
            myDB.rs = ps.executeQuery(); 
            while(myDB.rs.next()){
                c.setCustomerID(myDB.rs.getInt("customerID"));
                c.setNmame(myDB.rs.getString("name"));
                c.setAddress(myDB.rs.getString("address"));
                c.setMobileNumber(myDB.rs.getString("mobileNumber"));
                c.setEmail(myDB.rs.getString("email"));
                c.setAge(myDB.rs.getInt("age"));
                count ++;
            }
          }catch(SQLException ex){
              ex.printStackTrace();
          }
        return c;
    }
    
    public Customer searchByMob(String mob){
        Customer c = new Customer();
        count = 0;
        try{
            PreparedStatement ps = myDB.con.prepareStatement("select * from customer where mobileNumber = ?");
            ps.setString(1, mob);
            myDB.rs = ps.executeQuery();
            while(myDB.rs.next()){
                c.setCustomerID(myDB.rs.getInt("customerID"));
                c.setNmame(myDB.rs.getString("name"));
                c.setAddress(myDB.rs.getString("address"));
                c.setMobileNumber(myDB.rs.getString("mobileNumber"));
                c.setEmail(myDB.rs.getString("email"));
                c.setAge(myDB.rs.getInt("age"));
                count ++;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return c;
    }
}
