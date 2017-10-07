$(function() {
    $(document).ready(function(){
        var owl = $('.owl-carousel');

        owl.owlCarousel({
            nav: true,
            dots: false,
            navText: ["<i class='fa fa-angle-left' aria-hidden='true'></i>", "<i class='fa fa-angle-right' aria-hidden='true'></i>",
                "<i class='fa fa-angle-double-left' aria-hidden='true'></i>", "<i class='fa fa-angle-double-right' aria-hidden='true'></i>"],
            responsive: {
                0: {
                    items: 1
                },
                950:{
                    items: 2
                },
                1280: {
                    items: 3
                },
                1600: {
                    items: 4
                }
            }
        });
    });
});

