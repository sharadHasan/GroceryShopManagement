package myPackage;

public class Employee extends Person {
    private int employeeID;
    private double salary;
    
    public Employee(){
        
    }
    
    public Employee(int employeeID, String name, String address, String mobileNumber,String email,int age,int salary){
        this.employeeID = employeeID;
        this.name = name;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this. age = age;
        this.salary = salary;
    }
    public int getEmployeeID(){
        return employeeID;
    }
    
    public double getSalary(){
        return salary;
    }
    
    public void setEmployeeID(int employeeID){
        this.employeeID = employeeID;
    }
    
    public void setSalary(double salary){
        this.salary = salary;
    }
    
        @Override
        public String toString(){
            String str;
            str ="EmployeeID: "+ this.employeeID + "\n" + "Name: "+this.name+"\n"+"Address: "+this.address+"\n"+"Mobile: "+this.mobileNumber+"\n"+"Email: "+this.email+"\n"+"Age: "+this.age+"\n"+"Salary: "+this.salary;
            return str;
        }
}
