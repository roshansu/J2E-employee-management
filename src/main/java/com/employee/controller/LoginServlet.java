package com.employee.controller;

import com.employee.dao.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String username =
                request.getParameter("username");

        String password =
                request.getParameter("password");

        String sql =
                "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                HttpSession session =
                        request.getSession();

                session.setAttribute(
                        "username",
                        username);

                response.sendRedirect("dashboard.jsp");

            } else {

                request.setAttribute(
                        "error",
                        "Invalid username or password");

                request.getRequestDispatcher(
                                "login.jsp")
                        .forward(request, response);
            }

        } catch (SQLException e) {

            throw new ServletException(e);
        }
    }
}