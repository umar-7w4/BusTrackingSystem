package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.Bug;

@Repository
public interface BugDao extends JpaRepository<Bug, Integer>{


}
