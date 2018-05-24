
package daoPackage;

import java.sql.*;
import myPackage.Customer;

public interface CustomerDao {
    
    public ResultSet showCustomer();
    public boolean addNewCustomer(Customer c);
    public boolean deleteCustomer(String name);
    public boolean updateCustomer(Customer c);
    public Customer searchCustomer(String customerName);
    public Customer searchByMob(String mob);
}
