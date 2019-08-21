package com.fyh.xuanke.util;


import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {

    public static String salt = "springboot";

    public static String md5(String str){

        return DigestUtils.md5Hex(str);
    }


    //第一次MD5加密
    public static String inputToBack(String str){

        return md5(str+salt);
    }


    //第二次MD5加密
    public static String backToDb(String str,String dbSalt){

        return md5(str+salt);
    }


    public static String inputToDb(String str,String dbSalt){

        return backToDb(inputToBack(str),dbSalt);
    }
}
