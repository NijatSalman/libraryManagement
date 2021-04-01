<%--
  Created by IntelliJ IDEA.
  User: Nijat
  Date: 3/29/2021
  Time: 12:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="https://kit.fontawesome.com/eead799839.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<script>
    function setIdForReserve(id){
        var elem = document.getElementById("idForReservedBook");
        elem.value = id;
    }
</script>
<link rel="stylesheet" href="/users.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<head>
    <title>Admin Dashboard</title>
</head>
<body>

<p>I am in Admin Dashboard</p>
<div>
    <form action="/logout" method="GET">
        <button type="submit" class="btn btn-primary" value="submit">Log out</button>
    </form>
</div>
<div class="container mycontainer">

    <div>
        <form:form action="/adminDashboard/bookSearch" method="GET" modelAttribute="book">
        <div class="form-group">

            <form:input
                    path="name"
                    placeholder="Search Book"
                    class="form-control"/>
            <form/>
        </div>
    <div class="container myButton">
        <div >
            <form:button class="btn btn-primary" type="submit" id="btnsearch">Search</form:button>

            </form:form>
        </div>
        <span class="spacing"></span>
        <div>
            <form action="/adminDashboard/booking/list" method="GET">
                <button type="submit" class="btn btn-secondary" value="submit">Booking lists</button>
            </form>
        </div>
        <span class="spacing"></span>
        <div>
            <form action="/adminDashboard/booking/details" method="GET">
                <button type="submit" class="btn btn-secondary" value="submit">Booking details</button>
            </form>
        </div>
    </div>

    </div>


    <div>
        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>About</th>
                <th>Status</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${bookObj}" var="value">
                <tr>
                    <td>${value.name}</td >
                    <td>${value.about}</td >
                    <td>${value.bookStatusId.name}</td>

<%--                    <td>--%>
<%--                        <c:choose>--%>
<%--                            <c:when test="${value.bookStatusId.id=='1'}">--%>
<%--                                &lt;%&ndash;                            <form action="userDetail" method="GET">&ndash;%&gt;--%>
<%--                                <input type="hidden" name="id" value="${value.id}">--%>
<%--                                <button class="btn btn-secondary" type="submit" value="update"--%>
<%--                                        data-toggle="modal" data-target="#exampleModal"--%>
<%--                                        onclick="setIdForReserve(${value.id})">--%>
<%--                                    Bronlamaq--%>
<%--                                </button>--%>
<%--                                &lt;%&ndash;                                <button class="btn btn-secondary" type="submit"  value="update">Bronlamaq</button>&ndash;%&gt;--%>
<%--                                &lt;%&ndash;                            </form>&ndash;%&gt;--%>
<%--                                <br />--%>
<%--                            </c:when>--%>
<%--                            <c:otherwise>--%>
<%--                                <button class="btn btn-secondary" type="submit" value="update" disabled>Bronlamaq</button>--%>
<%--                                <br />--%>
<%--                            </c:otherwise>--%>
<%--                        </c:choose>--%>

<%--                    </td>--%>
                </tr >
            </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Modal -->
<%--    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--        <div class="modal-dialog" role="document">--%>
<%--            <div class="modal-content">--%>
<%--                <div class="modal-header">--%>
<%--                    <h5 class="modal-title" id="exampleModalLabel">Xəbərdarlıq</h5>--%>
<%--                    <button type="button" class="close" data-dismiss="modal" aria-label="close">--%>
<%--                        <span aria-hidden="true">&times;</span>--%>
<%--                    </button>--%>
<%--                </div>--%>
<%--                <div class="modal-body">--%>
<%--                    Bu kitabı sifariş etmək istədiyinizə əminsiniz?--%>
<%--                </div>--%>
<%--                <div class="modal-footer">--%>
<%--                    <form action="user/reserve/book" method="POST">--%>
<%--                        <input type="hidden" name="id" value="" id="idForReservedBook"/>--%>
<%--                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Xeyr</button>--%>
<%--                        <input type="submit" class="btn btn-danger" value="Bəli">--%>
<%--                    </form>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
</div>
</body>
</html>
