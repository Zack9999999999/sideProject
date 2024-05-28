package com.example.side.account.dao;

import com.example.side.account.dto.RegisterAccountRequest;
import com.example.side.account.model.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {

    void createUser(Account account);

    Account selectUser(String name);

}
