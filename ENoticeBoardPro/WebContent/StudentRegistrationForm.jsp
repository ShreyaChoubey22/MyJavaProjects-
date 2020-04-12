
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<body>
<h3>Student-Registration-Form</h3>
<form action="StudentAccountCreation" method="post">
<pre>
UserId:     <input type="text" name="userid"/> 
Password:   <input type="password" name="pwd"/> 
Name:       <input type="text" name="name"/>
Department: <select name="branch">
            <option>CS</option>
            <option>IT</option>
            <option>Electical</option>
            <option>E&TC</option>
            
            </select>
Semester:   <select name="sem">
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
            <option>7</option>
            <option>8</option>
            
            </select>         
            <input type="submit" value="Create-Account"/> 
<a href="admin-home.jsp">Home</a>        
</pre>
</form>

</body>
</html>