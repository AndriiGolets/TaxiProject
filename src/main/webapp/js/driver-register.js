$(document).ready(function () {
    $("button").click(function () {
        driverRegister();
    });
});

function driverRegister() {

    var driverInfo = {
        key: "create",
        phone: $("#phone").val(),
        name: $("#myName").val(),
        pass: $("#pass").val(),
        carColor: $("#carColor").val(),
        carModel: $("#carModel").val(),
        carNumber: $("#carNumber").val()
    };
    
    $.post("driver-register", driverInfo, function (data) {
        if(data === "true") {
            window.location.replace("choose-order");
        }else {
            $("#myModal").modal();
            $("#error-phone").text($("#phone").val());
            $("#phone").val("-").blur();
        }
    })
}

