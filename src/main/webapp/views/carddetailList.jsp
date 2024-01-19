<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Carddetail list by CardID</title>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h1>Carddetail list by CardID</h1>
	<table>
		<tr>
			<th>Book's ID</th>
			<th>Status</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="carddetail" items="${carddetail}">
			<tr>
				<td>${carddetail.getBookID()}</td>
				<td>${carddetail.getStatus()}</td>
				<td>
					<!-- <a
					href="../../carddetail/getUpdateStatus/${carddetail.getBookID()}">
						Change Status </a> --> <form:form method="POST"
						action="../../carddetail/getUpdateStatus/${carddetail.getBookID()}"
						modelAttribute="carddetail1">
						<form:input type="hidden" value="${carddetail.getCardID()}"
							placeholder="Enter carddetail's ID" path="cardID" />
						<input type="submit" value="Change Status">
					</form:form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="../../librarycard/getAllLibrarycard"> Return </a>
</body>
</html>