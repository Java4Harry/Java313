<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Notebook choice</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <jsp:include page="header.jsp" />
    <section>
        <form action="notebook.jsp" method="post">
            <p>Производитель:
                <select name="manufactor" id="manufactor" required>
                    <option value="Asus">Asus</option>
                    <option value="Chuwi">Chuwi</option>
                    <option value="Lenovo">Lenovo</option>
                    <option value="Maibenben">Maibenben</option>
                    <option value="MSI">MSI</option>
                    <option value="ThunderRobot">ThunderRobot</option>
                </select>
            </p>
            <p>Диагональ:
                <select name="screenSize" id="screenSize" required>
                    <option value="13.3">13.3</option>
                    <option value="14">14</option>
                    <option value="15.6">15.6</option>
                    <option value="17.3">17.3</option>
                </select></p>
            <p>Процессор:
                <label for="i5">
                    <input type="checkbox" name="processor" id="i5" value="Intel i5">Intel i5
                </label>
                <label for="i7">
                    <input type="checkbox" name="processor" id="i7" value="Intel i7">Intel i7
                </label>
                <label for="amd">
                    <input type="checkbox" name="processor" id="amd" value="AMD Ryzon">AMD Ryzon
                </label></p>
            <p>Видеокарта:
                <select name="graphics" id="graphics" required>
                    <option value="GeForce 2050">GeForce 2050</option>
                    <option value="GeForce 3050">GeForce 3050</option>
                    <option value="GeForce 3070">GeForce 3070</option>
                    <option value="GeForce 4050">GeForce 4050</option>
                </select></p>
            <p>Объем оперативной памяти:
                <label for="8">
                    <input type="radio" name="RAM" id="8" value="8">8
                </label>
            <label for="16">
                <input type="radio" name="RAM" id="16" value="16">16
            </label></p>
            <p>Объем SSD:
                <label for="256">
                    <input type="radio" name="SSD" id="256" value="256">256 Мб
                </label>
                <label for="512">
                    <input type="radio" name="SSD" id="512" value="512">512 Мб
                </label></p>
            <p>Тип матрицы:
                <label for="VA">
                    <input type="radio" name="screen" id="VA" value="VA">VA
                </label>
                <label for="IPS">
                    <input type="radio" name="screen" id="IPS" value="IPS">IPS
                </label>
                <label for="OLED">
                    <input type="radio" name="screen" id="OLED" value="OLED">OLED
                </label></p>
            <p>Разрешение экрана:
                <label for="min">
                    <input type="radio" name="resolution" id="min" value="1366х768">1366х768 пикселей
                </label>
                <label for="max">
                    <input type="radio" name="resolution" id="max" value="1920х1080">1920х1080 пикселей
                </label></p>
            <p>Сенсорный экран:
                <label for="sensorYes">
                    <input type="radio" name="sensor" id="sensorYes" value="yes">Да
                </label>
                <label for="sensorNo">
                    <input type="radio" name="sensor" id="sensorNo" value="no">Нет
                </label></p>
            <p>Подсветка клавиатуры:
                <label for="lightYes">
                    <input type="radio" name="light" id="lightYes" value="yes">Да
                </label>
                <label for="lightNo">
                    <input type="radio" name="light" id="lightNo" value="no">Нет
                </label></p>
            <p>Операционная система:
                <label for="linux">
                    <input type="radio" name="os" id="linux" value="Linux">Linux
                </label>
                <label for="windows">
                    <input type="radio" name="os" id="windows" value="Windows">Windows
                </label>
                <label for="osNone">
                    <input type="radio" name="os" id="osNone" value="Without OS">Без ОС
                </label></p>
            <div class="button__container">
                <div class="button__container__element">
                    <input type="submit" value="Подтвердить">
                </div>
                <div class="button__container__element">
                    <input type="reset" value="Сбросить">
                </div>
            </div>
        </form>
    </section>
    <jsp:include page="footer.jsp" />
</div>
</body>
</html>