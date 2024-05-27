package com.example.side.account.login.service.impl;

import com.example.side.account.login.mybatis.LoginMapper;
import com.example.side.account.login.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public void login() {
        loginMapper.login();
    }
}
