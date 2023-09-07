package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer>{

}
