package com.devsuperior.dslist.repositories.user;

import com.devsuperior.dslist.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
}
