package com.example.side.account.service.impl;

import com.example.side.account.dao.LoginMapper;
import com.example.side.account.service.ILoginService;
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
