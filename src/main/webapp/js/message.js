var idForEdit;

$(document).on('click', 'a.edit-btn', function () {
    idForEdit = $(this).parent().parent().parent().parent().attr("id");
    editMessageGet();
});

$(document).on('click', 'a.delete-btn', function () {
    idForEdit = $(this).parent().parent().parent().parent().attr("id");
    deleteGet();
});

$(document).ready(function () {

    getAllMessages();

    $("#input-button").click(function () {
        addMessage();
        $("#input-button").blur();
    });

    $("#modal-button").click(function () {
        var message = $("#modal-input").val();
        if (message) {
            editMessagePut();
        }
    })
});

function deleteGet() {
    $.post("message", {
            key: "delete",
            id: idForEdit
        },
        function (data) {
            if (data) {
                window.location.replace("message");
            } else {
                alert("You cant delete this message");
            }
        }, "json"
    );
}

function editMessageGet() {

    $.post("message", {
            key: "edit-get",
            id: idForEdit
        },
        function (data) {
            $("#myModal").modal();
            if (data) {
                $("#modal-label").text(data.name);
                $("#modal-input").show().val(data.message);
            } else {
                $("#modal-input").hide();
                $("#modal-label").text("You can`t edit this message");
            }
        }, "json"
    );
}

function editMessagePut() {
    $.post("message", {
            key: "edit-put",
            id: idForEdit,
            message: $("#modal-input").val()
        },
        function () {
            window.location.replace("message");
        });
}

function addMessage() {
    var name = $("#name-input").val();
    var message = $("#input").val();
    if (name && message) {
        $.post("message", {
                key: "add",
                message: message,
                name: name
            },
            function (id) {
                appendMessage(id, name, message);
                $("#name-input").val("");
                $("#input").val("");
            }
        );
    } else if (!name) {
        alert("Please enter your name.");
    } else if (!message) {
        alert("Please enter your message.");
    }
}

function appendMessage(id, name, message) {
    $("#message-area").append(
        "<div class=\"col-xs-12 message-container\" id=\"" + id + "\">" +
        "<div class=\"col-xs-12 message-header\">" +
        "<div class=\"col-xs-6\">" +
        "<h4 class=\"message-name\">" + name + "</h4>" +
        "</div>" +
        "<div class=\"message-buttons\">" +
        "<h4><a class=\"edit-btn\">edit |</a><a class=\"delete-btn\"> delete</a></h4>" +
        "</div>" +
        "</div>" +
        "<div class=\"col-xs-12 message-body\">" +
        "<p>" + message + "</p>" +
        "</div>" +
        "</div>"
    );
}

function getAllMessages() {
    $.post("message", {
            key: "get-all"
        },
        function (messageList) {
            if (messageList) {
                for (var i = 0; i < messageList.length; i++) {
                    var id = messageList[i].id;
                    var name = messageList[i].name;
                    var message = messageList[i].message;
                    appendMessage(id, name, message);
                }
            }
        }, "json"
    );
}