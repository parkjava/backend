package com.parkjava.repository;

import com.parkjava.model.userModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface userRepository extends JpaRepository<userModel, Long> {

    @Query(value = "SELECT * FROM  USERS where users.user_index =1", nativeQuery = true)
    List<userModel> find1User();

}