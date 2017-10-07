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
    //document.querySelector(".owl-nav").classList.remove("disabled");
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
	$("#workout-group-add").children(".fa").click(function () {	
		$("#workout-group-add").hide();
		$("#new-workout").show();
	});
	
	var settings = {
			url: "/add_group",
			type: "POST",
			dataType: "text",
			data: {
				text: $("#new-group-name").val()
			}/*,
			success: function (data) {
				console.log(data);
			}*/
	};
	
	$("#confirm-new-workout").keyup(function(event) {
        if(event.keyCode == 13) {
        	settings.data.text = $('#new-group-name').val();
        	sendRequest(settings);
        }
    });
	
	$("#confirm-new-workout").click(function() {
		settings.data.text = $('#new-group-name').val();
		sendRequest(settings);
	});
	
	$("#cancel-new-workout").click(function() {
		$('#new-workout').hide();
		$("#workout-group-add").show();
	});
};

function sendRequest(settings) {
	$.ajax(settings);
};
