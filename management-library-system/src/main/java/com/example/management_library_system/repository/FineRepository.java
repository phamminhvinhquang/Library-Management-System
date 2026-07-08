package com.example.management_library_system.repository;

import com.example.management_library_system.model.Fine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FineRepository extends JpaRepository<Fine, Integer> {
    // Kế thừa toàn bộ các hàm CRUD mặc định (findAll, save, delete,...) từ JpaRepository
}