package com.example.side.utils;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class EncryptionUtils {

    public String encryptionBCrypt(String passWord) {
        return BCrypt.hashpw(passWord, BCrypt.gensalt());
    }

    public void encryptionMD5(){

    }

    public void EncryptionAES(){

    }

    public void EncryptionSHA(){

    }

    public void EncryptionRSA(){

    }
}
