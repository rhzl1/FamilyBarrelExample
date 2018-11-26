package com.example.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 */
public class MD5Util {

    /**
     * MD5验签
     * @param src 密码 未加密
     * @param code 加密后密文
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    static public boolean verify(String src, String code) {
        try {
            MessageDigest md5 = null;
            byte[] byteArray = null;
            md5 = MessageDigest.getInstance("MD5");
            byteArray = src.getBytes("UTF-8");
            byte[] md5Bytes = md5.digest(byteArray);

            StringBuffer hexValue = getBuffer(md5Bytes);

            return hexValue.toString().equals(code);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }

    /***
     * MD5加密
     * @param src 代加密串
     * @param charset 加密格式
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    static public String MD5Encode(String src, String charset){
        try {
            MessageDigest md5 = null;
            md5 = MessageDigest.getInstance("MD5");

            byte[] byteArray = null;

            byteArray = src.getBytes(charset);

            byte[] md5Bytes = md5.digest(byteArray);

            StringBuffer hexValue = getBuffer(md5Bytes);

            return hexValue.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    static private StringBuffer getBuffer(byte[] md5Bytes){
        StringBuffer hexValue = new StringBuffer(32);
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue;
    }
}
