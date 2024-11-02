<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Task</title>
    <style>
        div{
            text-align: center;
            padding: 50px 0;
            text-align: center;
        }
        h1{
            text-align: center;
        }
        table{
            background: bisque;
            width: 800px;
            margin: 50px auto;
        }
    </style>
</head>
<body>
<h1>Корректировка задачи</h1>
<form action="updateTask" method="post">
    <input type="hidden" name="id" value="${editTask.id}">
    <table>
        <tr>
            <td>Наименование</td>
            <td><input type="text" name="task" value="${editTask.task}"></td>
            <td><button>Обновить</button></td>
        </tr>
    </table>
</form>
</body>
</html>
