<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Home Page</title>
    <style>
        div{
            text-align: center;
        }
        table{
            border-collapse: collapse;
            background: bisque;
            width: 600px;
            margin: 50px auto;
        }

        tr{
            padding: 30px 0;
            border-top: 2px solid gray;
            border-bottom: 2px solid gray;
        }
        .action{
            width: 200px;
            display: flex;
            justify-content: space-between;
        }
        .green{
            padding: 10px;
            border-radius: 10px 10px;
            border: 1px solid #05d305;
            background: #05d305;
        }
        .green:hover{
            border: 1px solid #a1b7a1;
            background: #a1b7a1;
        }
        .green a{
            text-decoration: none;
        }
        .buttonContainer{
            margin: 0 auto;
            width: 200px;
        }
        h4{
            color: green;
        }
    </style>
</head>
<body>
<div>
    <h1>Список задач</h1>
    <c:if test="${not empty msg}">
        <h4>${msg}</h4>
        <c:remove var="msg" />
    </c:if>
    <div class="buttonContainer">
        <div class="green">
            <a href="/new">Установить новую задачу</a>
        </div>
    </div>
    <table>
        <tr>
            <th>Номер</th>
            <th>Наименование задачи</th>
            <th>Действие</th>
        </tr>
        <c:forEach items="${taskList}" var="tasks">
            <tr>
                <td>${tasks.id}</td>
                <td>${tasks.task}</td>
                <td class="action">
                    <a href="edit/${tasks.id}">Редактирование</a>
                    <a href="delete/${tasks.id}">Удаление</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
