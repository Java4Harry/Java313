<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Result Page</title>
    <link rel="stylesheet" href="../../component/style.css">
</head>
<body>
<h2>Ваш поисковый запрос</h2>
<hr>
<ul>
    <li>Сезонность резины: ${tire.check}</li>
    <li>Радиус: ${tire.radius}</li>
    <li>Ширина: ${tire.width}</li>
    <li>Профиль: ${tire.height}</li>
</ul>
<hr>
</body>
</html>
