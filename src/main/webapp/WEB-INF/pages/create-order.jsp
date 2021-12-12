<%@include file="include.jsp" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main-page>
    <jsp:attribute name="body">

    <script src="js/create-order.js"></script>
    <script src="js/google-map.js"></script>

    <form method="post" action="create-order" class="form-horizontal">
        <h3> Find a taxi in Kiev: </h3>

        <div class="form-group">
            <div class="col-xs-9">
                <label for="goFrom">I go from: </label>
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
            <div class="col-xs-9">
                <label for="goTo">Destination:</label>
                <input id="goTo" placeholder="Input street and house num." class="form-control text-type">
                <span> </span>
            </div>
            <div class="col-xs-3">
                <label for="goToNum">Num: </label>
                <input id="goToNum" placeholder="Num." class="form-control text-type">
                <span> </span>
            </div>
        </div>

        <div class="form-group">
            <label for="phone" class="col-xs-12 col-md-3">Phone number: </label>
            <div class="col-xs-12 col-md-6">
                <input type="text" id="phone" class="form-control phone"
                       placeholder="Phone number">
                <span> </span>
            </div>
        </div>

        <div class="form-group">
            <label for="myName" class="col-xs-12 col-md-3"> My name:</label>
            <div class="col-xs-12 col-md-6">
                <input id="myName"
                       placeholder="Name." class="form-control text-type">
                <span> </span>
            </div>
        </div>

        <div class="form-group">
            <div class="col-xs-6 col-md-3 checkbox">
                <label><input name="rememberMe" type="checkbox"> Remember me</label>
            </div>
            <div class="col-xs-6 col-md-6 ">
                <button class="btn btn-primary btn-block" type="button" id="calculate">
                    Calculate
                </button>
            </div>
        </div>

        <div id="calculatedInfo">
            <div class="form-group">
                <div id="price-distance" class="form-group col-xs-6 col-md-6">
                    <h4>Distance: <span id="distance"></span></h4>
                    <h4>Price: <span id="price"></span></h4>
                </div>
            </div>
            <div class="form-group">
                <div class="col-xs-12 col-md-6">
                    <button type="button"
                            class="btn btn-primary btn-block btn-lg" id="create"> Go now!
                    </button>
                </div>
            </div>
        </div>
    </form>
    </jsp:attribute>

    <jsp:attribute name="table">

        <div>
            <div id="googleMap"></div>
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
                  <h4> Order with phone: <span id="error-phone"></span> is present!</h4>
              </div>
              <div class="modal-footer">
                  <button type="button" class="get-order btn btn-default" data-dismiss="modal">Ok</button>
              </div>
          </div>
      </div>
  </div>

    </jsp:attribute>

</t:main-page>
