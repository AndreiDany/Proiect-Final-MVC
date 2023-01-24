<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri= "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

<title>Clienti</title>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<jsp:include page="/common/headStyles.jsp"/>

<style>

	.button {
	  background-color: white;
	  border: 2px solid #555555;
	  color: black;
	  padding: 15px 32px;
	  text-align: center;
	  text-decoration: none;
	  display: inline-block;
	  font-size: 16px;
	  margin: 4px 2px;
	  cursor: pointer;
	}
	 .mini-button {
	  padding: 2px 3px;
	  font-size: 3px;
	  margin: 2px 1px;	  
	}
</style>

</head>
<body>

<jsp:include page="/common/navbar.jsp"/>

<!-- Page content -->
<div class="w3-content" style="max-width:1100px">

<!-- Clienti Section -->
  <div class="w3-row w3-padding-64" id="menu">
  	<div class="w3-col l6 w3-padding-large">
  	
    	<h1 class="w3-center">Clienti</h1><br>
    	
    	<c:forEach var="c" items="${model.clienti}" >

		<h4> <c:out value="${c.nume}"/> <c:out value=" ${c.prenume}"/> </h4>
		
		<p class="w3-text-grey"> 
			<c:out value="numar de telefon: ${c.numarDeTelefon}"/>
		<p class="w3-text-grey"> 
			<c:out value="email: ${c.email}"/> <br>
			
			<a href="<c:url value="pregatireModificareClient.htm?id=${c.id}"/>">
		    <button class="button mini-button"><h6>Modificare</h6></button>
		    </a>
		    <a href="<c:url value="stergereClient.htm?id=${c.id}"/>">
		    <button class="button mini-button"><h6>Stergere</h6></button>
		    </a>
		</p>
		
		<br>

	  </c:forEach>
	  
 
    </div>
  </div>

</div>

<!-- Footer -->
<jsp:include page="/common/footer.jsp"/>

</body>
</html>