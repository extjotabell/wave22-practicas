package com.example.relacionesjpa.repository;

import com.example.relacionesjpa.entity.OneToOne.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findById(Long id);
}
