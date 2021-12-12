package ua.taxi.server.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.context.ApplicationContext;
import ua.taxi.base.model.message.Message;
import ua.taxi.server.dao.MessageDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by andrii on 31.08.16.
 */

@WebServlet(urlPatterns = {"/message"})
public class MessageServlet extends HttpServlet {

    private MessageDao messageDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
        ApplicationContext applicationContext = (ApplicationContext) getServletContext().getAttribute("spring-context");
        messageDao = applicationContext.getBean(MessageDao.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        resp.setContentType("text/html; charset=UTF-8");
        String key = req.getParameter("key");
        ObjectWriter jacksonWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

        if (key.equals("add")) {
            String name = req.getParameter("name");
            String message = req.getParameter("message");
            String sessionKey;
            if (session.getAttribute("sessionKey") == null) {
                sessionKey = LocalDateTime.now().toString();
                session.setAttribute("sessionKey", sessionKey);
            } else {
                sessionKey = (String) session.getAttribute("sessionKey");
            }
            int id = messageDao.addMessage(new Message(message, name, sessionKey));
            resp.getWriter().print(id);

        } else if (key.equals("get-all")) {
            List<Message> list = messageDao.getAllMessages();
            String jsonData = jacksonWriter.writeValueAsString(list);
            resp.getWriter().print(jsonData);
        } else if (key.equals("edit-get")) {
            String id = req.getParameter("id");
            Message message = messageDao.getMessage(Integer.parseInt(id));
            if (message.getSessionKey().equals(session.getAttribute("sessionKey"))) {
                resp.getWriter().print(jacksonWriter.writeValueAsString(message));
            }else {
                resp.getWriter().print("false");
            }
        } else if (key.equals("edit-put")) {
            String id = req.getParameter("id");
            String message = req.getParameter("message");
            messageDao.edit(Integer.parseInt(id), message);
        } else if (key.equals("delete")){
            String id = req.getParameter("id");
            Message message = messageDao.getMessage(Integer.parseInt(id));
            if (message.getSessionKey().equals(session.getAttribute("sessionKey"))) {
                messageDao.deleteMessage(Integer.parseInt(id));
                resp.getWriter().print("true");
            }else {
                resp.getWriter().print("false");
            }
        }
    }
}
