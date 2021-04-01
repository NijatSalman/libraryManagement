<%--
  Created by IntelliJ IDEA.
  User: Nijat
  Date: 3/31/2021
  Time: 8:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="static/css/users.css">
<script src="https://kit.fontawesome.com/eead799839.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<head>
    <title>User Book Reservation</title>
</head>
<body>
<div>
    <form action="/logout" method="GET">
        <button type="submit" class="btn btn-primary" value="submit">Log out</button>
    </form>
</div>
<div>
    <table class="table">
        <thead>
        <tr>
            <th>Name</th>
            <th>About</th>
            <th>Status</th>
            <th>date</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${bookReservObj}" var="value">
            <form:form action="/userDashboard/user/book/reserve/dismiss" method="POST" modelAttribute="bookReservationForum" >
            <tr>
                <td>${value.bookId.name}</td >
                <td>${value.bookId.about}</td>
                <td>${value.bookId.bookStatusId.name}</td>
                <td>${value.date}</td>
                <td>
                    <input type="hidden" name="id" value="${value.id}"/>
                <form:button class="btn btn-primary" type="submit" id="btnreject">Dismiss</form:button>
                </td>
            </tr >
            </form:form>
        </c:forEach>


        </tbody>
    </table>
</div>
</br>
<div>
    <form action="/userDashboard" method="GET">
        <button type="submit" class="btn btn-secondary" value="submit">Go back</button>
    </form>
</div>
</body>
</html>
