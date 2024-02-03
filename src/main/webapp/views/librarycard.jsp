<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>library card list</title>
    <style>
        table,
        th,
        td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <h1>library card list</h1>
    <!-- <h1>Name = ${name}, age = ${age}</h1> -->
    <!-- Display categories here, inside a Table -->
    <!--for better UI, let's use Bootstrap-->
    <table>
        <tr>
            <th>CardID</th>
            <th>UserID</th>
            <th>Borrowed day</th>
            <th>Pay day</th>
          </tr>
          <c:forEach var="librarycard" items="${librarycard}">
              <tr>
                  <td>${librarycard.getCardID()}</td>
                  <td>${librarycard.getUserID()}</td>
                  <td>${librarycard.getBorrowedday()}</td>
                  <td>${librarycard.getPayday()}</td>
                  <td>
                    <a href="../../carddetail/getCarddetailByCardID/${librarycard.getCardID()}">
                      Show CardDetails
                    </a>
                </td>
              </tr>
          </c:forEach>
    </table>
    <a href="/librarycard/insertLibrarycard"> Insert Librarycard </a>
    <a href="../../library"> Return </a>
</body>
</html>
