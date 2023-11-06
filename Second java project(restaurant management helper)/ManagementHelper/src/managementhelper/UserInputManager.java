/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managementhelper;

import java.util.InputMismatchException;
import java.util.Scanner;


public class UserInputManager {
private final static String[] days = {"Monday", "Tuesday", "Wednesday","Thursday", "Friday", "Saturday", "Sunday"};

    public UserInputManager(){
        
    }
   
    public void displayWelcomeScreen(){
        System.out.println("Welcome to management helper!");
        System.out.println("==================================");
        System.out.println("Please choose a command:");
        System.out.println("[1] Add a new employee");
        System.out.println("[2] Delete an employee");
        System.out.println("[3] Display  employee information");
        System.out.println("[4] Display all employees");
        System.out.println("[5] sort employees based on their id number in ascending order");
        System.out.println(" Press any other key to exit the program ");
        
    }
    public void displayInfo(){
        System.out.println("[1] Display hours worked this week ");
        System.out.println("[2] Display weekly schedule");
        System.out.println("[3] Display status and salary");
        System.out.println("[4] Display the employee's pay of the current week");
        System.out.println("====================================");
        System.out.println("Press any other key to return to the main menu");
        
    }
    
    
    public int userInput() {
      Scanner sc = new Scanner(System.in);
      int userInput;
      try{
     userInput  =sc.nextInt();
      }catch(InputMismatchException a){
        return -1; // when we return -1 to the main class, the boolean variable endOfProgram becomes true. 
      }
      
        return userInput;
          
    }
      public Employee createEmployee(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the employee's first name");
         String firstName = sc.nextLine();
          System.out.println("Please enter the employee's last name");
          String lastName = sc.nextLine();
          employeeStatus();
          String statusChoice = sc.nextLine();
          while(!statusChoice.equalsIgnoreCase("1") && !statusChoice.equalsIgnoreCase("2") && !statusChoice.equalsIgnoreCase("3")){
              System.out.println("Please choose one of the availabe options!");
            employeeStatus();
           statusChoice = sc.nextLine();  
          }
          double salary = salaryChoice(); 
          if(statusChoice.equalsIgnoreCase("1")){
           
            return new Chef( firstName, lastName, "Chef", salary );  
                }else if(statusChoice.equalsIgnoreCase("2")){
                   
                return new Waiter(firstName, lastName, "Waiter", salary );
                    }else if(statusChoice.equalsIgnoreCase("3")){
                        
                     return new Bartender(firstName, lastName, "Bartender", salary);  
                    }         
          return createEmployee();
      }
      
    public void employeeStatus(){
        System.out.println("Please choose the type of employee:");
        System.out.println("[1] Chef");
        System.out.println("[2] Waiter");
        System.out.println("[3] Bartender");
    }
    public double salaryChoice(){
       Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the salary of the employee");
        double salary = 0;
        try{
         salary = sc.nextDouble();
        }catch(InputMismatchException e){
            System.out.println("Please enter a number!");
            return salaryChoice();
        }
        if(salary <= 0){
            System.out.println("Please enter a positive number!");
         return salaryChoice();   
        }
        return salary;
    }
    
    public int retrieveEmployeeId(){
       Scanner sc = new Scanner(System.in); 
        System.out.println("Please enter the employee's id");
        int id = -1;
        try{
           id= sc.nextInt();
        }catch(InputMismatchException w){
           return  retrieveEmployeeId();
        }
        return id;
    }
 public void createSchedule(Employee e){
     
    Scanner sc = new Scanner(System.in);
     for(int i=0;i<days.length;i++){
         System.out.println("will the employee work on " + days[i]);
         System.out.println("Enter true for yes");
         System.out.println("enter false for no");
         boolean answer = retrieveBoolean();
         if(answer){
            double startingTime = retrieveShiftStart();
            double endingTime = retrieveShiftEnd();
            while(startingTime> endingTime){
                System.out.println("=========================================================================");
                System.out.println("Please make sure that the starting time is smaller than the ending time");
                
               startingTime = retrieveShiftStart();
               endingTime = retrieveShiftEnd();
            }
            if(startingTime==endingTime){
                System.out.println("Please make sure that the start time of your shift is different than the end time!");
                createSchedule(e);
                break;
            }
            if(i==0){
               e.getSchedule().add(new WeekDays(startingTime, endingTime, "Monday"));
            }else if(i==1){
             e.getSchedule().add(new WeekDays(startingTime, endingTime,"Tuesday"));   
            }else if(i==2){
             e.getSchedule().add(new WeekDays(startingTime, endingTime, "Wednesday"));   
            }else if(i==3){
             e.getSchedule().add(new WeekDays(startingTime, endingTime,"Thursday"));   
            }else if(i==4){
             e.getSchedule().add(new WeekDays(startingTime, endingTime, " Friday"));   
            }else if(i==5){
             e.getSchedule().add(new WeekDays(startingTime, endingTime, "Saturday"));   
            } else if(i==6){
             e.getSchedule().add(new WeekDays(startingTime, endingTime, "Sunday"));   
            }    
            
            
         }
     }
     
    
 }
 public boolean retrieveBoolean(){
    Scanner sc= new Scanner(System.in);
    boolean answer = false;
    try{
       answer = sc.nextBoolean();
    }catch(InputMismatchException c){
        System.out.println("=============================================");
        System.out.println("Please make sure to enter true or false!");
        return retrieveBoolean();
    }
    return answer;
 }
 public double retrieveShiftStart(){
    Scanner sc = new Scanner(System.in);
     System.out.println("Please note that the restaurant is open from 1pm until 11pm");
     System.out.println("When will the Employee start working?");
     double startTime = 0;
     try{
     startTime = sc.nextDouble();
     }catch(InputMismatchException d){
         System.out.println("Please make sure to enter a number!");
         return retrieveShiftStart();
     }
    if(startTime >11 || startTime<=0 ){
       return  retrieveShiftStart();
    }else{
      return startTime;  
    }
 }
 public double retrieveShiftEnd(){
    Scanner sc = new Scanner(System.in);
     System.out.println("Please note that the restaurant is open from 1pm until 11pm");
     System.out.println("When will the Employee stop working?");
    double endTime =0 ;
    try{
       endTime = sc.nextDouble();
    }catch(InputMismatchException f){
      System.out.println("Please make sure to enter a number!");
         return retrieveShiftEnd();  
    }
    if(endTime>11 || endTime<=0 ){
        return retrieveShiftEnd();
 
    }else{
      return endTime;  
    }

 }
 
 public void goodBye(){
    System.out.println("Program ended successfulley");
    System.out.println("===============================");
    System.out.println("Thank you for choosing Management Helper!");
    System.out.println("===============================");
 }
 
}