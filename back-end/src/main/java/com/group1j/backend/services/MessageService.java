package com.group1j.backend.services;

import com.group1j.backend.dto.CreateMessageDTO;
import com.group1j.backend.dto.CreateUserDTO;
import com.group1j.backend.dto.UserLoginDTO;
import com.group1j.backend.entities.*;
import com.group1j.backend.repositories.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    private MessageRepository messageRepository;

    //Constructor
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    /**
     * Method for returning all of the students in the system
     * @return
     */
    public List<Message> getAllMessages(){
        return messageRepository.findAll();
    }

    //public Appointment createAppointment(CreateUserDTO createUserDTO){} //TODO

    public Optional<Message> findByMessageid(Integer id){
        return messageRepository.findByMessageID(id);
    }

    public MessageRepository getMessageRepository() {
        return messageRepository;
    }

    public void setMessageRepository(MessageRepository MessageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message createMessage(CreateMessageDTO createMessageDTO) {
        Message m = new Message();
        m.setDate(createMessageDTO.getDate());
        m.setReceiverID(createMessageDTO.getReceiverID());
        m.setText(createMessageDTO.getText());
        messageRepository.save(m);
        return m;
    }
}
