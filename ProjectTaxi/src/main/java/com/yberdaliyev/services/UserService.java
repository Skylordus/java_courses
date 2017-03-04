package com.yberdaliyev.services;

import com.yberdaliyev.models.daos.*;
import com.yberdaliyev.models.pojos.Admin;
import com.yberdaliyev.models.pojos.Client;
import com.yberdaliyev.models.pojos.Driver;
import com.yberdaliyev.models.pojos.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

/**
 * Created by Yerlan on 26.02.2017.
 */
@Service
public class UserService implements IUserService {

    static Logger logger = Logger.getLogger(UserService.class);

    private final IUserDAO IUserDAO;
    private final IAdminDAO IAdminDAO;
    private final IClientDAO IClientDAO;
    private final IDriverDAO IDriverDAO;

    @Autowired
    public UserService(IUserDAO IUserDAO, IAdminDAO IAdminDAO, IClientDAO IClientDAO, IDriverDAO IDriverDAO) {
        this.IUserDAO = IUserDAO;
        this.IAdminDAO = IAdminDAO;
        this.IClientDAO = IClientDAO;
        this.IDriverDAO = IDriverDAO;
    }

    public void register(String user_role,
                         String user_name,
                         String user_surname,
                         String user_patronymic,
                         String user_birthdate,
                         String user_login,
                         String user_password,
                         String user_email) {

        User user = null;

        if (user_role.equals("client")) {
            user = new Client();
        } else if (user_role.equals("driver")) {
            user = new Driver();
        } else if (user_role.equals("admin")) {
            user = new Admin();
        }

        user.setFirstname( user_name );
        user.setLastname( user_surname );
        user.setPatronymic( user_patronymic );
        if (!user_birthdate.isEmpty()) user.setBirthdate(Date.valueOf(user_birthdate));
        user.setLogin( user_login );
        user.setPwd( user_password );
        user.setEmail( user_email );

        if (user_role.equals("client")) {
            Client client = (Client) user;
            client.setDate_registered(new Date(new java.util.Date().getTime()));
            client.setOrders_amount((long)0);
            IClientDAO.insert(client);
        } else if (user_role.equals("driver")) {
            Driver driver = (Driver) user;
            driver.setCar((long)0);
            driver.setExperience_years((long)0);
            IDriverDAO.insert(driver);
        } else if (user_role.equals("admin")) {
            Admin admin = (Admin) user;
            IAdminDAO.insert(admin);
        }
    }

    public User authorize(String login, String password) {

        User user = IUserDAO.getByLoginAndPassword(login, password);

        return user;
    }
}
