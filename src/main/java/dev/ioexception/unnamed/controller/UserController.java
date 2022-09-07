package dev.ioexception.unnamed.controller;

import dev.ioexception.unnamed.domain.User;
import dev.ioexception.unnamed.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    UserService userService;

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }


}
