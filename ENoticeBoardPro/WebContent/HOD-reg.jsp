<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<body>
<h3>Staff-Account-Creation</h3>
<form action="FacultyAccountCreation" method="post">
<pre>
UserId:     <input type="text" name="userid"/> 
Password:   <input type="password" name="pwd"/> 
Name:       <input type="text" name="name"/>
Department: <select name="dept">
            <option>Exam</option>
            <option>Sports</option>
            <option>Cultural</option>
            <option>Administration</option>
            
            </select>
            <input type="submit" value="Create-Account"/> 
<a href="admin-home.jsp">Home</a>        
</pre>
</form>

</body>
</html>