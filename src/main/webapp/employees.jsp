<%@ page import="java.util.List" %>
<%@ page import="com.employee.model.Employee" %>

<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    List<Employee> employees =
            (List<Employee>) request.getAttribute("employees");
%>

<!DOCTYPE html>

<html>

<head>

    <title>Employees</title>

    <link rel="stylesheet"
          href="css/style.css">

</head>

<body>

<div class="container">

    <h2>Employee List</h2>

    <a href="employee-form.jsp">
        <button>Add Employee</button>
    </a>

    <br><br>

    <table>

        <tr>

            <th>ID</th>
            <th>Code</th>
            <th>Name</th>
            <th>Email</th>
            <th>Department</th>
            <th>Salary</th>
            <th>Action</th>

        </tr>

        <%
            for (Employee employee : employees) {
        %>

        <tr>

            <td><%= employee.getId() %></td>

            <td>
                <%= employee.getEmployeeCode() %>
            </td>

            <td>
                <%= employee.getName() %>
            </td>

            <td>
                <%= employee.getEmail() %>
            </td>

            <td>
                <%= employee.getDepartment() %>
            </td>

            <td>
                <%= employee.getSalary() %>
            </td>

            <td>

                <a href="employees?action=delete&id=<%= employee.getId() %>"
                   onclick="return confirm('Delete employee?')">

                    Delete

                </a>

            </td>

        </tr>

        <%
            }
        %>

    </table>

    <br>

    <a href="dashboard.jsp">
        Back to Dashboard
    </a>

</div>

</body>

</html>