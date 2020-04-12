<%@include file="info.jsp" %>

<%
String v1="",v2="",v3="";

//step 1 fetch all cookies
Cookie ck[]=request.getCookies();
//step search desired one
if(ck!=null)
{
for(Cookie c:ck)
{
	
    String s=c.getName();
    if(s.equals("admin-id"))
    {
    	v1=c.getValue();
    }
    else if(s.equals("admin-pwd"))
    {
    	v2=c.getValue();
    }
    else if(s.equals("hod-id"))
    {
    	v1=c.getValue();
    }
    else if(s.equals("hod-pwd"))
    {
    	v2=c.getValue();
    }
    else if(s.equals("stud-id"))
    {
    	v1=c.getValue();
    }
    else if(s.equals("stud-pwd"))
    {
    	v2=c.getValue();
    }
    else if(s.equals("hod-utype"))
    {
    	v3=c.getValue();
    }
    else if(s.equals("admin-utype"))
    {
    	v3=c.getValue();
    }
    else if(s.equals("student-utype"))
    {
    	v3=c.getValue();
    }
   
    
}
}

%>

<html>
<body>
<h1>Digital Notice Board</h1>
<h2>Login Page</h2>
<hr>
<form action="VerifyUser" method="post">
<pre>
Userid: <input type="text" name="uid" value="<%=v1%>"/>
Password: <input type="password" name="pwd" value="<%=v2%>"/> 
UserType: <select name="utype" value="<%=v3%>"><br>
<option>admin</option>
<option>HOD</option>
<option>student</option>
</select>
SavePassword         <input type="checkbox" name="savepwd"/><br><br>
                     <input type="submit" value="login"/><br>
</pre>
</form>
<hr>
<a href="StudentRegistrationForm.jsp">New-Student-Registration</a>


</body>
</html>