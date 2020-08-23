package com.practice.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.demo.model.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student,Integer> {
	 List < Student > findAll();
}
