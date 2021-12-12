<%@include file="include.jsp" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main-page>

<jsp:attribute name="sidebar">
  <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.css">
  <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.js"></script>
  <script src="js/choose-order.js"></script>
  <script src="js/google-map.js"></script>

  <form class="form-horizontal">
      <div class="form-group address">
          <label for="my-address" class="col-xs-12">Enter your current location:</label>
          <div class="col-xs-12">
              <input id="my-address"
                     placeholder="Sreet houseN" class="form-control address">
              <span> </span>
          </div>
      </div>
      <div class="form-group">
          <div class="col-xs-12">
              <button type="button" class="btn btn-primary btn-block" id="sort">
                  Sort orders by my location.
              </button>
          </div>
      </div>
  </form>
</jsp:attribute>

<jsp:attribute name="body">

  <h3> Driver info: </h3>
  <div class="col-xs-12 ">
      <table class="table table-striped table-bordered">
          <tbody>
          <tr>
              <td>Name</td>
              <td id="name"></td>
          </tr>
          <tr>
              <td>Phone</td>
              <td id="phone"></td>
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

</jsp:attribute>

<jsp:attribute name="table">

<h3> Choose your order:</h3>

    <div class="dataTables_wrapper col-xs-12">
        <table id="order-table" class="display nowrap order-table" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>Phone</th>
                <th>Go From</th>
                <th>Go To</th>
                <th>Distance</th>
                <th>Dist. to me</th>
                <th>Price</th>
                <th>Created</th>
            </tr>
            </thead>
            <tfoot>
            <tr>
                <th>Phone</th>
                <th>Go From</th>
                <th>Go To</th>
                <th>Distance</th>
                <th>Dist. to me</th>
                <th>Price</th>
                <th>Created</th>
            </tr>
            </tfoot>
        </table>
    </div>

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
                  <h3> Order info: </h3>
                  <table class="table">
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
              <div class="modal-footer">
                  <button type="button" id="get-order" class="get-order btn btn-default" data-dismiss="modal">Get order</button>
              </div>
          </div>
      </div>
  </div>
    </jsp:attribute>
</t:main-page>

