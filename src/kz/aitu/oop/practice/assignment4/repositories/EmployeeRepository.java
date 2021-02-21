package kz.aitu.oop.practice.assignment4.repositories;

import kz.aitu.oop.practice.assignment4.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment4.entities.Employee;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IEmployeeRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private final IDB db;

    public EmployeeRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean hireEmployee(Employee employee) {
        Connection con = null;
        try {
            con = db.getConnection(); //connecting to database
            String sql = "INSERT INTO employees(id,name,surname,role,salary) VALUES (?,?,?,?,?)"; //sql query
            PreparedStatement st = con.prepareStatement(sql);

            /*
            inputting 5 records(id, name, surname, role and salary)
             */
            st.setInt(1, employee.getId());
            st.setString(2, employee.getName());
            st.setString(3, employee.getSurname());
            st.setString(4, employee.getRole());
            st.setInt(5, employee.getSalary());

            st.execute();
            return true; //returning true if entered records are correct
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Employee getEmployee(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,role,salary FROM employees WHERE id=?"; //sql query to find employee by id
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id); //inputting id

            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                /*
                outputting column's records
                 */
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("role"),
                        rs.getInt("salary"));

                return employee;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,role,salary FROM employees";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Employee> employees = new LinkedList<>();
            while (rs.next()) {

                /*
                outputting column's records
                 */
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("role"),
                        rs.getInt("salary"));

                employees.add(employee);
            }

            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public int totalProjectCost() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "select sum(salary) as totalcost from employees"; //sql query
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while(rs.next()) {
                int sum = rs.getInt("totalcost");
                System.out.print(sum); //outputting totalcost
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }

}
