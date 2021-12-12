package ua.taxi.server.servlet;

import com.google.gson.Gson;
import ua.taxi.base.model.user.Car;
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
 * Created by andrii on 04.07.16.
 */

@WebServlet(urlPatterns = {"/driver-register"})
public class DriverRegServlet extends ServletInit {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/driver-register.jsp").forward(req, resp);
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
            String carModel = req.getParameter("carModel");
            String carColor = req.getParameter("carColor");
            String carNumber = req.getParameter("carNumber");

            if (name == null
                    || phone == null
                    || pass.length() < 6
                    || carModel.length() < 2
                    || carColor.length() < 2
                    || carNumber.length() < 2) {

                errorMessage(req, resp, "input error", "Input data Error");
            } else {
                UserValidateMessage message = userService.register(
                        phone, pass, name, new Car(carNumber, carModel, carColor));
                if (message.isState()) {
                    session.setAttribute("driverInfo",
                            jacksonWriter.writeValueAsString(
                                    new DriverWebViview((Driver) message.getUser())));
                    resp.getWriter().print("true");
                } else {
                    //errorMessage(req, resp, message.getTitle(), message.getBody());
                }
            }
        }
    }
}
