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
public class Account implements IAccount{
    protected static int counter = 1;
    protected int accountNumber;
    protected double balance;
    protected Client owner;
    protected String type ;
    
    protected ArrayList<Transaction> transactions;
    

  
    public Account(String type) {
        this.type = type;
        this.transactions = new ArrayList<Transaction>();
        this.balance=0;
        this.accountNumber=counter;
        Account.counter++;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static int getCounter() {
        return Account.counter;
    }

    public static void setCounter(int counter) {
        Account.counter = counter;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client getOwner() {
        return this.owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    @Override
    public double deposit(double d) {
     this.balance = this.balance  + d;
     this.transactions.add(new Transaction("Deposit", d));
     return this.balance;
    }

    @Override
    public void displayAllTransactions() {
       for(int i =0;i<this.transactions.size();i++){
         System.out.println(this.transactions.get(i));; 
                     
       }
           
    }

    @Override
    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }
    
    public double withdrawal(double w) {
       if(this.balance>= w && w>=0){
        this.balance = this.balance  - w;
     this.transactions.add(new Transaction("withdrawal", w));
     return this.balance;
       }
       else{
         return -1.1; 
         }
       
    }
    
    public String toString(){
    return this.type+"("+this.accountNumber +"):" + this.balance +"$"+"" ;
    }
}
