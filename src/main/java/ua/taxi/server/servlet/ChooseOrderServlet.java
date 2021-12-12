package ua.taxi.server.servlet;

import com.google.gson.Gson;
import ua.taxi.base.model.order.Order;
import ua.taxi.base.model.order.OrderStatus;
import ua.taxi.base.model.order.OrderValidateMessage;
import ua.taxi.base.model.order.OrderWebView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrii on 15.07.16.
 */

@WebServlet(urlPatterns = {"/choose-order"})
public class ChooseOrderServlet extends ServletInit {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/choose-order.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        resp.setContentType("text/html; charset=UTF-8");

        String key = req.getParameter("key");

        if (key.equals("get-driver")) {
            try {
                String driverInfo = session.getAttribute("driverInfo").toString();
                resp.getWriter().print(driverInfo);
            } catch (Exception e) {
            }
        } else if (key.equals("get-orders")) {
            List<Order> orderList = orderService.getAllOrders(1, 10);
            List<OrderWebView> orderWebList = new ArrayList<>();
            for (Order order : orderList) {
                orderWebList.add(new OrderWebView(order));
            }
            resp.getWriter().print(jacksonWriter.writeValueAsString(orderWebList));
        } else if (key.equals("get-order-by-phone")) {
            String userPhone = req.getParameter("phone");
            OrderValidateMessage ovm = orderService.getOrder(userPhone);
            if (ovm.isState()) {
                resp.getWriter().print(jacksonWriter.writeValueAsString(
                        new OrderWebView(ovm.getOrder())));
            }
        } else if (key.equals("redirect-order-info")) {
            String passPhone = req.getParameter("passengerPhone");
            String driverPhone = req.getParameter("driverPhone");
            session.setAttribute("order-info-phone", passPhone);
            OrderValidateMessage ovm = orderService.getOrder(passPhone);
            if (ovm.isState()) {
                Order order = ovm.getOrder();
                order.setDriverPhone(driverPhone);
                order.setOrderStatus(OrderStatus.IN_PROGRESS);
                orderService.changeOrder(passPhone, order);
            }
        }
    }
}

