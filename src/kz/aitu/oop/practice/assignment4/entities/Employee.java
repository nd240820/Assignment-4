package kz.aitu.oop.practice.assignment4.entities;

public class Employee {

    /*
    access modifier, data types, variables
     */
    private int id;
    private String name;
    private String surname;
    private String role;
    private int salary;


    /*
    method for recording data
     */
    public Employee(int id, String name, String surname, String role, int salary) {
        setId(id);
        setName(name);
        setSurname(surname);
        setRole(role);
        setSalary(salary);
    }

    /*
    getters and setters for data
     */
    public int  getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    /*
    method for outputting all data
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", role=" + role + '\'' +
                ", salary=" + salary + '\'' +
                '}';
    }
}
