package ua.taxi.server.servlet;

import ua.taxi.base.model.order.Address;
import ua.taxi.base.model.user.*;
import ua.taxi.base.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



@WebServlet(urlPatterns = {"/passenger-register"})
public class PassengerRegisterServlet extends ServletInit{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/passenger-register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        resp.setContentType("text/html; charset=UTF-8");

        String key = req.getParameter("key");

        if (key.equals("create")) {
            String name = req.getParameter("name");
            String phone = Utils.phoneValidate(req.getParameter("phone"));
            String pass = req.getParameter("pass");
            Address address = Utils.addressValidate(req.getParameter("address"));


            if (name == null
                    || phone == null
                    || pass.length() < 6
                    || address == null
                    ){
                errorMessage(req, resp, "input error", "Input data Error");
            } else {
                UserValidateMessage message = userService.register(
                        phone, pass, name, address);
                if (message.isState()) {
                    session.setAttribute("passengerInfo",
                            jacksonWriter.writeValueAsString(
                                    new PassengerWebView((Passenger) message.getUser())));
                    resp.getWriter().print("true");
                } else {
                    //errorMessage(req, resp, message.getTitle(), message.getBody());
                }
            }
        }
    }
}
