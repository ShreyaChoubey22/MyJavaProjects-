<%@include file="info.jsp" %>
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
<hr>
<form>
<pre>
<a href="noticepost.jsp">Post-Notice</a>
<a href="">Remove-Notice</a>
<a href="">Update-Notice</a>
<a href="">View-Queries</a>
<a href="">Logout</a>
</pre>

</form>







<hr>


</body>
</html>