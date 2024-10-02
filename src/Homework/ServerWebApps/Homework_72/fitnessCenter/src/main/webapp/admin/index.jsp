<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Main Page</title>
    <jsp:include page="../component/allcss.jsp" />
</head>
<body>
<jsp:include page="navbar.jsp" />
<c:if test="${empty adminObj}">
    <c:redirect url="../admin_login.jsp"></c:redirect>
</c:if>
<c:if test="${not empty sucсMsg}">
    <p class="center text-success fs-3">${sucсMsg}</p>
    <c:remove var="sucсMsg" scope="session" />
</c:if>
<section class="admin">
    <div class="wrap">
        <h2>Панель администратора</h2>
        <div class="admin__block">
            <div class="admin__element">
                <img src="../component/images/picto_4.jpg" alt="">
                <h3>Инструкторы</h3>
                <p>7</p>
            </div>
            <div class="admin__element">
                <img src="../component/images/picto_2.jpg" alt="">
                <h3>Клиенты</h3>
                <p>37</p>
            </div>
            <div class="admin__element">
                <img src="../component/images/picto_3.jpg" alt="">
                <h3>Общее</h3>
                <p>10</p>
            </div>
            <div class="admin__element" data-bs-toggle="modal" data-bs-target="#exampleModal">
                <img src="../component/images/picto_1.jpg" alt="">
                <h3>Секция</h3>
                <p>10</p>
            </div>
        </div>
    </div>
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Добавление секции</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="../addCoach" method="post">
                        <div class="form-group">
                            <label for="coach">Введите название секции:</label>
                            <input type="text" name="coachname" class="form-control" id="coach">
                        </div>
                        <div class="text-center mt-3">
                            <button class="btn btn-dark">Добавить</button>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-dark" data-bs-dismiss="modal">Закрыть</button>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
