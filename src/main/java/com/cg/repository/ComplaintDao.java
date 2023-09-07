package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.Bug;
import com.cg.model.Complaint;

@Repository
public interface ComplaintDao extends JpaRepository<Complaint, Integer>{

}
