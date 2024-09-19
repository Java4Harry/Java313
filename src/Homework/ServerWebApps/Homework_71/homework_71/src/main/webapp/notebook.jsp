<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your choice</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <jsp:include page="header.jsp" />
    <section>
    <p><b>Производитель: </b><%= request.getParameter("manufactor") %> </p>
    <p><b>Диагональ: </b><%= request.getParameter("screenSize") %></p>
    <p><b>Процессор: </b><%
    String[] processor = request.getParameterValues("processor");
    for (String proc: processor) {
        out.println("  |  " + proc + "  |  ");
    }
    %></p>
    <p><b>Видеокарта: </b><%= request.getParameter("graphics") %></p>
    <p><b>Объем оперативной памяти: </b><%= request.getParameter("RAM") %></p>
    <p><b>Объем SSD: </b><%= request.getParameter("SSD") %></p>
    <p><b>Тип матрицы: </b><%= request.getParameter("screen") %></p>
    <p><b>Разрешение экрана: </b><%= request.getParameter("resolution") %></p>
    <p><b>Сенсорный экран: </b><%= request.getParameter("sensor") %></p>
    <p><b>Подсветка клавиатуры: </b><%= request.getParameter("light") %></p>
    <p><b>Операционная система: </b><%= request.getParameter("os") %></p>
    </section>
    <jsp:include page="footer.jsp" />
</div>
</body>
</html>
