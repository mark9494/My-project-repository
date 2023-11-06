/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package managementhelper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;

/**
 *
 * @author Mark
 */
public class ManagementHelper {

    public static void main(String[] args) {
        File f1 = new File("C:\\Users\\Mark\\Downloads\\Employees list");
        Restaurant resto = new Restaurant();
        UserInputManager uim = new UserInputManager();
        Comparator<Employee> salaryComparator = new Comparator<Employee>() {

            @Override
            public int compare(Employee e1, Employee e2) {
                if (e1.getSalary() > e2.getSalary()) {
                    return 1;
                } else if (e2.getSalary() > e1.getSalary())//array of employees is sorted by ascending order of salaryeach time a new employee is added
                {
                    return -1;
                } else {
                    return 0;
                }
            }

        };
        Comparator<Employee> idComparator = new Comparator<Employee>() {

            @Override
            public int compare(Employee e1, Employee e2) {
                if (e1.getId() > e2.getId()) {
                    return 1;
                } else if (e2.getId() > e1.getId())//array of employees is sorted by ascending order of salaryeach time a new employee is added
                {
                    return -1;
                } else {
                    return 0;
                }
            }

        };
        boolean endOfProgram = false;

        while (!endOfProgram) {
            uim.displayWelcomeScreen();

            int userCommand = uim.userInput();

            if (userCommand < 1 || userCommand > 5) {
                uim.goodBye();
                endOfProgram = true;
            }

            if (userCommand == 1) {//creating an employee
                Employee e = uim.createEmployee();

                uim.createSchedule(e);
                resto.getEmployees().add(e);
                resto.getEmployees().sort(salaryComparator);
                try {
                    FileWriter w = new FileWriter(f1);
                    for (int i = 0; i < resto.getEmployees().size(); i++) {
                        w.write("\n" + resto.getEmployees().get(i)); // please note that the order of the employees in the file is dependant on their salary in ascending order(refer to comparator at the start of the main method)
                    }
                    w.close();
                } catch (IOException h) {

                }

                e.calculateHoursWorked(e);

            } else if (userCommand == 2) {//deleting an employee
                Employee e = resto.findEmployee();
                if (e != null) {

                    resto.deleteEmployee(e);
                }
            } else if (userCommand == 3) {//this options gives many different commands to choose from regarding an employee's info
                uim.displayInfo();
                boolean returnToMainMenu = false;
                while (!returnToMainMenu) {

                    int userChoice = uim.userInput();
                    if (userChoice < 1 || userChoice > 4) {
                        System.out.println("Program terminated successfully!");
                        returnToMainMenu = true;
                    }
                    if (userChoice == 1) {
                        Employee e = resto.findEmployee();
                        if (e != null) {

                            e.displayHoursWorked();
                        }
                    } else if (userChoice == 2) {
                        Employee e = resto.findEmployee();
                        if (e != null) {

                            int size = e.getSchedule().size();
                            if (size == 0) {
                                System.out.println("==================================");
                                System.out.println("the employee's schedule is empty!");
                                System.out.println("==================================");
                            }
                            for (int i = 0; i < e.getSchedule().size(); i++) {
                                System.out.println(e.getSchedule().get(i));//no need to handle exception because we will always loop through the size of the arraylis.
                            }
                        }
                    } else if (userChoice == 3) {
                        Employee e = resto.findEmployee();
                        if (e != null) {
                            e.displayStatusAndSalary();
                        }
                    } else if (userChoice == 4) {
                        Employee e = resto.findEmployee();
                        if (e != null) {

                            e.displayPayOfCurrentWeek();
                        }
                    }

                    uim.displayInfo();
                }

            } else if (userCommand == 4) {
                resto.displayEmployees();
            } else if (userCommand == 5) {
                resto.getEmployees().sort(idComparator);
                System.out.println("employees sorted successfully!");// note that everytime a new employee is added, the employees will get sorted in ascending order of salary.
                //also, the file will always have the employees sorted in ascending order of salary because it is the priority of this system of management
            }
        }

    }

}
