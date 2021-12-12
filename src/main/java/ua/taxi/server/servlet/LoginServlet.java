package ua.taxi.server.servlet;

import ua.taxi.base.model.order.OrderStatus;
import ua.taxi.base.model.order.OrderValidateMessage;
import ua.taxi.base.model.order.OrderWebView;
import ua.taxi.base.model.user.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by andrii on 15.07.16.
 */

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends ServletInit {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        resp.setContentType("text/html; charset=UTF-8");

        String key = req.getParameter("key");

        if (key.equals("login")) {

            String phone = req.getParameter("phone");
            String pass = req.getParameter("pass");
            UserValidateMessage uvm = userService.login(phone, pass);

            if (uvm.isState()) {
                User user = uvm.getUser();
                if (user instanceof Driver) {
                    DriverWebViview driver = new DriverWebViview((Driver) user);
                    session.setAttribute("driverInfo",
                            jacksonWriter.writeValueAsString(driver));
                    session.setAttribute("user", "driver");
                    OrderValidateMessage ovm = orderService.getOrderInProgresByDriverPhone(phone);
                    if (ovm.isState()) {
                        resp.getWriter().print("choose-order-info");
                    } else {
                        resp.getWriter().print("choose-order");
                    }
                } else if (user instanceof Passenger) {
                    PassengerWebView passenger = new PassengerWebView((Passenger) user);
                    session.setAttribute("passengerInfo",
                            jacksonWriter.writeValueAsString(passenger));
                    session.setAttribute("user", "passenger");
                    OrderValidateMessage ovm = orderService.getOrder(phone);
                    if (ovm.isState()) {
                        if (ovm.getOrder().getOrderStatus() == OrderStatus.NEW ||
                                ovm.getOrder().getOrderStatus() == OrderStatus.IN_PROGRESS) {
                            session.setAttribute("orderInfo",
                                    jacksonWriter.writeValueAsString(new OrderWebView(ovm.getOrder())));
                            resp.getWriter().print("create-order-info");
                        }
                    } else {
                        resp.getWriter().print("create-order");
                    }
                }
            }
        }
    }
}