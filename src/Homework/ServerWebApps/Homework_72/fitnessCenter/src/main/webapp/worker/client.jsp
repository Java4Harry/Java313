<%@ page import="com.entity.Worker" %>
<%@ page import="com.dao.AppointmentDao" %>
<%@ page import="com.db.DBConnect" %>
<%@ page import="com.entity.Appointment" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Coach View Schedule</title>
    <jsp:include page="../component/allcss.jsp" />
</head>
<body>
<jsp:include page="navbar.jsp" />
<c:if test="${empty workerObj}">
    <c:redirect url="../coach_login.jsp"></c:redirect>
</c:if>
<c:if test="${not empty sucMsg}">
    <p class="center text-success fs-3">${sucMsg}</p>
    <c:remove var="sucMsg" scope="session" />
</c:if>
<c:if test="${not empty errorMsg}">
    <p class="center text-danger fs-3">${errorMsg}</p>
    <c:remove var="errorMsg" scope="session" />
</c:if>
<div class="coach">
    <div class="wrap">
        <h2>График занятий</h2>
        <table class="table">
            <tr>
                <th scope="col">ФИО:</th>
                <th scope="col">Пол:</th>
                <th scope="col">Возраст:</th>
                <th scope="col">Дата тренировки:</th>
                <th scope="col">Email:</th>
                <th scope="col">Телефон:</th>
                <th scope="col">Пожелания:</th>
                <th scope="col">Статус:</th>
                <th scope="col">Действие:</th>
            </tr>
            <%
                Worker worker = (Worker) session.getAttribute("workerObj");
                AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
                List<Appointment> list = dao.getAllAppointmentsByWorkerLogin(worker.getId());
                for (Appointment app : list) {
                    %>
            <tr>
                <td><%= app.getFullName()%></td>
                <td><%= app.getGender()%></td>
                <td><%= app.getAge()%></td>
                <td><%= app.getAppointDate()%></td>
                <td><%= app.getEmail()%></td>
                <td><%= app.getPhone()%></td>
                <td><%= app.getLikes()%></td>
                <td><%= app.getStatus()%></td>
                <td>
                    <a href="comment.jsp?id=<%= app.getId()%>" class="btn btn-sm btn-dark">Комментарий</a>
                </td>
            </tr>
            <%
                }

            %>
        </table>
    </div>
</div>
</body>
</html>
