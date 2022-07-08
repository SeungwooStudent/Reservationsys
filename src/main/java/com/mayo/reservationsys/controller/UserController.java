package com.mayo.reservationsys.controller;

import com.mayo.reservationsys.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public String signup(@RequestParam("id") String id, @RequestParam("password") String password) {
        System.out.println("signup!");
        return userService.signup(id, password);
    }

    @PostMapping("/login")
    public String login(@RequestParam("id") String id, @RequestParam("password") String password) {
        System.out.println("login");
        return userService.login(id, password);
    }

}
