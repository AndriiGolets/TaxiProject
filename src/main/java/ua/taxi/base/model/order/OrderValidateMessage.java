package ua.taxi.base.model.order;


/**
 * Created by Andrii on 5/4/2016.
 */
public class OrderValidateMessage {

    private Order order;
    private String title;
    private String body;
    private boolean state;

    public OrderValidateMessage(){

    }

    public OrderValidateMessage(Order order, String title, String body, boolean state) {
        this.order = order;
        this.title = title;
        this.body = body;
        this.state = state;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "OrderValidateMessage{" +
                "order=" + order +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", state=" + state +
                '}';
    }
}
