package ua.taxi.server.servlet;

import com.google.gson.Gson;
import org.apache.log4j.Logger;
import ua.taxi.base.model.order.Order;
import ua.taxi.base.model.order.OrderStatus;
import ua.taxi.base.model.order.OrderValidateMessage;
import ua.taxi.base.model.user.Driver;
import ua.taxi.base.model.user.DriverWebViview;
import ua.taxi.base.model.user.UserValidateMessage;
import ua.taxi.base.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by andrii on 15.07.16.
 */

@WebServlet(urlPatterns = {"/create-order-info"})
public class CreateOrderInfoServlet extends ServletInit {

    private static final Logger LOG = Logger.getLogger(UtilsServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/create-order-info.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        resp.setContentType("text/html; charset=UTF-8");
        String key = req.getParameter("key");

        if (key.equals("get-info")) {
            try {
                resp.getWriter().print(session.getAttribute("orderInfo"));
            }catch (Exception e) {
                LOG.warn("create-order-info  " + e);
            }
        } else if (key.equals("add-price")) {
            String addPrice = req.getParameter("addPrice");
            addPrice = addPrice.replaceAll("[\\D]+", "");
            if (!addPrice.equals("")) {
                double addPriceInt = Double.parseDouble(addPrice);
                String phone = req.getParameter("phone");
                OrderValidateMessage ovm = orderService.getOrder(phone);
                if (ovm.isState()) {
                    Order order = ovm.getOrder();
                    double newPrice = order.getPrice() + addPriceInt;
                    order.setPrice(newPrice);
                    orderService.changeOrder(phone, order);
                    Map<String, String> priceMap = new HashMap<>();
                    priceMap.put("newPrice", Utils.priceFormat(newPrice));
                    resp.getWriter().print(new Gson().toJson(priceMap));
                } else {
                   // errorMessage(req, resp, ovm.getTitle(), ovm.getBody());
                }
            }
        } else if (key.equals("get-status")){

            String phone = req.getParameter("orderPhone");
            OrderValidateMessage ovm =  orderService.getOrder(phone);
            if(ovm.isState()){
                Order order = ovm.getOrder();
                if(order.getOrderStatus() == OrderStatus.IN_PROGRESS){
                    UserValidateMessage uvm = userService.getUser(order.getDriverPhone());
                    if(uvm.isState()){
                        Driver driver = (Driver) uvm.getUser();
                        String driverJson =  jacksonWriter.writeValueAsString(new DriverWebViview(driver));
                        resp.getWriter().print(driverJson);
                    }
                }
            }
        }
    }


}
