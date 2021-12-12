$(document).ready(function () {
    $("input").blur(function () {
        if ($(this).val()) {
            inputValidate($(this));
        }
    });

    setLoginHeader();
});

function setLoginHeader() {
    $.post("main-page", {},
        function (data) {
            if (data) {
                $("#login-header").html("You logged as a " + data.type + "<br>tel.:" + data.phone);
            }
        }, "json"
    );
}

function inputValidate(input) {

    var value = input.val();
    var inputClass = input.attr("class");
    var inputId = input.attr("id");
    var key;

    if (inputClass.includes("phone")) {
        key = "phone";
        validateUtils(key, value, input);
    } else if (inputClass.includes("text-type")) {
        if (value.length < 1) {
            setErrorInput(input);
        } else {
            setSuccessInput(input, value);
        }
    } else if (inputClass.includes("pass")) {
        if (value.length < 6) {
            setErrorInput(input);
        } else {
            setSuccessInput(input, value);
        }
    }
}

function validateUtils(key, value, input) {
    $.get("utils", {key: key, value: value},
        function (data) {
            if (data === "") {
                setErrorInput(input);
            } else {
                setSuccessInput(input, data);
            }
        }
    );
}

function setSuccessInput(input, value) {
    input.parent().parent().attr("class", "form-group has-success has-feedback");
    input.next().attr("class", "glyphicon glyphicon-ok form-control-feedback");
    input.val(value);
    input.css("border", "1px solid orange");
}

function setErrorInput(input) {
    input.parent().parent().attr("class", "form-group has-error has-feedback");
    input.next().attr("class", "glyphicon glyphicon-remove form-control-feedback");
    input.css("border", "1px solid red");
}

function getFromAddress() {

    var address = $("#goFrom").val();
    var num = $("#goFromNum").val();
    if (address && num) {
        var splitVal = address.split(",");
        return splitVal[0] + " " + num;
    }
}

function getToAddress() {

    var address = $("#goTo").val();
    var num = $("#goToNum").val();
    if (address && num) {
        var splitVal = address.split(",");
        return splitVal[0] + " " + num;
    }
    return " ";
}

function validateOrderInfo(orderInfo) {
    for (var i = 0; orderInfo.length; i++){
        if(!orderInfo[i]){
            return false;
        }
    }
    return true;
}
