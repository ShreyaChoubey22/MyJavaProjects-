<%@include file="info.jsp" %>
<%

String studid=(String)session.getAttribute("stud-id");
String branch=(String)session.getAttribute("branch");
if(studid==null)
{
	response.sendRedirect("index.jsp");
}
%>
<html>

<body>

<h2>Welcome <%=studid%> (<%=branch %>)</h2>
<hr>
<form method="get">
<pre>
<a href="showdept">View-Notices</a>
<a href="">Change-Profile</a>
<a href="">Logout</a>

</pre>
</form>
<hr>
<%@include file="scroll.jsp" %>

</body>
</html>