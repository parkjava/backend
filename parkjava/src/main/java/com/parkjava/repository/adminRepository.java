package com.parkjava.repository;

import com.parkjava.model.adminModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface adminRepository extends JpaRepository<adminModel, Long> {

    @Query(value = "SELECT * FROM parkJavaAdmin where parkJavaAdmin.admin_index =1", nativeQuery = true)
    List<adminModel> find1Admin();


}