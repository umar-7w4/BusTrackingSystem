package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.Staff;
import com.cg.model.Task;

@Repository
public interface TaskDao  extends JpaRepository<Task, Integer>{

}

