package ua.taxi.server.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.taxi.base.model.user.*;

import ua.taxi.base.model.order.Address;
import ua.taxi.server.dao.UserDao;

import javax.persistence.PersistenceException;

/**
 * Created by serhii on 23.04.16.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

    public UserServiceImpl() {
    }

    @Override
    public UserValidateMessage register(String phone, String pass, String name, Address homeAdress) {

        try {
            User passenger = new Passenger(phone, pass, name, homeAdress);
            userDao.createUser(passenger);
            LOGGER.trace("register: " + passenger);
            return new UserValidateMessage(true, "Create UserValidateMessage", "Create new Passenger\n" + passenger, passenger);
        } catch (Exception e) {
            LOGGER.warn(("register: user with this phone is already registered"));
            return new UserValidateMessage(false, "Create UserValidateMessage", "user with this phone\n" +
                    " is already registered", null);
        }
    }

    @Override
    public UserValidateMessage register(String phone, String pass, String name, Car car) {

        try {
            User driver = new Driver(phone, pass, name, car);
            userDao.createUser(driver);
            LOGGER.trace("register: " + driver);
            return new UserValidateMessage(true, "Create UserValidateMessage", "Create new driver\n" + driver, driver);
        } catch (Exception e) {
            LOGGER.warn("register: user with this phone is already registered" + e);
            return new UserValidateMessage(false, "Create UserValidateMessage", "user with this phone\n" +
                    " is already registered ", null);
        }
    }

    @Override
    public int driverRegisteredQuantity() {

        int count = userDao.driverRegisteredQuantity();
        LOGGER.trace("driverRegisteredQuantity: " + count);
        return count;
    }

    @Override
    public int passangerRegisteredQuantity() {

        int count = userDao.passengerRegisteredQuantity();
        LOGGER.trace("passengerRegisteredQuantity: " + count);
        return count;
    }

    @Override
    public UserValidateMessage login(String phone, String pass) {

        try {
            User user = userDao.getUser(phone);
            if (user.getPass().equals(pass)) {
                LOGGER.trace("login: " + user);
                return new UserValidateMessage(true, "login UserValidateMessage", "Pass is Ok", user);
            }
        } catch (PersistenceException e) {
        }
        LOGGER.warn(("login Warning. Input is incorrect"));
        return new UserValidateMessage(false, "login Warning", "Input is incorrect", null);
    }


    @Override
    public UserValidateMessage changePassanger(String phone, String pass, String name, Address homeAdress) {

        try {
            User passanger = new Passenger(phone, pass, name, homeAdress);
            User oldPassanger = userDao.update(passanger);
            LOGGER.trace("changePassanger: new" + passanger + "; old: " + oldPassanger);
            return new UserValidateMessage(true, "Change passenger", "Old user:\n" + oldPassanger, passanger);
        } catch (PersistenceException e) {
            LOGGER.warn(("Change passenger Warning, user with this phone not present"));
            return new UserValidateMessage(false, "Change passenger error", "user with this phone\n" +
                    " is not present", null);
        }
    }

    @Override
    public UserValidateMessage changeDriver(String phone, String pass, String name, Car car) {

        try {
            User driver = new Driver(phone, pass, name, car);
            User oldDriver = userDao.update(driver);
            LOGGER.trace("changeDriver: new" + driver + "; old: " + oldDriver);
            return new UserValidateMessage(true, "Change driver", "Old user:\n" + oldDriver, driver);
        } catch (PersistenceException e) {

            LOGGER.warn(("Change driver Warning, user with this phone not present"));
            return new UserValidateMessage(false, "Change driver error", "user with this phone\n" +
                    " is not present", null);
        }
    }

    @Override
    public UserValidateMessage getUser(String phone) {

        try {
            User user = userDao.getUser(phone);
            LOGGER.trace("getUser: " + user);
            return new UserValidateMessage(true, "Change passenger", "Old user:\n" + user, user);
        } catch (PersistenceException e) {
            LOGGER.warn(("getUser Warning, user with this phone not present"));
            return new UserValidateMessage(false, "Change passenger error", "user with this phone\n" +
                    " is not present", null);
        }
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
