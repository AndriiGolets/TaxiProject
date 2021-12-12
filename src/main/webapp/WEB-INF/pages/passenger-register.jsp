<%@include file="include.jsp" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main-page>
<jsp:attribute name="body">
<script src="js/passenger-register.js"></script>
<script src="js/google-map.js"></script>

<form method="post" action="passenger-register" class="form-horizontal">
    <h3> Please, enter registration info: </h3>

    <h5> Registered passenger take 5% bonus! </h5>

    <div class="form-group">
        <label for="phone" class="col-xs-6"> My phone:</label>
        <div class="col-xs-8">
            <input id="phone" placeholder="Phone number." class="form-control phone">
            <span> </span>
        </div>
    </div>

    <div class="form-group">
        <label for="myName" class="col-xs-6"> My name:</label>
        <div class="col-xs-8">
            <input id="myName" placeholder="Name." class="form-control text-type">
            <span> </span>
        </div>
    </div>

    <div class="form-group">
        <label for="pass" class="col-xs-6"> Create password:</label>
        <div class="col-xs-8">
            <input id="pass" type="password" class="form-control pass">
            <span> </span>
        </div>
    </div>

    <div class="form-group">
        <div class="col-xs-8">
            <label for="goFrom">home address: </label>
            <input id="goFrom" placeholder="Input street." class="form-control text-type">
            <span> </span>
        </div>
        <div class="col-xs-3">
            <label for="goFromNum">Num: </label>
            <input id="goFromNum" placeholder="Num." class="form-control text-type">
            <span> </span>
        </div>
    </div>

    <div class="form-group">
        <div class="col-xs-8 ">
            <button type="button" class="btn btn-primary btn-block">Register</button>
        </div>
    </div>
</form>
</jsp:attribute>


    <jsp:attribute name="table">

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
                  <h4>Passenger with phone: <span id="error-phone"></span> is present!</h4>
              </div>
              <div class="modal-footer">
                  <button type="button" class="get-order btn btn-default" data-dismiss="modal">Ok</button>
              </div>
          </div>
      </div>
  </div>

    </jsp:attribute>


</t:main-page>

