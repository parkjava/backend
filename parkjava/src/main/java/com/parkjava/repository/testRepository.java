package com.parkjava.repository;


import com.parkjava.model.test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface testRepository extends JpaRepository<test, Long> {
}