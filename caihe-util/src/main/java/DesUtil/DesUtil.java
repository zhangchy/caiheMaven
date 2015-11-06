package DesUtil;

import java.io.IOException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DesUtil{  
    public static byte[] desEncrypt(byte[] plainText,String desKey) throws Exception {  
        SecureRandom sr = new SecureRandom();  
        byte rawKeyData[] = desKey.getBytes();    
        DESKeySpec dks = new DESKeySpec(rawKeyData);  
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
        SecretKey key = keyFactory.generateSecret(dks);  
        Cipher cipher = Cipher.getInstance("DES");  
        cipher.init(Cipher.ENCRYPT_MODE, key, sr);  
        byte data[] = plainText;  
        byte encryptedData[] = cipher.doFinal(data);  
        return encryptedData;  
    }  
  
    public static byte[] desDecrypt(byte[] encryptText,String desKey) throws Exception {  
        SecureRandom sr = new SecureRandom();  
        byte rawKeyData[] = desKey.getBytes(); 
        DESKeySpec dks = new DESKeySpec(rawKeyData);  
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
        SecretKey key = keyFactory.generateSecret(dks);  
        Cipher cipher = Cipher.getInstance("DES");  
        cipher.init(Cipher.DECRYPT_MODE, key, sr);  
        byte encryptedData[] = encryptText;  
        byte decryptedData[] = cipher.doFinal(encryptedData);  
        return decryptedData;  
    }  
  
    public static String encrypt(String input,String deskey) throws Exception {  
        return base64Encode(desEncrypt(input.getBytes(),deskey));  
    }  
  
    public static String decrypt(String input,String deskey) throws Exception {  
        byte[] result = base64Decode(input);  
        return new String(desDecrypt(result,deskey));  
    }  
  
    public static String base64Encode(byte[] s) {  
        if (s == null)  
            return null;  
        BASE64Encoder b = new sun.misc.BASE64Encoder();  
        return b.encode(s);  
    }  
  
    public static byte[] base64Decode(String s) throws IOException {  
        if (s == null)  
            return null;  
        BASE64Decoder decoder = new BASE64Decoder();  
        byte[] b = decoder.decodeBuffer(s);  
        return b;  
    }  
  
    public static void main(String[] args) throws Exception {  
        String key = "fxro45L7SYj6guWGV1csFi1imyV3dLeF";  
        System.out.println("Decode:" + DesUtil.decrypt("4556",key));  
    }  
} 
