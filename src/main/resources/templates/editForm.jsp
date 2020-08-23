<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Form</title>
</head>
<body>

<form:form method="POST" action="/editStudentEntry" 
  modelAttribute="student">
    <form:label path="name">Name</form:label>
    <form:input path="name" value='${student.name}' />
    
    <form:label path="email">Email</form:label>
    <form:input path="email" value='${student.email}'  />
    
    <input type="submit" value="Submit" />
</form:form>

</body>
</html>