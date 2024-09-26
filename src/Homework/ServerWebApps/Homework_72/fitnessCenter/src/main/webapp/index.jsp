<%@ page import="java.sql.Connection" %>
<%@ page import="com.db.DBConnect" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Fitness Center - Sport Republic /Main page/</title>
    <jsp:include page="component/allcss.jsp" />
</head>
<body>
<jsp:include page="component/navbar.jsp" />
<% Connection conn = DBConnect.getConn(); %>
<div id="carouselExampleCaptions" class="carousel slide">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="/component/images/common_1.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
                <h5>Кардио-зал</h5>
                <p>Большой выбор тренажеров для кардио-тренировок</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="/component/images/common_2.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
                <h5>Силовой зал</h5>
                <p>Самое современное оборудования для прорабоки всех групп мышц</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="/component/images/common_3.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
                <h5>Бассейн</h5>
                <p>Место для отдыха и релакса</p>
            </div>
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>
<secion class="advantages">
    <div class="wrap">
        <h2>Фитнес-центр международного класса</h2>
        <div class="advantages__block">
            <div class="advantages__element-left">
                <div>
                    <h4>Новейшие технологии и оборудование</h4>
                    <p>Сотрудничество с ведущими компаниями производителями спортивного оборудования и инвентаря позволяет нам оснастить наши клубы лучшими в своем классе тренажерами и системами тренировок. Функциональное оборудование и инвентарь, современные методики тренировок в сочетании с грамотным обучением и тренировками – залог получения желаемого результата.</p>
                </div>
                <div>
                    <h4>Профессионализм</h4>
                    <p>Мы – профессионалы с многолетним опытом работы в сфере фитнеса и оказания услуг. Формируя команду каждого клуба, мы отдаем предпочтение профессионалам фитнеса, которые смогут поделиться с Вами своими знаниями. Одним из основных критериев приема в компанию новых сотрудников является стремление учиться, развиваться, совершенствоваться и повышать свой профессионализм. Компания регулярно проводит обучение и тренинги своих специалистов, результаты которых в виде грамотных тренировок и качества сервиса в целом они готовы передать Вам!</p>
                </div>
                <div>
                    <h4>Доступность</h4>
                    <p>У нас нет ограничений по возрасту в разумных пределах. Наш клуб находится в самом центре города с панорамным видом. У нас удобный график работы!</p>
                </div>
                <div>
                    <h4>Уникальный дизайн</h4>
                    <p>Проект дизайна разрабатывался одной из ведущих  мастерских в сфере фитнес услуг и сочетает в себе стиль, функциональность, урбанизм и комфорт.</p>
                </div>
            </div>
            <div class="advantages__element-right">
                <img src="/component/images/advantages.png" alt="">
            </div>
        </div>
    </div>
</secion>
<section class="team">
    <div class="wrap">
        <h2>Наша команда - тренеры международного класса</h2>
    <div class="team__block">
        <div class="team__element">
            <img src="/component/images/coach_1.jpg" alt="">
            <h5>Гибкова Вера Игоревна</h5>
            <p>Тренер по йоге</p>
        </div>
        <div class="team__element">
            <img src="/component/images/coach_2.jpg" alt="">
            <h5>Тяжелов Роман Русланович</h5>
            <p>Тренер по бодибилдингу</p>
        </div>
        <div class="team__element">
            <img src="/component/images/coach_3.jpg" alt="">
            <h5>Лавигина Нонна Леонидовна</h5>
            <p>Тренер по пластике</p>
        </div>
        <div class="team__element">
            <img src="/component/images/coach_4.jpg" alt="">
            <h5>Сердечников Анатолий Алексеевич</h5>
            <p>Кардио-тренер</p>
        </div>
    </div>
    </div>
</section>
<jsp:include page="component/footer.jsp" />
</body>
</html>