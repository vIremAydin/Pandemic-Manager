package com.group1j.backend.services;

import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Service
public class UserService {
    //Fields
    PasswordEncoder passwordEncoder;
    static SecretKey key;
    static IvParameterSpec iv;

    /**
     * Method to encode user's password.
     * @param password
     * @param num
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidAlgorithmParameterException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws InvalidKeyException
     */
    public String encode(String password, int num) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        String encoded = "";
        if(num == 0){
            passwordEncoder = new CeaserCipher();
        }
        else{
            passwordEncoder = new AES();
        }
        if(key == null && iv == null){
            key = generateKey(128);
            iv = generateIv();
        }
        encoded = passwordEncoder.encode(password,key,iv);
        return encoded;
    }

    /**
     * Method to decode user's password
     * @param password
     * @param num
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidAlgorithmParameterException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws InvalidKeyException
     */
    public String decode(String password, int num) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        String decoded = "";
        if(num == 0){
            passwordEncoder = new CeaserCipher();
        }
        else{
            passwordEncoder = new AES();
        }
        decoded = passwordEncoder.decode(password,key,iv);
        return decoded;
    }

    /**
     * It generates key for AES operation
     * @param n
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static SecretKey generateKey(int n) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(n);
        SecretKey key = keyGenerator.generateKey();
        return key;
    }

    /**
     * It generates iv for AES operation
     * @return
     */
    public static IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

}
