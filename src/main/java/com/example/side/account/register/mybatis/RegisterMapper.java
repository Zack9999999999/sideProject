package com.example.side.account.register.mybatis;

import com.example.side.account.register.dto.RegisterAccount;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {

    int createUser(RegisterAccount registerAccount);

    RegisterAccount selectUser(String name);

}
