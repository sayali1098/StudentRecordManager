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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">

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
	   
	   <div class="body-div1">
			  <a href="${pageContext.request.contextPath}/new"> 
			  <button class="button" id="addBlog" ><i class="fas fa-plus-circle"></i>Add New Record</button>
			  </a>  
       </div>
       
<div class="body-div2">
	<c:forEach var="records" items="${recordlist}">
		<div class="article-card">
			<img src="./assets/student96.png" alt="">
			<div class="card-text">
				<h1 id="blog-title"><c:out value="${records.getStudentName()}"  /></h1>
				<p id="blog-description"><c:out value="${records.getStudentBranch()}" /></p>
				<p id="blog-description"><c:out value="${records.getStudentCgpa()}" /></p>
				<p>Date of Birth <b><c:out value="${records.getDateOfBirth()}" /></b> </p>
				</div>
				<div class="card-buttons">
				<a href="edit?id=<c:out value='${records.getStudentId()}' />"><button type="button" id="edit">EDIT</button></a> <span>|</span><a href="delete?id=<c:out value='${records.getStudentId()}'/>"><button id="delete">DELETE</button></a>
			</div>
		</div>
	</c:forEach> 
</div>
       
</body>
</html>