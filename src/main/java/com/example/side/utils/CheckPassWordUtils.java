package com.example.side.utils;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CheckPassWordUtils {

    private static final String REGEXPN = "^(?=.*[az])(?=.*[AZ])(?=.*\\d)(?=.*[@#$%^&+=]).{8,20}$";

    public boolean checkPassWord(String passWord) {

        Pattern pattern = Pattern.compile(REGEXPN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(passWord);

        return matcher.matches();
    }

}
