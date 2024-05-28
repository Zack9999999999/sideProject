package com.example.side.account.controller;

import com.example.side.account.dto.RegisterAccountRequest;
import com.example.side.account.service.IRegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RegisterController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IRegisterService iRegisterService;

    @PostMapping("/createUser")
    public Map<String, Object> createUser(@RequestBody RegisterAccountRequest registerAccountRequest) {

        //再補驗證

        return iRegisterService.createUser(registerAccountRequest);
    }
}
