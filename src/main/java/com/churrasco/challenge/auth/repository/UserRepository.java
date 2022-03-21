package com.churrasco.challenge.auth.repository;

import com.churrasco.challenge.auth.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByUsername(String username);

    UserEntity findByUsernameOrEmail(String username, String email);

}
