
package myPackage;

import java.util.Scanner;

public class Product {
    private int productID;
    private String productName;
    private double productPrice;
    private double storage;
    
    Scanner scanner = new Scanner(System.in);
    
    public Product(){
        
    }
    
    public Product(int productID,String productName,double productPrice,double storage){
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.storage = storage;
    }
    
    public int getProductID(){
        return productID;
    }
    
    public String getProductName(){
        return productName;
    }
    
    public double getProductPrice(){
        return productPrice;
    }
    
    public double getStorage(){
        return storage;
    }
    
    public void setProductID(int productID){
        this.productID = productID;
    }
    
    public void setProductName(String productName){
        this.productName = productName;
    }
    
    
    public void setProductPrice(double productPrice){
        this.productPrice = productPrice;
    }
    
    public void setProductStorage(double storage){
        this.storage = storage;
    }
    
    @Override
    public String toString(){
        String str;
        str = "ProductID: "+this.productID+"\n"+"Product Name: "+this.productName+"\n"+"Product Price: "+this.productPrice+"\n"+"Available quantity: "+this.storage;
        return str;
    }
}
