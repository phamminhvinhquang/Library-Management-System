package com.example.management_library_system.config;

import com.example.management_library_system.model.Account;
import com.example.management_library_system.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // 1. Tạo tài khoản ADMIN
        if (!accountRepository.existsByEmail("admin@gmail.com")) {
            Account admin = new Account();
            admin.setEmail("admin@gmail.com");
            admin.setPassword(passwordEncoder.encode("123456")); // Mã hóa mật khẩu
            admin.setFullName("Admin System");
            admin.setRole("ROLE_ADMIN");
            accountRepository.save(admin);
            System.out.println("Đã tạo tài khoản Admin!");
        }

        // 2. Tạo tài khoản STAFF
        if (!accountRepository.existsByEmail("staff@gmail.com")) {
            Account staff = new Account();
            staff.setEmail("staff@gmail.com");
            staff.setPassword(passwordEncoder.encode("123456"));
            staff.setFullName("Staff Library");
            staff.setRole("ROLE_STAFF");
            accountRepository.save(staff);
            System.out.println("Đã tạo tài khoản Staff!");
        }

        // 3. Tạo tài khoản USER
        if (!accountRepository.existsByEmail("user@gmail.com")) {
            Account user = new Account();
            user.setEmail("user@gmail.com");
            user.setPassword(passwordEncoder.encode("123456"));
            user.setFullName("User Member");
            user.setRole("ROLE_USER");
            accountRepository.save(user);
            System.out.println("Đã tạo tài khoản User!");
        }
    }
}