<%@ page import="com.dao.WorkerDao" %>
<%@ page import="com.db.DBConnect" %>
<%@ page import="com.entity.Worker" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Client Appointment Page</title>
    <jsp:include page="component/allcss.jsp" />
</head>
<body>
<jsp:include page="component/navbar.jsp" />
<div class="appointment">
    <div class="wrap">
        <h2>Запись на занятия</h2>
        <c:if test="${not empty errorMsg}">
            <p class="center text-danger fs-3">${errorMsg}</p>
            <c:remove var="errorMsg" scope="session" />
        </c:if>
        <c:if test="${not empty succMsg}">
            <p class="center text-success fs-3">${succMsg}</p>
            <c:remove var="succMsg" scope="session" />
        </c:if>
        <form action="addAppointment" method="post" class="row g-3">
            <input type="hidden" name="clientid" value="${clientObj.id}">
            <div class="col-md-6">
                <label for="fio" class="form-label">ФИО:</label>
                <input type="text" name="fullname" class="form-control" id="fio" required>
            </div>
            <div class="col-md-6">
                <label for="gender" class="form-label">Пол:</label>
                <select name="gender" class="form-control" id="gender" required>
                    <option value="male">Мужской</option>
                    <option value="female">Женский</option>
                </select>
            </div>
            <div class="col-md-6">
                <label for="age" class="form-label">Возраст:</label>
                <input type="number" name="age" class="form-control" id="age" required>
            </div>
            <div class="col-md-6">
                <label for="date" class="form-label">Дата занятия:</label>
                <input type="date" name="appoint_date" class="form-control" id="date" required>
            </div>
            <div class="col-md-6">
                <label for="email" class="form-label">Email:</label>
                <input type="email" name="email" class="form-control" id="email" required>
            </div>
            <div class="col-md-6">
                <label for="tel" class="form-label">Телефон:</label>
                <input type="text" name="number" class="form-control" id="tel" required>
            </div>
            <div class="col-md-6">
                <label for="like" class="form-label">Пожелания:</label>
                <input type="text" name="like" class="form-control" id="like" required>
            </div>
            <div class="col-md-6">
                <label for="section" class="form-label">Инструктор:</label>
                <select name="sect" class="form-control" id="section" required>
                    <option value="">--Выбор--</option>
                    <%
                        WorkerDao dao = new WorkerDao(DBConnect.getConn());
                        List<Worker> list = dao.getAllWorkers();
                        for (Worker wor : list) {
                            %>
                        <option value="<%= wor.getId()%>"><%= wor.getFullName()%> (<%= wor.getSection()%>)</option>
                    <%
                        }
                    %>
                </select>
            </div>
            <div class="col-md-12">
                <label for="address" class="form-label">Адрес:</label>
                <textarea name="address" class="form-control" id="address" required rows="3"></textarea>
            </div>
            <c:if test="${empty clientObj}">
                <a href="client_login.jsp" class="btn btn-dark">Авторизация</a>
            </c:if>
            <c:if test="${not empty clientObj}">
                <button class="btn button btn-dark">Записаться</button>
            </c:if>
        </form>
    </div>
</div>
</body>
</html>
