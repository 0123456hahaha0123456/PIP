package com.lab4.responsitory;

import com.lab4.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRespository extends JpaRepository<User,Long> {
    User findByUsername(String name);

}
