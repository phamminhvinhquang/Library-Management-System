package com.example.management_library_system.controller;

import com.example.management_library_system.model.Account;
import com.example.management_library_system.repository.AccountRepository;
import com.example.management_library_system.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/account")
@CrossOrigin(origins = "*") // Hỗ trợ gọi API từ Frontend
public class AccountController {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AccountController(AccountRepository accountRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // =======================================================
    // 1. API CẬP NHẬT TÊN (FULL NAME)
    // =======================================================
    @PutMapping("/change-info")
    public ResponseEntity<?> changeInfo(@RequestHeader("Authorization") String token, @RequestBody Map<String, String> requestData) {
        try {
            // Lấy email từ token gửi lên (Cắt bỏ chữ "Bearer " ở đầu)
            String jwt = token.substring(7);
            String email = jwtUtil.extractEmail(jwt);

            Optional<Account> accountOpt = accountRepository.findByEmail(email);
            if (accountOpt.isEmpty()) {
                return ResponseEntity.status(404).body(Map.of("message", "Không tìm thấy tài khoản!"));
            }

            Account account = accountOpt.get();
            String newFullName = requestData.get("fullName");

            if (newFullName != null && !newFullName.trim().isEmpty()) {
                account.setFullName(newFullName);
                accountRepository.save(account); // Lưu tên mới vào Database
                
                return ResponseEntity.ok(Map.of(
                    "message", "Cập nhật tên thành công!",
                    "newFullName", account.getFullName()
                ));
            } else {
                return ResponseEntity.badRequest().body(Map.of("message", "Tên không được để trống!"));
            }

        } catch (Exception e) {
            return ResponseEntity.status(401).body(Map.of("message", "Token không hợp lệ hoặc đã hết hạn!"));
        }
    }

    // =======================================================
    // 2. API ĐỔI MẬT KHẨU
    // =======================================================
    @PutMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestHeader("Authorization") String token, @RequestBody Map<String, String> requestData) {
        try {
            String jwt = token.substring(7);
            String email = jwtUtil.extractEmail(jwt);

            Optional<Account> accountOpt = accountRepository.findByEmail(email);
            if (accountOpt.isEmpty()) {
                return ResponseEntity.status(404).body(Map.of("message", "Không tìm thấy tài khoản!"));
            }

            Account account = accountOpt.get();
            String currentPassword = requestData.get("currentPassword");
            String newPassword = requestData.get("newPassword");

            // Kiểm tra mật khẩu cũ có khớp với Hash trong Database không
            if (!passwordEncoder.matches(currentPassword, account.getPassword())) {
                return ResponseEntity.status(400).body(Map.of("message", "Mật khẩu hiện tại không chính xác!"));
            }

            // Băm mật khẩu mới và lưu đè lên
            account.setPassword(passwordEncoder.encode(newPassword));
            accountRepository.save(account);

            return ResponseEntity.ok(Map.of("message", "Đổi mật khẩu thành công!"));

        } catch (Exception e) {
            return ResponseEntity.status(401).body(Map.of("message", "Token không hợp lệ hoặc đã hết hạn!"));
        }
    }

    // =======================================================
    // API LẤY TẤT CẢ TÀI KHOẢN TỪ MYSQL
    // =======================================================
    @GetMapping("/all")
    public ResponseEntity<?> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return ResponseEntity.ok(accounts);
    }
    // =======================================================
    // 3. API XÓA TÀI KHOẢN (Chỉ Admin & Nhân Viên)
    // =======================================================
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@RequestHeader("Authorization") String token, @PathVariable Integer id) {
        try {
            String jwt = token.substring(7);
            String email = jwtUtil.extractEmail(jwt);
            Account caller = accountRepository.findByEmail(email).orElse(null);
            
            if (caller == null) return ResponseEntity.status(401).body(Map.of("message", "Token không hợp lệ!"));

            Account target = accountRepository.findById(id).orElse(null);
            if (target == null) return ResponseEntity.status(404).body(Map.of("message", "Không tìm thấy tài khoản!"));

            // Phân quyền bảo mật
            if (caller.getRole().equals("ROLE_USER")) {
                return ResponseEntity.status(403).body(Map.of("message", "Bạn không có quyền thực hiện thao tác này!"));
            }
            if (caller.getRole().equals("ROLE_STAFF") && !target.getRole().equals("ROLE_USER")) {
                return ResponseEntity.status(403).body(Map.of("message", "Nhân viên chỉ có thể xóa tài khoản Độc giả!"));
            }
            if (caller.getRole().equals("ROLE_ADMIN") && target.getRole().equals("ROLE_ADMIN")) {
                return ResponseEntity.status(403).body(Map.of("message", "Không thể xóa tài khoản Quản trị viên khác!"));
            }

            accountRepository.delete(target);
            return ResponseEntity.ok(Map.of("message", "Xóa tài khoản thành công!"));
        } catch (Exception e) {
            return ResponseEntity.status(401).body(Map.of("message", "Lỗi xác thực Token!"));
        }
    }

    // =======================================================
    // 4. API CẬP NHẬT VAI TRÒ TÀI KHOẢN (Chỉ Admin)
    // =======================================================
    @PutMapping("/{id}/role")
    public ResponseEntity<?> updateAccountRole(@RequestHeader("Authorization") String token, @PathVariable Integer id, @RequestBody Map<String, String> data) {
        try {
            String jwt = token.substring(7);
            String email = jwtUtil.extractEmail(jwt);
            Account caller = accountRepository.findByEmail(email).orElse(null);
            
            if (caller == null) return ResponseEntity.status(401).body(Map.of("message", "Token không hợp lệ!"));

            Account target = accountRepository.findById(id).orElse(null);
            if (target == null) return ResponseEntity.status(404).body(Map.of("message", "Không tìm thấy tài khoản!"));

            String newRole = data.get("role");

            // Phân quyền bảo mật
            if (caller.getRole().equals("ROLE_USER")) {
                return ResponseEntity.status(403).body(Map.of("message", "Bạn không có quyền thực hiện thao tác này!"));
            }
            if (caller.getRole().equals("ROLE_STAFF")) {
                return ResponseEntity.status(403).body(Map.of("message", "Nhân viên không có quyền thay đổi vai trò tài khoản!"));
            }
            if (caller.getRole().equals("ROLE_ADMIN") && target.getRole().equals("ROLE_ADMIN")) {
                return ResponseEntity.status(403).body(Map.of("message", "Không thể sửa thông tin của Quản trị viên khác!"));
            }

            target.setRole(newRole);
            accountRepository.save(target);
            return ResponseEntity.ok(Map.of("message", "Cập nhật vai trò thành công!"));
        } catch (Exception e) {
            return ResponseEntity.status(401).body(Map.of("message", "Lỗi xác thực Token!"));
        }
    }
}