package com.yberdaliyev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yerlan on 5/20/17.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    private String index() {
        return "/login";
    }
}
