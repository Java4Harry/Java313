<%@ page import="com.entity.Worker" %>
<%@ page import="com.dao.WorkerDao" %>
<%@ page import="com.db.DBConnect" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Worker Main Page</title>
    <jsp:include page="../component/allcss.jsp" />
</head>
<body>
<jsp:include page="navbar.jsp" />
<c:if test="${empty workerObj}">
    <c:redirect url="../coach_login.jsp"></c:redirect>
</c:if>
<section class="worker">
    <div class="wrap">
        <h2>Панель инструктора</h2>
        <%
            Worker w = (Worker) session.getAttribute("workerObj");
            WorkerDao dao = new WorkerDao(DBConnect.getConn());
        %>
        <div class="worker__block">
            <div class="worker__element">
                <h3>Инструктор</h3>
                <h4><%= dao.countWorkers()%></h4>
            </div>
            <div class="worker__element">
                <h3>Расписание</h3>
                <h4><%= dao.countAppointmentWorkerId(w.getId())%></h4>
            </div>
        </div>
    </div>
</section>
</body>
</html>
