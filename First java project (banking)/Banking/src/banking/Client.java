/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Client implements IClient{
    private static int counter = 1;
    
    private int id;
    private  String firstName;
    private  String lastName; 
    private ArrayList<Account> accountList;
  
    
    
    
    public Client(String firstName, String lastName) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.id = counter++;
       this.accountList = new ArrayList<Account>();
    }

    public ArrayList<Account> getAccountList() {
        return this.accountList;
    }
    
    
    
    
    public static int getCounter() {
        return Client.counter;
    }

    
    
    public static void setCounter(int counter) {
        Client.counter = counter;
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

    @Override
    public void addAccount(Account newAccount) {
    this.accountList.add(newAccount);
    }

    @Override
    public void displayAccounts() {
       for(int i = 0; i < this.accountList.size(); i++){
        System.out.println(this.accountList.get(i)); //this method is not used because 
        //we already have a method that does the exact saem thing in bank called displayClientAccounts 
        
       }    
    }

    @Override
    public Account getAccount(int accountNumber) {
        for(int i = 0; i < this.accountList.size(); i++){
         if(accountNumber == this.accountList.get(i).getAccountNumber()){
            return this.accountList.get(i);
        } 
        }  
        return null;
    }
   public String toString(){
   return  " (" +this.id+ ")" +  this.lastName + ", " + this.firstName;
    }
   
}
