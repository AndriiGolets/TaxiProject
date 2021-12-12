package ua.taxi.server.dao.jpa;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.taxi.base.model.message.Message;
import ua.taxi.server.dao.MessageDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by andrii on 31.08.16.
 */

@Component(value = "messageDao")
public class MessageDaoImpl implements MessageDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    @Transactional
    public int addMessage(Message message) {

        manager.persist(message);
        manager.flush();
        return message.getId();
    }

    @Override
    public Message getMessage(int id) {
        return manager.find(Message.class, id);
    }

    @Override
    public List<Message> getAllMessages() {
        return manager.createQuery("SELECT m from Message m ", Message.class)
                .getResultList();
    }


    @Override
    @Transactional
    public Message deleteMessage(int id) {
        Message message =  manager.find(Message.class, id);
        manager.remove(message);
        manager.flush();
        return message;
    }

    @Override
    @Transactional
    public Message edit(int id, String messageBody) {
        Message message = manager.find(Message.class, id);
        message.setMessage(messageBody);
        manager.merge(message);
        return message;
    }
}
