package com.icc.daelimbada.user.repository;

import com.icc.daelimbada.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    @Query(
            "SELECT u.email " +
                    "FROM User u " +
                    "WHERE u.username=:username"
    )
    String findUserEmailByUsername(@Param("username") String username);
}
