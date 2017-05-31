package com.yberdaliyev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yerlan on 5/20/17.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    private String index() {
        return "/login";
    }

    @RequestMapping("downloadPDF")
    private ModelAndView downloadPdf() {
        return new ModelAndView("downloadPdfPage");
    }
}
