$(function() {
   $(document).ready(function() {
       expand();
       customization();
       workoutGroupAddingHandler();
       scrollAnimation();
   });
});

function scrollAnimation() {
    $(".last-day-item").click();
}

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
        }
    });
}

function customization() {
	$("#new-workout").hide();
    [].forEach.call(document.getElementsByClassName("workout-day"), function(item) {
        switch(item.getAttribute("success")) {
            case "2": customizeUpDay(item); break;
            case "1": customizeRepeatDay(item); break;
            case "0": customizeDownDay(item); break;
        }
    });
}

function customizeUpDay(item) {
    item.classList.add("workout-day-up");

    item.querySelector(".workout-day-wrap").querySelector(".workout-day-arrow").
    querySelector(".workout-arrow-icon").querySelector(".fa").
    classList.add("fa-arrow-circle-o-up");

}

function customizeRepeatDay(item) {
    item.classList.add("workout-day-repeat");

    item.querySelector(".workout-day-wrap").querySelector(".workout-day-arrow").
    querySelector(".workout-arrow-icon").querySelector(".fa").
    classList.add("fa-repeat");
}

function customizeDownDay(item) {
    item.classList.add("workout-day-down");

    item.querySelector(".workout-day-wrap").querySelector(".workout-day-arrow").
    querySelector(".workout-arrow-icon").querySelector(".fa").
    classList.add("fa-arrow-circle-o-down");
}

function workoutGroupAddingHandler() {
	$("#workout-group-add").children(".fa").click(addGroupModOn);
	$(".nav-elem")[1].onclick = addGroupModOn;

	var settings = {
			url: $("#logo").attr("href") + "add_group",
			type: "POST",
			dataType: "text",
			data: {
				text: $("#new-group-name").val()
			},
			success: function () {
				location.reload();
			},
            error: function () {
                $("#error-message").show();
            }
	};
	
	$("#confirm-new-day").keyup(function(event) {
        if(event.keyCode == 13) {
        	settings.data.text = $('#new-group-name').val();
        	sendRequest(settings);
        }
    });
	
	$("#confirm-new-day").click(function() {
		settings.data.text = $('#new-group-name').val();
		sendRequest(settings);
	});
	
	$("#cancel-new-day").click(addGroupModOff);
}

function addGroupModOn() {
    $("#workout-group-add").hide();
    $("#new-workout").show();
    var navs = $(".nav-elem");
    navs[0].classList.remove("active");
    navs[1].classList.add("active");

    $("body").animate({scrollTop: document.body.scrollHeight}, 700);
}

function addGroupModOff() {
    $('#new-workout').hide();
    $("#workout-group-add").show();
    var navs = $(".nav-elem");
    navs[1].classList.remove("active");
    navs[0].classList.add("active");

    $("#error-message").hide();
}

function sendRequest(settings) {
	$.ajax(settings);
}
