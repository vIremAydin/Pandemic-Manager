package com.group1j.backend.dto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateMessageDTO {
    //Fields
    private String text;
    private String date;
    private int senderID;
    private List<Integer> receiverID;

}
