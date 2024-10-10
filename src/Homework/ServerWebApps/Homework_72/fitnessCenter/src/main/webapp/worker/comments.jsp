<%@ page import="com.dao.AppointmentDao" %>
<%@ page import="com.db.DBConnect" %>
<%@ page import="com.entity.Appointment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Comment Page</title>
    <jsp:include page="../component/allcss.jsp" />
</head>
<body>
<jsp:include page="navbar.jsp" />
<c:if test="${empty workerObj}">
    <c:redirect url="../coach_login.jsp"></c:redirect>
</c:if>
<div class="comment">
    <div class="wrap">
        <h2>Комментарий к занятию</h2>
        <%
            int id = Integer.parseInt(request.getParameter("id"));
            AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
            Appointment ap = dao.getAppointmentById(id);
        %>
        <form action="../updateStatus" method="post" class="row">
            <div class="col-md-6">
                <label for="name">ФИО клиента: </label>
                <input type="text" readonly class="form-control" id="name" value="<%= ap.getFullName()%>">
            </div>
            <div class="col-md-6">
                <label for="age">Возраст: </label>
                <input type="text" readonly class="form-control" id="age" value="<%= ap.getAge()%>">
            </div>
            <div class="col-md-6">
                <label for="phone">Телефон: </label>
                <input type="text" readonly class="form-control" id="phone" value="<%= ap.getPhone()%>">
            </div>
            <div class="col-md-6">
                <label for="like">Пожелания клиента: </label>
                <input type="text" readonly class="form-control" id="like" value="<%= ap.getLikes()%>">
            </div>
            <div class="col-md-12">
                <label for="comment">Комментарий: </label>
                <textarea name="comment" required class="form-control" id="comment"></textarea>
            </div>
            <input type="hidden" name="id" value="<%= ap.getId()%>">
            <input type="hidden" name="cid" value="<%= ap.getWorkerId()%>">
            <div>
                <button class="btn but">Отправить</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
