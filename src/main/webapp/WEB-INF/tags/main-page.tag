<%@tag description="Main page template" pageEncoding="UTF-8" %>
<%@attribute name="body" fragment="true" %>
<%@attribute name="table" fragment="true" %>
<%@attribute name="sidebar" fragment="true" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Online taxi program</title>
    <link rel="icon" type="image/png" sizes="32x32" href="/img/favicon-32x32.png">
    <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"
            integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
            crossorigin="anonymous">
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCTR0DEqXJs9-IURAnEW1Yc06tz0Qmn_rg&signed_in=true&libraries=places"></script>
    <script src="js/bootstrap/bootstrap.min.js"></script>
    <link href="css/taxi-project.css" rel="stylesheet">
    <script src="js/main-page.js"></script>
</head>

<body>

<div class="container">

    <div class="col-xs-4 col-xs-offset-7" id="register-block">
        <div class="col-xs-12">
            <h3 id="login-header"><a href="passenger-register" id="registerRef">register</a> | <a href="login"
                                                                                                  id="loginRef">login</a>
            </h3>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-3 col-xs-offset-2"><img src="img/yellow-taxi.jpg"></div>
        <div class="col-xs-6 col-xs-offset-1"><a href="create-order"><h1> Find a taxi online !</h1></a></div>
    </div>

    <div class="row">
        <div id="sidebar" class="col-xs-4 hidden-xs col-sm-4 ">
            <div class="col-xs-12 ">
                <h3> Invite Drivers!</h3>
                <p> Take special possibilities for work !</p>
                <a type="button" href="driver-register" class="btn btn-primary btn-lg">Start Driving</a>
            </div>
        </div>
        <div id="sideform" class="col-xs-12 col-sm-4">
            <jsp:invoke fragment="sidebar"/>
        </div>

        <div id="form" class="col-xs-12 col-sm-8 ">
            <jsp:invoke fragment="body"/>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-12 ">
            <jsp:invoke fragment="table"/>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-12">
            <hr>
            <h4 id="footer"> Created by Andrii Golets </h4>
        </div>
    </div>
</div>

<div class="row">

</div>
</body>
</html>