package com.tomo.springmicroservice.springmicroservice.jpa;

import com.tomo.springmicroservice.springmicroservice.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
