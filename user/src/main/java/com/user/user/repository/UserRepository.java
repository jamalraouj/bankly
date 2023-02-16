package com.user.user.repository;

import com.user.user.entity.TableUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<TableUser, Long>{
    Optional<TableUser> findByEmail(String email);
}
