package com.example.side.account.service;

import com.example.side.account.dto.RegisterAccountRequest;
import com.example.side.account.model.Account;

import java.util.Map;

public interface IRegisterService {

    Account createUser(RegisterAccountRequest registerAccountRequest);

}
