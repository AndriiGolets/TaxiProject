<%@include file="include.jsp" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main-page>
<jsp:attribute name="body">

<c:set var="transfered" value="${requestScope.order}"/>


<form method="post" action="create-order-info" class="form-horizontal">
    <script src="js/create-order-info.js"></script>
    <script src="js/google-map.js"></script>
    <h3 id="waiting-info"> -= Waiting for a driver =- </h3>

    <div class="row" id ="driver-info">
        <h3> Driver info: </h3>
        <table class="table table-striped table-bordered">
            <tbody>
            <tr>
                <td>Name</td>
                <td id="name"></td>
            </tr>
            <tr>
                <td>Phone</td>
                <td id="driver-phone"></td>
            </tr>
            <tr>
                <td>Car model</td>
                <td id="model"></td>
            </tr>
            <tr>
                <td>Car color</td>
                <td id="color"></td>
            </tr>
            <tr>
                <td>Car number</td>
                <td id="number"></td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="row">
        <h3> Passenger info: </h3>
        <table class="table table-striped table-bordered">
            <tbody>
            <tr>
                <td>My phone</td>
                <td id="phone"></td>
            </tr>
            <tr>
                <td>Departure point</td>
                <td id="goFrom"></td>
            </tr>
            <tr>
                <td>Destination</td>
                <td id="goTo"></td>
            </tr>
            <tr>
                <td>Distance</td>
                <td id="distance"></td>
            </tr>
            <tr>
                <td>Price</td>
                <td id="price"></td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="form-group">
        <label for="addPrice" class="col-xs-6"> Add to Price:</label>
        <div class="col-xs-8">
            <div class="col-xs-6">
                <input id="addPrice" placeholder="0" class="form-control">
            </div>
            <div class="col-xs-6">
                <button type="button" id="addButton" class="btn btn-primary btn-block">
                    Add
                </button>
            </div>
        </div>
    </div>

    <div class="form-group">
        <label class="col-xs-6"> Create time: <span id="createTime"></span></label>
        <label class="col-xs-6"> Wait time: <span id="waitTime"></span></label>
    </div>


</form>

</jsp:attribute>

<jsp:attribute name="table">

    <div>
        <div id="googleMap"></div>
    </div>

</jsp:attribute>

</t:main-page>

