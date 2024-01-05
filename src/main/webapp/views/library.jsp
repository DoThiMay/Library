<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Category list</title>
    <style>
        table,
        th,
        td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <h1>Book list</h1>
    <!-- <h1>Name = ${name}, age = ${age}</h1> -->
    <!-- Display categories here, inside a Table -->
    <!--for better UI, let's use Bootstrap-->
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Author</th>
            <th>Year</th>
            <th>Price</th>
            <th>Number</th>
          </tr>
          <c:forEach var="book" items="${book}">
              <tr>
                  <td>${book.getBookID()}</td>
                  <td>${book.getBookName()}</td>
                  <td>${book.getAuthor()}</td>
                  <td>${book.getYear()}</td>
                  <td>${book.getPrice()}</td>
                  <td>${book.getNumber()}</td>
              </tr>
          </c:forEach>
    </table>
</body>
</html>