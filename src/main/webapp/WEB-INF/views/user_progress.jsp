<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Progressor</title>
    <link rel="shortcut icon" href="<c:url value='/resources/images/favicon.ico' />" type="images/x-icon">
    <link rel="stylesheet" href="<c:url value='/resources/css/main.css' />">
    <link rel="stylesheet" href="<c:url value='/resources/css/progress.css' />">
    <link rel="stylesheet" href="<c:url value='/resources/css/owl.carousel.min.css' />">
    <link rel="stylesheet" href="<c:url value='/resources/css/font-awesome.min.css' />">
    <link rel="stylesheet" href="<c:url value='/resources/css/font.css' />">
</head>
<body>

<header>
    <ul class="nav-block">
        <li class="nav-elem active">
            <a class="nav-link" href="/">Мой прогресc</a>
        </li>
        <li class="nav-elem">
            <a class="nav-link" href="#2">Создать</a>
        </li>
    </ul>
    <a id="logo" href="/"><img src="<c:url value='/resources/images/logo.png' />"></a>
    <ul class="nav-block">
        <li class="nav-elem">
            <a class="nav-link" href="#4">Регистрация</a>
        </li>
        <li class="nav-elem">
            <a class="nav-link" href="#5">Войти</a>
        </li>
    </ul>
</header>

<div id="workout-groups">

    <c:forEach var="group" items="${groups}">
        <div id="group-${group.id}" class="workout-group">

            <div class="workout-title">
                <p>${group.name}<p>
            </div>

            <div class="workout-progress-area">
                <div class="workout-car-wrap">
                    <div class="owl-carousel">

                        <c:forEach var="day" items="${group.days}">
                            <div class="workout-day" success="${day.type}" size="${fn:length(day.sets)}">

                                <div class="workout-date">
                                    <p>${day.date}</p>
                                </div>

                                <div class="workout-day-wrap">
                                    <div class="workout-list">

                                        <c:forEach var="set" items="${day.sets}" varStatus="status">
                                            <div class="workout-list-item">
                                                <div class="workout-iteration-num">
                                                    <p>${status.index + 1}</p>
                                                </div>
                                                <div class="workout-iteration-value">
                                                    <p>${set.reps} x ${set.weight} кг</p>
                                                </div>
                                            </div>
                                        </c:forEach>

                                    </div>

                                    <div class="workout-day-arrow">
                                        <div class="workout-arrow-icon">
                                            <i class="fa" aria-hidden="true"></i>
                                        </div>
                                    </div>

                                </div>

                                <div class="workout-day-changer">
                                    <i class="fa" aria-hidden="true"></i>
                                </div>

                            </div>
                        </c:forEach>

                        <a id="add-day-of-group-${group.id}" class="workout-day-add" href="#">
                            <i class="fa fa-plus-circle" aria-hidden="true"></i>
                        </a>

                    </div>
                </div>
            </div>
        </div>
    </c:forEach>

</div>

<div id="new-workout" class="workout-group">
    <div class="workout-title">
        <input id="new-group-name" type="text" placeholder="Введите название">
        <p id="error-message">Название не должно быть пустым или дублировать название другой группы</p>
    </div>
    <div class="workout-progress-area">
        <div class="workout-group-add-area">
            <i id="confirm-new-workout" class="fa fa-check-circle" aria-hidden="true"></i>
            <i id="cancel-new-workout" class="fa fa-times-circle" aria-hidden="true"></i>
        </div>
    </div>
</div>

<div id="workout-group-add">
    <i class="fa fa-plus-circle" aria-hidden="true"></i>
</div>

<script src="<c:url value='/resources/js/jquery-3.2.1.min.js' />"></script>
<script src="<c:url value='/resources/js/owl.carousel.js' />"></script>
<script src="<c:url value='/resources/js/carousel.js' />"></script>
<script src="<c:url value='/resources/js/visualization.js' />"></script>
</body>

</html>