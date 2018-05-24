package myPackage;

/**
* This customer class inherits the Person class
* It is used to store the information of the customers.
*/
public class Customer extends Person {
    private int customerID;
    public Customer(){

    }

     public Customer(int customerID, String name, String address, String mobileNumber,String email,int age){
     this.customerID = customerID;
     this.name = name;
     this.address = address;
     this.mobileNumber = mobileNumber;
     this.email = email;
     this. age = age;
    }

     public int getCustomerID(){
         return customerID;
     }

     public void setCustomerID(int customerID){
         this.customerID = customerID;
     }

     @Override
     public String toString(){
         String str;
         str ="CustomerID: "+ this.customerID + "\n" + "Name: "+this.name+"\n"+"Address: "+this.address+"\n"+"Mobile: "+this.mobileNumber+"\n"+"Email: "+this.email+"\n"+"Age: "+this.age;
         return str;
     }
}
