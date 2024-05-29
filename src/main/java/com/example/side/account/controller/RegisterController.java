package com.example.side.account.controller;

import com.example.side.account.dto.RegisterAccountRequest;
import com.example.side.account.model.Account;
import com.example.side.account.service.IRegisterService;
import com.example.side.vo.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RegisterController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IRegisterService iRegisterService;

    @PostMapping("/createUser")
    public RestResult<Map<String, Object>> createUser(@RequestBody RegisterAccountRequest registerAccountRequest) {

        Map<String, Object> map = new HashMap<>();

        Account user = iRegisterService.createUser(registerAccountRequest);
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("name", user.getName());
        userMap.put("email", user.getEmail());

        logger.info("會員:{},創建成功", user.getName());
        map.put("code", RestResult.SUCCESS);
        map.put("msg", "創建成功");
        map.put("data", userMap);
        return RestResult.getRestResult(map);
    }
}
