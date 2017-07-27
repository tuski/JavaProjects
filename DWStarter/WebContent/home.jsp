<%@ page import="java.util.Date" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My webpage using jsp</title>
</head>
<body>
Hellow tuski!
<p> 
My name is <%= " ... You are ...." %>

</p>
<%
for(int i=0;i<10;i++)
	{out.println("The value of i is: "+i);
	
   out.println("<br/>");
	}
%>
<%! 
public String returnName(){
return "tuski123";	
}

%>

<%= returnName() %>
	<form id="form-1">
	</form>

</body>
</html>