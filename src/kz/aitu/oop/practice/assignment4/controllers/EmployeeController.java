package kz.aitu.oop.practice.assignment4.controllers;

import kz.aitu.oop.practice.assignment4.entities.Employee;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IEmployeeRepository;

import java.util.List;

public class EmployeeController {
    private final IEmployeeRepository repo;

    public EmployeeController(IEmployeeRepository repo) {
        this.repo = repo;
    }

    public String hireEmployee(int id, String name, String surname, String role, int salary) {
        Employee employee = new Employee(id, name, surname, role, salary);

        boolean hired = repo.hireEmployee(employee); //creating new variable and equalizing it to input of method from controller class

        return (hired ? "Employee was hired!" : "Can not hire employee!"); //if else
    }

    public String getEmployee(int id) {
        Employee employee = repo.getEmployee(id); //creating new variable and equalizing it to output of method from controller class

        return (employee == null ? "Employee was not found!" : employee.toString()); //if else
    }

    public String getAllEmployees() {

        /*
        outputting all records from database by calling method from repo class
         */
        List<Employee> employees = repo.getAllEmployees();

        return employees.toString();
    }

    public int totalProjectCost() {

        /*
        outputting result from database by calling method from repo class
         */
        int totalCost = repo.totalProjectCost();
        return totalCost;
    }
}