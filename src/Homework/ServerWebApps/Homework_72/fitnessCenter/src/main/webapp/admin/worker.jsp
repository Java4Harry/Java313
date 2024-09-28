<%@ page import="com.dao.CoachDao" %>
<%@ page import="com.db.DBConnect" %>
<%@ page import="java.util.List" %>
<%@ page import="com.entity.Coach" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Admin Page - Worker</title>
    <jsp:include page="../component/allcss.jsp" />
</head>
<body>
<jsp:include page="navbar.jsp" />
<section class="worker">
    <div class="wrap">
        <h2>Добавить сотрудника</h2>
        <c:if test="${not empty sucсMsg}">
            <p class="center text-success fs-3">${sucсMsg}</p>
            <c:remove var="sucсMsg" scope="session" />
        </c:if>
        <c:if test="${not empty errorMsg}">
            <p class="center text-danger fs-3">${errorMsg}</p>
            <c:remove var="errorMsg" scope="session" />
        </c:if>
        <form action="../addWorker" method="post">
            <div class="mb-3">
                <label for="full">ФИО:</label>
                <input type="text" required name="full_name" class="form-control" id="full">
            </div>
            <div class="mb-3">
                <label for="dob">Дата рождения:</label>
                <input type="date" required name="dob" class="form-control" id="dob">
            </div>
            <div class="mb-3">
                <label for="quality">Квалификация:</label>
                <input type="text" required name="qualification" class="form-control" id="quality">
            </div>
            <div class="mb-3">
                <label for="special">Секция:</label>
                <select name="spec" required class="form-control" id="special">
                    <option value="">-- Выбор секции</option>
                    <%
                        CoachDao dao = new CoachDao(DBConnect.getConn());
                        List<Coach> list = dao.getAllCoach();
                        for (Coach c : list) { %>
                    <option value=""><%= c.getCoachName()%></option>
                    <%
                        }
                    %>
                </select>
            </div>
            <div class="mb-3">
                <label for="email">Email:</label>
                <input type="email" required name="email" class="form-control" id="email">
            </div>
            <div class="mb-3">
                <label for="tel">Телефон:</label>
                <input type="text" required name="mobphone" class="form-control" id="tel">
            </div>
            <div class="mb-3">
                <label for="psw">Пароль:</label>
                <input type="password" required name="password" class="form-control" id="psw">
            </div>
            <button class="btn btn-dark">Отправить</button>
        </form>
    </div>
</section>
</body>
</html>
