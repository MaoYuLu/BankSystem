package com.myl.bank.util;


/**
 * @author MaoYulu
 *对数据进行MD5加密
 */
public class MD5Util {
	  public String encode(byte[] source) {  
        String s = null;  
        //将字节转换成16进制表示的字符
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };  
        try {  
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");  
            md.update(source);  
            //计算结果是一个128位的长整数o
            byte tmp[] = md.digest();  
            System.out.println();
            //
            char str[] = new char[16 * 2];   
            int k = 0;   
            for (int i = 0; i < 16; i++) {   
                byte byte0 = tmp[i];   
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];   
                str[k++] = hexDigits[byte0 & 0xf];   
            }  
            s = new String(str);   
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return s;  
    }  
      
    public String getMD5(String source) {  
        return (source == null || "".equals(source)) ? "" : encode(source.getBytes());  
    }  
}