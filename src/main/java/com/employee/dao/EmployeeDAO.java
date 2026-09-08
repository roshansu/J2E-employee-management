package com.employee.dao;

import com.employee.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public boolean addEmployee(Employee employee) {

        String sql = """
                INSERT INTO employees
                (employee_code, name, email, department, salary)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, employee.getEmployeeCode());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getEmail());
            ps.setString(4, employee.getDepartment());
            ps.setDouble(5, employee.getSalary());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }

    public List<Employee> getAllEmployees() {

        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT * FROM employees";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Employee employee = new Employee();

                employee.setId(rs.getInt("id"));
                employee.setEmployeeCode(
                        rs.getString("employee_code"));
                employee.setName(
                        rs.getString("name"));
                employee.setEmail(
                        rs.getString("email"));
                employee.setDepartment(
                        rs.getString("department"));
                employee.setSalary(
                        rs.getDouble("salary"));

                employees.add(employee);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return employees;
    }

    public Employee getEmployeeById(int id) {

        String sql =
                "SELECT * FROM employees WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Employee(
                        rs.getInt("id"),
                        rs.getString("employee_code"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }

    public boolean updateEmployee(Employee employee) {

        String sql = """
                UPDATE employees
                SET employee_code = ?,
                    name = ?,
                    email = ?,
                    department = ?,
                    salary = ?
                WHERE id = ?
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, employee.getEmployeeCode());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getEmail());
            ps.setString(4, employee.getDepartment());
            ps.setDouble(5, employee.getSalary());
            ps.setInt(6, employee.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteEmployee(int id) {

        String sql =
                "DELETE FROM employees WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }
}