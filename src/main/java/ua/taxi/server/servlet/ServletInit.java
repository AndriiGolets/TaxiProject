package ua.taxi.server.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ua.taxi.server.service.OrderService;
import ua.taxi.server.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andrii on 07.07.16.
 */
public class ServletInit extends HttpServlet {

    private ApplicationContext applicationContext;
    UserService userService;
    OrderService orderService;
    ObjectWriter jacksonWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

    static Logger LOG = Logger.getLogger(DriverRegServlet.class);

    @Override
    public void init() throws ServletException {
        applicationContext = (ApplicationContext) getServletContext().getAttribute("spring-context");
        userService = applicationContext.getBean(UserService.class);
        orderService = applicationContext.getBean(OrderService.class);
        LOG.info("--!!-- Servlet context init!");
        System.out.println();
    }

    public void errorMessage(HttpServletRequest req, HttpServletResponse resp,
                             String errorTitle, String errorMessage) throws ServletException, IOException {
        resp.sendRedirect("WEB-INF/pages/error.jsp");
    }
}
