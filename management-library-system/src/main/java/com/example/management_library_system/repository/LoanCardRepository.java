package com.example.management_library_system.repository;

import com.example.management_library_system.model.LoanCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanCardRepository extends JpaRepository<LoanCard, Integer> {
}