package com.group1j.backend.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Message {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int messageID;

    private String text;
    private String date;
    private int senderID;

    @ElementCollection
    @CollectionTable(name = "receiver_list", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "receiver_id")
    private List<Integer> receiverID;

    //Default Constructor
    public Message(){

    }

    //Constructor
    public Message(String text, String date, int senderID, List<Integer> receiverID) {
        this.text = text;
        this.date = date;
        this.senderID = senderID;
        this.receiverID = receiverID;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public List<Integer> getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(List<Integer> receiverID) {
        this.receiverID = receiverID;
    }
}
