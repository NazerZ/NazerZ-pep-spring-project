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

    List<Message> findAll();
    
    @Query("SELECT m FROM Message m WHERE m.posted_by = :account_id")
    List<Message> getMessagesByAccountId(@Param("account_id") Integer account_id);
}
