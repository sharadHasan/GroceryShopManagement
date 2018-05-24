package myPackage;
import java.sql.*;
public class DBConnect {
    public Connection con = null;
    public ResultSet rs = null;
    
    public DBConnect(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/groceryshopmanagement", "root", "");
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
