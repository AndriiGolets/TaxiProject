package ua.taxi.base.utils;

import ua.taxi.base.model.order.Address;

/**
 * Created by Andrii on 4/30/2016.
 */
public class Utils {

    public static String phoneValidate(String phone) {
        String onlyNumbersPhone = phone.replaceAll("[\\D]+", "");
        if (onlyNumbersPhone.startsWith("38")) {
            onlyNumbersPhone = onlyNumbersPhone.substring(2);
        } else if (onlyNumbersPhone.startsWith("8")) {
            onlyNumbersPhone = onlyNumbersPhone.substring(1);
        }
        if (onlyNumbersPhone.length() != 10 || !onlyNumbersPhone.startsWith("0")) {
            return null;
        }
        return "(" + onlyNumbersPhone.substring(0, 3) +
                ")" + onlyNumbersPhone.substring(3, 6) +
                "-" + onlyNumbersPhone.substring(6, 8) +
                "-" + onlyNumbersPhone.substring(8, 10);
    }

    public static Address addressValidate(String address) {

        String[] arr = address.split(",");
        address = arr[0];
        arr = address.split("\\s(?=([\\d]{1,2}(\\b|\\w\\b)))");
        if (arr.length != 2) {
            return null;
        } else {
            return new Address(arr[0], arr[1]);
        }
    }

    public static String distanceFormat(double distance) {
        return String.format("%3.2f km", distance / 1000);
    }

    public static String priceFormat(double price) {
        return String.format("%3.0f грн.", price);
    }

}
