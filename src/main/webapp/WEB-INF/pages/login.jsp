<%@include file="include.jsp" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main-page>
<jsp:attribute name="body">
<script src="js/login.js"></script>

<form method="post" action="login" class="form-horizontal">

    <h3> Login: </h3>

    <div class="form-group">
        <label for="myPhone" class="col-xs-6 phone"> My phone:</label>
        <div class="col-xs-8">
            <input id="myPhone" placeholder="Phone number." class="form-control phone">
            <span> </span>
        </div>
    </div>

    <div class="form-group">
        <label for="pass" class="col-xs-6 "> Enter password:</label>
        <div class="col-xs-8">
            <input id="pass" type="password"  class="form-control pass">
            <span> </span>
        </div>
    </div>

    <div class="form-group">
        <div class="col-xs-8 ">
            <button type="button" id="login" class="btn btn-primary btn-block">Login</button>
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
                  <h4>Login data incorrect!</h4>
              </div>
              <div class="modal-footer">
                  <button type="button" class="get-order btn btn-default" data-dismiss="modal">Ok</button>
              </div>
          </div>
      </div>
  </div>

</jsp:attribute>

</t:main-page>

