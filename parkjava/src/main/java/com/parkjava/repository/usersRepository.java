package com.parkjava.repository;


import com.parkjava.model.usersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usersRepository extends JpaRepository<usersModel, Long> {
}