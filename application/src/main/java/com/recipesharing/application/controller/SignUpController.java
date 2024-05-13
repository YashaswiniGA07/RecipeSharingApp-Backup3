package com.recipesharing.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.recipesharing.application.dto.SignUpDTO;
import com.recipesharing.application.dto.UserDTO;
import com.recipesharing.application.service.AuthService;



@Controller
@RequestMapping("/signUp")
public class SignUpController {

    @Autowired
    private AuthService authService;

    @PostMapping()
    public ResponseEntity<?> signupUser(@RequestBody SignUpDTO signupDTO) {
       UserDTO createdUser = authService.createUser(signupDTO);
       if (createdUser == null){
           return new ResponseEntity<>("User not created, come again later!", HttpStatus.BAD_REQUEST);
       }
       return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

}