<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Guestbook Example</title>
    <meta charset="utf-8">
    <link rel="icon" type="image/png" sizes="32x32" href="/img/favicon-32x32.png">
    <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"
            integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
            crossorigin="anonymous">
    </script>
    <script src="js/bootstrap/bootstrap.min.js"></script>
    <script src="js/message.js"></script>

    <style>
        a {
            cursor: pointer;
            text-decoration: none !important;
        }

        h2 {
            color: darkorange;
        }

        p {
            margin-top: 15px;
        }

        .message-container {
            margin-top: 20px;
        }

        .message-body {
            border: 1px solid orange;
            border-bottom-left-radius: 5px;
            border-bottom-right-radius: 5px;
        }

        .message-header {
            height: 30px;
            background-color: orange;
            border-top-left-radius: 5px;
            border-top-right-radius: 5px;
        }

        .message-buttons {
            position: absolute;
            right: 20px;
        }

        .btn {
            background-color: orange;
        }

        #footer {
            text-align: center;
        }

        #message-area {
            margin-left: 1px;
        }

    </style>
</head>
<body>

<div class="container col-xs-8 col-lg-offset-2">
    <h2>Taxi Project guest book</h2>

    <hr>
    <div class="row" id="message-area">
    </div>
    <hr>
    <div class="row">
        <form class="col-xs-12 input-container">
            <div class="form-group col-xs-8">
                <label for="name-input">Please enter your name:</label>
                <input class="form-control" id="name-input">
            </div>
            <div class="form-group col-xs-8">
                <label for="input">You can print your comment here:</label>
                <textarea class="form-control" rows="5" id="input"></textarea>
            </div>
            <div class="form-group col-xs-12">
                <button class="btn" id="input-button" type="button">Send comment</button>
            </div>
        </form>
        <hr>
        <div class="col-xs-12">
            <hr>
            <h4 id="footer"> Created by Andrii Golets </h4>
        </div>
    </div>

</div>

<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title"></h4>
            </div>
            <div class="modal-body">
                <label id="modal-label" for="modal-input"></label>
                <textarea class="form-control" rows="5" id="modal-input"></textarea>
            </div>
            <div class="modal-footer">
                <button type="button" id="modal-button" class="get-order btn btn-default" data-dismiss="modal">Ok
                </button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
