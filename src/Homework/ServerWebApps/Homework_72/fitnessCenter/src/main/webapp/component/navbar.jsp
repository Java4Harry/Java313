<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<div class="main">
    <div class="wrap">
        <ul class="menu">
            <li class="logo"><a href="index.jsp">Главная</a></li>
            <c:if test="${empty clientObj}">
            <li><a href="admin_login.jsp">Администратор</a></li>
            <li><a href="coach_login.jsp">Инструктор</a></li>
            <li><a href="#">Занятия</a></li>
            <li><a href="client_login.jsp">Клиент</a></li>
            </c:if>
            <c:if test="${not empty clientObj}">
                <li><a href="#">Расписание</a></li>
                <li><a href="#">График моих тренировок</a></li>
                <li>
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                            ${clientObj.name}
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">Изменить пароль</a></li>
                            <li><a class="dropdown-item" href="../clientLogout">Выход</a></li>
                        </ul>
                    </div>
                </li>
            </c:if>
        </ul>
    </div>
</div>

