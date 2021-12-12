package ua.taxi.base.model.user;

/**
 * Created by andrii on 31.07.16.
 */
public class DriverWebViview {

    private String phone;
    private String name;
    private String carModel;
    private String carNumber;
    private String carColor;
    private String type;

    public DriverWebViview() {

    }

    public DriverWebViview(Driver driver) {
        phone = driver.getPhone();
        name = driver.getName();
        carModel = driver.getCar().getModel();
        carNumber = driver.getCar().getNumber();
        carColor = driver.getCar().getColor();
        type = "Driver";
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

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
