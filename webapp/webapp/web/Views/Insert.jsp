<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Название документа</title>
    <style>
        #navbar ul{
            display: none;
            background-color: #f90;
            position: absolute;
            top: 100%;
        }
        #navbar li:hover ul { display: block; }
        #navbar, #navbar ul{
            margin: 0;
            padding: 0;
            list-style-type: none;
        }
        #navbar {
            height: 30px;
            background-color: #666;
            padding-left: 25px;
            min-width: 470px;
        }
        #navbar li {
            float: left;
            position: relative;
            height: 100%;
        }
        #navbar li a {
            display: block;
            padding: 6px;
            width: 100px;
            color: #fff;
            text-decoration: none;
            text-align: center;
        }
        #navbar ul li { float: none; }
        #navbar li:hover { background-color: #f90; }
        #navbar ul li:hover { background-color: #666; }
    </style>
</head>

<body>
<ul id="navbar">
    <li><a href="/read">Read</a></li>
    <li><a href="/insert">Insert</a></li>
    <li><a href="/index.jsp">Exit</a></li>
</ul>

<div>
    <div>
        <div>
            <h3>Insert Employees</h3>
        </div>

        <form method="post" action="insert">
            <input type='text' required placeholder="Full_Name" name='Full_Name' /><br>
            <input type='text' required placeholder="Department" name='Department' /><br>
            <input type='text' required placeholder="Phone" name='Phone' /><br>
            <input type='text' required placeholder="Salary" name='Salary' /><br>
            <input type='submit' value='Add' />
        </form>

    </div>
</div>

</body>
</html>
