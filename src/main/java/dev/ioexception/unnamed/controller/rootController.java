package dev.ioexception.unnamed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class rootController {

    @GetMapping("/")
    public String root() {
        return "index";
    }
}
