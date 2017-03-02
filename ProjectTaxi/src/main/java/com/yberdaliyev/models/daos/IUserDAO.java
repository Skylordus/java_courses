package com.yberdaliyev.models.daos;

import com.yberdaliyev.models.pojos.User;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Yerlan on 02.03.2017.
 */

public interface IUserDAO {
    PreparedStatement insert(String statement, User user);

    User getByLoginAndPassword(String login, String password);

    void setFields(User user, ResultSet rs) throws SQLException;
}
