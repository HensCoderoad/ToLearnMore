package com.wechat.manager.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author: Hens
 * @DateTime: 2019/12/3 20:22
 * @Description: 加密工具类
 */
public class SignUtil {
    /**
     * 与接口配置中的token一致
      */
    private static String token = "hens";

    /**
     * 验证签名
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce){
        String[] arr = new String[]{token, timestamp, nonce};
        // 按字典排序
        Arrays.sort(arr);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<arr.length;i++){
            stringBuilder.append(arr[i]);
        }
        MessageDigest messageDigest = null;
        String tmpStr = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] digest = messageDigest.digest(stringBuilder.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        stringBuilder = null;
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()):false;
    }

    /**
     * 字符数组转换为16进制字符串
     * @param bytes
     * @return
     */
    private static String byteToStr(byte[] bytes){
        String strDigest= "";
        for (int i = 0; i < bytes.length; i++) {
            strDigest += byteToHexStr(bytes[i]);
        }
        return strDigest;
    }

    /**
     * 字节转换为16进制字符串
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte){
        char[] digit = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        char[] tempArr = new char[2];
        tempArr[0] = digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }
}
