<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
	.error {
		color: red;
	}
</style>
</head>
<body>
	<h2> Insert new User</h2>
	<form:form method="POST"
		action="/users/insertUser"
		modelAttribute="user">
		<form:input type="text"
			placeholder="Enter user's name" 
			value="${user.getUserName()}"
			path="userName" />
		<br/>
		<form:errors path="userName" cssClass="error"/> <br>
		
		<form:input type="text"
			placeholder="Enter user's phone" 
			value="${user.getPhone()}"
			path="phone" />
		<br/>
		<form:errors path="phone" cssClass="error"/> <br>
		
		<form:input type="text"
			placeholder="Enter user's address" 
			value="${user.getAddress()}"
			path="address" />
		<br/>
		<form:errors path="address" cssClass="error"/> <br>
		
		<form:input type="text"
			placeholder="Enter user's gender" 
			value="${user.getGender()}"
			path="gender" />
		<br/>
		<form:errors path="gender" cssClass="error"/> <br>
		  <p class="error">${error}</p>  
		 <input type="submit" value="Insert" />
    </form:form>
		