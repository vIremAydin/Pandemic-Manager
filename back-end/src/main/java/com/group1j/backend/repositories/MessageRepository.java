package com.group1j.backend.repositories;

import com.group1j.backend.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {

    //@Query("SELECT x FROM Message x WHERE x.messageID = ?1")
    Optional<Message> findByMessageId(Integer messageID);

    //@Query("SELECT x FROM Message x WHERE x.senderID = ?1")
    Optional<Message> findBySenderId(Integer senderID);

    //@Query("SELECT x FROM Message x WHERE x.?? = ?1")
    //Optional<Message> findByReceiverId(Integer? ?); //receiverID is list
}
