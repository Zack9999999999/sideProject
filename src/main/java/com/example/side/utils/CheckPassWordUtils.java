package com.example.side.utils;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CheckPassWordUtils {

    private static final String REGEXPN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,20}$";

    public boolean checkPassWord(String passWord) {

        Pattern pattern = Pattern.compile(REGEXPN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(passWord);

        return matcher.matches();
    }

    public static void main(String[] args) {
        String x = "@Ss1234567";

        CheckPassWordUtils checkPassWordUtils = new CheckPassWordUtils();

        System.out.println(checkPassWordUtils.checkPassWord(x));
    }

}
