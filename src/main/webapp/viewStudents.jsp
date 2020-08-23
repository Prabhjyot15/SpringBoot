<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Students</title>
</head>
<body>
View All Students
<table style="align:center;">
       <th>Name</th>
       <th>Edit</th>
       <th>Delete</th>
       <c:forEach items="${students}" var="student">
         <tr>
            <td><c:out value="${student.name}"/></td>
			<td><a href="/editStudent/${student.id}">Edit</a></td>
			<td><a href="/deleteStudent/${student.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>