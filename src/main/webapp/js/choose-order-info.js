var order;
$(document).ready(function () {

    getOrderInfo();

    $("#finish").click(function () {
        finish();
    });
    $("#sidebar").hide();

    loadRoute();
});

function loadRoute() {
    if (order) {
        displayRoute(order.goFrom, order.goTo);
    } else {
        setTimeout(function () {
            loadRoute();
        }, 1000);
    }
}

function getOrderInfo() {
    $.post("choose-order-info", {
            key: "get-order-info"
        },
        function (data) {
            if (data) {
                order = data;
                $("#pass-phone").text(data.phone);
                $("#goFrom").text(data.goFrom);
                $("#goTo").text(data.goTo);
                $("#distance").text(data.distance);
                $("#price").text(data.price);
                $("#created").text(data.createTime);
            }
        }, "json"
    );
}

function finish() {
    $.post("choose-order-info", {
            key: "complete-order",
            orderPhone: $("#pass-phone").text()
        },
        function () {
            window.location.replace("choose-order");
        }
    );
}