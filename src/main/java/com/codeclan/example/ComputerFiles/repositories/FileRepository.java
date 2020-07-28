package com.codeclan.example.ComputerFiles.repositories;

import com.codeclan.example.ComputerFiles.models.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
}
