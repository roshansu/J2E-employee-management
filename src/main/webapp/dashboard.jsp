<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>

<head>

    <title>Dashboard</title>

    <link rel="stylesheet"
          href="css/style.css">

</head>

<body>

<div class="container">

    <h2>Employee Management Dashboard</h2>

    <p>
        Welcome,
        <%= session.getAttribute("username") %>
    </p>

    <a href="employees">
        <button>Manage Employees</button>
    </a>

    <br><br>

    <a href="logout">
        Logout
    </a>

</div>

</body>

</html>