package ua.taxi.base.model.order;

import ua.taxi.base.utils.DateUtils;
import ua.taxi.base.utils.Utils;

/**
 * Created by andrii on 30.07.16.
 */
public class OrderWebView {

    private String phone;
    private String goFrom;
    private String goTo;
    private String passName;
    private String distance;
    private String price;
    private String createTime;
    private String minDistance;

    public OrderWebView(Order order) {
        phone = order.getUserPhone();
        goFrom = order.getFrom().toString();
        goTo = order.getTo().toString();
        distance = Utils.distanceFormat(order.getDistance());
        price = Utils.priceFormat(order.getPrice());
        createTime = DateUtils.HHmm(order.getCreateTime());
        passName = order.getUserName();
        minDistance = "-=-";
    }

    public OrderWebView() {

    }

    public String getPassName() {
        return passName;
    }

    public void setPassName(String passName) {
        this.passName = passName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGoFrom() {
        return goFrom;
    }

    public void setGoFrom(String goFrom) {
        this.goFrom = goFrom;
    }

    public String getGoTo() {
        return goTo;
    }

    public void setGoTo(String goTo) {
        this.goTo = goTo;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(String minDistance) {
        this.minDistance = minDistance;
    }
}
