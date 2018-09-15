<%@ page import="app.Entities.Employee" %>
<%@ page import="java.util.*" %>
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
<table id="table" border="0">
    <%
        List <Employee> employees = (List<Employee>) request.getAttribute("employees");
        if (employees != null && !employees.isEmpty()){
            out.println("<tr>");
            out.println("<th>Full_name</th>");
            out.println("<th>Department</th>");
            out.println("<th>Phone</th>");
            out.println("<th>Salary</th>");
            out.println("</tr>");
            for(int i = 0;i<employees.size();i++){
                String table = "<tr><td>" + employees.get(i).getFull_name()+ "</td><td>" + employees.get(i).getDepartment()+ "</td><td>" + employees.get(i).getPhone() + "</td><td>" + employees.get(i).getSalary()   + "</td>";
                String delete = "<td>"+ "<button id=\"delete\" onclick=\"Delete(this); return false;\">Delete</button>" +  "</td>";
                String update = "<td>" + "<button id=\"update\" onclick=\"Update(this); return false;\">Update</button>" + "</td></tr>";
                out.println(table +  delete + update);
            }
        }
        else{
            out.println("<p>There are no users yet!</p>");
        }
    %>
</table>
<script>
    function Delete(r) {
        var i = r.parentNode.parentNode.rowIndex;
        document.getElementById("table").deleteRow(i);
        var request = new XMLHttpRequest();
        var url = encodeURI("http://localhost:8080/delete?i="+i);
        request.open("get", url, true);
        request.send();
    }
    function Update(r) {
        var i = r.parentNode.parentNode.rowIndex;
        var request = new XMLHttpRequest();
        var url = encodeURI("http://localhost:8080/update?i="+i);
        request.open("get", url, true);
        request.send();
    }
</script>
</body>
</html>