<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Students here</title>
</head>
<body>
<form:form method="POST" action="/addStudent" 
  modelAttribute="student">
    <form:label path="name">Name</form:label>
    <form:input path="name" />
    
    <form:label path="email">Email</form:label>
    <form:input path="email" />
    
    <input type="submit" value="Submit" />
</form:form>
</body>
</html>