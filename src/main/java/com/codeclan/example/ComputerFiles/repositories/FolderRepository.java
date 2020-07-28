package com.codeclan.example.ComputerFiles.repositories;

import com.codeclan.example.ComputerFiles.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
}
