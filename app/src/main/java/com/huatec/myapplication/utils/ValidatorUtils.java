package com.huatec.myapplication.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证工具
 */
public class ValidatorUtils {

    /**
     * 判断密码格式是否正确
     *
     * @param password 密码
     */
    public static boolean isPassword(String password) {
        String str = "^[a-zA-Z]\\w{5,17}$";//字母、数字、下划线组成，字母开头，6-18位
        return matcher(str, password);
    }

    /**
     * 判断email格式是否正确
     *
     * @param email 邮箱
     */
    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 验证用户名
     *
     * @param userName 用户名
     */
    public static boolean isUserName(String userName) {
        String validateStr = "^[\\u4e00-\\u9fff\\w]{3,16}$";//字母、数字、中文、下划线组成，3-16位
        return matcher(validateStr, userName);
    }

    private static boolean matcher(String reg, String string) {
        boolean tem;
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(string);
        tem = matcher.matches();
        return tem;
    }


}
