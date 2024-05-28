package com.example.side.account.service;

import com.example.side.account.dto.RegisterAccountRequest;

import java.util.Map;

public interface IRegisterService {

    Map<String, Object> createUser(RegisterAccountRequest registerAccountRequest);

}
