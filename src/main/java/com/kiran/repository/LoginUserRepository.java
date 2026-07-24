package com.kiran.repository;

import com.kiran.Entity.LoginEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginUserRepository extends JpaRepository<User,Long> {


    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndDeletedIsFalse(String email);

    boolean existsByEmailAndDeletedIsFalse(String email);

}
