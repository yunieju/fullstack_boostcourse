<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Add New Todo Task</title>
<style> 
	@import url("css/newtodo.css");
</style>
</head>
<body>
	<h1 class = 'title'>Add new Todo task</h1>
	<div class='form_container'>
	<form id = 'answer' action = ${pageContext.request.contextPath}/addnew method ='post' >
	  <section class = 'question'>
	  <label for = 'title'> What is this task? <br></label>
	  <input type="text" name = 'new_title' placeholder='Ex. Full stack Study'> 
	  </section>
	  
	  <section class = 'quesiton'>
	  <label for ='name'> Who should complete this? <br></label>
	  <input type="text" name = 'new_name' placeholder='Example: Bob'>
	  </section>
	  <section class = 'question'>
	  <span class= 'question'> Select priority </span>
	  <ul class="sequence_list">
					<li>
						<label for="sequence_1"> 
							<input type="radio" id="sequence_1" name="new_sequence" value="1" required/>1
						</label>
					</li>
					<li>
						<label for="sequence_2">
							<input type="radio" id="sequence_2" name="new_sequence" value="2"/>2
						</label>
					</li>
					<li>
						<label for="sequence_3">
							<input type="radio" id="sequence_3" name="new_sequence" value="3"/>3
						</label>
					</li>
				</ul>
	  </section>
	  
	  <section class='button_container'>
	  <button type = "button" onclick="location.href='main'" id = "goback"> Go back </button>
	  <input type = "submit" value="Submit" class = "buttons">
	  <input type = "reset" value = "Reset" class = "buttons">
	  </section>
	  
	 </form>
	 </div>
	 
	
</body>
  
  
</html>