<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User list</title>
    <style>
        table,
        th,
        td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <h1>User list</h1>
    <!-- <h1>Name = ${name}, age = ${age}</h1> -->
    <!-- Display categories here, inside a Table -->
    <!--for better UI, let's use Bootstrap-->
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Gender</th> 
          </tr>
          <c:forEach var="user" items="${user}">
              <tr>
                  <td>${user.getUserID()}</td>
                  <td>${user.getUserName()}</td>
                  <td>${user.getPhone()}</td>
                  <td>${user.getAddress()}</td>
                  <td>${user.getGender()}</td>
              </tr>
          </c:forEach>
    </table>
</body>
</html>