<%@ page contentType="text/html; charset=UTF-8" language="java" %>


<html>
<head>
    <title>List of Employee</title>
</head>
<body>

<h3>Таблица</h3>

<br>
<table border="3">
    <c:forEach items="${col}" var="col">
        <tr>
            <td> ${col.id} </td>
            <td> ${col.titleArticle} </td>
            <td> ${col.createdArticle} </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>