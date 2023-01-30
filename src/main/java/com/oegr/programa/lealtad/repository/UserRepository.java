package com.oegr.programa.lealtad.repository;

import com.oegr.programa.lealtad.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneById(long id);
    Optional<User> findOneByEmail(String email);
}
