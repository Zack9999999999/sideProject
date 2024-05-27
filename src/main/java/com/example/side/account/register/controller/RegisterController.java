package com.example.side.account.register.controller;

import com.example.side.account.register.dto.RegisterAccount;
import com.example.side.account.register.service.IRegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IRegisterService iRegisterService;

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody RegisterAccount registerAccount) {

        //再補驗證

        int result = iRegisterService.createUser(registerAccount);

        if (result == 1) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
