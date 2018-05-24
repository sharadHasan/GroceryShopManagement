package daoPackage;

import myPackage.Product;
import java.sql.*;
public interface ProductDao {
        public ResultSet showStorage();
        public boolean addNewProduct(Product p);
        public boolean deleteProduct(String name);
        public boolean updateProduct(Product p);
        public Product searchProduct(String prodName1); 
}
