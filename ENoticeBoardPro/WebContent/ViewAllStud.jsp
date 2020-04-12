
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.ssi1.getConnection"%>
<%

java.sql.Connection conn=getConnection.connect();
String qr="select * from student";
PreparedStatement ps=conn.prepareStatement(qr);
ResultSet rs=ps.executeQuery();

%>
<%!
String convert(int n)
{
	String res=null;
	switch(n)
	{
	case 1:
		res= "one";
		break;
	case 2:
		res= "two";
		break;
	case 3:
		res= "three";
		break;	
	case 4:
		res= "four";
		break;
	case 5:
		res="five";
		break;	
	case 6:
		res= "six";
		break;
	case 7:
		res= "seven";
		break;	
	case 8:
		res= "eight";
		break;
			}
	return res;
}
%>
<html>
<body>
<h2>Students-List</h2>
<table border=2>
<tr>
<th>Id</th>
<th>Password</th>
<th>Name</th>
<th>branch</th>
<th>Sem</th>
<th>Status</th>
</tr>
<%
while(rs.next())
{
	String s1=rs.getString(1);
	String s2=rs.getString(2);
	String s3=rs.getString(3);
	String s4=rs.getString(4);
	String s5=rs.getString(5);
	String s6=rs.getString(6);
	
%>
<tr>
<td><%=s1%></td>
<td><%=s2%></td>
<td><%=s3%></td>
<td><%=s4%></td>
<td><%=convert(Integer.parseInt(s5))%></td>
<td><%=s6%></td>
</tr>
<%

} 
conn.close();%>
</table>

</body>
</html>