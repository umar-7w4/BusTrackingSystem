package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.Complaint;
import com.cg.model.Staff;


@Repository
public interface StaffDao extends JpaRepository<Staff, Integer>{


}
