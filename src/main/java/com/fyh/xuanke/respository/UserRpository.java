package com.fyh.xuanke.respository;

import com.fyh.xuanke.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRpository extends JpaRepository<User,String>{

//    public User findByUsernameAndPassword(String username,String password);
         public User findByUsername(String username);
}
