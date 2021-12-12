<%@include file="include.jsp" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main-page>
<jsp:attribute name="sidebar">

</jsp:attribute>

<jsp:attribute name="body">
 <script src="js/choose-order-info.js"></script>
 <script src="js/google-map.js"></script>
    <h3> Order info: </h3>
    <div class="row  col-xs-12">
        <table class="table table-striped table-bordered">
            <tbody>
            <tr>
                <td>Passenger phone</td>
                <td id="pass-phone"></td>
            </tr>
            <tr>
                <td>Go From</td>
                <td id="goFrom"></td>
            </tr>
            <tr>
                <td>Go To</td>
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
            <tr>
                <td>Created</td>
                <td id="created"></td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="row">
        <div class="col-xs-12 col-md-6">
            <button type="button"
                    class="btn btn-primary btn-block btn-lg" id="finish"> Finish and take new order
            </button>
        </div>
    </div>

    </jsp:attribute>

    <jsp:attribute name="table">

    <div>
        <div id="googleMap"></div>
    </div>

</jsp:attribute>

</t:main-page>
