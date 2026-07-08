package com.example.management_library_system.controller;

import com.example.management_library_system.model.Fine;
import com.example.management_library_system.repository.FineRepository; // Đảm bảo bạn đã tạo FineRepository tương ứng
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fines")
@CrossOrigin(origins = "*") // Cho phép Frontend gọi API không bị lỗi Block CORs
public class FineController {

    @Autowired
    private FineRepository fineRepository;

    // API lấy tất cả danh sách tiền phạt trong Database MySQL
    @GetMapping
    public List<Fine> getAllFines() {
        return fineRepository.findAll();
    }
}