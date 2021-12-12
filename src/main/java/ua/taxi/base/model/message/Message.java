package ua.taxi.base.model.message;

import javax.persistence.*;

/**
 * Created by andrii on 31.08.16.
 */

@Entity
@Table(name = "Messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String message;

    @Column
    private String name;

    @Column
    private String sessionKey;

    public Message() {}

    public Message(String message, String name, String sessionKey)
    {
        this.message = message;
        this.name = name;
        this.sessionKey = sessionKey;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", name='" + name + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                '}';
    }
}
