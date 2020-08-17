<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	 <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Smart Manager</title>
	 <link rel="stylesheet" href="./css/record.css">
	<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
</head>
<body>
	<nav>
	 <img src="./assets/logo.png" alt="logo" />
	        <h3> Smart Manager</h3>
	        <ul>
	        	<li> <a href="${pageContext.request.contextPath}/allrecords">Records</a></li>
	            <li> <a href="${pageContext.request.contextPath}/login">Login</a></li>
	            <li> <a href="${pageContext.request.contextPath}/signup">Signup</a></li>
	        </ul>
	</nav>
	
	 <c:if test="${records != null}">
     <form action="${pageContext.request.contextPath}/update" method="post">
     </c:if>
     <c:if test="${records == null}">
     <form action ="${pageContext.request.contextPath}/new" method="post">
     </c:if>
      
 	<c:if test="${records != null}">
  		<input type="hidden" name="recordId" value="<c:out value='${records.getStudentId()}'/>" />
   		</c:if>  
					<c:if test="${records != null}"> Edit Record </c:if>
					<c:if test="${records == null}"> Add New Record </c:if>
         
		<input id="title" name="title"  value="<c:out value='${records.getStudentName()}'/>" placeholder="Student Name" type="text" />
		<input id="msg" name="message" value="<c:out value='${records.getStudentBranch()}'/>" placeholder="Student Branch and Department Details" type="text"></input>  
		<input id="cgpa" name="cgpa" value="<c:out value='${records.getStudentCgpa()}'/>" placeholder="Student CGPA" type="text" />
		<button id="post" type="submit"> Add Record </button>
	</form>
	<%-- value="<c:out value='${records.getStudentName}'/>"
	value="<c:out value='${records.getStudentBranch}'/>"
	value="<c:out value='${records.getStudentCgpa}'/>" --%>
</body>
</html>