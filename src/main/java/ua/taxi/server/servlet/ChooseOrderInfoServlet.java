package ua.taxi.server.servlet;

import ua.taxi.base.model.order.OrderStatus;
import ua.taxi.base.model.order.OrderValidateMessage;
import ua.taxi.base.model.order.OrderWebView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by andrii on 15.07.16.
 */

@WebServlet(urlPatterns = {"/choose-order-info"})
public class ChooseOrderInfoServlet extends ServletInit{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/choose-order-info.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        resp.setContentType("text/html; charset=UTF-8");

        String key = req.getParameter("key");

        if (key.equals("get-order-info")) {
            Object userPhone;
            if ((userPhone = session.getAttribute("order-info-phone")) != null) {
                OrderValidateMessage ovm = orderService.getOrder(userPhone.toString());
                if (ovm.isState()) {
                    resp.getWriter().print(jacksonWriter.writeValueAsString(
                            new OrderWebView(ovm.getOrder())));
                }
            }
        }else if(key.equals("complete-order")){
            String orderPhone = req.getParameter("orderPhone");
            orderService.changeOrderStatus(orderPhone, OrderStatus.DONE);
        }
    }
}
