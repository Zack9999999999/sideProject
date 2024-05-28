package com.example.side.account.controller;

import com.example.side.account.service.ILoginService;
import com.example.side.account.dto.LoginRequest;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ILoginService iLoginService;

    //登入
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        String loginName = loginRequest.getLoginName();
        String loginPassWord = loginRequest.getLoginPassWord();

        Map<String, Object> map = new HashMap<>();
        map.put("loginName", loginName);
        map.put("loginPassWord", loginPassWord);

        iLoginService.login();

        boolean check = checkLogin(map);

        if (check) {
            logger.info("使用者{},登入成功", loginName);
            return ResponseEntity.status(HttpStatus.OK).body(map);
        } else {
            logger.warn("使用者{},登入失敗", loginName);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    //登出
    @PostMapping("/loginout")
    public ResponseEntity<?> loginOut() {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    //檢查帳密
    public boolean checkLogin(Map<String, Object> checkMap) {

        String name = "sgps5555";
        String pwd = "fab18667b56b6803c1e5d33e4a6cf228"; //123

        String loginName = (String) checkMap.get("loginName");
        String loginPassWord = (String) checkMap.get("loginPassWord");

        String hashedPwd = "";
        hashedPwd = DigestUtils.md5DigestAsHex((loginPassWord).getBytes());
        for(int i = 0; i < 10; i++){
            hashedPwd = DigestUtils.md5DigestAsHex((hashedPwd).getBytes());
        }
        logger.info("加密後為:{}", hashedPwd);

        if (name.equals(loginName) && pwd.equals(hashedPwd)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
