/*var months = {
    "0": "января",
    "1": "февраля",
    "2": "марта",
    "3": "апреля",
    "4": "мая",
    "5": "июня",
    "6": "июля",
    "7": "августа",
    "8": "сентября",
    "9": "октября",
    "10": "ноября",
    "11": "декабря"
};*/

var months = ["января", "февраля", "марта", "апреля", "мая", "июня", "августа", "сентября", "октября", "ноября", "декабря"];

$(function() {
    Calendar2("calendar2", new Date().getFullYear(), new Date().getMonth());

    document.querySelector('#calendar2 thead tr:nth-child(1) td:nth-child(1)').onclick = function() {
        Calendar2("calendar2", document.querySelector('#calendar2 thead td:nth-child(2)').dataset.year,
            parseFloat(document.querySelector('#calendar2 thead td:nth-child(2)').dataset.month)-1);
    };

    document.querySelector('#calendar2 thead tr:nth-child(1) td:nth-child(3)').onclick = function() {
        Calendar2("calendar2", document.querySelector('#calendar2 thead td:nth-child(2)').dataset.year,
            parseFloat(document.querySelector('#calendar2 thead td:nth-child(2)').dataset.month)+1);
    };
});

$(document).ready(function() {
    $('#confirm').click(fillDay);
    $('#confirm-new-day').click(sendData);
    $('#cancel-new-day').click(function() {
        window.location.href = $("#logo").attr("href");
    });

    $('#set').keyup(function(event) {
        if(event.keyCode == 13)
            fillDay();
    });

    $('#rep').keyup(function(event) {
        if(event.keyCode == 13)
            fillDay();
    });

    $('#weight').keyup(function(event) {
        if(event.keyCode == 13)
            fillDay();
    });

    $('#up-wrap').click(function(event) {
        event.currentTarget.classList.add('chosen');
        $('#repeat-wrap')[0].classList.remove('chosen');
        $('#down-wrap')[0].classList.remove('chosen');
    });

    $('#repeat-wrap').click(function(event) {
        event.currentTarget.classList.add('chosen');
        $('#up-wrap')[0].classList.remove('chosen');
        $('#down-wrap')[0].classList.remove('chosen');
    });

    $('#down-wrap').click(function(event) {
        event.currentTarget.classList.add('chosen');
        $('#up-wrap')[0].classList.remove('chosen');
        $('#repeat-wrap')[0].classList.remove('chosen');
    });
});

function fillDay() {
    var rep = $('#rep');
    var weight = $('#weight');
    var set = $('#set');
    var list = $('.workout-day-list');

    $('div.workout-day-list-item').remove();

    for(i=0; i < set.val(); i++) {
        var repId = "rep" + i;
        var weightId = "weight" + i;
        list.append("<div class='workout-day-list-item'>" +
            "<div class='workout-set-num'>Подход " + (i + 1) + "</div> " +
            "<div class='workout-set-value'>" +
            "<input id=" + repId + " class='reps' type='text' size='1' value='" + rep.val() + "'>" +
            "<p>&nbsp;x&nbsp;</p>" +
            "<input id=" + weightId + " class='weight' type='text' size='3' value='" + weight.val() + "'>" +
            "<p>&nbsp;кг</p>" +
            "</div>" +
            "</div>");
    }
}

function Calendar2(id, year, month) {
    var Dlast = new Date(year,month+1,0).getDate(),
        D = new Date(year,month,Dlast),
        DNlast = new Date(D.getFullYear(),D.getMonth(),Dlast).getDay(),
        DNfirst = new Date(D.getFullYear(),D.getMonth(),1).getDay(),
        calendar = '<tr>',
        month=["Январь","Февраль","Март","Апрель","Май","Июнь","Июль","Август","Сентябрь","Октябрь","Ноябрь","Декабрь"];
    if (DNfirst != 0) {
        for(var  i = 1; i < DNfirst; i++) calendar += '<td>';
    }else{
        for(var  i = 0; i < 6; i++) calendar += '<td>';
    }
    for(var  i = 1; i <= Dlast; i++) {
        if (i == new Date().getDate() && D.getFullYear() == new Date().getFullYear() && D.getMonth() == new Date().getMonth()) {
            calendar += '<td class="valid today" id="chosen">' + i;
        }else{
            calendar += '<td class="valid">' + i;
        }
        if (new Date(D.getFullYear(),D.getMonth(),i).getDay() == 0) {
            calendar += '<tr>';
        }
    }
    for(var  i = DNlast; i < 7; i++) calendar += '<td>&nbsp;';
    document.querySelector('#'+id+' tbody').innerHTML = calendar;
    document.querySelector('#'+id+' thead td:nth-child(2)').innerHTML = month[D.getMonth()] +' '+ D.getFullYear();
    document.querySelector('#'+id+' thead td:nth-child(2)').dataset.month = D.getMonth();
    document.querySelector('#'+id+' thead td:nth-child(2)').dataset.year = D.getFullYear();
    if (document.querySelectorAll('#'+id+' tbody tr').length < 6) {  // чтобы при перелистывании месяцев не "подпрыгивала" вся страница, добавляется ряд пустых клеток. Итог: всегда 6 строк для цифр
        document.querySelector('#'+id+' tbody').innerHTML += '<tr><td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;';
    }

    $('.valid').click(function(event) {
        var previousChosen = document.getElementById('chosen');
        if(previousChosen !== null)
            previousChosen.removeAttribute('id');
        event.target.id = "chosen";
    });
}

function sendData() {
    var day = $("#chosen")[0].textContent;
    var month = $("#calendar2 > thead > tr")[0].childNodes[1].getAttribute("data-month");
    var year = $("#calendar2 > thead > tr")[0].childNodes[1].getAttribute("data-year");

    var date = day + " " + months[month - 2 + 1] + " " + year + " г.";

    var data = {
        date : date,
        type: getType(),
        sets: getSetsInfo()
    };

    var parameter = window.location.search.replace( "?", "" ); // will return the GET parameter
    var values = parameter.split("=");

    var settings = {
        url: $("#logo").attr("href") + "add_day" + "?" + values[0] + "=" + values[1],
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function(message) {
            window.location.href = $("#logo").attr("href");
        },
        error: function () {
            $("#error-message").show();
        }
    };

    sendRequest(settings);
}

function getSetsInfo() {
    var sets = [];
    [].forEach.call($(".workout-set-value"), function(item, index) {
        sets[index] = {
            "reps": $("#rep" + index).val() - 1 + 1,
            "weight": $("#weight" + index).val() - 1 + 1
        };
    });
    return sets;
}

function getType() {
    var chosenType = document.querySelector(".chosen");
    if(chosenType.id === "up-wrap") {
        return 2;
    } else if(chosenType.id === "repeat-wrap") {
        return 1;
    } else if(chosenType.id === "down-wrap") {
        return 0;
    }
}

function sendRequest(settings) {
    $.ajax(settings);
}
