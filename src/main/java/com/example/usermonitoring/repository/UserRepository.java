package com.example.usermonitoring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.usermonitoring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<User, Long> {


    // JPQL Query
    @Query("select u from User u where u.nationalId = :nationalId")
    User findByNationalId(
            @Param("nationalId") String nationalId
    );

    // Native Query
    @Query(
            value = "select * from users where national_id = :nationalId",
            nativeQuery = true
    )
    User findNativeByNationalId(
            @Param("nationalId") String nationalId
    );

}