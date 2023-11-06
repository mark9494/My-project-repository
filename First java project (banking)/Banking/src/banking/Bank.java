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
public class Bank implements IBank{
    private String bankNumber;
    private String address;
    private ArrayList<Client> clientList = new ArrayList<Client>();
    
       UserInputManager uim = new UserInputManager();
       
       public Bank() {
       }

    public ArrayList<Client> getClientList() {
        return this.clientList;
    }

       
       
       
       
    public String getBankNumber() {
        return "";
    }

    public void setBankNumber(String bankNumber) {
        
    }

    public String getAddress() {
        return "";
    }

    public void setAddress(String address) {
        
    }

    @Override
    public void addClient(Client newClient) {
   this.clientList.add(newClient);
    
    }

    @Override
    public void displayClientAccounts(int clientId) {
      Client  client = getClient(clientId);
      if(client!=null){
          System.out.println("Accounts for: "+ client.getLastName()+", "+ client.getFirstName() + "("+ client.getId()+")");  
         for(int i=0;i<client.getAccountList().size();i++){
             System.out.println(client.getAccountList().get(i));
         } 
          
      }else{
          System.out.println("id not found");
      }  
    }

    @Override
    public void displayClientList() {
    System.out.println("The list of all the clients is: ");
              for(int i = 0; i<this.clientList.size();i++){  
                System.out.println(this.clientList.get(i));
    
    
    }
    }
    @Override
    public Client getClient(int id) {
     
        for(int i = 0; i < this.clientList.size(); i++){
        
            if(id == this.clientList.get(i).getId() ){
           
            return this.clientList.get(i);
            }
        }
        return null;
    }

    @Override
    public Account getClientAccount(int clientId, int accountNumber) {
       Client client = getClient(clientId);
       if(client!=null){
      Account acc =client.getAccount(accountNumber);
        if(acc!=null){
           return acc; 
        }else{
            System.out.println("account not found"); 
        return null;
        }
            
           
            
       }  else{
           System.out.println("id not found");
       return null;
       }
             
}
}