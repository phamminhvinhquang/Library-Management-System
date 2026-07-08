package com.example.management_library_system.repository;

import com.example.management_library_system.model.LoanDetail;
import com.example.management_library_system.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LoanDetailRepository extends JpaRepository<LoanDetail, Integer> {
    // Tìm danh sách chi tiết mượn của riêng một độc giả cụ thể
    List<LoanDetail> findByLoanCardBorrower(Account borrower);
}