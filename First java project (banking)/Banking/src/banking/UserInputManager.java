/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
 public class UserInputManager implements IUserInputManager{

    public UserInputManager() {
        
    }

    @Override
    public int retrieveAccountNumber() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please enter the account number: ");
       
        
        return sc.nextInt();
    }
    @Override
   
    
    public Account retrieveAccountType() {
       Scanner sc = new Scanner(System.in);
        System.out.println("please choose the type of account you would like to create");
        System.out.println("[1] checkingAccount");
        System.out.println("[2] SavingsAccount");
       int userInput = sc.nextInt();
     
       if(userInput==1){
         return new CheckingAccount("Checking");
       
       
       }else if(userInput==2){
      return  new SavingsAccount("Savings");  
       
       }
     
        return null ;
    }

    @Override
    public int retrieveClientId() {
       Scanner sc = new Scanner(System.in);
        
       System.out.println("Please enter your client id: ");
        
        return sc.nextInt();  
    }

    @Override
    public Client retrieveClientInfo() {
       
        
        Scanner sc = new Scanner(System.in);
        String lastName;
        String firstName ;
        //ArrayList<Client> client = new ArrayList<Client>();
        
        System.out.println("Please enter your first name: ");
      firstName =  sc.nextLine();
      System.out.println("Please enter your last name: ");
      lastName =  sc.nextLine();
      //client.add(new Client(firstName, lastName));
      //new Client(firstName, lastName);
      //client.add(new Client(firstName, lastName));
      return new Client(firstName, lastName);
             
    }

    @Override
    public double retrieveTransactionAmount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the amount: ");
           double amount= sc.nextDouble();
           if(amount<0){
               return -1.1; 
           }
        
        return  amount;
    }

    @Override
    public int retrieveUserOption() {
       
         Scanner sc = new Scanner(System.in);
       
         return   sc.nextInt();
    }
    
}
