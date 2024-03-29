package ua.taxi.base.model.user;

import java.io.Serializable;

/**
 * Created by serhii on 23.04.16.
 */
public class UserValidateMessage implements Serializable {

    private User user;
    private String title;
    private String body;
    private boolean state;

    public UserValidateMessage() {
    }

    public UserValidateMessage(boolean state, String title, String body, User user) {
        this.state = state;
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public boolean isState() {
        return state;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "UserValidateMessage{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
