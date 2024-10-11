<%@ page import="com.dao.CoachDao" %>
<%@ page import="com.db.DBConnect" %>
<%@ page import="java.util.List" %>
<%@ page import="com.entity.Coach" %>
<%@ page import="com.dao.WorkerDao" %>
<%@ page import="com.entity.Worker" %>
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
        <div class="offcanvas offcanvas-start show" data-bs-backdrop="static" tabindex="-1" id="staticBackdrop" aria-labelledby="staticBackdropLabel">
            <div class="offcanvas-header">
                <h3 class="offcanvas-title" id="staticBackdropLabel">Данные инструктора</h3>
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div class="offcanvas-body">
                <div>
                    <c:if test="${not empty sucсMsg}">
                        <p class="center text-success fs-3">${sucсMsg}</p>
                        <c:remove var="sucсMsg" scope="session" />
                    </c:if>
                    <c:if test="${not empty errorMsg}">
                        <p class="center text-danger fs-3">${errorMsg}</p>
                        <c:remove var="errorMsg" scope="session" />
                    </c:if>
                    <%
                        int id = Integer.parseInt(request.getParameter("id"));
                        WorkerDao daoEdit = new WorkerDao(DBConnect.getConn());
                        Worker worker = daoEdit.getWorkersById(id);
                    %>
                    <form action="../updateWorker" method="post">
                        <div class="mb-3">
                            <label for="full">ФИО:</label>
                            <input type="text" required name="full_name" class="form-control" id="full" value="<%= worker.getFullName()%>">
                        </div>
                        <div class="mb-3">
                            <label for="dob">Дата рождения:</label>
                            <input type="date" required name="dob" class="form-control" id="dob" value="<%= worker.getDob()%>">
                        </div>
                        <div class="mb-3">
                            <label for="quality">Квалификация:</label>
                            <input type="text" required name="qualification" class="form-control" id="quality" value="<%= worker.getQualification()%>">
                        </div>
                        <div class="mb-3">
                            <label for="special">Секция:</label>
                            <select name="spec" required class="form-control" id="special">
                                <option><%= worker.getSection()%></option>
                                <%
                                    CoachDao dao = new CoachDao(DBConnect.getConn());
                                    List<Coach> list = dao.getAllCoach();
                                    for (Coach c : list) { %>
                                <option value="<%= c.getCoachName()%>"><%= c.getCoachName()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="email">Email:</label>
                            <input type="email" required name="email" class="form-control" id="email" value="<%= worker.getEmail()%>">
                        </div>
                        <div class="mb-3">
                            <label for="tel">Телефон:</label>
                            <input type="text" required name="mobphone" class="form-control" id="tel" value="<%= worker.getPhone()%>">
                        </div>
                        <div class="mb-3">
                            <label for="psw">Пароль:</label>
                            <input type="password" required name="password" class="form-control" id="psw" value="<%= worker.getPassword()%>">
                        </div>
                        <input type="hidden" name="id" value="<%= worker.getId()%>">
                        <button class="btn btn-dark">Обновить</button>
                    </form>
                </div>
            </div>
        </div>
        <br>
        <h2>Данные инструктора</h2>
        <table class="table">
            <tr>
                <th scope="col">Имя</th>
                <th scope="col">Дата рождения</th>
                <th scope="col">Квалификация</th>
                <th scope="col">Секция</th>
                <th scope="col">Email</th>
                <th scope="col">Телефон</th>
                <th scope="col">Действие</th>
            </tr>
            <%
                WorkerDao dao2 = new WorkerDao(DBConnect.getConn());
                List<Worker> list2 = dao2.getAllWorkers();
                for (Worker w : list2) {
            %>
            <tr>
                <td><%= w.getFullName()%></td>
                <td><%= w.getDob()%></td>
                <td><%= w.getQualification()%></td>
                <td><%= w.getSection()%></td>
                <td><%= w.getEmail()%></td>
                <td><%= w.getPhone()%></td>
                <td>
                    <a href="edit_worker.jsp?id=<%= w.getId()%>" class="btn btn-sm btn-dark">Изменить</a>
                    <a href="../deleteWorker?id=<%= w.getId()%>" class="btn btn-sm btn-danger">Удалить</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </div>
</section>
</body>
</html>
