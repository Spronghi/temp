package com.smart_museum.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController implements ErrorController{

    private static final String PATH = "error";

    @RequestMapping(value = PATH)
    public String error() {
        return "<META http-equiv=\"refresh\" content=\"5;URL=backoffice/login.html\">"
        		+ "<p>Ops! An error occurred! You are been redirected to the home page soon. "
        		+ "<a href=\"backoffice/login.html\">Click there to make it fastest</a></p>";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}