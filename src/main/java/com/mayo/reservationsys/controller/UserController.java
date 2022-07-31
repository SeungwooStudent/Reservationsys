package com.mayo.reservationsys.controller;

import com.mayo.reservationsys.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequiredArgsConstructor
@Api(tags = {"회원가입 & 로그인"})
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    @ApiOperation(value = "회원가입", notes = "회원가입")
    public String signup(@RequestParam("id") String id, @RequestParam("password") String password) {
        System.out.println("signup!");
        return userService.signup(id, password);
    }

    @PostMapping("/login")
    @ApiOperation(value = "로그인", notes = "로그인")
    public String login(@RequestParam("id") String id, @RequestParam("password") String password) {
        System.out.println("login");
        return userService.login(id, password);
    }

}
