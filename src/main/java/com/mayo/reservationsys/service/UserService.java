package com.mayo.reservationsys.service;

import com.mayo.reservationsys.entity.User;
import com.mayo.reservationsys.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public String signup(String id, String password) {
        try {
            String encodePassword = passwordEncoder.encode(password);
            User user = User.builder().id(id).password(encodePassword).build();
            userRepository.save(user);
            return "ok";

        } catch (Exception e) {
            System.out.println("err : " + e.getMessage());
            return e.getMessage();
        }
    }

    public String login(String id, String password) {
        User user = userRepository.findUserById(id);
        boolean check = passwordEncoder.matches(password, user.getPassword());
        return check == true ? "success login" : "fail login";
    }
}
