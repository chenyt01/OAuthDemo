package com.demo.userservice.dao;



import com.demo.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
