package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.Task;
import com.cg.model.User;

@Repository
public interface UserDao  extends JpaRepository<User, Integer>{

}

