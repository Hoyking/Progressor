<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Progressor</title>
    <link rel="shortcut icon" href="<c:url value="/resources/images/favicon.ico" />" type="images/x-icon">
    <link rel="stylesheet" href="<c:url value="/resources/css/main.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/workout_day.css" />">
	<link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css" />">    
</head>
<body>

    <header>
        <ul class="nav-block">
            <li class="nav-elem active">
                <a class="nav-link" href="/progressor">Мой прогресс</a>
            </li>
            <li class="nav-elem">
                <a class="nav-link" href="#2">Создать</a>
            </li>
        </ul>
        <a id="logo" href="/progressor"><img src="<c:url value="/resources/images/logo.png" />"></a>
        <ul class="nav-block">
            <li class="nav-elem">
                <a class="nav-link" href="#4">Регистрация</a>
            </li>
            <li class="nav-elem">
                <a class="nav-link" href="#5">Войти</a>
            </li>
        </ul>
    </header>

    <div class="workout-group">
        <div class="workout-title">
            <p>Подтягивания<p>
        </div>
        <div class="workout-progress-area">
            <table id="calendar2">
                <thead>
                <tr><td class="switcher">‹<td colspan="5"><td class="switcher">›
                <tr><td>Пн<td>Вт<td>Ср<td>Чт<td>Пт<td>Сб<td>Вс
                <tbody>
            </table>

            <div class="workout-day-prop-wrap">
                <div class="workout-day-prop">
                    <p>Подходы: </p>
                    <input type="text" id="set" size="1">
                    <p>Вес: </p>
                    <input type="text" id="weight" size="3">
                    <p>Повторения: </p>
                    <input type="text" id="rep" size="1">
                    <i id="confirm" class="fa fa-check-circle-o" aria-hidden="true"></i>
                </div>

                <div class="workout-day-list"></div>
            </div>

            <div class="workout-day-indic-wrap">
                <div id="up-wrap" class="indicator chosen">
                    <i class="fa fa-arrow-circle-o-up" aria-hidden="true"></i>
                    <p>УДАЧНАЯ</p>
                </div>
                <div id="repeat-wrap" class="indicator">
                    <i class="fa fa-repeat" aria-hidden="true"></i>
                    <p>СРЕДНЯЯ</p>
                </div>
                <div id="down-wrap" class="indicator">
                    <i class="fa fa-arrow-circle-o-down" aria-hidden="true"></i>
                    <p>НЕУДАЧНАЯ</p>
                </div>
            </div>
        </div>
    </div>

	
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/workout-day.js" />"></script>

</body>
</html>