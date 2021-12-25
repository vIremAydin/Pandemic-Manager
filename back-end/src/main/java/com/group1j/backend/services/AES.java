package com.group1j.backend.services;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES implements PasswordEncoder{

    //Constructor
    public AES() throws NoSuchAlgorithmException {

    }

    /**
     * Encode purposes
     * @param password
     * @param key
     * @param iv
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    @Override
    public String encode(String password,SecretKey key,IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            cipher.init(Cipher.ENCRYPT_MODE,key ,iv );
            byte[] cipherText = cipher.doFinal(password.getBytes());
            return Base64.getEncoder()
                    .encodeToString(cipherText);
    }

    /**
     * Decode purposes
     * @param password
     * @param key
     * @param iv
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    @Override
    public String decode(String password,SecretKey key,IvParameterSpec iv)throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] plainText = cipher.doFinal(Base64.getDecoder()
                .decode(password));
        return new String(plainText);
    }

}
