<!DOCTYPE html>

<html>

<head>

    <title>Add Employee</title>

    <link rel="stylesheet"
          href="css/style.css">

</head>

<body>

<div class="container">

    <h2>Add Employee</h2>

    <form action="employees" method="post">

        <input type="hidden"
               name="action"
               value="add">

        <label>Employee Code</label>

        <input type="text"
               name="employeeCode"
               required>

        <label>Name</label>

        <input type="text"
               name="name"
               required>

        <label>Email</label>

        <input type="email"
               name="email"
               required>

        <label>Department</label>

        <select name="department">

            <option value="IT">IT</option>

            <option value="HR">HR</option>

            <option value="Finance">
                Finance
            </option>

            <option value="Marketing">
                Marketing
            </option>

        </select>

        <label>Salary</label>

        <input type="number"
               name="salary"
               required>

        <button type="submit">
            Add Employee
        </button>

    </form>

</div>

</body>

</html>