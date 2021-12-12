package ua.taxi.server.servlet;

import ua.taxi.base.model.order.Order;
import ua.taxi.base.model.order.OrderStatus;
import ua.taxi.base.model.order.OrderWebView;
import ua.taxi.base.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrii on 03.08.16.
 */

@WebServlet(urlPatterns = {"/load-orders"})
public class LoadOrders extends ServletInit {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        HttpSession session = req.getSession(true);

        List<Order> orderList = orderService.getOrdersWithStatus(OrderStatus.NEW, 1, 100);
        List<OrderWebView> orderWebList = new ArrayList<>();
        for (Order order : orderList) {
            OrderWebView orderWebView = new OrderWebView(order);
            Object driverLocation;
            if ((driverLocation = session.getAttribute("driverLocation")) != null) {
                double minDistance = orderService.getDistance(
                        order.getFrom(),
                        Utils.addressValidate(driverLocation.toString())
                );
                orderWebView.setMinDistance(String.valueOf(minDistance/1000));
            }
            orderWebList.add(orderWebView);
        }
        String jsonData = jacksonWriter.writeValueAsString(orderWebList);
        jsonData = "{ \"data\": " + jsonData + " }";
        //LOG.info("loadOrders: " + jsonData);
        resp.getWriter().print(jsonData);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        HttpSession session = req.getSession(true);

        String address = req.getParameter("address");
        session.setAttribute("driverLocation", address);

    }
}
