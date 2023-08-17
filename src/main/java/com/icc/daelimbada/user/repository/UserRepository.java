package com.icc.daelimbada.user.repository;

import com.icc.daelimbada.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
