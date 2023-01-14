package com.example.springsecuritysample.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springsecuritysample.entity.LoginUser;

@Repository
public interface LoginUserRepository extends JpaRepository<LoginUser, Long> {
    Optional<LoginUser> findByEmail(String email);
}
