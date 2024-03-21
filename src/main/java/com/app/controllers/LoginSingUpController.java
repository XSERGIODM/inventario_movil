package com.app.controllers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loginSingUp")
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class LoginSingUpController {
    @GetMapping("/login")
    public String login() {
        return "loginSingup/login";
    }

    @GetMapping("/singUp")
    public String singUp() {
        return "loginSingup/singUp";
    }
}
