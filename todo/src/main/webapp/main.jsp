<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.connect.todo.dto.Todo"%>
<%@page import="java.util.List"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:set var="todoList" value='<%=request.getAttribute("TODO")%>' />
<c:set var="doingList" value='<%=request.getAttribute("DOING")%>' />
<c:set var="doneList" value='<%=request.getAttribute("DONE")%>' />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To Do List</title>
<style> 
	@import url("css/main.css");
</style>
</head>
<body>
  	<button onclick = "location.href='new'" id = 'addbutton'>Add New</button>
<div class="row">
  	<div class="column" id = "left">
  	  <h1 class = "title">TO DO </h1>
	    <div class ="todo">
	      <c:forEach var="item" items = "${todoList}">
	      	<li class = "card" data-id = "${item.id}" data-type = "${item.type}">
	      		<h3 class = "card_title">${item.title }</h3>
	      		<span class = "card_text">Registered Date: ${item.regDate }, ${item.name }, ${item.sequence }</span>
	      		<button class = "move_button">-></button> 
	      	</li>
	      </c:forEach>
	    </div>
	  </div>
  
	  <div class="column" id="mid">
	  	<h1 class = "title">DOING</h1>
	  	<c:forEach var="item" items = "${doingList}">
	      	<li class = "card"  data-id = "${item.id}" data-type = "${item.type}">
	      		<h3 class = "card_title">${item.title }</h3>
	      		<span class = "card_text">Registered Date: ${item.regDate }, ${item.name }, ${item.sequence }</span>
	      	</li>
	      </c:forEach>
	  
	  </div>
	  
	  <div class="column" id = "right">
	 	 <h1 class = 'title'> DONE </h1>  
	 	 <c:forEach var="item" items = "${doneList}">
	      	<li class = "card"  data-id = "${item.id}" data-type = "${item.type}">
	      		<h3 class = "card_title">${item.title }</h3>
	      		<span class = "card_text">Registered Date: ${item.regDate }, ${item.name }, ${item.sequence }</span>
	      	</li>
	      </c:forEach>
	  </div>
  </div>
<script src = 'js/main.js'></script>
</body>

</html>