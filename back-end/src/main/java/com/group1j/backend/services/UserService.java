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
    PasswordEncoder passwordEncoder;
    static SecretKey key;
    static IvParameterSpec iv;

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

    public static SecretKey generateKey(int n) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(n);
        SecretKey key = keyGenerator.generateKey();
        return key;
    }

    public static IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

}
