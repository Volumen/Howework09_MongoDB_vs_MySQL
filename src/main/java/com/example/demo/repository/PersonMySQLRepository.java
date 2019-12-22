package com.example.demo.repository;

import com.example.demo.model.PersonMySQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonMySQLRepository extends JpaRepository<PersonMySQL, Long> {
}
