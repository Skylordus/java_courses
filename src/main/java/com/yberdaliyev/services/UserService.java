package com.yberdaliyev.services;

import com.yberdaliyev.models.forms.LoginForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by yerlan on 5/23/17.
 */
@Service
public class UserService {
    private ArrayList<LoginForm> users = new ArrayList<LoginForm>();

    public UserService() {
        users.add(new LoginForm("user","pass"));
    }

    public String checkLogin(LoginForm form) {

        for (LoginForm user : users) {
            if (user.equals(form)) return "success";
        }
        return "failure";
    }

    public boolean userExists(LoginForm form) {
        if (users.contains(form)) return true;
        return false;
    }

    public void createUser(LoginForm user) {
        users.add(user);
    }

}
