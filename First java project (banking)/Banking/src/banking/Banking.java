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
public class Banking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bank myBank = new Bank();
        UserInputManager uim = new UserInputManager();

        boolean endOfprogram = false;

        while (!endOfprogram) {

            System.out.println("Commands list");

            System.out.println("[1] Add a new Client");
            System.out.println("[2] Create a new Account ");
            System.out.println("[3] Make a Deposit");
            System.out.println("[4] Make a Withdrawal");
            System.out.println("[5] List Account Transactions");
            System.out.println("[6] List Clients");
            System.out.println("[7] List Client Accounts");
            System.out.println("[8] Exit");
            System.out.println("Please choose a command to procede: ");

            int userInputValue = uim.retrieveUserOption();

            if (!(userInputValue < 8 && userInputValue > 0)) {
                endOfprogram = true;
                System.out.println("End of program");
                break;
            }

            if (userInputValue == 1) {

                myBank.addClient(uim.retrieveClientInfo());

            } else if (userInputValue == 2) {

                Client clientFound = myBank.getClient(uim.retrieveClientId());

                if (clientFound != null) {
                    Account accType = uim.retrieveAccountType();
                    if (accType != null) {
                        clientFound.addAccount(accType);
                    } else {
                        System.out.println("unknown command");
                    }
                } else {
                    System.out.println("id not found");
                }

            } else if (userInputValue == 3) {
                int clientId = uim.retrieveClientId();
                int accountNumber = uim.retrieveAccountNumber();

                Account acc = myBank.getClientAccount(clientId, accountNumber);
                if (acc != null) {
                    double amount = uim.retrieveTransactionAmount();
                    if (amount == -1.1) {
                        System.out.println("Cannot deposit a negative number");

                    } else {
                        acc.deposit(amount);
                        System.out.println(acc);
                    }
                }

            } else if (userInputValue == 4) {

                int clientId = uim.retrieveClientId();
                int accountNumber = uim.retrieveAccountNumber();

                Account acc = myBank.getClientAccount(clientId, accountNumber);

                if (acc != null) {

                    double withdrawalCheck = acc.withdrawal(uim.retrieveTransactionAmount());
                    if (withdrawalCheck == -1.1) {
                        System.out.println("insufficient funds");
                    } else {
                        System.out.println(acc);
                    }
                }

            } else if (userInputValue == 5) {
                int clientId = uim.retrieveClientId();
                int accountNumber = uim.retrieveAccountNumber();

                Account acc = myBank.getClientAccount(clientId, accountNumber);
                if (acc != null) {
                    acc.displayAllTransactions();

                    System.out.println(acc);
                }
            } else if (userInputValue == 6) {

                myBank.displayClientList();

            } else if (userInputValue == 7) {
                myBank.displayClientAccounts(uim.retrieveClientId());

            }

        }

    }

}
