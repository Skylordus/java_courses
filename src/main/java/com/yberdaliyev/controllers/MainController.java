package com.yberdaliyev.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yerlan on 5/20/17.
 */
@Controller
public class MainController {
    private static final Logger logger = Logger.getLogger(MainController.class);

    @RequestMapping("/")
    private String index() {
        logger.error("hoho");
        return "redirect:login-flow";
    }

    @RequestMapping("downloadPDF")
    private ModelAndView downloadPdf() {
        return new ModelAndView("downloadPdfPage");
    }
}
