package com.mleiva.relacionesjpa.repository;

import com.mleiva.relacionesjpa.entity.OneToOne.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
