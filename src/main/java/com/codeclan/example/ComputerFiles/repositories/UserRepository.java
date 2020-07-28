package com.codeclan.example.ComputerFiles.repositories;

import com.codeclan.example.ComputerFiles.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
