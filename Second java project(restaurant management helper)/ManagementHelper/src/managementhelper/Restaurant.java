/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managementhelper;

import java.util.ArrayList;

/**
 *
 * @author Mark
 */
public class Restaurant extends UserInputManager implements IRestaurant{
 private  ArrayList<Employee> employees ; 
 
     public Restaurant(){
        this.employees = new ArrayList<>(); 
     }

    public ArrayList<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
 @Override
      public Employee findEmployee(){
          int id = retrieveEmployeeId();
        for(int i =0;i<this.employees.size();i++){
         int empId = this.employees.get(i).getId();
            if(id==empId){
                
              return this.employees.get(i);
            }
        }
          System.out.println("===================================");
          System.out.println("Id not found, please try again");
          System.out.println("===================================");
        return  null;
      } 
     
 @Override
      public void deleteEmployee(Employee e){
       this.employees.remove(e);
      }
      public void displayEmployees(){
          for(int i =0;i<employees.size();i++){
              System.out.println(employees.get(i)); 
          }
      }
    
}
