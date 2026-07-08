package com.example.management_library_system.controller;

import com.example.management_library_system.model.Account;
import com.example.management_library_system.repository.AccountRepository;
import com.example.management_library_system.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(AccountRepository accountRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Account account) {
        if (accountRepository.existsByEmail(account.getEmail())) {
            return ResponseEntity.badRequest().body(Map.of("message", "Email này đã được đăng ký sử dụng!"));
        }

        // Băm mã hóa mật khẩu trước khi lưu xuống database MySQL
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        
        // Mặc định phân quyền tài khoản mới tạo là Độc giả (ROLE_USER)
        if (account.getRole() == null || account.getRole().isEmpty()) {
            account.setRole("ROLE_USER");
        }

        accountRepository.save(account);
        return ResponseEntity.ok(Map.of("message", "Đăng ký tài khoản thành công!"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");

        Optional<Account> accountOpt = accountRepository.findByEmail(email);
        if (accountOpt.isEmpty()) {
            return ResponseEntity.status(401).body(Map.of("message", "Tài khoản hoặc mật khẩu không chính xác!"));
        }

        Account account = accountOpt.get();
        // So khớp mật khẩu thô gửi từ client với chuỗi hash mã hóa trong DB
        if (!passwordEncoder.matches(password, account.getPassword())) {
            return ResponseEntity.status(401).body(Map.of("message", "Tài khoản hoặc mật khẩu không chính xác!"));
        }

        // Tạo chuỗi mã Token JWT gửi trả lại cho Client
        String token = jwtUtil.generateToken(account.getEmail(), account.getRole());

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("fullName", account.getFullName());
        response.put("role", account.getRole());
        response.put("message", "Đăng nhập thành công!");

        return ResponseEntity.ok(response);
    }
}