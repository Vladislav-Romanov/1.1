<%@ page import="app.Entities.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>

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
<%
    Employee employee = null;
    System.out.println("abc");
    employee = (Employee) request.getAttribute("Employee");
    if(employee != null) {
        out.println(" <form method=\"post\" action=\"insert\">");
        out.println("<input name=\"Full_Name\" type=\"text\" value=\""+ employee.getFull_name() + "\">");
        out.println("<input name=\"Department\" type=\"text\" value=\"" + employee.getDepartment() + "\">");
        out.println("<input name=\"Phone\" type=\"text\" value=\"" + employee.getPhone() + "\">");
        out.println("<input name=\"textfield\" type=\"text\" value=\"" + employee.getSalary() + "\">");
        out.println("<input type='submit' value='Update' />");
    }
    else{
        out.println("<br>" + "Что-то пошло не так" + "</br>");
    }
%>
</div>
<div>
    <button onclick="location.href='/Views/Menu.jsp'">Back to menu</button>
</div>
</body>
</html>
