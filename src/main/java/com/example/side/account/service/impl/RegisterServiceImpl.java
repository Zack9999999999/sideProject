package com.example.side.account.service.impl;

import com.example.side.account.dto.RegisterAccountRequest;
import com.example.side.account.dao.RegisterMapper;
import com.example.side.account.model.Account;
import com.example.side.account.service.IRegisterService;
import com.example.side.utils.CheckPassWordUtils;
import com.example.side.utils.EncryptionUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class RegisterServiceImpl implements IRegisterService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RegisterMapper registerMapper;

    @Autowired
    private EncryptionUtils encryptionUtils;

    @Autowired
    private CheckPassWordUtils checkPassWordUtils;

    @Override
    public Map<String, Object> createUser(RegisterAccountRequest registerAccountRequest) {
        Map<String, Object> map = new HashMap<>();

        String userName = registerAccountRequest.getName();
        String passWord = registerAccountRequest.getPassWord();

        //檢查帳號有沒有被創建過
        if (registerMapper.selectUser(userName) == null) {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date now = new Date();
            String createTime = sdf.format(now);
            registerAccountRequest.setCreateTime(createTime);

            //檢查密碼強度
            boolean verifyPassWord = checkPassWordUtils.checkPassWord(passWord);
            if (!verifyPassWord) {
                logger.error("密碼{}強度太弱", passWord);
                map.put("code", "error");
                map.put("msg", "密碼強度太弱");
                return map;
            }

            //密碼加密
            String encodedPassword = encryptionUtils.encryptionBCrypt(passWord);
            registerAccountRequest.setPassWord(encodedPassword);

            //dto -> vo
            Account account = new Account();
            BeanUtils.copyProperties(registerAccountRequest, account);

            registerMapper.createUser(account);

            map.put("code", "success");
            map.put("msg", "註冊成功");
            return map;
        }
        logger.error("帳號{}已創建過", registerAccountRequest.getName());
        map.put("code", "error");
        map.put("msg", "帳號已創建過");
        return map;
    }

    public static void main(String[] args) {

        String pwd = "123456";
        //加密
        String hashpw = BCrypt.hashpw(pwd, BCrypt.gensalt());
        System.out.println(hashpw);

        //驗證
        boolean checkpw = BCrypt.checkpw(pwd, hashpw);
        System.out.println(checkpw);
    }

}
