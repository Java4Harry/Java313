<%@ page import="com.dao.CoachDao" %>
<%@ page import="com.db.DBConnect" %>
<%@ page import="com.entity.Coach" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../component/allcss.jsp" />
</head>
<body>
<jsp:include page="../component/navbar.jsp" />
<c:if test="${empty workerObj}">
    <c:redirect url="../coach_login.jsp"></c:redirect>
</c:if>
<section class="wrap">
    <h2>Редактирование профиля</h2>
    <c:if test="${not empty errorMsg}">
        <p class="center text-danger fs-3">${errorMsg}</p>
        <c:remove var="errorMsg" scope="session" />
    </c:if>
    <c:if test="${not empty succMsg}">
        <p class="center text-success fs-3">${succMsg}</p>
        <c:remove var="succMsg" scope="session" />
    </c:if>
    <div class="row">
        <div class="col-md-4">
            <div class="card point-card">
                <div class="card-body">
                    <form action="../workerChangePassword" method="post">
                        <div>
                            <label for="old">Введите старый пароль:</label>
                            <input type="password" name="oldPassword" class="form-control" id="old" required>
                        </div>
                        <div>
                            <label for="new">Введите новый пароль:</label>
                            <input type="password" name="newPassword" class="form-control" id="new" required>
                        </div>
                        <input type="hidden" value="${workerObj.id}" name="wid">
                        <button class="btn button btn-dark">Изменить пароль</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-8">
            <div class="card point-card">
                <div class="card-body">
                    <form action="../workerUpdateProfile" method="post">
                        <div class="mb-3">
                            <label for="full">ФИО:</label>
                            <input type="text" required name="full_name" class="form-control" id="full" value="${workerObj.fullName}">
                        </div>
                        <div class="mb-3">
                            <label for="dob">Дата рождения:</label>
                            <input type="date" required name="dob" class="form-control" id="dob"  value="${workerObj.dob}">
                        </div>
                        <div class="mb-3">
                            <label for="quality">Квалификация:</label>
                            <input type="text" required name="qualification" class="form-control" id="quality"  value="${workerObj.qualification}">
                        </div>
                        <div class="mb-3">
                            <label for="special">Секция:</label>
                            <select name="spec" required class="form-control" id="special">
                                <option value="">${workerObj.section}</option>
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
                            <input type="email" required readonly name="email" class="form-control" id="email"  value="${workerObj.email}">
                        </div>
                        <div class="mb-3">
                            <label for="tel">Телефон:</label>
                            <input type="text" required name="mobphone" class="form-control" id="tel"  value="${workerObj.phone}">
                        </div>
                        <input type="hidden" name="id" value="${workerObj.id}">
                        <button class="btn btn-dark">Обновить</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
