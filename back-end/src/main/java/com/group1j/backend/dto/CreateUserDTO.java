package com.group1j.backend.dto;

import lombok.Data;

@Data
public class CreateUserDTO {
    //Fields
    private int id;
    private String name;
    private String email;
    private String password;
    private String hesCode;
}
