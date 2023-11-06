/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managementhelper;

/**
 *
 * @author Mark
 */
public class Chef extends Employee {
   
   public Chef(String firstName, String lastName, String status, double salary){
      super(firstName, lastName,  status, salary);
   }

   @Override
    public void displayPayOfCurrentWeek(){
          double weeklySalary = this.hoursWorked * this.salary; 
           System.out.println(this.firstName + " " + this.lastName + " made "+ weeklySalary+"$ this week");
       }
    
}
