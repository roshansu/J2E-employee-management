package com.employee.controller;

import com.employee.dao.EmployeeDAO;
import com.employee.model.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {

    private EmployeeDAO employeeDAO;

    public void init() {
        employeeDAO = new EmployeeDAO();
    }

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action =
                request.getParameter("action");

        if ("delete".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id"));

            employeeDAO.deleteEmployee(id);

            response.sendRedirect("employees");

        } else {

            request.setAttribute(
                    "employees",
                    employeeDAO.getAllEmployees());

            request.getRequestDispatcher(
                            "employees.jsp")
                    .forward(request, response);
        }
    }

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action =
                request.getParameter("action");

        String employeeCode =
                request.getParameter("employeeCode");

        String name =
                request.getParameter("name");

        String email =
                request.getParameter("email");

        String department =
                request.getParameter("department");

        double salary =
                Double.parseDouble(
                        request.getParameter("salary"));

        Employee employee =
                new Employee(
                        employeeCode,
                        name,
                        email,
                        department,
                        salary
                );

        if ("add".equals(action)) {

            employeeDAO.addEmployee(employee);

        }

        response.sendRedirect("employees");
    }
}