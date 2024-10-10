<%@ page import="com.dao.AppointmentDao" %>
<%@ page import="com.db.DBConnect" %>
<%@ page import="com.dao.WorkerDao" %>
<%@ page import="com.entity.Appointment" %>
<%@ page import="java.util.List" %>
<%@ page import="com.entity.Worker" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Coach View Schedule</title>
    <jsp:include page="../component/allcss.jsp" />
</head>
<body>
<jsp:include page="navbar.jsp" />
<div class="client">
    <div class="wrap">
        <h2>Данные клиента</h2>
        <table class="table">
            <tr>
                <th scope="col">ФИО:</th>
                <th scope="col">Пол:</th>
                <th scope="col">Возраст:</th>
                <th scope="col">Дата тренировки:</th>
                <th scope="col">Email:</th>
                <th scope="col">Телефон:</th>
                <th scope="col">Пожелания:</th>
                <th scope="col">Инструктор:</th>
                <th scope="col">Адрес:</th>
                <th scope="col">Статус:</th>
            </tr>
            <%
                AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
                WorkerDao dao2 = new WorkerDao(DBConnect.getConn());
                List<Appointment> list = dao.getAllAppointments();
                for (Appointment appointment : list) {
                    Worker w = dao2.getWorkersById(appointment.getWorkerId());
                    %>
            <tr>
                <td><%= appointment.getFullName()%></td>
                <td><%= appointment.getGender()%></td>
                <td><%= appointment.getAge()%></td>
                <td><%= appointment.getAppointDate()%></td>
                <td><%= appointment.getEmail()%></td>
                <td><%= appointment.getPhone()%></td>
                <td><%= appointment.getLikes()%></td>
                <td><%= w.getFullName()%></td>
                <td><%= appointment.getAddress()%></td>
                <td><%= appointment.getStatus()%></td>
            </tr>
            <%
                }
            %>
        </table>
    </div>
</div>
</body>
</html>