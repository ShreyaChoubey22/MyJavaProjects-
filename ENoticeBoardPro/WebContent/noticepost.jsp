<%

String hodid=(String)session.getAttribute("id");
String dept=(String)session.getAttribute("dept");
if(hodid==null)
{
	response.sendRedirect("index.jsp");
}
%>
<html>

<body>
<h2>Welcome <%=hodid%> (<%=dept %>)</h2>
<h3>Notice-Post-Form</h3>
<form action="SaveNotice" method="post">
Title:<br> <input type="text" name="title"/><br><br><br>
Message<br> :<textarea name="msg" rows="10" cols="20"></textarea><br><br><br>
<input type="submit" value="PostNotice"/>
</form>
<hr>
<a href="faculty-home.jsp">Home</a>
</body>
</html>