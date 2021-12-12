package ua.taxi.server.servlet;

import ua.taxi.base.model.order.OrderValidateMessage;
import ua.taxi.base.model.order.OrderWebView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by andrii on 08.07.16.
 */

@WebServlet(urlPatterns = {"/main-page"})
public class MainWindowServlet extends ServletInit {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        resp.setContentType("text/html; charset=UTF-8");

        Object user;

        if ((user = session.getAttribute("user")) != null) {
            if(user.toString().equals("driver")){
                resp.getWriter().print(session.getAttribute("driverInfo").toString());
            }else if(user.toString().equals("passenger")){
                resp.getWriter().print(session.getAttribute("passengerInfo").toString());
            }
        }
    }
}

