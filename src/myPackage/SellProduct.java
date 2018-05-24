package myPackage;

public class SellProduct {
    private String productName;
    private double rate;
    private double quantity;
    private double price;
    
    public String getProductName(){
        return productName;
    }
    
    public double getRate(){
        return rate;
    }
    
    public double getQuantity(){
        return quantity;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setProductName(String prodName){
        productName = prodName;
    }
    
    public void setRate(double rate){
        this.rate  = rate;
    }
    
    public void setQuantity(double quant){
        quantity = quant;
    }  
    
    public void setPrice(){
        price = rate*quantity;
    }
}
