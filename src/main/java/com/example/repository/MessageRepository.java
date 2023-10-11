package com.example.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Account;
import com.example.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer>{

    //@Query("select m from Message m")
    List<Message> findAll();

   // @Query("from message where id = :id")
    //Message findByMessageId(@Param("id") int id);
    
    /*  
    @Transactional
    @Query(value="UPDATE message SET message_text = :text WHERE message_id = :id")
    int updateMessageText(@Param("id") int id, @Param("text") String newText);
    */
}
