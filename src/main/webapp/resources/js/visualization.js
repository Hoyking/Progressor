$(function() {
   $(document).ready(function() {
       expand();
       customization();
       workoutGroupAddingHandler();
   });
});

function expand(){
    [].forEach.call(document.getElementsByClassName("workout-day"), function(day) {
        var size = day.getAttribute("size");
        if(size > "5") {
            var changer = day.querySelector(".workout-day-changer");
            changer.classList.add("workout-day-changer-active");
            var icon = changer.querySelector(".fa");
            icon.classList.add("fa-angle-down");
            $(changer).click(function() {
                var workoutList = day.querySelector(".workout-day-wrap").querySelector(".workout-list");
                if($(workoutList).css("height") === "115px") {
                    height = 115 + 23 * (size - 5);
                    icon.classList.remove("fa-angle-down");
                    icon.classList.add("fa-angle-up");
                }
                else {
                    height = 115;
                    icon.classList.remove("fa-angle-up");
                    icon.classList.add("fa-angle-down");
                }
                $(workoutList).animate({
                    height: height+"px"
                }, 100, "linear");
            });
        };
    });
};

function customization() {
	$("#new-workout").hide();
    [].forEach.call(document.getElementsByClassName("workout-day"), function(item) {
        switch(item.getAttribute("success")) {
            case "2": customizeUpDay(item); break;
            case "1": customizeRepeatDay(item); break;
            case "0": customizeDownDay(item); break;
        };
    });
};

function customizeUpDay(item) {
    item.classList.add("workout-day-up");

    item.querySelector(".workout-day-wrap").querySelector(".workout-day-arrow").
    querySelector(".workout-arrow-icon").querySelector(".fa").
    classList.add("fa-arrow-circle-o-up");

};

function customizeRepeatDay(item) {
    item.classList.add("workout-day-repeat");

    item.querySelector(".workout-day-wrap").querySelector(".workout-day-arrow").
    querySelector(".workout-arrow-icon").querySelector(".fa").
    classList.add("fa-repeat");
};

function customizeDownDay(item) {
    item.classList.add("workout-day-down");

    item.querySelector(".workout-day-wrap").querySelector(".workout-day-arrow").
    querySelector(".workout-arrow-icon").querySelector(".fa").
    classList.add("fa-arrow-circle-o-down");
};

function workoutGroupAddingHandler() {

}


var url = document.location.href;
var settings = {
	"url": url,
	"method": "POST"
}

$("#workout-group-add").children(".fa").click(function () {
	/*$("#workout-groups").append(
		"<div id='new-workout' class='workout-group'>" +
			"<div class='workout-title'>" +
	            "<input id='new-group-name' type='text' placeholder='Введите название'>" +
	        "</div>" +
	        "<div class='workout-progress-area'>" +
	        	"<div class='workout-group-add-area'>" +
	        		"<i id='confirm-new-workout' class='fa fa-check-circle' aria-hidden='true'></i>" +
	        		"<i id='cancel-new-workout' class='fa fa-times-circle' aria-hidden='true'></i>" +
	        	"</div>" +
	        "</div>" +
		"</div>");*/
	
	$("#workout-group-add").hide();
	$("#new-workout").show();
});

$("#confirm-new-workout").click(function() {
	$.ajax(settings);
});

$("#cancel-new-workout").click(function() {
	$('#new-workout').hide();
	$("#workout-group-add").show();
});