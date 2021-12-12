<%@include file="WEB-INF/pages/test/include.jsp" %>

<html>
<head>
    <title>Welcome Taxi Project</title>
    <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap/bootstrap.min.js"></script>
    <style>
        #footer {
            text-align: center;
        }

    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-8 col-lg-offset-2">
            <h3><a type="button" class="btn-block" href="create-order">Welcome to the Taxi Project !</a></h3>
            <p> This program can help you to find the taxi in Kiev.</p>
            <p> On the start page you can enter your trip information
                and see distance, price value and the route on the google map.
                When you accept order info you appear on the "wait for a driver page". <br>
                You can also register as a passenger. It will help you to fill
                trip info next time.
            </p>
            <p> If you choose start driving button on the main page you will go
                to the driver registration page, after registration you appear on
                the "choose order page" where you can choose order in the table or
                on the google map. <br>
                You can enter your current location and sort orders for distance to you
            </p>

            <h3> It is a sample of a project with using following technologies:</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-4 col-lg-offset-2">
            <h4> For server side:</h4>

            <ul>Java 1.8</ul>
            <ul>Maven</ul>
            <ul>Spring core</ul>
            <ul>JPA Hibernate</ul>
            <ul>MySql</ul>
            <ul>Javax Servlet</ul>
            <ul>Tomcat Server</ul>
            <ul>Google Maps Geocoding</ul>

            <h5> Now, I work under realization:</h5>

            <ul>Spring MVC</ul>
            <ul>Spring Data</ul>
            <ul>Spring Security</ul>
            <ul>Spring Social</ul>
        </div>
        <div class="col-xs-4">
            <h4> For client side:</h4>
            <ul>*.jsp Server pages</ul>
            <ul>Bootstrap</ul>
            <ul>Java Script</ul>
            <ul>JQuery</ul>
            <ul>Ajax</ul>
            <ul>DataTables</ul>
            <ul>Google Maps</ul>
            <ul>Google Routes</ul>
            <ul>Google Places</ul>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-8 col-lg-offset-2">
            <ul>
                <li><a href="create-order">Go to the taxi-project Main-page</a></li>
            </ul>
            <h4> You can see the source code of the project on <a
                    href="https://github.com/AndriiGolets/TaxiProject">GitHub</a></h4>
            <h4> Leave your comment and suggestion on the <a href="message">Taxi Project guest book</a></h4>
        </div>
    </div>
    <div class="col-xs-12">
        <hr>
        <h4 id="footer"> Created by Andrii Golets </h4>
    </div>
</div>
</body>
</html>
