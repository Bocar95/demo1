package com.example.demo.rest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController {

    // @RequestMapping("/error")
    // public String handleError() {
    //     // Redirige vers votre page d'erreur personnalisée
    //     return "error/404";
    // }


}

