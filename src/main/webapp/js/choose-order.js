$(document).ready(function () {

    $("#sidebar").hide();

    $.post("choose-order",
        {key: "get-driver"},
        function (data) {
            fillDriverInfo(data);
        }, "json"
    );

    loadOrders();

    $("#sort").click(function () {
        sortOrders();
    });

    $('#order-table').on('click', 'tr', function () {
        chooseOrder($(this).children().first().text());
    });

    $("#get-order").click(function () {
        redirectOrderInfo();
    });

    displayOrders();

});

function redirectOrderInfo() {
    $.post("choose-order", {
        key: "redirect-order-info",
        passengerPhone: $("#pass-phone").text(),
        driverPhone: $("#phone").text()
    }, function () {
        window.location.replace("choose-order-info");
    });
}

function loadOrders() {
    $('#order-table').DataTable({
        "ajax": "load-orders",
        "columns": [
            {"data": "phone"},
            {"data": "goFrom"},
            {"data": "goTo"},
            {"data": "distance"},
            {"data": "minDistance"},
            {"data": "price"},
            {"data": "createTime"}
        ],
        "order": [[4, "asc"]],
        "scrollX": true
    });
}

function fillDriverInfo(driver) {

    $("#phone").text(driver.phone);
    $("#name").text(driver.name);
    $("#model").text(driver.carModel);
    $("#color").text(driver.carColor);
    $("#number").text(driver.carNumber);
}

function chooseOrder(userPhone) {

    $.post("choose-order", {
            key: "get-order-by-phone",
            phone: userPhone
        },
        function (data) {
            $("#pass-phone").text(data.phone);
            $("#goFrom").text(data.goFrom);
            $("#goTo").text(data.goTo);
            $("#distance").text(data.distance);
            $("#price").text(data.price);
            $("#created").text(data.createTime);
            $("#myModal").modal();
        }, "json"
    );
}

function sortOrders() {

    if ($("#my-address").val()) {
        $.post("load-orders", {
            address: $("#my-address").val()
        },function () {
            window.location.replace("choose-order");
            }
        );
       
    }
}