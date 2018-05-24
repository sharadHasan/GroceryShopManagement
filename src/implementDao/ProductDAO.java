package implementDao;
import daoPackage.*;
import myPackage.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class ProductDAO implements ProductDao {
    
    DBConnect myDB = new DBConnect();
    public int count;
    
    public int getCount(){
        return count;
    }
    public ResultSet showStorage(){
        try{
           PreparedStatement ps = myDB.con.prepareStatement("select * from product"); 
           myDB.rs = ps.executeQuery();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return myDB.rs;
    }
    
    public Product searchProduct(String prodName1){
        Product p = new Product();
        count  = 0;
        try{
            PreparedStatement ps = myDB.con.prepareStatement("select * from product where productName = ?");
            ps.setString(1, prodName1); 
            myDB.rs = ps.executeQuery(); 
            while(myDB.rs.next()){
                p.setProductID(myDB.rs.getInt("productID"));
                p.setProductName(myDB.rs.getString("productName"));
                p.setProductPrice(myDB.rs.getDouble("productPrice"));
                p.setProductStorage(myDB.rs.getDouble("storage"));
                count ++;
            }
          }catch(SQLException ex){
              ex.printStackTrace();
          }
        return p;
    }

    public boolean addNewProduct(Product p){
        boolean inserted = false;
        try{
            PreparedStatement ps = myDB.con.prepareStatement("insert into product (productName,productPrice,storage) values (?,?,?)");
            ps.setString(1, p.getProductName());
            ps.setString(2, Double.toString(p.getProductPrice()));
            ps.setString(3, Double.toString(p.getStorage()));
            ps.executeUpdate();
            inserted = true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return inserted;
    }
    
    public boolean deleteProduct(String name){
        boolean deleted = false;
        try{
            PreparedStatement ps = myDB.con.prepareStatement("delete from product where productName = ?");
            ps.setString(1, name);
            ps.executeUpdate();
            deleted = true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return deleted;
    }
    
    public boolean updateProduct(Product p){
        boolean updated = false;
        try{
            PreparedStatement ps = myDB.con.prepareStatement("update product set productPrice = ?, storage = ? where productName = ?");
            ps.setString(1, Double.toString(p.getProductPrice()));
            ps.setString(2, Double.toString(p.getStorage()));
            ps.setString(3, p.getProductName());
            ps.executeUpdate();
            updated = true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return updated;
    }
    
    public void adjustQuantity(double quant, String name){
        try{
            PreparedStatement ps = myDB.con.prepareStatement("update product set storage = storage-? where productName = ?");
            ps.setString(1, Double.toString(quant));
            ps.setString(2, name);
            ps.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
