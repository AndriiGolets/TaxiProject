package ua.taxi.server.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import ua.taxi.base.model.order.Address;
import ua.taxi.base.model.order.OrderValidateMessage;
import ua.taxi.base.model.order.OrderWebView;
import ua.taxi.base.model.user.UserValidateMessage;
import ua.taxi.base.utils.Utils;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by andrii on 08.07.16.
 */
@WebServlet(urlPatterns = {"/create-order"})
public class CreateOrderServlet extends ServletInit {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/create-order.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        resp.setContentType("text/html; charset=UTF-8");
        String key = req.getParameter("key");

        if (key.equals("get-passenger")) {
            try {
                String passengerInfo = session.getAttribute("passengerInfo").toString();
                resp.getWriter().print(passengerInfo);
            }catch (Exception e){
                LOG.warn(e);
            }
        } else {

            String name = req.getParameter("name");
            String phone = Utils.phoneValidate(req.getParameter("phone"));
            Address goFrom = Utils.addressValidate(req.getParameter("goFrom"));
            Address goTo = Utils.addressValidate(req.getParameter("goTo"));

            if (key.equals("calculate")) {

                OrderValidateMessage ovm = orderService.getOrder(phone);
                String distance = Utils.distanceFormat(orderService.getDistance(goFrom, goTo));
                String price = Utils.priceFormat(orderService.getPrice(goFrom, goTo));
                Map<String, String> jsonMap = new HashMap<>();
                jsonMap.put("distance", distance);
                jsonMap.put("price", price);
                jsonMap.put("isPresent", String.valueOf(ovm.isState()));
                resp.getWriter().print(new Gson().toJson(jsonMap));
            } else if (key.equals("create")) {

                if (validate(name, phone, goFrom, goTo)) {
                    OrderValidateMessage message = orderService.createOrder(
                            phone, name, goFrom, goTo);
                    if (message.isState()) {
                        session.setAttribute("orderInfo", jacksonWriter.writeValueAsString(new OrderWebView(message.getOrder())));
                    } else {
                        errorMessage(req, resp, message.getTitle(), message.getBody());
                    }
                } else {
                    errorMessage(req, resp, "Incorrect Input", "Input data incorrect");
                }
            }
        }
    }

    private boolean validate(String name, String phone, Address goFrom, Address goTo) {
        return !(name == null || phone == null || goFrom == null || goTo == null);
    }
}

