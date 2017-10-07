$(function() {
    Calendar2("calendar2", new Date().getFullYear(), new Date().getMonth());

    document.querySelector('#calendar2 thead tr:nth-child(1) td:nth-child(1)').onclick = function() {
        Calendar2("calendar2", document.querySelector('#calendar2 thead td:nth-child(2)').dataset.year, parseFloat(document.querySelector('#calendar2 thead td:nth-child(2)').dataset.month)-1);
    };

    document.querySelector('#calendar2 thead tr:nth-child(1) td:nth-child(3)').onclick = function() {
        Calendar2("calendar2", document.querySelector('#calendar2 thead td:nth-child(2)').dataset.year, parseFloat(document.querySelector('#calendar2 thead td:nth-child(2)').dataset.month)+1);
    };
});

$(document).ready(function() {
    $('#confirm').click(fillDay);
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
        list.append("<div class='workout-day-list-item'>" +
            "<div class='workout-set-num'>Подход " + (i + 1) + "</div> " +
            "<div class='workout-set-value'>" +
            "<input type='text' size='1' value='" + rep.val() + "'>" +
            "<p>&nbsp;x&nbsp;</p>" +
            "<input type='text' size='3' value='" + weight.val() + "'>" +
            "</div>" +
            "</div>");
    };
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
};