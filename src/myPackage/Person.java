package myPackage;

public class Person {
    protected String name;
    protected String address;
    protected String mobileNumber;
    protected String email;
    protected int age;
   
    public Person(){
        
    }
    
    public Person(String name, String address, String mobileNumber,String email,int age){
        this.name = name;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this. age = age;
    }
    
    public String getName(){
        return name;
    }
    
    public String getAddress(){
        return address;
    }
    
    public String getMobileNumber(){
        return mobileNumber;
    }
    
    public String getEmail(){
        return email;
    }
    
    public int getAge(){
        return age;
    }
    
    public void setNmame(String name){
        this.name = name;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public void setMobileNumber(String mobileNumber){
        this.mobileNumber = mobileNumber;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setAge(int age){
        this. age = age;
    }
    
    @Override
    public String toString(){
        String str;
        str = "Name: "+this.name+"\n"+"Address: "+this.address+"\n"+"Mobile: "+this.mobileNumber+"\n"+"Email: "+this.email+"\n"+"Age: "+this.age;
        return str;
    }
}
