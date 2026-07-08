package com.example.management_library_system.controller;

import com.example.management_library_system.dto.LoanRequestDTO;
import com.example.management_library_system.service.LoanService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.util.Base64;
import java.util.Map;

@RestController
@RequestMapping("/api/loan")
@CrossOrigin(origins = "*") 
public class LoanController {

    @Autowired
    private LoanService loanService;

    // Hàm tự động giải mã JWT Token để lấy chính xác Email thật của user
    private String getRealUserEmail(Principal principal, String authHeader) {
        // 1. Nếu Spring Security hoạt động chuẩn xác
        if (principal != null && principal.getName() != null) {
            return principal.getName();
        }
        
        // 2. Nếu Principal bị null, hệ thống tự động giải mã chuỗi Token từ Frontend gửi lên
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            try {
                String[] parts = token.split("\\.");
                if (parts.length > 1) {
                    // Giải mã phần Payload của JWT
                    String payload = new String(Base64.getUrlDecoder().decode(parts[1]), StandardCharsets.UTF_8);
                    ObjectMapper mapper = new ObjectMapper();
                    JsonNode node = mapper.readTree(payload);
                    
                    // Lấy định danh (thường lưu ở trường sub, email hoặc username)
                    if (node.has("sub")) return node.get("sub").asText();
                    if (node.has("email")) return node.get("email").asText();
                    if (node.has("username")) return node.get("username").asText();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        throw new RuntimeException("Không thể xác thực danh tính người dùng từ Token!");
    }

    @PostMapping("/create")
    public ResponseEntity<?> createLoan(@RequestBody LoanRequestDTO request, 
                                        Principal principal, 
                                        @RequestHeader(value = "Authorization", required = false) String authHeader) {
        try {
            // Lấy email thật
            String userEmail = getRealUserEmail(principal, authHeader); 
            loanService.createLoan(userEmail, request);
            return ResponseEntity.ok(Map.of("message", "Đã gửi yêu cầu mượn sách thành công! Vui lòng chờ duyệt."));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }

    @GetMapping("/my-loans")
    public ResponseEntity<?> getMyLoans(Principal principal,
                                        @RequestHeader(value = "Authorization", required = false) String authHeader) {
        try {
            // Lấy email thật
            String userEmail = getRealUserEmail(principal, authHeader);
            return ResponseEntity.ok(loanService.getMyLoans(userEmail));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }

    @PutMapping("/detail/{id}/status")
    public ResponseEntity<?> updateLoanStatus(@PathVariable Integer id, @RequestBody Map<String, String> body) {
        try {
            String newStatus = body.get("status");
            loanService.updateLoanStatus(id, newStatus);
            return ResponseEntity.ok(Map.of("message", "Đã cập nhật trạng thái thành: " + newStatus));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }
}