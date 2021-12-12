$(document).ready(function () {

    initFromAutocomplete();
    
    $("button").click(function () {
        passengerRegister();
    });
});

function passengerRegister() {

    var passengerInfo = {
        key: "create",
        phone: $("#phone").val(),
        name: $("#myName").val(),
        pass: $("#pass").val(),
        address: getFromAddress().val()
    };

    if (validateOrderInfo(passengerInfo)) {

        $.post("passenger-register", passengerInfo, function (data) {
            if (data === "true") {
                window.location.replace("create-order");
            } else {
                $("#myModal").modal();
                $("#error-phone").text($("#phone").val());
                $("#phone").val("-").blur();
            }
        })
    }
}