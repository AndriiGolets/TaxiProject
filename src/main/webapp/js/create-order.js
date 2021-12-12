$(document).ready(function () {

    fillOrder();
    initFromAutocomplete();
    initToAutocomplete();

    $("#goFromNum").blur(function () {
        var address = getFromAddress();
        if (address) {
            setMarkerByAddress(address, "goFrom");
        }
    });

    $("#goToNum").blur(function () {
        var address = getToAddress();
        if (address) {
            setMarkerByAddress(address, "goTo");
        }
    });

    $("button").click(function () {
        createOrderService($(this).attr("id"));
    });

    $("#calculatedInfo").hide();
});


function createOrderService(button) {

    var orderInfo = {
        key: button,
        goTo: getToAddress(),
        goFrom: getFromAddress(),
        phone: $("#phone").val(),
        name: $("#myName").val()
    };

    if(validateOrderInfo(orderInfo)) {

        if (button === "calculate") {
            googleMapInitialize();
            setTimeout(displayRoute(getFromAddress(), getToAddress()), 1000);
            $.post("create-order", orderInfo, function (data) {
                if (data.isPresent === "false") {
                    $("#distance").text(data.distance);
                    $("#price").text(data.price);
                    $("#calculatedInfo").show(200);
                    $("#calculate").blur();
                    window.scrollTo(0, 1000);
                } else {
                    $("#myModal").modal();
                    $("#error-phone").text(orderInfo.phone);
                    $("#phone").val("-").blur();
                }
            }, "json")
        }

        if (button === "create") {
            $.post("create-order", orderInfo, function () {
                window.location.replace("create-order-info");
            })
        }
    }
}


function fillOrder() {

    $.post("create-order",
        {key: "get-passenger"},
        function (data) {
            $("#goFrom").val(data.address);
            inputValidate($("#goFrom"));
            setMarkerByAddress($("#goFrom").val(), "goFrom");
            $("#phone").val(data.phone);
            inputValidate($("#phone"));
            $("#myName").val(data.name);
            inputValidate($("#myName"));
        }, "json"
    );
}