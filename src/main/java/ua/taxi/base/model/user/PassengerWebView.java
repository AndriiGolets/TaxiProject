package ua.taxi.base.model.user;

/**
 * Created by andrii on 02.08.16.
 */
public class PassengerWebView {


    private String phone;
    private String name;
    private String address;
    private String type;

    public PassengerWebView() {

    }

    public PassengerWebView(Passenger passenger) {
        phone = passenger.getPhone();
        name = passenger.getName();

        address = passenger.getHomeAdress().toString();
        type = "Passanger";
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
