package com.example.repository;

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
    
    @Query("from account where username = :username and password = :password")
    public Account getLogin(@Param("username") String username, @Param ("password")String password);

    @Query("insert into account(username,password) values(:username, :password)")
    public Account addUser(@Param("username")String username, @Param("password") String password);
    
    @Query("from account where username =:username")
    public <T> Optional<T> getUsername(@Param("username") String username);
}
