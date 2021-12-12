$(document).ready(function () {
    $("#login").click(function () {
        login();
    });
});

function login() {

    $.post("login", {
            key: "login",
            pass: $("#pass").val(),
            phone: $("#myPhone").val()
        }, function (data) {
        if(data === "create-order"){
            window.location.replace("create-order");
        }else if(data === "choose-order") {
            window.location.replace("choose-order");
        }else if(data ==="choose-order-info"){
            window.location.replace("choose-order-info");
        }else if(data ==="create-order-info"){
            window.location.replace("create-order-info");
        }else {
            $("#myModal").modal();
            $("#phone").val("-").blur();
        }
    });
}
