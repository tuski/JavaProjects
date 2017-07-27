<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, com.tusar.*" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP tag demo</title>
</head>
<body>
 <% List<Student> students=new ArrayList<>();
 for(int i=0;i<10;i++){
	 students.add(new Student("First "+i,"Last "+i,10+i));
 }
 pageContext.setAttribute("studentList", students);
 %>
 
 <%-- 
 <c:forEach var="student" items="${studentList}">
   <c:out value="${student}"/><br/>
 </c:forEach> --%>
 
 <c:forEach var="s" items="${studentList}">
    <c:out value="${s}"></c:out>
 </c:forEach>
 
 
<c:out value=" ${2829903 } " />

<c:set  var="data" scope="session"  value="${20 }" ></c:set>

<c:out value="${data }"> <c:out value="${data}"></c:out>
</c:out>
<c:if test="${ data>100}" >
   <c:out value="${data}"/>
</c:if>

<c:if test="${not (data>100) }">
   <c:out value="${data}"/>
   </c:if>

<c:choose>
<c:when test="${data>100 }">
    <c:out value="${data}"/> 
</c:when>
<c:otherwise>

</c:otherwise>

</c:choose>

</body>
</html>