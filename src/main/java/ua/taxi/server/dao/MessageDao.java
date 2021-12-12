package ua.taxi.server.dao;

import ua.taxi.base.model.message.Message;

import java.util.List;

/**
 * Created by andrii on 31.08.16.
 */
public interface MessageDao {

    int addMessage(Message message);

    Message getMessage(int id);

    List<Message> getAllMessages();

    Message deleteMessage(int id);

    Message edit(int id, String messageBody);

}
