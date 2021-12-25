package com.group1j.backend.services;

public interface PasswordEncoder {
    public String encode(String password);
    public String decode(String password);
}
