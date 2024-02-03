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
	<h2> Insert new LibraryCard</h2>
	<form:form method="POST"
		action="/librarycard/insertLibrarycard"
		modelAttribute="librarycard">
		<form:input type="date"
			placeholder="Enter librarycard's borrowedday" 
			value="${librarycard.getBorrowedday()}"
			path="borrowedday" />
		<br/>
		<form:errors path="borrowedday" cssClass="error"/> <br>
		<form:input type="date" 
			placeholder="Enter librarycard's payday" 
			value="${librarycard.getPayday()}"
			path="payday" />
		<br/>
		<form:errors path="payday" cssClass="error"/> <br>       
        <form:select path="userID">
            <c:forEach var="user" items="${user}">
                <form:option value="${user.getUserID()}">
                   ${user.getUserID()}
                </form:option>
            </c:forEach>                        
        </form:select>
        <p class="error">${error}</p>    
        <input type="submit" value="Insert" />
    </form:form>
</head>
<body>

</body>
</html>