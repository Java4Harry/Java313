<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Task</title>
    <style>
        div{
            text-align: center;
            padding: 50px 0;
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
<div>
    <h1>Новая задача</h1>
    <form action="save" method="post">
        <table>
            <tr>
                <td>Наименование</td>
                <td><input type="text" name="task"></td>
                <td><button>Создать</button></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
