/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package managementhelper;

import java.util.ArrayList;

/**
 *
 * @author Mark
 */
public abstract class Employee {
    private ArrayList<WeekDays> schedule ; 
    
    protected double hoursWorked;
    protected static int counter =1;
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String status;
    protected double salary;
   
    public Employee(String firstName, String lastName, String status, double salary){
      schedule = new ArrayList<>();
      this.id = counter;
      this.firstName = firstName;
      this.lastName = lastName;
      this.status = status;
      this.salary = salary;
      this.hoursWorked=0;
      
      counter++;
    }

    public ArrayList<WeekDays> getSchedule() {
        return this.schedule;
    }

    public void setSchedule(ArrayList<WeekDays> schedule) {
        this.schedule = schedule;
    }

    

    

    public double getHoursWorked() {
        return this.hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public static int getCounter() {
        return Employee.counter;
    }

    public static void setCounter(int counter) {
        Employee.counter = counter;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
   public String toString(){
     return "[" + this.id+ "] "+ this.firstName +" " +this.lastName + "(" + this.status + ")";
   }
        
     public void calculateHoursWorked(Employee e){
         double hoursWorked = 0;
     for(int i =0;i< e.getSchedule().size();i++){
     WeekDays day = e.getSchedule().get(i);
    double startingTime = day.getShiftStart();
    double endingTime = day.getShiftEnd();
     hoursWorked =(endingTime - startingTime) + hoursWorked;// why can't we put this. on weeklySalary?
     
     }
      e.setHoursWorked(hoursWorked);
     }
     public void displayHoursWorked(){
         System.out.println("===================================================");
         System.out.println(firstName + " "+ lastName + " has worked " + hoursWorked + " hours this week");
         System.out.println("===================================================");
     }
     public void displayStatusAndSalary(){
         System.out.println(firstName + " " + lastName +" is a " + status +" and is payed " + salary +"$ an hour");  
     }
    
     
     
      abstract void displayPayOfCurrentWeek();//each employee is paid differently whic is why this method is abstract and cannot be concrete
      //Please refer to the classes that inherit Employee to find the actual body of this method
          
       
}
