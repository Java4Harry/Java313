<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Tire Choose</title>
    <link rel="stylesheet" href="../../component/style.css">
</head>
<body>
<h1>Выбор резины</h1>
<div class="wrap">
<form action="tireChoose" method="post">
        <p>
            <label for="check">Сезонность: </label>
                <input type="checkbox" id="check" name="check" value="зимние">Зимние
                <input type="checkbox" name="check" id="check" value="летние">Летние
        </p>
        <p>
            <label for="radius">Радиус: </label>
                <input type="text" name="radius" id="radius">
        </p>
        <p>
            <label for="width">Ширина: </label>
            <input type="text" name="width" id="width">
        </p>
        <p>
            <label for="height">Профиль: </label>
            <input type="text" name="height" id="height">
        </p>
        <p>
            <button>Подобрать резину</button>
        </p>
</form>
</div>
</body>
</html>
