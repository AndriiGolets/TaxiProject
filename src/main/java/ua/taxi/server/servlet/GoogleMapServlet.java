package ua.taxi.server.servlet;

import com.google.gson.Gson;
import ua.taxi.base.model.geolocation.Location;
import ua.taxi.base.model.order.Marker;
import ua.taxi.base.model.order.Order;
import ua.taxi.base.model.order.OrderStatus;
import ua.taxi.base.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andrii on 03.08.16.
 */

@WebServlet(urlPatterns = {"/google-map"})
public class GoogleMapServlet extends ServletInit {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        Map<String, String> jsonMap = new HashMap<>();
        String key = req.getParameter("key");

        if (key.equals("get-lat-lng")) {
            String address = req.getParameter("address");
            Location location = orderService.getLatLng(Utils.addressValidate(address));
            jsonMap.put("lat", Double.toString(location.getLat()));
            jsonMap.put("lng", Double.toString(location.getLng()));
            resp.getWriter().print(new Gson().toJson(jsonMap));
        } else if (key.equals("get-address-x2")) {
            String address1 = req.getParameter("address1");
            String address2 = req.getParameter("address2");
            Location location1 = orderService.getLatLng(Utils.addressValidate(address1));
            Location location2 = orderService.getLatLng(Utils.addressValidate(address2));
            jsonMap.put("lat1", Double.toString(location1.getLat()));
            jsonMap.put("lng1", Double.toString(location1.getLng()));
            jsonMap.put("lat2", Double.toString(location2.getLat()));
            jsonMap.put("lng2", Double.toString(location2.getLng()));
            resp.getWriter().print(new Gson().toJson(jsonMap));
        } else if (key.equals("get-orders")) {
            List<Order> orders = orderService.getOrdersWithStatus(OrderStatus.NEW, 1, 100);
            List<Marker> jsonOrders = new ArrayList<>();
            for (Order order : orders) {
                Location location = orderService.getLatLng(order.getFrom());
                String lat = Double.toString(location.getLat());
                String lng = Double.toString(location.getLng());
                jsonOrders.add(new Marker(lat, lng, order.getFrom().toString(),order.getUserPhone()));
            }
            String jsonList = jacksonWriter.writeValueAsString(jsonOrders);
            LOG.info(jsonList);
            resp.getWriter().print(jsonList);
        }
    }
}
