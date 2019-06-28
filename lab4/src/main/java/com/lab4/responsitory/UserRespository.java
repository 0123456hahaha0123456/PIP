package com.lab4.responsitory;

import com.lab4.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRespository extends JpaRepository<User,Long> {
    User findByUserName(String name);

}
