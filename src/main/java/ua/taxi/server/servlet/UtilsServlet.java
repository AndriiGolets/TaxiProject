package ua.taxi.server.servlet;

import org.apache.log4j.Logger;
import ua.taxi.base.model.order.Address;
import ua.taxi.base.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andrii on 21.07.16.
 */
@WebServlet(urlPatterns = {"/utils"})
public class UtilsServlet extends ServletInit {

    private static final Logger LOG = Logger.getLogger(UtilsServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String key = req.getParameter("key");
        String value = req.getParameter("value");

        LOG.info("key = " + key + ";  value = " + value);
        resp.setContentType("text/html; charset=UTF-8");

        if (key.equals("phone")) {
            value = Utils.phoneValidate(value);
            resp.getWriter().print(value != null ? value : "");
        } else if (key.equals("address")) {
            Address address = Utils.addressValidate(value);
            resp.getWriter().print(address != null ? address.toString() : "");
        }

    }
}
