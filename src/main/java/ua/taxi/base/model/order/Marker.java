package ua.taxi.base.model.order;

/**
 * Created by andrii on 04.08.16.
 */
public class Marker {

    private String lat;
    private String lng;
    private String address;

    public Marker(){}

    public Marker(String lat, String lng, String address, String phone) {
        this.lat = lat;
        this.lng = lng;
        this.address = address + " tel: " + phone;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
