<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>

<title>Cherit</title>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<jsp:include page="/common/headStyles.jsp"/>

<style>
	a{
	text-decoration: none;
	}
	
	.button {
	  color: white;
	  padding: 10px 32px;
	  text-align: center;
	  text-decoration: none;
	  display: inline-block;
	  font-size: 16px;
	  margin: 4px 2px;
	  cursor: pointer;
	}
	.buttonBlack {
	  background-color: white;
	  color: black;
	  border: 2px solid #555555;
	}
	.pozitie-butoane{
	  display: flex;
	  justify-content:left;
	  margin-left:30px;
	}
</style>

</head>

<body>

<jsp:include page="/common/navbar.jsp"/>

<!-- Header -->
<header class="w3-display-container w3-content w3-wide" style="max-width:1600px;min-width:500px" id="home">
  <img class="w3-image" src="img/imgHome.jpg" alt="Restaurnant image" width="1600" height="800">
  <div class="w3-display-bottomleft w3-padding-large w3-opacity">
    <h1 class="w3-xxlarge" style="text-color: white">Cherit</h1>
  </div>
</header>

<!-- Page content -->
<div class="w3-content" style="max-width:1100px">

  <!-- About Section -->
  <div class="w3-row w3-padding-64" id="about">
    <div class="w3-col m6 w3-padding-large w3-hide-small">
     <img src="img/despreNoi.jpg" class="w3-round w3-image w3-opacity-min" alt="Table Setting" width="600" height="750">
    </div>

    <div class="w3-col m6 w3-padding-large">
      <h1 class="w3-center">Despre noi</h1><br>
      <h5 class="w3-center">Activam din 1998</h5>
      <p class="w3-large">The Cherit was founded in blabla by Mr. Dani in lorem ipsum dolor sit amet, consectetur adipiscing elit consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute iruredolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.We only use <span class="w3-tag w3-light-grey">seasonal</span> ingredients.</p>
      <p class="w3-large w3-text-grey w3-hide-medium">Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod temporincididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
    </div>
  </div>
  
  <hr>
  
  <!-- Menu Section -->
  <div class="w3-row w3-padding-64" id="menu">
  	<div class="w3-col l6 w3-padding-large">
  	
    	<h1 class="w3-center">Meniu</h1><br>
    	
    	<a class="pozitie-butoane" href="<c:url value="/afiseazaMeniu.htm?produsCulinar=1"/>">
    		<button class="button buttonBlack"><h5>Pizza</h5></button>
    	</a>
    	<p class="w3-text-grey">Ingrediente proaspete si naturale, selectate si pastrate cu grija</p>
    	<br>
    
    	
    	<a class="pozitie-butoane" href="<c:url value="/afiseazaMeniu.htm?produsCulinar=2"/>">
    		<button class="button buttonBlack"><h5>Paste</h5></button>
    	</a>
    	<p class="w3-text-grey">Ingrediente proaspete si naturale, selectate si pastrate cu grija</p>
    	<br>
    	
    	<a class="pozitie-butoane" href="<c:url value="/afiseazaMeniu.htm?produsCulinar=3"/>">
    		<button class="button buttonBlack"><h5>Kebab</h5></button>
    	</a>
    	<p class="w3-text-grey">Ingrediente proaspete si naturale, selectate si pastrate cu grija</p>
    	<br>
    	
    	<a class="pozitie-butoane" href="<c:url value="/afiseazaMeniu.htm?produsCulinar=4"/>">
    		<button class="button buttonBlack"><h5>Desert</h5></button>
    	</a>
    	<p class="w3-text-grey">Ingrediente proaspete si naturale, selectate si pastrate cu grija</p>
    
    </div>  
    
    <div class="w3-col l6 w3-padding-large">
      <img src="img/meniu.jpg" class="w3-round w3-image w3-opacity-min" alt="Menu" style="width:100%">
      
    </div>
  </div>

  <hr>

  <!-- Contact Section -->
  <div class="w3-container w3-padding-64" id="contact">
    <h1>Contact</h1><br>
    <h5>Pentru comenzi sau rezervari telefonice sunati la numarul: 0712345678.</h5>
    <p class="w3-text-blue-grey w3-large"><b>Adresa: Unit 2 The Meadows, Ballybrit, Galway, H91 EF24, Irlanda</b></p>
    <p class="w3-text-blue-grey w3-large"><b>Email: bethlahem.galway.com</b></p>
    <br>
    <h4>Puteti de asemenea sa rezervati o masa completand formularul:</h4> <br>    
    
    <a href="<c:url value="PregatireRezervare.htm"/>">
	  <button class="button buttonBlack"><h6>Rezerva o masa</h6></button>
	</a>
    
    <br> <br> <br>
    
    <h4>Verifica lista clienti (doar pentru admin):</h4> <br>   
    
    <a href="<c:url value="listaClienti.htm"/>">
	  <button class="button buttonBlack"><h6>Lista clienti</h6></button>
	</a>
	
	<br> <br> <br>
    
    <h4>Verifica lista rezervari (doar pentru admin):</h4> <br>   
    
    <a href="<c:url value="listaRezervari.htm"/>">
	  <button class="button buttonBlack"><h6>Lista rezervari</h6></button>
	</a>

  </div>
  
<!-- End page content -->
</div>

<!-- Footer -->
<jsp:include page="/common/footer.jsp"/>

</body>
</html>
    