package com.myl.bank.util;


/**
 * @author MaoYulu
 *�����ݽ���MD5����
 */
public class MD5Util {
	  public String encode(byte[] source) {  
        String s = null;  
        //���ֽ�ת����16���Ʊ�ʾ���ַ�
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };  
        try {  
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");  
            md.update(source);  
            //��������һ��128λ�ĳ�����o
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