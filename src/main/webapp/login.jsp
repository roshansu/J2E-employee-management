<!DOCTYPE html>
<html>
<head>

    <title>Employee Management - Login</title>

    <style>

        body {
            font-family: Arial, sans-serif;
            background: #f2f2f2;
        }

        .login-box {
            width: 350px;
            margin: 100px auto;
            padding: 30px;
            background: white;
            border-radius: 8px;
        }

        input {
            width: 100%;
            padding: 10px;
            margin: 8px 0 15px;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            padding: 10px;
            cursor: pointer;
        }

    </style>

</head>

<body>

<div class="login-box">

    <h2>Employee Management System</h2>

    <form action="login" method="post">

        <label>Username</label>

        <input
            type="text"
            name="username"
            placeholder="Enter username"
        >

        <label>Password</label>

        <input
            type="password"
            name="password"
            placeholder="Enter password"
        >

        <button type="submit">
            Login
        </button>

    </form>

</div>

</body>
</html>