var order;
var driver;

$(document).ready(function () {

    loadOrder();
    init();

    $("#driver-info").hide();
    $("button").click(function () {
        addToPrice();
    });

});

function init() {
    if (order) {
        fillOrderInfo(order);
        waitTime(order.createTime);
        displayRoute(order.goFrom, order.goTo);
        waitDriver();
    } else {
        setTimeout(function () {
            init();
        }, 1000);
    }
}

function waitDriver() {
    $.post("create-order-info", {
            key: "get-status",
            orderPhone: order.phone
        },
        function (data) {
            driver = data;
        }, "json"
    );

    if (!driver) {
        setTimeout(function () {
            waitDriver();
        }, 3000);
    } else {
        $("#driver-info").show(1000);
        $("#waiting-info").hide();
        $("#name").text(driver.name);
        $("#driver-phone").text(driver.phone);
        $("#model").text(driver.carModel);
        $("#color").text(driver.carColor);
        $("#number").text(driver.carNumber);
    }
}

function loadOrder() {
    $.post("create-order-info",
        {key: "get-info"},
        function (data) {
            order = data;
        }, "json"
    );
}

function fillOrderInfo(order) {
    $("#phone").text(order.phone);
    $("#goFrom").text(order.goFrom);
    $("#goTo").text(order.goTo);
    $("#distance").text(order.distance);
    $("#price").text(order.price);
    $("#createTime").text(order.createTime);
}

function waitTime(createTime) {

    var createHour = createTime.split(".")[0];
    var createMinute = createTime.split(".")[1];
    var createSecond = createTime.split(".")[2].split(" ")[0];
    var now = new Date();
    var createData = new Date(
        now.getFullYear(),
        now.getMonth(),
        now.getDay(),
        createHour, createMinute, createSecond);
    timer(createData);
}
function timer(time) {
    var now = new Date();
    var waitTimeMS = new Date(now.getTime() - time.getTime());
    var h = waitTimeMS.getHours() - 2;
    var m = waitTimeMS.getMinutes();
    var s = waitTimeMS.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('waitTime').innerHTML = h + ":" + m + ":" + s;
    setTimeout(function () {
        timer(time);
    }, 500);
}

function checkTime(i) {
    if (i < 10) {
        i = "0" + i
    }
    return i;
}

function addToPrice() {
    $.post("create-order-info", {
            key: "add-price",
            addPrice: $("#addPrice").val(),
            phone: $("#phone").text()
        },
        function (data) {
            $("#price").text(data.newPrice);
        },
        "json"
    );
    $("#addButton").blur();
}