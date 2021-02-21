package kz.aitu.oop.practice.assignment4;

import kz.aitu.oop.practice.assignment4.controllers.EmployeeController;
import kz.aitu.oop.practice.assignment4.repositories.EmployeeRepository;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final EmployeeController controller;
    private final Scanner scanner;

    public MyApplication(EmployeeController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {

            /*
            outputting messages to console
             */
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all employees");
            System.out.println("2. Get employee by id");
            System.out.println("3. Employ employee");
            System.out.println("4. See total project cost");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-4): "); //choosing option
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllEmployeesMenu(); //calling method in case of option = 1
                } else if (option == 2) {
                    getEmployeeByIdMenu(); //calling method in case of option = 2
                } else if (option == 3) {
                    hireEmployeeMenu(); //calling method in case of option = 3
                } else if (option == 4) {
                    totalProjectCost(); //calling method in case of option = 4
                } else {
                    break; //stopping program
                }
            } catch (InputMismatchException m) {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");

        }
    }

    public void getAllEmployeesMenu() {
        String response = controller.getAllEmployees(); //creating new variable and equalizing it to output of method from controller class
        System.out.println(response);
    }

    public void getEmployeeByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getEmployee(id); //creating new variable and equalizing it to output of method from controller class
        System.out.println(response);
    }

    public void hireEmployeeMenu() {
        /*
        input records
         */
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Please enter role");
        String role = scanner.next();
        System.out.println("Please enter salary");
        int salary = scanner.nextInt();

        String response = controller.hireEmployee(id, name, surname, role, salary); //creating new variable and equalizing it to output of method from controller class
        System.out.println(response);
    }

    public void totalProjectCost() {
        System.out.println("Total project cost is ");
        int result = controller.totalProjectCost(); //creating new variable and equalizing it to output of method from controller class
        System.out.println(result);
    }

}