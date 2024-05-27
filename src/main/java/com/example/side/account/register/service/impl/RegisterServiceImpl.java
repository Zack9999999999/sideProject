package com.example.side.account.register.service.impl;

import com.example.side.account.register.dto.RegisterAccount;
import com.example.side.account.register.mybatis.RegisterMapper;
import com.example.side.account.register.service.IRegisterService;
import com.example.side.utils.CheckPassWordUtils;
import com.example.side.utils.EncryptionUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    public int createUser(RegisterAccount registerAccount) {

        //檢查帳號有沒有被創建過
        RegisterAccount account = registerMapper.selectUser(registerAccount.getName());

        if (account == null) {

            String userName = registerAccount.getName();
            String passWord = registerAccount.getPassWord();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date now = new Date();
            String createTime = sdf.format(now);
            registerAccount.setCreateTime(createTime);

            //檢查密碼強度
            boolean verifyPassWord = checkPassWordUtils.checkPassWord(passWord);
            if (!verifyPassWord) {
                logger.info("密碼{}強度太弱", passWord);
                return 0;
            }

            //密碼加密
            String encodedPassword = encryptionUtils.encryptionBCrypt(passWord);
            registerAccount.setPassWord(encodedPassword);

            return registerMapper.createUser(registerAccount);
        }
        logger.info("帳號{}已創建過", account.getName());
        return 0;
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
