package com.example.studentcrudproject.utility;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class security {
    private static final String key = "yourEncryptKey12";
    private static final String initVector = "yourEncryptKey12";
    public static void main(String ar[])
    {
        System.out.println("Enter text");
       String data = new Scanner(System.in).next();
       String encryptedData = security.Encrypted(key, initVector, data);
       System.out.println("Encrypted data >> "+encryptedData);
       String decryptedData = security.Decrypted(key, initVector, encryptedData);
       System.out.println("Decrypted data >> "+decryptedData);
    }

    private static String Encrypted(String key, String initVector, String data) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"),"AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private static String Decrypted(String key, String initVector, String data) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"),"AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}