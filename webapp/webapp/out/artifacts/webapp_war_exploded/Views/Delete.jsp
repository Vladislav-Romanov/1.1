<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>

<div>
    <div>
        <div>
            <h2>Delete Employees</h2>
        </div>

        <form method="post" action="delete">
            <input type='text' required placeholder="Full_Name" name='Full_Name' /><br>
            <input type='submit' value='delete' />
        </form>

    </div>
</div>

<div>
    <button onclick="location.href='/Views/Menu.jsp'">Back to menu</button>
</div>
</body>
</html>


