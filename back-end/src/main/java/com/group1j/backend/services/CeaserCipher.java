package com.group1j.backend.services;

public class CeaserCipher implements PasswordEncoder{
    private static final int key = 8;

    @Override
    public String encode(String password) {
        String encrypted = "";
        char ch;
        for(int i = 0; i < password.length(); ++i){
            ch = password.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                ch = (char)(ch + key);

                if(ch > 'z'){
                    ch = (char)(ch - 'z' + 'a' - 1);
                }

                encrypted += ch;
            }
            else if(ch >= 'A' && ch <= 'Z'){
                ch = (char)(ch + key);

                if(ch > 'Z'){
                    ch = (char)(ch - 'Z' + 'A' - 1);
                }

                encrypted += ch;
            }
            else {
                encrypted += ch;
            }
        }

        return encrypted;
    }

    @Override
    public String decode(String password) {
        String decrypted = "";
        char ch;
        for(int i = 0; i < password.length(); ++i){
            ch = password.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                ch = (char)(ch - key);

                if(ch < 'a'){
                    ch = (char)(ch + 'z' - 'a' + 1);
                }

                decrypted += ch;
            }
            else if(ch >= 'A' && ch <= 'Z'){
                ch = (char)(ch - key);

                if(ch < 'A'){
                    ch = (char)(ch + 'Z' - 'A' + 1);
                }

                decrypted += ch;
            }
            else {
                decrypted += ch;
            }
        }
        return decrypted;
    }
}
