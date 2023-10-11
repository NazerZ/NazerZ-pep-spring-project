package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    //account login
    // account register

    //@Query("SELECT a FROM account a WHERE a.username = :username")
    public Account findByUsername(@Param("username")String username);
    
    public Account findByUsernameAndPassword(String username, String password);
    
}
