<%@include file="include.jsp" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main-page>
<jsp:attribute name="body">

<form method="post" action="driver-register" class="form-horizontal">
    <script src="js/driver-register.js"></script>
    <h3> Please, enter registration info: </h3>

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
        <label for="carModel" class="col-xs-6"> Car model:</label>
        <div class="col-xs-8">
            <input id="carModel" placeholder="Car model." class="form-control text-type">
            <span> </span>
        </div>
    </div>

    <div class="form-group">
        <label for="carNumber" class="col-xs-6"> Car number:</label>
        <div class="col-xs-8">
            <input id="carNumber" placeholder="Car number." class="form-control text-type">
            <span> </span>
        </div>
    </div>

    <div class="form-group">
        <label for="carColor" class="col-xs-6"> Car color:</label>
        <div class="col-xs-8">
            <input id="carColor" placeholder="Car color." class="form-control text-type">
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
                  <h4>Driver with phone: <span id="error-phone"></span> is present!</h4>
              </div>
              <div class="modal-footer">
                  <button type="button" class="get-order btn btn-default" data-dismiss="modal">Ok</button>
              </div>
          </div>
      </div>
  </div>

    </jsp:attribute>

</t:main-page>

