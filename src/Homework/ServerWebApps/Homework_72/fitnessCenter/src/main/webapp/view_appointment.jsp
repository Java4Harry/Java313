<%@ page import="com.entity.Client" %>
<%@ page import="com.dao.AppointmentDao" %>
<%@ page import="com.db.DBConnect" %>
<%@ page import="com.dao.WorkerDao" %>
<%@ page import="com.entity.Appointment" %>
<%@ page import="java.util.List" %>
<%@ page import="com.entity.Worker" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Appointment Page</title>
    <jsp:include page="component/allcss.jsp" />
</head>
<body>
<jsp:include page="component/navbar.jsp" />
<div class="appointment">
    <div class="wrap">
        <h2>Мои тренировки</h2>
        <table class="table">
            <tr>
                <th scope="col">ФИО:</th>
                <th scope="col">Пол:</th>
                <th scope="col">Возраст:</th>
                <th scope="col">Дата тренировки:</th>
                <th scope="col">Пожелания:</th>
                <th scope="col">Инструктор:</th>
                <th scope="col">Статус:</th>
            </tr>
            <%
                Client client = (Client) session.getAttribute("clientObj");
                AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
                WorkerDao dao2 = new WorkerDao(DBConnect.getConn());
                List<Appointment> list = dao.getAllAppointmentsByLoginClientId(client.getId());
                for (Appointment appointment : list) {
                    Worker w = dao2.getWorkersById(appointment.getWorkerId());
                %>
            <tr>
                <td><%= appointment.getFullName()%></td>
                <td><%= appointment.getGender()%></td>
                <td><%= appointment.getAge()%></td>
                <td><%= appointment.getAppointDate()%></td>
                <td><%= appointment.getLikes()%></td>
                <td><%= w.getFullName()%></td>
                <td>
                <%
                    if ("В обработке".equals(appointment.getStatus())) {
                        %>
                    <a href="#" class="btn btn-success">В обработке</a>
                    <%
                    } else {
                        %>
                            <%= appointment.getStatus()%>
                    <%
                    }
                %>
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
